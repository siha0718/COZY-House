<template>
  <!-- Section-->
  <section class="py-5">
    <div class="container px-4 px-lg-5 mt-5 cardCon">
      <div class="gx-4 gx-lg-5 justify-content-center cardList">
        <!-- start card -->
        <!-- col mb-5  -->
        <!-- <div class="" v-if="starList && starList.length != 0"></div> -->
        <!-- col mb-5 -->
        <div class="row" v-if="starList && starList.length != 0">
          <h4 class="recommTitle mb-5">
            {{ loginUser.username }}님의 즐겨찾기
          </h4>
          <star-list-item
            v-for="(star, index) in starList"
            :key="index"
            :star="star"
            class="col-4"
          ></star-list-item>
        </div>
        <div class="cardList" v-else>매물이 존재하지 않습니다.</div>

        <!-- end card -->
      </div>
    </div>
  </section>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
import StarListItem from "@/components/star/StarListItem.vue";
export default {
  data: {},
  components: {
    StarListItem,
  },
  created() {
    if (!this.loginUser) {
      alert("로그인하세요");
      this.$router.push("/");
    }
    this.getStars;
  },
  computed: {
    ...mapActions(["getStars"]),
    ...mapState(["loginUser"]),
    ...mapState(["starList"]),
  },
};
</script>

<style scoped>
.cardList {
  text-align: center;
}
</style>
