<template>
  <div>
    <house-search></house-search>
    <!-- 중앙에 맵 -->

    <!-- 라우터뷰로 처음에 리스트, 리스트에서 선택누르면 디테일가지 -->
    <router-view></router-view>
  </div>
</template>

<script>
import HouseSearch from "@/components/house/HouseSearch.vue";

export default {
  name: "AppHouse",
  components: {
    HouseSearch,
  },
  created() {
    this.$router.push("/house/list");
  },
};
</script>

<style scoped>
@import "../../public/css/main.css";
@import "../../public/css/house-list.css";
@import "../../public/css/house-search.css";
</style>
