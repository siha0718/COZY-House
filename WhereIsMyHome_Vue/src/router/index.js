import Vue from "vue";
import VueRouter from "vue-router";

import AppMain from "@/views/AppMain.vue";
import AppHouse from "@/views/AppHouse.vue";
import AppStar from "@/views/AppStar.vue";
Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "main",
    component: AppMain,
  },
  {
    path: "/board",
    name: "board",
    component: () => import("@/views/AppBoard.vue"),
    redirect: "/board/list",
    children: [
      {
        path: "list",
        name: "boardlist",
        component: () => import("@/components/board/BoardList"),
      },
      {
        path: "write",
        name: "boardwrite",
        component: () => import("@/components/board/BoardWrite"),
      },
      {
        path: "view",
        name: "boardview",
        component: () => import("@/components/board/BoardView"),
      },
      {
        path: "modify",
        name: "boardmodify",
        component: () => import("@/components/board/BoardModify"),
      },
    ],
  },
  {
    path: "/user",
    name: "user",
    component: () => import("@/views/AppUser.vue"),
    children: [
      {
        // login
        path: "login",
        name: "userlogin",
        component: () => import("@/components/user/UserLogin"),
      },
      {
        //detail
        path: "detail",
        name: "userdetail",
        component: () => import("@/components/user/UserDetail"),
      },
      {
        //regist
        path: "regist",
        name: "userregist",
        component: () => import("@/components/user/UserRegist"),
      },
    ],
  },
  {
    path: "/house",
    name: "house",
    component: AppHouse,
  },
  {
    path: "/detail",
    name: "detail",
    component: () => import("@/components/house/HouseDetail"),
  },
  {
    path: "/star",
    name: "star",
    component: AppStar,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
