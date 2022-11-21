<template>
  <div></div>
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
  },
  methods: {
    ...mapActions(["getSido", "getGugun", "getHouseList"]),
    ...mapMutations(["CLEAR_SIDO_LIST", "CLEAR_GUGUN_LIST", "CLEAR_APT_LIST"]),

    gugunList() {
      // console.log(this.sidoCode);
      this.CLEAR_GUGUN_LIST();
      this.gugunCode = null;
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
<style></style>
