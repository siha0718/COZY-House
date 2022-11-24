<template>
  <!-- <div id="update">
        <h3>수정폼</h3>
        글번호 :<input type="text" v-model="board.no" readonly><br>
        제목 :<input type="text" v-model="board.title"><br>
        작성자 :<input type="text" v-model="board.writer" readonly><br>
        내용: <textarea cols="30" rows="10" v-model="board.content"></textarea>
        <button @click="modifyBoard(board)">수정</button>
    </div> -->
  <div>
    <h1 class="underline mt-5">Modify</h1>
    <div class="absbtn mt-5">
      <b-form>
        <b-form-group id="input-group-1" label="No:" label-for="input-1" description="">
          <b-form-input id="input-1" v-model="board.boardno" type="text" readonly> </b-form-input>
        </b-form-group>

        <b-form-group
          id="input-group-2"
          label="Title:"
          label-for="input-2"
          description="수정하실 글의 제목을 입력해주세요."
        >
          <b-form-input
            id="input-2"
            v-model="board.subject"
            type="text"
            placeholder="글 제목"
            required
          >
          </b-form-input>
        </b-form-group>

        <b-form-group id="input-group-3" label="Writer:" label-for="input-3">
          <b-form-input
            id="input-3"
            v-model="board.userid"
            placeholder="작성자"
            required
          ></b-form-input>
        </b-form-group>

        <b-form-group id="input-group-4" label="Contents:" label-for="input-4">
          <b-form-textarea id="input-4" v-model="board.content" placeholder="내용..." required>
          </b-form-textarea>
        </b-form-group>

        <div style="padding-top: 15px">
          <b-button @click="modifyBoard">Modify</b-button>
          <b-button @click.prevent="deleteBoard">Delete</b-button>
        </div>
      </b-form>
      <!-- <b-card class="mt-3" header="Form Data Result">
                <pre class="m-0">{{ board }}</pre>
            </b-card> -->
    </div>
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

export default {
  name: "boardmodify",
  data() {
    return {
      board: {
        boardno: "",
        subject: "",
        content: "",
        userid: "",
      },
    };
  },
  created() {
    let tboard = this.$store.state.board;
    this.board.boardno = tboard.boardno;
    this.board.subject = tboard.subject;
    this.board.content = tboard.content;
    this.board.userid = tboard.userid;
  },
  methods: {
    ...mapActions(["updateBoard", "deleteBoard"]),
    modifyBoard() {
      this.updateBoard(this.board);
    },
    deleteBoard() {
      console.log("딜리트호출");
      this.$store.dispatch("deleteBoard", this.board);
    },
  },
};
</script>

<style>
.absbtn {
  width: 450px;
  margin: auto;
}
</style>
