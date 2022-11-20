import router from "@/router";
import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

Vue.use(Vuex);
// import boardStore from '@/store/modules/boardStore.js'

const API_USER_URL = `http://localhost:9999/vue/user`;
const API_BOARD_URL = `http://localhost:9999/vue/board`;

export default new Vuex.Store({
  state: {
    user: {},
    loginUser: null,
    ////////BOARD////////
    board: {},
    boardList: [],
  },
  getters: {
    loginUser(state) {
      console.log(state.loginUser);
      return state.loginUser;
    },
    ////////BOARD////////
    getboard(state) {
      return state.board;
    },
    getboardlist(state) {
      return state.boardList;
    },
  },
  mutations: {
    SET_LOGIN_USER(state, user) {
      state.loginUser = user;
    },
    DELETE_LOGIN_USER(state) {
      state.loginUser = null;
    },
    ////////BOARD////////
    GET_BOARD_LIST(state, boardList) {
      state.boardList = boardList;
    },
    CREATE_BOARD(state, board) {
      state.boardList.push(board);
    },
    SET_BOARD(state, articleno) {
      for (let i = 0; i < state.boardList.length; i++) {
        if (boardList[i].articleno == articleno) {
          state.board = boardList[i];
          break;
        }
      }
    },
    UPDATE_BOARD(state, board) {
      for (let i = 0; i < state.boardList.length; i++) {
        if (boardList[i].articleno == board.articleno) {
          state.boardList.splice(i, i + 1);
          break;
        }
      }
    },
    DELETE_BOARD(state, articleno) {
      for (let i = 0; i < state.boardList.length; i++) {
        if (boardList[i].articleno == articleno) {
          state.board = boardList[i];
          break;
        }
      }
    },
  },
  actions: {
    //회원가입
    createUser: function ({ context }, user) {
      console.log(user);
      axios({
        url: API_USER_URL + `/regist`,
        method: "post",
        data: user,
      })
        .then((res) => {
          console.log(res.data.msg);
          if (res.data.msg == "success") {
            alert("등록되었습니다.");
            router.push("/user/login");
          } else {
            alert("등록실패.");
            router.push("/user/regist");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    //로그인
    setLoginUser: function ({ commit }, user) {
      axios({
        url: API_USER_URL + `/login`,
        method: "POST",
        data: user,
      })
        .then((res) => {
          // console.log(res.data.msg);
          if (res.data.msg == "success") {
            alert("로그인 성공!");
            // console.log("action"+user.userid);
            commit("SET_LOGIN_USER", res.data.user);
            router.push("/");
          } else {
            alert("로그인 실패");
            router.push("/user/login");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    //회원정보 수정
    updateUser: function ({ commit }, user) {
      axios({
        url: API_USER_URL,
        method: "PUT",
        data: user,
      })
        .then((res) => {
          if (res.msg == "success") {
            alert("수정 성공!");
            commit("SET_LOGIN_USER", user);
            router.push("/user/detail");
          } else {
            alert("수정 실패");
            router.push("/user/detail");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    //회원탈퇴
    deleteUser: function ({ commit }, user) {
      axios({
        url: API_USER_URL,
        method: "DELETE",
        data: user,
      })
        .then((res) => {
          if (res == 1) {
            alert("삭제 완료!");
            commit("DELETE_LOGIN_USER");
            router.push("/");
          } else {
            alert("삭제 실패");
            router.push("/user/detail");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    ////////BOARD////////
    getBoardList({ commit }) {
      axios({
        url: API_BOARD_URL,
        method: "get",
      })
        .then((res) => {
          // console.log(res);
          commit("GET_BOARD_LIST", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    createBoard({ commit }, board) {
      axios({
        url: API_BOARD_URL,
        method: "post",
        data: board,
      })
        .then((res) => {
          console.log(res);
          commit("CREATE_BOARD", board);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    selectBoard({ commit }, board_num) {
      commit("SET_BOARD", board_num);
    },
    updateBoard({ context }, board) {
      axios({
        url: API_BOARD_URL,
        method: "put",
        data: board,
      })
        .then((res) => {
          console.log(res);
          commit("UPDATE_BOARD", board);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    deleteBoard({ context }, board_num) {
      axios({
        url: API_BOARD_URL,
        method: "delete",
        data: board,
        params: {
          articleno: board_num,
        },
      })
        .then((res) => {
          console.log(res);
          commit("DELETE_BOARD", board_num);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    ////////BOARD////////
  },
  modules: {},
});
