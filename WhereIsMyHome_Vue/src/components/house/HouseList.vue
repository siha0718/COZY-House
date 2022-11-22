<template>
<<<<<<< HEAD
  <div>리스트입니다!</div>
=======
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
          <!--
          <div class="list">
            <img src="img/화면 캡처 2022-11-22 022838.png" alt="" />
            <ul>
              <li>투룸</li>
              <li><strong>월세 2억/140</strong></li>
              <li>51.24㎡ 2층</li>
              <li>서초구 반포동</li>
              <li>★신축2룸★전용15평★에어컨3대★논현동</li>
            </ul>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="16.644"
              height="22.774"
              viewBox="0 0 16.644 22.774"
            >
              <g id="그룹_21" data-name="그룹 21" transform="translate(-4086.086 -233.5)">
                <line
                  id="선_16"
                  data-name="선 16"
                  x2="13.815"
                  transform="translate(4087.5 234.5)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
                <line
                  id="선_17"
                  data-name="선 17"
                  y1="20.359"
                  transform="translate(4101.315 234.5)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
                <line
                  id="선_18"
                  data-name="선 18"
                  y1="20.359"
                  transform="translate(4087.5 234.5)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
                <line
                  id="선_19"
                  data-name="선 19"
                  y1="6.908"
                  x2="6.908"
                  transform="translate(4087.5 247.952)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
                <line
                  id="선_20"
                  data-name="선 20"
                  x1="6.908"
                  y1="6.908"
                  transform="translate(4094.408 247.952)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
              </g>
            </svg>
          </div>

          <div class="list">
            <img src="img/화면 캡처 2022-11-22 022838.png" alt="" />
            <ul>
              <li>투룸</li>
              <li><strong>월세 2억/140</strong></li>
              <li>51.24㎡ 2층</li>
              <li>서초구 반포동</li>
              <li>★신축2룸★전용15평★에어컨3대★논현동</li>
            </ul>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="16.644"
              height="22.774"
              viewBox="0 0 16.644 22.774"
            >
              <g id="그룹_21" data-name="그룹 21" transform="translate(-4086.086 -233.5)">
                <line
                  id="선_16"
                  data-name="선 16"
                  x2="13.815"
                  transform="translate(4087.5 234.5)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
                <line
                  id="선_17"
                  data-name="선 17"
                  y1="20.359"
                  transform="translate(4101.315 234.5)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
                <line
                  id="선_18"
                  data-name="선 18"
                  y1="20.359"
                  transform="translate(4087.5 234.5)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
                <line
                  id="선_19"
                  data-name="선 19"
                  y1="6.908"
                  x2="6.908"
                  transform="translate(4087.5 247.952)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
                <line
                  id="선_20"
                  data-name="선 20"
                  x1="6.908"
                  y1="6.908"
                  transform="translate(4094.408 247.952)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
              </g>
            </svg>
          </div>

          <div class="list">
            <img src="img/화면 캡처 2022-11-22 022838.png" alt="" />
            <ul>
              <li>투룸</li>
              <li><strong>월세 2억/140</strong></li>
              <li>51.24㎡ 2층</li>
              <li>서초구 반포동</li>
              <li>★신축2룸★전용15평★에어컨3대★논현동</li>
            </ul>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="16.644"
              height="22.774"
              viewBox="0 0 16.644 22.774"
            >
              <g id="그룹_21" data-name="그룹 21" transform="translate(-4086.086 -233.5)">
                <line
                  id="선_16"
                  data-name="선 16"
                  x2="13.815"
                  transform="translate(4087.5 234.5)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
                <line
                  id="선_17"
                  data-name="선 17"
                  y1="20.359"
                  transform="translate(4101.315 234.5)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
                <line
                  id="선_18"
                  data-name="선 18"
                  y1="20.359"
                  transform="translate(4087.5 234.5)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
                <line
                  id="선_19"
                  data-name="선 19"
                  y1="6.908"
                  x2="6.908"
                  transform="translate(4087.5 247.952)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
                <line
                  id="선_20"
                  data-name="선 20"
                  x1="6.908"
                  y1="6.908"
                  transform="translate(4094.408 247.952)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
              </g>
            </svg>
          </div>

          <div class="list">
            <img src="img/화면 캡처 2022-11-22 022838.png" alt="" />
            <ul>
              <li>투룸</li>
              <li><strong>월세 2억/140</strong></li>
              <li>51.24㎡ 2층</li>
              <li>서초구 반포동</li>
              <li>★신축2룸★전용15평★에어컨3대★논현동</li>
            </ul>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="16.644"
              height="22.774"
              viewBox="0 0 16.644 22.774"
            >
              <g id="그룹_21" data-name="그룹 21" transform="translate(-4086.086 -233.5)">
                <line
                  id="선_16"
                  data-name="선 16"
                  x2="13.815"
                  transform="translate(4087.5 234.5)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
                <line
                  id="선_17"
                  data-name="선 17"
                  y1="20.359"
                  transform="translate(4101.315 234.5)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
                <line
                  id="선_18"
                  data-name="선 18"
                  y1="20.359"
                  transform="translate(4087.5 234.5)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
                <line
                  id="선_19"
                  data-name="선 19"
                  y1="6.908"
                  x2="6.908"
                  transform="translate(4087.5 247.952)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
                <line
                  id="선_20"
                  data-name="선 20"
                  x1="6.908"
                  y1="6.908"
                  transform="translate(4094.408 247.952)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
              </g>
            </svg>
          </div>

          <div class="list">
            <img src="img/화면 캡처 2022-11-22 022838.png" alt="" />
            <ul>
              <li>투룸</li>
              <li><strong>월세 2억/140</strong></li>
              <li>51.24㎡ 2층</li>
              <li>서초구 반포동</li>
              <li>★신축2룸★전용15평★에어컨3대★논현동</li>
            </ul>
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="16.644"
              height="22.774"
              viewBox="0 0 16.644 22.774"
            >
              <g id="그룹_21" data-name="그룹 21" transform="translate(-4086.086 -233.5)">
                <line
                  id="선_16"
                  data-name="선 16"
                  x2="13.815"
                  transform="translate(4087.5 234.5)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
                <line
                  id="선_17"
                  data-name="선 17"
                  y1="20.359"
                  transform="translate(4101.315 234.5)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
                <line
                  id="선_18"
                  data-name="선 18"
                  y1="20.359"
                  transform="translate(4087.5 234.5)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
                <line
                  id="선_19"
                  data-name="선 19"
                  y1="6.908"
                  x2="6.908"
                  transform="translate(4087.5 247.952)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
                <line
                  id="선_20"
                  data-name="선 20"
                  x1="6.908"
                  y1="6.908"
                  transform="translate(4094.408 247.952)"
                  fill="none"
                  stroke="#a38f85"
                  stroke-linecap="round"
                  stroke-width="2"
                />
              </g>
            </svg>
          </div>
        --></div>
        <div class="areaList" v-else>매물이 존재하지 않습니다.</div>
      </div>
    </div>
  </div>
>>>>>>> 85669316f51d75e1af746d9d5c0bb05da242bc13
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
<<<<<<< HEAD

export default {
  name: "HouseList",
  components: {},
=======
import HouseListItem from "@/components/house/HouseListItem.vue";

export default {
  name: "HouseList",
  components: {
    HouseListItem,
  },
>>>>>>> 85669316f51d75e1af746d9d5c0bb05da242bc13
  data() {
    return {};
  },
  computed: {
    ...mapState(["houses"]),
  },
<<<<<<< HEAD
};
</script>
<style></style>
=======
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
>>>>>>> 85669316f51d75e1af746d9d5c0bb05da242bc13
