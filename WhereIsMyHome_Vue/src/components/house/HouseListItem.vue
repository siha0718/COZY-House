<template>
  <div class="list">
    <img src="@/assets/2.jpg" alt="" @click="detail" />
    <ul>
      <li>{{ house.아파트 }}</li>
      <li>
        <strong>{{ house.거래금액 }}원</strong>
      </li>
      <li>51.24㎡ 2층</li>
      <li>서초구 {{ house.법정동 }}</li>
      <li>★신축2룸★전용15평★에어컨3대★논현동</li>
    </ul>
    <p class="star" @click="bookmark">
      <svg
        class="starsvg"
        height="48"
        viewBox="0 0 40 40"
        width="40"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          d="M34 6H14c-2.21 0-3.98 1.79-3.98 4L10 42l14-6 14 6V10c0-2.21-1.79-4-4-4zm0 30l-10-4.35L14 36V10h20v26z"
        />
        <path d="M0 0h48v48H0z" fill="none" />
      </svg>
    </p>
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
  methods: {
    ...mapActions(["addStar, getStars"]),
    ...mapMutations(["ADD_USER_STARS, SET_USER_STARS"]),
    ...mapState(["loginUser"]),
    bookmark() {
      console.log(this.$store.state.loginUser);
      if (!this.$store.state.loginUser) {
        alert("로그인하세요");
        return;
      }

      console.log(this.house);

      let aptcode =
        this.house.법정동 + this.house.지번 + this.house.년 + this.house.월;

      let newHouse = {
        houseCode: aptcode,
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
    },
    detail() {
      this.$store.commit("SET_DETAIL_HOUSE", this.house);
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
