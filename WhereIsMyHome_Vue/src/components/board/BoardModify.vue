<template>
  <!-- <div id="update">
        <h3>수정폼</h3>
        글번호 :<input type="text" v-model="board.no" readonly><br>
        제목 :<input type="text" v-model="board.title"><br>
        작성자 :<input type="text" v-model="board.writer" readonly><br>
        내용: <textarea cols="30" rows="10" v-model="board.content"></textarea>
        <button @click="modifyBoard(board)">수정</button>
    </div> -->
    <section class="py-5">
    <div class="container px-5">
      <!-- Contact form-->
      <div class="rounded-3 py-5 px-4 px-md-5 mb-5">
        <div class="text-center mb-5">
          <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-envelope"></i></div>
          <h1 class="fw-bolder">게시글 수정</h1>
        </div>
        <div class="row gx-5 justify-content-center">
          <div class="col-lg-8 col-xl-6">
            <!-- * * * * * * * * * * * * * * *-->
            <!-- * * SB Forms Contact Form * *-->
            <!-- * * * * * * * * * * * * * * *-->
            <!-- This form is pre-integrated with SB Forms.-->
            <!-- To make this form functional, sign up at-->
            <!-- https://startbootstrap.com/solution/contact-forms-->
            <!-- to get an API token!-->
            <form id="contactForm" data-sb-form-api-token="API_TOKEN">
              <!-- Name input-->
              <div class="form-floating mb-3">
                <input
                  v-model="board.subject"
                  class="form-control"
                  id="name"
                  type="text"
                  placeholder="제목"
                  required
                  data-sb-validations="required"
                />
                <label for="name">제목</label>
                <div class="invalid-feedback" data-sb-feedback="name:required">A name is required.</div>
              </div>
              <div class="form-floating mb-3">
                <input
                  v-model="board.userid"
                  class="form-control"
                  id="name"
                  type="text"
                  placeholder="작성자"
                  required
                  data-sb-validations="required"
                />
                <label for="name">작성자</label>
                <div class="invalid-feedback" data-sb-feedback="name:required">A name is required.</div>
              </div>

              <!-- Message input-->
              <div class="form-floating mb-3">
                <textarea
                  class="form-control"
                  id="message"
                  type="text"
                  placeholder="게시글을 작성해 주세요"
                  style="height: 20rem"
                  data-sb-validations="required"
                  v-model="board.content"
                ></textarea>
                <!--<label for="message">게시글을 수정해주세요...</label>-->
                <div class="invalid-feedback" data-sb-feedback="message:required">A message is required.</div>
              </div>
              <!-- Submit success message-->
              <!---->
              <!-- This is what your users will see when the form-->
              <!-- has successfully submitted-->
              <div class="d-none" id="submitSuccessMessage">
                <div class="text-center mb-3">
                  <div class="fw-bolder">Form submission successful!</div>
                  To activate this form, sign up at
                  <br />
                  <a href="https://startbootstrap.com/solution/contact-forms"
                    >https://startbootstrap.com/solution/contact-forms</a
                  >
                </div>
              </div>
              <!-- Submit error message-->
              <!---->
              <!-- This is what your users will see when there is-->
              <!-- an error submitting the form-->
              <div class="d-none" id="submitErrorMessage">
                <div class="text-center text-danger mb-3">Error sending message!</div>
              </div>
              <!-- Submit Button-->
              <div class="row subBtn">
                <button class="col-6 btn btn-lg boardBtn" id="modifyButton" @click.prevent="modifyBoard">Modify</button>
                <button class="col-6 btn btn-lg boardBtn" id="deleteButton" @click.prevent="deleteBoard">Delete</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>
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

<style scoped>
@import "../../../public/css/main.css";
@import "../../../public/css/board.css";
.absbtn {
  width: 450px;
  margin: auto;
}
</style>
