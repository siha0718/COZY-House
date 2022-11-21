<template>
  <div class="container-fluid">
    <!-- start container -->
    <nav class="navbar navbar-expand-sm">
      <div class="container-fluid header">
        <a class="navbar-brand logo" href="#">LOGO</a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#collapsibleNavbar"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-center" id="collapsibleNavbar">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="#">아파트</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">원룸</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">빌라</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">주택</a>
            </li>
          </ul>
        </div>
        <ul class="navbar-nav">
          <li class="nav-item justify-content-end">
            <a class="nav-link" href="#">로그인</a>
          </li>
        </ul>
      </div>
    </nav>

    <!-- 왼쪽 선택 화면 -->

    <div class="leftSelect col-md-4">
      <input class="search" placeholder="지역, 지하철역, 학교 검색" v-model="inputSearch" />

      <div class="apt">아파트</div>
      <div class="selectBuild">원룸, 투룸</div>
      <div class="selectBuild2">빌라</div>

      <div class="typeText">거래유형</div>
      <div class="inner1 inner">완료</div>
      <div class="inner2">실거래</div>
      <div class="inner3 inner">전체</div>

      <b-form-select
        v-model="sidoCode"
        :options="sidos"
        @change="gugunList"
        class="form-select form-select-sm sido sido1"
      ></b-form-select>
      <b-form-select
        v-model="gugunCode"
        :options="guguns"
        class="form-select form-select-sm sido sido2"
      ></b-form-select>
      <select class="form-select form-select-sm sido sido3" label for="년" v-model="year">
        <option>2014년</option>
        <option>2015년</option>
        <option>2016년</option>
        <option>2017년</option>
        <option>2018년</option>
        <option>2019년</option>
        <option>2020년</option>
        <option>2021년</option>
        <option>2022년</option>
      </select>
      <select class="form-select form-select-sm sido sido4" label for="월" v-model="month">
        <option>1월</option>
        <option>2월</option>
        <option>3월</option>
        <option>4월</option>
        <option>5월</option>
        <option>6월</option>
        <option>7월</option>
        <option>8월</option>
        <option>9월</option>
        <option>10월</option>
        <option>11월</option>
        <option>12월</option>
      </select>

      <div class="typeText2">거래금액</div>

      <div class="range">
        <!-- <label for="customRange" class="form-label">Custom range</label> -->
        <input type="range" class="form-range" id="customRange" />
      </div>

      <div class="typeText3">전체해제</div>

      <div class="searchBtn textSet" @click="searchApt">검색</div>
    </div>
  </div>
  <!-- end container -->
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

export default {
  name: "BoardList",
  components: {},

  data() {
    return {
      houseType: "apt",
      dealType: "done",
      sidoCode: null,
      gugunCode: null,
      year: null,
      month: null,
      inputSearch: null,
      priceMin: null,
      priceMax: null,
    };
  },
  computed: {
    ...mapState(["sidos", "guguns", "houses"]),
  },
  created() {
    this.CLEAR_SIDO_LIST();
    this.CLEAR_APT_LIST();
    this.getSido();
    // console.log("created 까지 해봤음");
    console.log(this.$store.state.sidos);
  },
  methods: {
    ...mapActions(["getSido", "getGugun", "getHouseList"]),
    ...mapMutations(["CLEAR_SIDO_LIST", "CLEAR_GUGUN_LIST", "CLEAR_APT_LIST"]),

    gugunList() {
      // console.log(this.sidoCode);
      this.CLEAR_GUGUN_LIST();
      this.gugunCode = null;
      // console.log("선택한 시도코드는" + this.sidoCode);
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
    searchApt() {
      if (this.sidoCode === "" || this.gugunCode === "" || this.year === "" || this.month === "") {
        alert("필수 입력 시도 & 구군 & 년/월");
        return;
      }
      let option = {
        houseType: this.houseType,
        dealType: this.dealType,
        sidoCode: this.sidoCode,
        gugunCode: this.gugunCode,
        year: this.year,
        month: this.month,
        inputSearch: this.inputSearch,
        priceMin: this.priceMin,
        priceMax: this.priceMax,
      };
      this.getHouseList(option);
    },
  },
};
</script>
<style>
@import "../../../public/css/prototype1.css";
</style>
