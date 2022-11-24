<template>
  <div>
    <div id="map"></div>
  </div>
</template>
<script>
import { mapActions, mapState } from "vuex";
import { eventBus } from "../../main.js";

export default {
  name: "KakaoMap",
  data() {
    return {
      markers: [],
      infowindow: null,
      housepos: [],
    };
  },

  //mounted ==========================================================================================
  mounted() {
    console.log("마운트");
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=a55445555a66d8b5e8ad74af0600510c&libraries=services";
      //"//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=fd238029c35092754edfae10d0b0e6f9&libraries=services";
      document.head.appendChild(script);
    }
  },

  //methods ==========================================================================================
  methods: {
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(37.566824, 126.978649),
        level: 5,
      };
      this.map = new kakao.maps.Map(container, options);
    },
    async getLatLng(addr) {
      // 주소-좌표 변환 객체를 생성합니다
      let geocoder = new kakao.maps.services.Geocoder();

      return await new Promise((resolve) => {
        geocoder.addressSearch(addr, function (result, status) {
          // 정상적으로 검색이 완료됐으면
          if (status === kakao.maps.services.Status.OK) {
            resolve(new kakao.maps.LatLng(result[0].y, result[0].x));
          }
        });
      });
    },

    async displayMarker(houseList) {
      // console.log("디스플레이마커!!");

      var geocoder = new kakao.maps.services.Geocoder();
      let housePosition = [];
      // console.log(housePosition);
      for (let i = 0; i < houseList.length; i++) {
        let where = houseList[i].법정동 + " " + houseList[i].지번;
        let tmp = await this.getLatLng(where);
        housePosition.push([tmp.Ma, tmp.La]);
      }

      // console.log(housePosition);

      if (this.markers.length > 0) {
        this.markers.forEach((marker) => marker.setMap(null));
      }
      const positions = housePosition.map((position) => new kakao.maps.LatLng(...position));

      if (positions.length > 0) {
        this.markers = positions.map(
          (position) =>
            new kakao.maps.Marker({
              map: this.map,
              position,
            })
        );

        const bounds = positions.reduce((bounds, latlng) => bounds.extend(latlng), new kakao.maps.LatLngBounds());

        this.map.setBounds(bounds);
      }
    },
  },

  //computed ==========================================================================================
  computed: {
    ...mapState(["houses"]),
  },
  created() {
    eventBus.$on("housList", (houseList) => {
      this.displayMarker(houseList);
    });
  },
};
</script>
<style scoped>
#map {
  width: 100%;
  height: 1080px;
}

.button-group {
  margin: 10px 0px;
}

button {
  margin: 0 3px;
}
</style>
