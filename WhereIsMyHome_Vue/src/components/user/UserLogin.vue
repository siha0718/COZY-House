<template>
  <div class="wrap">
    <div class="login">
      <h2>로그인</h2>
      <div class="login_sns">
        <li>
          <a href="#"><i class="fab fa-instagram"></i></a>
        </li>
        <li>
          <a href="#"><i class="fab fa-facebook-f"></i></a>
        </li>
        <li>
          <a href="#"><i class="fab fa-twitter"></i></a>
        </li>
      </div>

      <div class="login_id">
        <h4>ID</h4>
        <input type="text" class="form-control" id="id" name="userId" v-model="user.userid" />
      </div>

      <div class="login_pw">
        <h4>Password</h4>
        <input type="password" id="pw" name="userPwd" v-model="user.userpwd" />
      </div>

      <div class="login_etc">
        <div class="checkbox">
          <input type="checkbox" name="remember" value="ok" /> 아이디 기억하기
        </div>
      </div>

      <div class="submit">
        <input type="submit" value="submit" @click="dologin" />
      </div>

      <div class="join">
        <a href="regist">회원가입</a>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

export default {
  name: "UserLogin",
  data() {
    return {
      user: {
        userid: "",
        userpwd: "",
      },
    };
  },
  methods: {
    ...mapActions(["setLoginUser"]),
    dologin() {
      this.setLoginUser(this.user);
      // router.push("/");
    },
  },
};
</script>

<style scoped>
@import "../../../public/css/login.css";
</style>
