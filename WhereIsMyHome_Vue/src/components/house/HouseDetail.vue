<template>
  <div>
    <!-- 디테일입니다!
    {{ house.아파트 }} -->
    <section class="py-5">
      <div class="container px-4 px-lg-5 my-5">
        <div class="row gx-4 gx-lg-5 align-items-center">
          <div class="col-md-6">
            <img class="card-img-top mb-5 mb-md-0" src="@/assets/2.jpg" alt="..." />
            <div class="mb-5"></div>
            <house-reply></house-reply>
          </div>
          <div class="col-md-6">
            <div class="small mb-1">등록번호 {{ house.지역코드 }}</div>
            <h1 class="display-5 fw-bolder">
              {{ house.아파트 }}
            </h1>
            <div class="fs-5 mb-5">
              <!-- <span class="text-decoration-line-through"></span> -->
              <span>{{ house.거래금액 }}만원</span>
              <div class="borderStyle mt-5"></div>
            </div>
            <div>
              <ul class="detailList">
                <li>{{ house.년 + "/" + house.월 }} 등록 매물</li>
                <li>투룸(욕실2개)</li>
                <li>세대당 1대 주차 가능</li>
                <li>{{ house.층 }}층</li>
                <li>즉시 입주 가능</li>
                <li>남향</li>
                <li>엘레베이터 있음</li>
                <li>on : {{ house.star }}</li>
              </ul>
            </div>
            <div class="borderStyle mt-5 mb-5"></div>
            <h4 class="">관리비 15만원</h4>
            <ul class="detailList">
              <li>포함 : 없음</li>
              <li>별도 : 전기, 가스, 수도, 인터넷, 티비</li>
            </ul>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
//디테일 밑에 댓글 컴포넌트
import HouseReply from "@/components/house/HouseReply.vue";

export default {
  name: "HouseDetail",
  components: {
    HouseReply,
  },

  data() {
    return {
      content: "",
    };
  },
  created() {
    // if (!this.house) {
    //   alert("잘못된 접근");
    //   this.$router.push("/");
    // }
  },
  computed: {
    ...mapState(["house", "houseCode", "loginUser", "commentList"]),
  },
  methods: {},
};
</script>
<style scoped>
@import "../../../public/css/house-detail.css";
</style>
