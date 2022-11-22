<template>
  <div class="list">
    <img src="@/assets/2.jpg" alt="" />
    <ul>
      <li>{{ house.아파트 }}</li>
      <li>
        <strong
          >{{
            (parseInt(house.거래금액.replace(",", "")) * 10000) | price
          }}원</strong
        >
      </li>
      <li>51.24㎡ 2층</li>
      <li>서초구 {{ house.법정동 }}</li>
      <li>★신축2룸★전용15평★에어컨3대★논현동</li>
    </ul>
    <svg
      xmlns="http://www.w3.org/2000/svg"
      width="16.644"
      height="22.774"
      viewBox="0 0 16.644 22.774"
    >
      <g
        id="그룹_21"
        data-name="그룹 21"
        transform="translate(-4086.086 -233.5)"
      >
        <line
          id="선_16"
          data-name="선 16"
          x2="13.815"
          transform="translate(4087.5 234.5)"
          fill="none"
          stroke="#a38f85"
          stroke-linecap="round"
          stroke-width="2"
        />
        <line
          id="선_17"
          data-name="선 17"
          y1="20.359"
          transform="translate(4101.315 234.5)"
          fill="none"
          stroke="#a38f85"
          stroke-linecap="round"
          stroke-width="2"
        />
        <line
          id="선_18"
          data-name="선 18"
          y1="20.359"
          transform="translate(4087.5 234.5)"
          fill="none"
          stroke="#a38f85"
          stroke-linecap="round"
          stroke-width="2"
        />
        <line
          id="선_19"
          data-name="선 19"
          y1="6.908"
          x2="6.908"
          transform="translate(4087.5 247.952)"
          fill="none"
          stroke="#a38f85"
          stroke-linecap="round"
          stroke-width="2"
        />
        <line
          id="선_20"
          data-name="선 20"
          x1="6.908"
          y1="6.908"
          transform="translate(4094.408 247.952)"
          fill="none"
          stroke="#a38f85"
          stroke-linecap="round"
          stroke-width="2"
        />
      </g>
    </svg>
  </div>
</template>

<script>
export default {
  name: "HouseListItem",
  data() {
    return {
      isColor: false,
    };
  },
  props: {
    house: Object,
  },
  // methods: {
  //   ...mapActions(houseStore, ["detailHouse"]),
  //   selectHouse() {
  //     // console.log("listRow : ", this.house);
  //     // this.$store.dispatch("getHouse", this.house);
  //     this.detailHouse(this.house);
  //   },
  //   colorChange(flag) {
  //     this.isColor = flag;
  //   },
  // },
};
</script>

<style></style>
