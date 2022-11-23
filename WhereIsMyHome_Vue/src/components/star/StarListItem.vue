<template>
  <div class="card h-100">
    <!-- Product image-->
    <img class="card-img-top" src="@/assets/2.jpg" alt="..." @click="test" />
    <!-- Product details-->
    <div class="card-body p-4">
      <div class="text-center">
        <!-- Product name-->
        <h5 class="fw-bolder">{{ star.houseName }}</h5>
        <!-- Product price-->
        {{ star.price }}
      </div>
    </div>
    <!-- Product actions-->
    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
      <div class="text-center">
        <a class="btn btn-outline-dark mt-auto" href="#">즐겨찾기 해제</a>
      </div>
    </div>
  </div>
</template>

<script>
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
    test() {
      console.log(this.star);
    },
  },
};
</script>

<style></style>
