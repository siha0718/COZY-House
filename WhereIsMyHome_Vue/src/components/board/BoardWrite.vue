<template>
  <!-- Page content-->
  <section class="py-5">
    <div class="container px-5">
      <!-- Contact form-->
      <div class="rounded-3 py-5 px-4 px-md-5 mb-5">
        <div class="text-center mb-5">
          <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-envelope"></i></div>
          <h1 class="fw-bolder">게시글 작성</h1>
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
                <label for="message">게시글을 작성해주세요...</label>
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
                <button class="col-6 btn btn-lg boardBtn" id="submitButton" @click.prevent="newPost">Submit</button>
                <button class="col-6 btn btn-lg boardBtn" id="cancelButton" type="reset">Cancel</button>
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
  name: "BoardWrite",
  data() {
    return {
      board: {
        subject: "",
        content: "",
      },
    };
  },
  components: {},
  methods: {
    ...mapActions(["createBoard"]),
    newPost() {
      let board = {
        subject: this.board.subject,
        content: this.board.content,
        userid: this.$store.state.loginUser.userid,
      };
      // console.log(board);
      this.createBoard(board);
    },
  },
};
</script>

<style scoped>
@import "../../../public/css/main.css";
@import "../../../public/css/board.css";
</style>
