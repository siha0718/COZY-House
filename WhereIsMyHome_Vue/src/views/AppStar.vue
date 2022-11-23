<template>
  <!-- Section-->
  <section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
      <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
        <!-- start card -->

        <div class="col mb-5 cardList" v-if="starList && starList.length != 0">
          <star-list-item v-for="(star, index) in starList" :key="index" :star="star" />
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

<style></style>
