<template>
  <!--<div>
    <div>Comment</div>
    <input type="text" v-model="content" />
    <div @click="writecomment">댓글작성</div>
    <div v-for="comment in commentList">
      <div>
        {{ comment }}
      </div>
      <div @click="deletecomment(comment.cmNum)">댓글삭제</div>
    </div>
  </div>-->

  <!-- Comments section-->
  <section>
    <div class="card bg-light commBg">
      <div class="card-body">
        <!-- Comment form-->
        <form class="mb-4">
          <textarea class="form-control" rows="3" placeholder="댓글을 남겨주세요..." v-model="content"></textarea>
          <button class="btn" @click="writecomment">작성</button>
        </form>

        <!-- Comment with nested comments-->
        <div class="mb-4">
          <!-- Parent comment-->
          
          <div class="row">
            <div v-for="comment in commentList">
              <div class="fw-bold col-8">{{comment.userid}}</div>
              <div>
                {{ comment.content }}
              </div>
              <div class="btn col-4" @click.prevent="deletecomment(comment.cmNum)">삭제</div>
            </div>
            
          
          </div>
        </div>
       
      </div>
    </div>
  </section>
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

<style scoped>
/*@import "../../../public/css/board.css";*/

.btn{
  width:70px;
  height:30px;
  right:0px;
  background-color:none;
  border-color: none!important;
  font-size:10px;
  float:right;
}
</style>
