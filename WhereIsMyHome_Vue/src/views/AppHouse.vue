<template>
  <div>
    <house-search></house-search>
    <!-- 중앙에 맵 -->
<<<<<<< HEAD

=======
<<<<<<< HEAD
=======
    <house-map></house-map>
>>>>>>> 25f04e7f261da3695bf14ace601150e54f62e90e
>>>>>>> 85669316f51d75e1af746d9d5c0bb05da242bc13
    <!-- 라우터뷰로 처음에 리스트, 리스트에서 선택누르면 디테일가지 -->
    <router-view></router-view>
  </div>
</template>

<script>
import HouseSearch from "@/components/house/HouseSearch.vue";
<<<<<<< HEAD

=======
import HouseMap from "@/components/house/HouseMap.vue";
>>>>>>> 85669316f51d75e1af746d9d5c0bb05da242bc13
export default {
  name: "AppHouse",
  components: {
    HouseSearch,
<<<<<<< HEAD
  },
  created() {
    this.$router.push("house/list");
=======
    HouseMap,
  },
  created() {
    this.$router.push("/house/list");
>>>>>>> 85669316f51d75e1af746d9d5c0bb05da242bc13
  },
};
</script>

<<<<<<< HEAD
<style></style>
=======
<style scoped>
@import "../../public/css/main.css";
@import "../../public/css/house-list.css";
@import "../../public/css/house-search.css";
</style>
>>>>>>> 85669316f51d75e1af746d9d5c0bb05da242bc13
