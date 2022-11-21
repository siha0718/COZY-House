import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "main",
    // component: HomeView
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
        path: "view/:no",
        name: "boardview",
        component: () => import("@/components/board/BoardView"),
      },
      {
        path: "modify/:no",
        name: "boardmodify",
        component: () => import("@/components/board/BoardModify"),
      },
    ],
  },
  {
    path: "/user",
    name: "user",
    component: () => import("@/views/AppUser.vue"),
    redirect: "/user/login",
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
    path: "/apt",
    name: "apt",
    component: () => import("@/views/AppBoard.vue"),
    redirect: "/apt/search",
    children: [
      {
        path: "search",
        name: "aptsearch",
        component: () => import("@/components/apt/AptSearch.vue"),
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
