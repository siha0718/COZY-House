<template>
  <div class="leftSelect">
    <input
      class="searchInput"
      placeholder="지역, 지하철역, 학교 검색"
      v-model="inputSearch"
    />

    <div class="selectBtn mt-4">
      <div
        class="btn-group selectBtn selectBtnIn"
        role="group"
        aria-label="Basic checkbox toggle button group"
      >
        <input
          type="checkbox"
          class="btn-check"
          id="btncheck1"
          autocomplete="off"
          @click="houseType = `apt`"
        />
        <label class="btn" for="btncheck1">아파트</label>
      </div>

      <div
        class="mt-3 btn-group selectBtn selectBtnIn"
        role="group"
        aria-label="Basic checkbox toggle button group"
      >
        <input
          type="checkbox"
          class="btn-check col-6"
          id="btncheck2"
          autocomplete="off"
          @click="houseType = `ot`"
        />
        <label class="btn" for="btncheck2">원룸,투룸</label>

        <input
          type="checkbox"
          class="btn-check col-6"
          id="btncheck3"
          autocomplete="off"
          @click="houseType = `villa`"
        />
        <label class="btn" for="btncheck3">빌라</label>
      </div>
    </div>

    <div class="selectBtn mt-4">
      <div class="mt-5">거래유형</div>
      <div
        class="btn-group selectBtn selectBtnIn mt-3"
        role="group"
        aria-label="Basic checkbox toggle button group"
      >
        <input
          type="checkbox"
          class="btn-check"
          id="btncheck4"
          autocomplete="off"
          @click="dealType = `done`"
        />
        <label class="btn col-4" for="btncheck4">완료</label>

        <input
          type="checkbox"
          class="btn-check"
          id="btncheck5"
          autocomplete="off"
          @click="dealType = `on`"
        />
        <label class="btn col-4" for="btncheck5">실거래</label>

        <input
          type="checkbox"
          class="btn-check"
          id="btncheck6"
          autocomplete="off"
          @click="dealType = `all`"
        />
        <label class="btn col-4" for="btncheck6">전체</label>
      </div>
    </div>

    <!-- v-model houseType-->
    <!-- <div class="group">
      <div class="btn apt" @click="houseType = `apt`">아파트</div>
      <div class="btn selectBuild" @click="houseType = `ot`">원룸, 투룸</div>
      <div class="btn selectBuild2" @click="houseType = `villa`">빌라</div>
    </div> -->

    <!-- v-model dealType-->
    <!-- <div class="typeText">거래유형</div>
    <div class="inner1 inner btn" @click="dealType = `done`">완료</div>
    <div class="inner2 btn" @click="dealType = `on`">실거래</div>
    <div class="inner3 inner btn" @click="dealType = `all`">전체</div> -->

    <div class="selectBox row mt-5">
      <b-form-select
        v-model="sidoCode"
        :options="sidos"
        @change="gugunList"
        class="form-select form-select-sm col-3"
      ></b-form-select>
      <b-form-select
        v-model="gugunCode"
        :options="guguns"
        class="form-select form-select-sm col-3"
      ></b-form-select>
      <b-form-select
        class="form-select form-select-sm col-3"
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
      </b-form-select>
      <b-form-select
        class="form-select form-select-sm col-3"
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
      </b-form-select>
    </div>

    <div class="mt-5">
      <div class="mt-5">거래금액</div>
      <!-- <input id="rangeInput" class="rangeInput" style="" max="10" min="0" step="1" type="range" /> -->
    </div>

    <!-- <div class="range">
      <input type="range" class="form-range" id="customRange" />
    </div> -->

    <div class="filter__option mt-3">
      <div class="filter__price">
        <div class="selected_price">
          <div class="selected_price--wrap row">
            <p class="col-2">최소</p>
            <span class="col-10"
              ><input
                type="text"
                name="min_price"
                id="minPrice"
                class="selected_price--min"
                value=""
                v-model="priceMin"
            /></span>
          </div>
          <div class="selected_price--wrap row">
            <p class="col-2">최대</p>
            <span class="col-10"
              ><input
                type="text"
                name="max_price"
                id="maxPrice"
                class="selected_price--max"
                value=""
                v-model="priceMax"
            /></span>
          </div>
        </div>
      </div>
    </div>

    <div class="mt-5">
      <div class="">전체해제</div>
      <button
        @click="searchApt"
        type="button"
        class="searchBtn-s textSet"
        data-bs-toggle="offcanvas"
        data-bs-target="#offcanvasRight"
        aria-controls="offcanvasRight"
      >
        검색
      </button>
    </div>
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
      // console.log("search시작 option은");
      // console.log(option);
      this.getHouseList(option);
      // eventBus.$emit("housList", this.$store.state.houses);
    },
  },
};
</script>

<style scoped>
@import "../../../public/css/main.css";
@import "../../../public/css/house-list.css";
@import "../../../public/css/house-search.css";
</style>
