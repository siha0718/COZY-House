<template>
  <div>
    <div @click="displayMarker()">ddddddddd</div>
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
      markerPositions1: [
        [37.5693369136369, 127.025374102832],
        [37.5608432938815, 127.02668707042],
        [37.5684498209013, 127.028040516397],
      ],
      housepos: [],
    };
  },

  //mounted ==========================================================================================
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=fd238029c35092754edfae10d0b0e6f9&libraries=services&autoload=false";
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

      //지도 객체를 등록합니다.
      //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
      this.map = new kakao.maps.Map(container, options);
    },

    displayMarker(houseList) {
      console.log("디스플레이마커!!");
      console.log(houseList);
      var housePosition = [];
      // 주소로 좌표를 검색합니다
      var geocoder = new kakao.maps.services.Geocoder();
      for (let i = 0; i < houseList.length; i++) {
        let where = houseList[i].법정동 + " " + houseList[i].지번;
        geocoder.addressSearch(where, function (result, status) {
          if (status === kakao.maps.services.Status.OK) {
            let tmp = new kakao.maps.LatLng(result[0].y, result[0].x);
            housePosition.push([tmp.Ma, tmp.La]);
          }
        });
      }
      console.log("housePosition", housePosition);
      console.log("this.markerPositions1", this.markerPositions1);

      const positions = this.markerPositions1.map((position) => new kakao.maps.LatLng(...position));

      if (positions.length > 0) {
        this.markers = positions.map(
          (position) =>
            new kakao.maps.Marker({
              map: this.map,
              position,
            })
        );

        const bounds = positions.reduce(
          (bounds, latlng) => bounds.extend(latlng),
          new kakao.maps.LatLngBounds()
        );

        this.map.setBounds(bounds);
      }
    },
  },

  //computed ==========================================================================================
  computed: {
    ...mapState(["houses"]),
  },
  created() {
    eventBus.$on("housList", (housList) => {
      this.displayMarker(housList);
    });
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#map {
  width: 600px;
  height: 600px;
}

.button-group {
  margin: 10px 0px;
}

button {
  margin: 0 3px;
}
</style>
