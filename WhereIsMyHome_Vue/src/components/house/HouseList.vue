<template>
  <div class="rightScreen">
    <!-- 오른쪽 화면 토글 버튼  -->
    <!-- <div class="toggle">
      <svg
        xmlns="http://www.w3.org/2000/svg"
        xmlns:xlink="http://www.w3.org/1999/xlink"
        width="96"
        height="96"
        viewBox="0 0 96 96"
      >
        <defs>
          <filter
            id="타원_13"
            x="0"
            y="0"
            width="96"
            height="96"
            filterUnits="userSpaceOnUse"
          >
            <feOffset dx="5" input="SourceAlpha" />
            <feGaussianBlur stdDeviation="5" result="blur" />
            <feFlood flood-opacity="0.439" />
            <feComposite operator="in" in2="blur" />
            <feComposite in="SourceGraphic" />
          </filter>
        </defs>
        <g
          id="그룹_4"
          data-name="그룹 4"
          transform="translate(-1379.364 -574.364)"
        >
          <g
            transform="matrix(1, 0, 0, 1, 1379.36, 574.36)"
            filter="url(#타원_13)"
          >
            <circle
              id="타원_13-2"
              data-name="타원 13"
              cx="33"
              cy="33"
              r="33"
              transform="translate(10 15)"
              fill="#d4b2a7"
            />
          </g>
          <path
            id="패스_2"
            data-name="패스 2"
            d="M1575.672,526l12.785,9.991-12.785,11.218"
            transform="translate(-159.701 85.759)"
            fill="none"
            stroke="#fff"
            stroke-linecap="round"
            stroke-linejoin="round"
            stroke-width="3"
          />
        </g>
      </svg>
    </div> -->

    <!-- 오른쪽 선택 화면  -->
    <!-- <div class="right active">
      <div class="rightSelect">
        <h5 class="areaTitle" @click="test">지역 목록</h5>

        <div class="areaList" v-if="houses && houses.length != 0">
          <house-list-item
            v-for="(house, index) in houses"
            :key="index"
            :house="house"
          />
        </div>
        <div class="areaList" v-else>매물이 존재하지 않습니다.</div>
      </div>
    </div> -->

    <!-- offcanvas 실험 -->

    <!-- <div
      class="offcanvas offcanvas-end"
      tabindex="-1"
      id="offcanvasRight"
      aria-labelledby="offcanvasRightLabel"
    > -->
    <div class="offcanvas-header" data-bs-scroll="true">
      <h5 class="" @click="test">지역 목록</h5>
      <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div class="offcanvas-body">
      <div class="areaList" v-if="this.houseList && this.houseList.length != 0">
        <house-list-item v-for="(house, index) in this.houseList" :key="index" :house="house" />
      </div>
      <div class="areaList" v-else>매물이 존재하지 않습니다.</div>
    </div>
  </div>

  <!--end rightScreen -->
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
import HouseListItem from "@/components/house/HouseListItem.vue";
import { eventBus } from "../../main.js";

export default {
  name: "HouseList",
  components: {
    HouseListItem,
  },
  data() {
    return {
      houseList: [],
    };
  },
  computed: {
    ...mapState(["houses", "starList", "loginUser"]),
  },
  watch: {
    houses: async function () {
      if (!this.loginUser) {
        return;
      }
      console.log("로그인확인", this.loginUser);
      //디비접근해서 현재유저의 즐겨찾기목록 다긁어오기
      //그 긁어온거랑 하우스 정보 비교해서 일치하면 즐겨찾기 된걸로 표시해서 this.houseList에 저장하기
      this.$store.dispatch("getStars");
      let ho = this.houses;
      let st = this.starList;
      console.log(ho);
      console.log(st.length);

      this.houseList = [];
      for (let i = 0; i < ho.length; i++) {
        this.houseList.push(ho[i]);
        for (let j = 0; j < st.length; j++) {
          let codes = st[j].houseCode.split("뷁");
          if (
            this.houseList[i].법정동 == codes[0] &&
            this.houseList[i].지번 == codes[1] &&
            this.houseList[i].년 == codes[2] &&
            this.houseList[i].월 == codes[3] &&
            this.houseList[i].거래금액 == codes[4]
          ) {
            this.houseList[i].star = "on";
            break;
          } else {
            this.houseList[i].star = "off";
          }
        }
      }
      console.log(this.houseList);
    },
  },
  methods: {
    test() {
      console.log("하우스 사이즈는");
      console.log(this.houses);

      // this.house.법정동 + this.house.지번 + this.house.년 + this.house.월;
    },
  },
  created() {
    eventBus.$on("houseList", function (houseList) {
      this.houseList = houseList;
    });
  },
};
</script>
<style scoped>
@import "../../../public/css/main.css";
@import "../../../public/css/house-list.css";
@import "../../../public/css/house-search.css";
</style>
