<template>
  <section class="py-5">
    <div class="container-sm mt-5">
      <!-- <h1 class="underline m-5">List</h1> -->
      <div style="text-align: right" class="mb-3">
        <button @click="moveWrite" class="btn writeBtn">글작성</button>
      </div>
      <div v-if="boardList.length">
        <b-table striped hover id="article-list" :fields="fields" :items="boardList">
          <!-- b-table 안에서 태그에 기능넣고 싶을 떄, template태그 안에서 작성해주면 된다!  -->
          <!-- 1. 특정 컬럼에 클릭 이벤트 -->
          <template #cell(subject)="data">
            <!-- <router-link :to="`/board/view/${data.item.no}`">{{ data.item.subject }}</router-link> -->
            <div @click="view(data.item)">{{ data.item.subject }}</div>
          </template>
          <!-- 2. 특정 컬럼에 filtering -->
          <template #cell(regtime)="data">
            {{ data.item.regtime }}
          </template>
        </b-table>
      </div>
      <div class="text-center" v-else>게시글이 없습니다.</div>
    </div>

  </section>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

export default {
  name: "BoardList",
  components: {},

  data() {
    return {
      articles: [],
      fields: [
        {
          key: "boardno",
          label: "글번호",
          sortable: true,
        },
        {
          key: "subject",
          label: "글제목",
        },
        {
          key: "content",
          label: "글내용",
        },
        {
          key: "userid",
          label: "작성자",
        },
        {
          key: "regtime",
          label: "작성일",
          sortable: true,
        },
      ],
    };
  },

  created() {
    console.log("보드크리에이트");
    this.getBoardList();
  },
  computed: {
    ...mapState(["boardList"]),
  },
  methods: {
    ...mapState(["loginUser"]),
    ...mapActions(["getBoardList", "selectBoard"]),
    moveWrite() {
      if (!this.loginUser()) {
        alert("로그인하세요");
      } else {
        this.$router.push({ name: "boardwrite" });
      }
    },
    view(board) {
      this.selectBoard(board);
      this.$router.push("/board/view");
    },
  },
};
</script>
<style scoped>
@import "../../../public/css/main.css";
@import "../../../public/css/board.css";

</style>
