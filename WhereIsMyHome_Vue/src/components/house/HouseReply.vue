<template>
  <div>
    <div>댓글</div>
    <input type="text" v-model="content" />
    <div @click="writecomment">댓글작성</div>
    <div v-for="comment in commentList">
      <div>
        {{ comment }}
      </div>
      <div @click="deletecomment(comment.cmNum)">댓글삭제</div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
export default {
  data() {
    return {
      content: "",
    };
  },
  computed: {
    ...mapState(["commentList"]),
  },
  methods: {
    // ...mapState(["loginUser", "houseCode"]),
    writecomment() {
      if (this.content) {
        let comment = {
          content: this.content,
          houseCode: this.$store.state.houseCode,
          userid: this.$store.state.loginUser.userid,
        };
        this.$store.dispatch("addComment", comment);
      }
    },
    deletecomment(cmNum) {
      this.$store.dispatch("deleteComment", cmNum);
    },
  },
};
</script>

<style></style>
