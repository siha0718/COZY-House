<template>
  <nav class="navbar navbar-expand-sm">
    <div class="container-fluid header">
<<<<<<< HEAD
      <a class="navbar-brand logo" href="#">LOGO</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
=======
      <router-link class="navbar-brand logo" :to="'/'">LOGO</router-link>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#collapsibleNavbar"
      >
>>>>>>> 85669316f51d75e1af746d9d5c0bb05da242bc13
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse justify-content-center" id="collapsibleNavbar">
        <ul class="navbar-nav">
          <li class="nav-item">
            <router-link class="nav-link" :to="'/house'">HOUSE</router-link>
          </li>
<<<<<<< HEAD
          <!-- <li class="nav-item">
              <a class="nav-link" href="#" :to="'/board/write'">즐겨찾기</a>
            </li> -->
        </ul>
      </div>
      <ul class="navbar-nav">
        <li class="nav-item justify-content-end">
          <a class="nav-link" href="#">로그인</a>
=======
          <li class="nav-item">
            <router-link class="nav-link" :to="'/house'">즐겨찾기</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" :to="'/house'">매물올리기</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" :to="'/house'">건의사항</router-link>
          </li>
        </ul>
      </div>
      <ul class="navbar-nav" v-if="loginUser">
        <li class="nav-item justify-content-end">
          <router-link class="nav-link" :to="'/user/detail'">회원수정</router-link>
        </li>

        <li class="nav-item justify-content-end">
          <a class="nav-link" @click="logout">로그아웃</a>
          <!-- <div class="nav-link" @click="logout">로그아웃</div> -->
          <!-- <router-link class="nav-link" @click="logout">로그아웃</router-link> -->
        </li>
      </ul>
      <ul class="navbar-nav" v-else>
        <li class="nav-item justify-content-end">
          <router-link class="nav-link" :to="'/user/login'">로그인</router-link>
        </li>
        <li class="nav-item justify-content-end">
          <router-link class="nav-link" :to="'/user/regist'">회원가입</router-link>
>>>>>>> 85669316f51d75e1af746d9d5c0bb05da242bc13
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
export default {
  name: "TheHeader",
  computed: {
    ...mapState(["loginUser"]),
    ...mapMutations(["DELETE_LOGIN_USER"]),
  },
  methods: {
    logout() {
      this.DELETE_LOGIN_USER;
    },
  },
};
</script>
<style scoped>
<<<<<<< HEAD
@import "../../public/css/prototype1.css";
=======
@import "../../public/css/main.css";
@import "../../public/css/house-list.css";
@import "../../public/css/house-search.css";
>>>>>>> 85669316f51d75e1af746d9d5c0bb05da242bc13
</style>
