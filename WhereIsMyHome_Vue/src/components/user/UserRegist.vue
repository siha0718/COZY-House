<template>
  <div action="" id="form-join" class="joinForm">
    <h2>회원가입</h2>
    <div class="textForm">
      <input
        name="userid"
        id="userId"
        type="text"
        class="id"
        v-model="user.userid"
        placeholder="ID"
      />
    </div>
    <div class="textForm">
      <input
        name="userpwd"
        id="userPwd"
        type="password"
        class="pw"
        placeholder="PASSWORD"
        v-model="user.userpwd"
      />
    </div>
    <div class="textForm">
      <input
        name="username"
        id="userName"
        type="text"
        class="name"
        placeholder="NAME"
        v-model="user.username"
      />
    </div>
    <div class="textForm">
      <input
        name="email"
        id="email"
        type="text"
        class="email"
        placeholder="EMAIL"
        v-model="user.useremail"
      />
    </div>

    <input
      type="submit"
      id="btn-join"
      class="btn"
      value="J O I N"
      @click="doRegist"
    />
  </div>
</template>

<script>
export default {
  name: "UserRegist",
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
    doRegist() {
      if (
        this.user.userid === "" ||
        this.user.userpwd === "" ||
        this.user.username === "" ||
        this.user.useremail === ""
      ) {
        alert("모든 내용을 입력해주세요");
        return;
      }
      this.$store.dispatch("createUser", this.user);
    },
  },
};
</script>

<style scoped>
@import "../../../public/css/user-regist.css";
</style>
