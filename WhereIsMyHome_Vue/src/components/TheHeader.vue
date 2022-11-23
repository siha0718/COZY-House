<template>
  <nav class="navbar navbar-expand-sm">
    <div class="container-fluid header">
      <router-link class="navbar-brand logo" :to="'/'">LOGO</router-link>
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
            <router-link class="nav-link" :to="'/house'">HOUSE</router-link>
          </li>
          <li class="nav-item">
            <a href="#" @click="star" class="nav-link">즐겨찾기</a>
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
          <div class="nav-link">"{{ loginUser.username }}"님 어서오세요</div>
        </li>

        <li class="nav-item justify-content-end">
          <router-link class="nav-link" :to="'/user/detail'">회원수정</router-link>
        </li>

        <li class="nav-item justify-content-end">
          <a class="nav-link" @click.prevent="logout">로그아웃</a>
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
      this.$store.dispatch("setLogout");
    },
    star() {
      if (this.loginUser) {
        this.$router.push("star");
      } else {
        alert("로그인하세요");
      }
    },
  },
};
</script>
<style scoped>
@import "../../public/css/main.css";
@import "../../public/css/house-list.css";
@import "../../public/css/house-search.css";
</style>
