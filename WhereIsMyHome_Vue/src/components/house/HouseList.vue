<template>
  <div>리스트입니다!</div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

export default {
  name: "HouseList",
  components: {},
  data() {
    return {};
  },
  computed: {
    ...mapState(["houses"]),
  },
};
</script>
<style></style>
