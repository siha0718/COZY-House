import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import BootstrapVue from "bootstrap-vue";
import "bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
import store from "./store";

Vue.use(BootstrapVue);
Vue.config.productionTip = false;
export const eventBus = new Vue();

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
