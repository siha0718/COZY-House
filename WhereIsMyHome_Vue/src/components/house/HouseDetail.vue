<template>
  <div>
    디테일입니다!

    <house-reply></house-reply>
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
    return {};
  },
  computed: {
    ...mapState(["house"]),
  },
};
</script>
<style></style>
