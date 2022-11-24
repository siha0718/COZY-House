<template>
  <div class="list">
    <img src="@/assets/2.jpg" alt="" @click="detail" />
    <ul>
      <li>{{ house.아파트 }}</li>
      <li>
        <strong>{{ house.거래금액.trim() }}원</strong>
      </li>
      <li>{{ house.법정동 }}</li>
      <li>지번 {{ house.지번 }}</li>
      <li>건축년도 {{ house.건축년도 }}</li>
    </ul>
    <div class="star" @click="bookmark">
      <div v-if="this.staron == `on`">
        <svg
          xmlns="http://www.w3.org/2000/svg"
          width="40"
          height="40"
          fill="currentColor"
          class="bi bi-boo kmark-fill"
          viewBox="0 0 16 16"
        >
          <path
            d="M2 2v13.5a.5.5 0 0 0 .74.439L8 13.069l5.26 2.87A.5.5 0 0 0 14 15.5V2a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2z"
          />
        </svg>
      </div>
      <div v-else>
        <svg class="starsvg" height="40" viewBox="0 0 40 40" width="40" xmlns="http://www.w3.org/2000/svg">
          <path
            d="M34 6H14c-2.21 0-3.98 1.79-3.98 4L10 42l14-6 14 6V10c0-2.21-1.79-4-4-4zm0 30l-10-4.35L14 36V10h20v26z"
          />
          <path d="M0 0h48v48H0z" fill="none" />
        </svg>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

export default {
  name: "HouseListItem",
  data() {
    return {};
  },
  props: {
    house: Object,
  },
  watch: {
    house: function () {},
  },
  computed: {
    staron() {
      return this.house.star;
    },
  },
  methods: {
    ...mapActions(["addStar, getStars, getCommentList"]),
    ...mapMutations(["ADD_USER_STARS, SET_USER_STARS"]),
    ...mapState(["loginUser"]),
    bookmark() {
      console.log(this.$store.state.loginUser);
      if (!this.$store.state.loginUser) {
        alert("로그인하세요");
        return;
      }

      console.log(this.house);

      let houseCode =
        this.house.법정동 +
        "뷁" +
        this.house.지번 +
        "뷁" +
        this.house.년 +
        "뷁" +
        this.house.월 +
        "뷁" +
        this.house.거래금액;

      let newHouse = {
        houseCode: houseCode,
        houseName: this.house.아파트,
        regCode: this.house.지역코드,
        dongName: this.house.법정동,
        jibun: this.house.지번,
        price: this.house.거래금액,
        year: this.house.년,
        month: this.house.월,
        type: this.house.아파트,
        userid: this.$store.state.loginUser.userid,
      };
      // console.log(newHouse);
      this.$store.dispatch("addStar", newHouse);
      // addStar(newHouse);
      alert("즐겨찾기 등록");
      this.house.star = "on";
    },
    detail() {
      let houseCode =
        this.house.법정동 +
        "뷁" +
        this.house.지번 +
        "뷁" +
        this.house.년 +
        "뷁" +
        this.house.월 +
        "뷁" +
        this.house.거래금액;
      this.$store.dispatch("getCommentList", houseCode);
      this.$store.commit("SET_DETAIL_HOUSE", this.house);
      console.log("디테일로이동");
      this.$router.push("/detail");
    },
  },
};
</script>

<style scopes>
@import "../../../public/css/main.css";
@import "../../../public/css/house-list.css";
@import "../../../public/css/house-search.css";
</style>
