<template>
  <div>
    <div>{{ board }}</div>
    <div @click="modify">수정하기</div>
  </div>
</template>
<script>
export default {
  name: "BoardView",
  data() {
    return {
      board: {},
    };
  },
  created() {
    this.board = this.$store.state.board;
    console.log(this.board);
  },
  methods: {
    modify() {
      if (this.$store.state.loginUser.userid == this.board.userid) {
        alert("글 작성 유저 접근");
        this.$router.push("/board/modify");
      } else if (this.$store.state.loginUser.userclass == 0) {
        alert("운영자 접근");
        this.$router.push("/board/modify");
      }
    },
  },
};
</script>

<style>
.absBtn label {
  text-align: left;
}
.absBtn a {
  color: #2c3034 !important;
}

.absBtn {
  width: 450px;
  margin: auto;
}

/* .board{
    padding-left: 50px;
} */
</style>
