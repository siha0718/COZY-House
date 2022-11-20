<template>
  <div>
    <form action="" id="form-join" class="joinForm">
      <input type="hidden" name="action" value="join">                                                                                     
        <h2>회원가입</h2>
        <div class="textForm">
          <input v-model="userid" name="userid" id="userId" type="text" class="id" placeholder="아이디">
        </div>
        <div class="textForm">
          <input v-model="userpwd" name="password" id="userPwd" type="password" class="pw" placeholder="비밀번호">
        </div>
        <div class="textForm">
          <input v-model="username" name="username" id="userName" type="text" class="name" placeholder="이름">
        </div>
        <div class="textForm">
          <input v-model="email" name="email" id="email" type="text" class="email" placeholder="이메일">
        </div>      
        <button @click.self.prevent="regist" id="btn-join" class="btn">J O I N</button>
    </form>
  </div>
</template>


<script>

import { mapActions } from "vuex";
import axios from "axios";

export default {
  name: "UserList",
  data() {
    return {
      userid: "",
      userpwd: "",
      username: "",
      email: "",
    };
  },
  methods: {
    regist() {
      if (
        this.userid === "" ||
        this.userpwd === "" ||
        this.username === "" ||
        this.email === ""
      ) {
        alert("모든 내용을 입력해주세요");
        return;
      }

      let user = {
        userid: this.userid,
        userpwd: this.userpwd,
        username: this.username,
        email: this.email
      };
      this.$store.dispatch("userStore/createUser", user);
    },
  },

}
</script>

<style>

</style>