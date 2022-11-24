<template>
  <!--<div>
    <div>{{ board }}</div>
    <div @click="modify">수정하기</div>
  </div>-->

  <section class="py-5">
    <div class="container px-5 my-5">
      <div class="row gx-5">
        <div class="col-lg-3">
          <div class="d-flex align-items-center mt-lg-5 mb-4">
            <img class="img-fluid rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." />
            <div class="ms-3">
              <div class="fw-bold">{{board.userid}}</div>
              <div class="text-muted">News, Business</div>
            </div>
          </div>
        </div>
        <div class="col-lg-9">
          <!-- Post content-->
          <article>
            <!-- Post header-->
            <header class="mb-4">
              <!-- Post title-->
              <h1 class="boardTitle mb-1">{{ board.subject }}</h1>
              <!-- Post meta content-->
              <div class="text-muted fst-italic mt-2 mb-2">{{board.regtime}}</div>
             
            </header>
        
            
            <!-- Post content-->
            <section class="mb-5 postSec">
              <p class="fs-5 mt-4 mb-4">{{board.content}}</p>              
            </section>
          </article>


          <!-- Comments section-->
          <section>
            <div class="card bg-light commBg">
              <div class="card-body">
                <!-- Comment form-->
                <form class="mb-4"><textarea class="form-control" rows="3"
                    placeholder="댓글을 남겨주세요..."></textarea></form>
                <!-- Comment with nested comments-->
                <div class="d-flex mb-4">
                  <!-- Parent comment-->
                  <div class="flex-shrink-0"><img class="rounded-circle"
                      src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div>
                  <div class="ms-3">
                    <div class="fw-bold">Siha Kim</div>
                    If you're going to lead a space frontier, it has to be government; it'll never be private
                    enterprise. Because the space frontier is dangerous, and it's expensive, and it has unquantified
                    risks.
                    <!-- Child comment 1-->
                    <div class="d-flex mt-4">
                      <div class="flex-shrink-0"><img class="rounded-circle"
                          src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div>
                      <div class="ms-3">
                        <div class="fw-bold">Dong Hyeck Choi</div>
                        And under those conditions, you cannot establish a capital-market evaluation of that enterprise.
                        You can't get investors.
                      </div>
                    </div>
                    <!-- Child comment 2-->
                    <div class="d-flex mt-4">
                      <div class="flex-shrink-0"><img class="rounded-circle"
                          src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div>
                      <div class="ms-3">
                        <div class="fw-bold">Siha Kim</div>
                        When you put money directly to a problem, it makes a good headline.
                      </div>
                    </div>
                  </div>
                </div>
                <!-- Single comment-->
                <div class="d-flex">
                  <div class="flex-shrink-0"><img class="rounded-circle"
                      src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div>
                  <div class="ms-3">
                    <div class="fw-bold">admin</div>
                    When I look at the universe and all the ways the universe wants to kill us, I find it hard to
                    reconcile that with statements of beneficence.
                  </div>
                </div>
              </div>
            </div>
          </section>
        </div>
      </div>
    </div>
  </section>
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
@import "../../../public/css/main.css";
@import "../../../public/css/board.css";


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

.postSec{
  margin-top:40px;
  /*border: 0.01rem solid rgb(44, 48, 52, 0.3);*/
  padding : 10px 10px 10px 10px;
  height:max-content;
}

/* .board{
    padding-left: 50px;
} */
</style>
