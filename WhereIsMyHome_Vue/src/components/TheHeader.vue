<template>
  <nav class="navbar navbar-expand-sm">
    <div class="container-fluid header">
      <a class="navbar-brand logo" href="#">LOGO</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse justify-content-center" id="collapsibleNavbar">
        <ul class="navbar-nav">
          <li class="nav-item">
            <router-link class="nav-link" :to="'/house'">HOUSE</router-link>
          </li>
          <!-- <li class="nav-item">
              <a class="nav-link" href="#" :to="'/board/write'">즐겨찾기</a>
            </li> -->
        </ul>
      </div>
      <ul class="navbar-nav">
        <li class="nav-item justify-content-end">
          <a class="nav-link" href="#">로그인</a>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
export default {
  name: "TheHeader",
};
</script>
<style scoped>
@import "../../public/css/prototype1.css";
</style>
