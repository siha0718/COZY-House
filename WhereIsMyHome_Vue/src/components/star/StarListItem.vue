<template>
  <div class="col mb-5">
    <div class="card h-100 shadow">
      <!-- Product image-->
      <img class="card-img-top" src="@/assets/2.jpg" alt="..." @click="test" />
      <!-- Product details-->
      <div class="card-body p-4">
        <div class="text-center">
          <!-- Product name-->
          <h5 class="fw-bolder">{{ star.houseName }}</h5>
          <!-- Product price-->
          {{ star.price }} 만원
        </div>
      </div>
      <!-- Product actions-->
      <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
        <div class="text-center">
          <a class="btn btn-outline-dark mt-auto" href="#" @click.prevent="deleteStar"
            >즐겨찾기 해제</a
          >
        </div>
      </div>
    </div>
  </div>
  <!-- </div> -->
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
export default {
  name: "StarListItem",
  data() {
    return {
      isColor: false,
    };
  },
  props: {
    star: Object,
  },
  methods: {
    ...mapActions(["deleteStar"]),
    ...mapState(["loginUser"]),
    test() {
      console.log(this.star);
    },
    deleteStar() {
      let dstar = {
        userid: this.loginUser().userid,
        houseCode: this.star.houseCode,
      };
      this.$store.dispatch("deleteStar", dstar);
    },
  },
};
</script>

<style>
.shadow {
    box-shadow: 0 0.5rem 1rem rgb(0 0 0 / 15%) !important;
}
</style>
