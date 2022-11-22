<template>
  <div class="leftSelect col-md-4">
    <input
      class="search"
      placeholder="지역, 지하철역, 학교 검색"
      v-model="inputSearch"
    />

    <!-- v-model houseType-->
    <div class="btn-group group"></div>
    <div class="apt" @click="houseType = `apt`">아파트</div>
    <div class="selectBuild" @click="houseType = `ot`">원룸, 투룸</div>
    <div class="selectBuild2" @click="houseType = `villa`">빌라</div>

    <!-- v-model dealType-->
    <div class="typeText">거래유형</div>
    <div class="inner1 inner" @click="dealType = `done`">완료</div>
    <div class="inner2" @click="dealType = `on`">실거래</div>
    <div class="inner3 inner" @click="dealType = `all`">전체</div>

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
    <select
      class="form-select form-select-sm sido sido3"
      label
      for="시/도"
      v-model="year"
    >
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
    <select
      class="form-select form-select-sm sido sido4"
      label
      for="시/도"
      v-model="month"
    >
      <option>01월</option>
      <option>02월</option>
      <option>03월</option>
      <option>04월</option>
      <option>05월</option>
      <option>06월</option>
      <option>07월</option>
      <option>08월</option>
      <option>09월</option>
      <option>10월</option>
      <option>11월</option>
      <option>12월</option>
    </select>

    <div class="typeText2">거래금액</div>

    <!-- <div class="range">
      <input type="range" class="form-range" id="customRange" />
    </div> -->
    <input placeholder="최소금액" v-model="priceMin" />
    <input placeholder="최대금액" v-model="priceMax" />

    <div class="typeText3">전체해제</div>

    <button @click="searchApt">검색</button>
    <!-- <div class="searchBtn textSet">검색</div> -->
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

export default {
  name: "HouseSearch",
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
      if (
        this.sidoCode === "" ||
        this.gugunCode === "" ||
        this.year === "" ||
        this.month === ""
      ) {
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
      console.log("search시작 option은");
      console.log(option);
      this.getHouseList(option);
    },
  },
};
</script>
<style scoped>
@import "../../../public/css/main.css";
@import "../../../public/css/house-list.css";
@import "../../../public/css/house-search.css";
</style>
