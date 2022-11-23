<template>
  <div>
    <!-- 오른쪽 화면 토글 버튼  -->
    <div class="toggle">
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
    </div>

    <!-- 오른쪽 선택 화면  -->
    <div class="right active">
      <div class="rightSelect col-md-4">
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
    </div>
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
import HouseListItem from "@/components/house/HouseListItem.vue";

export default {
  name: "HouseList",
  components: {
    HouseListItem,
  },
  data() {
    return {};
  },
  computed: {
    ...mapState(["houses"]),
  },
  methods: {
    test() {
      console.log("하우스 사이즈는");
      console.log(this.houses);
    },
  },
};
</script>
<style scoped>
@import "../../../public/css/main.css";
@import "../../../public/css/house-list.css";
@import "../../../public/css/house-search.css";
</style>
