<template>
  <div class="list">
    <img src="@/assets/2.jpg" alt="" />
    <ul>
      <li>{{ house.아파트 }}</li>
      <li>
        <strong
          >{{
            (parseInt(house.거래금액.replace(",", "")) * 10000) | price
          }}원</strong
        >
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
export default {
  name: "HouseListItem",
  data() {
    return {
      isColor: false,
    };
  },
  props: {
    house: Object,
  },
  methods: {
    ...mapActions(["addStar"]),
    ...mapMutations(["ADD_USER_STARS"]),

    bookmark() {
      let aptcode =
        this.house.법정동 + this.house.지번 + this.house.년 + this.house.월;
      // console.log("법정동 : " + this.house.법정동);
      // console.log("지번" + this.house.지번);
      // console.log("년" + this.house.년);
      // console.log("월" + this.house.월);
      // console.log(aptcode);
    },
  },
};
</script>

<style scopes>
@import "../../../public/css/main.css";
@import "../../../public/css/house-list.css";
@import "../../../public/css/house-search.css";
</style>
