<template>
  <div id="app">
    <div class="container-fluid">
      <the-header></the-header>
      <router-view></router-view>
    </div>
  </div>
</template>
<script>
import TheHeader from "@/components/TheHeader.vue";

export default {
  components: {
    TheHeader,
  },
};
</script>

<style scoped>
<<<<<<< HEAD
@import "../public/css/prototype1.css";
=======
@import "../public/css/main.css";
@import "../public/css/house-list.css";
@import "../public/css/house-search.css";
>>>>>>> 85669316f51d75e1af746d9d5c0bb05da242bc13
</style>
