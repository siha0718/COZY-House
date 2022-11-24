<template>
  <div class="qqqq">
    <house-search></house-search>
    <!-- 중앙에 맵 -->
    <house-map></house-map>
    <!-- 라우터뷰로 처음에 리스트, 리스트에서 선택누르면 디테일가지 -->

    <house-list
      class="offcanvas offcanvas-end"
      tabindex="-1"
      id="offcanvasRight"
      aria-labelledby="offcanvasRightLabel"
    ></house-list>
  </div>
</template>

<script>
import HouseSearch from "@/components/house/HouseSearch.vue";
import HouseMap from "@/components/house/HouseMap.vue";
import HouseList from "@/components/house/HouseList.vue";
export default {
  name: "AppHouse",
  components: {
    HouseSearch,
    HouseMap,
    HouseList,
  },
};
</script>

<style scoped>
@import "../../public/css/main.css";
@import "../../public/css/house-list.css";
@import "../../public/css/house-search.css";
</style>
