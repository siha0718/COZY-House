<template>
  <div action="" id="form-join" class="joinForm">
    <h2>회원수정</h2>
    <div class="textForm">
      <input name="userid" id="userId" type="text" class="id" v-model="user.userid" />
    </div>
    <div class="textForm">
      <input name="userpwd" id="userPwd" type="password" class="pw" v-model="user.userpwd" />
    </div>
    <div class="textForm">
      <input name="username" id="userName" type="text" class="name" v-model="user.username" />
    </div>
    <div class="textForm">
      <input name="email" id="email" type="text" class="email" v-model="user.useremail" />
    </div>
    <input type="submit" id="btn-edit" class="btn" value="E D I T" @click="doModify" />
    <input type="button" id="btn-delete" class="btn" value="D E L E T E" @click="doDelete" />
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
export default {
  name: "UserDetail",
  data() {
    return {
      user: {
        userid: "",
        userpwd: "",
        username: "",
        useremail: "",
      },
    };
  },
  methods: {
    ...mapState(["loginUser"]),
    ...mapActions(["deleteUser", "updateUser"]),
    doModify() {
      if (
        this.user.userid === "" ||
        this.user.userpwd === "" ||
        this.user.username === "" ||
        this.user.useremail === ""
      ) {
        alert("모든 내용을 입력해주세요");
        return;
      }
      this.updateUser(this.user);
    },
    doDelete() {
      this.deleteUser();
    },
  },
};
</script>

<style scoped>
@import "../../../public/css/user-regist.css";
</style>
