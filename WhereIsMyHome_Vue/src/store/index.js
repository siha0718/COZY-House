import router from "@/router";
import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import http from "@/api/http";
import { eventBus } from "../main.js";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);
// import boardStore from '@/store/modules/boardStore.js'

const API_USER_URL = `http://localhost:9999/home/user`;
const API_BOARD_URL = `http://localhost:9999/home/board`;
const API_APT_URL = `http://localhost:9999/home/apt`;
const API_STAR_URL = `http://localhost:9999/home/star`;
const API_COMMNET_URL = `http://localhost:9999/home/comment`;

export default new Vuex.Store({
  state: {
    ////////USER////////
    user: {},
    loginUser: null,
    ////////BOARD////////
    board: {},
    boardList: [],
    ////////APT////////
    sidos: [{ value: null, text: "선택하세요" }],
    guguns: [{ value: null, text: "선택하세요" }],
    houses: [],
    house: null,
    houseCode: null,
    positions: [],
    ////////STAR////////
    starList: [],
    star: {},
    ////////COMMENT////////
    commentList: {},
  },
  getters: {
    loginUser(state) {
      // console.log(state.loginUser);
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
      console.log("최종");
      console.log(user);
      state.loginUser = user;
    },
    DELETE_LOGIN_USER(state) {
      // console.log("뮤테이션 딜리트 실행");
      state.loginUser = null;
    },
    ////////BOARD////////
    GET_BOARD_LIST(state, boardList) {
      state.boardList = boardList;
    },
    CREATE_BOARD(state, board) {
      state.boardList.push(board);
    },
    SET_BOARD(state, board) {
      state.board = board;
    },
    DELETE_BOARD(state, boardno) {
      for (let i = 0; i < state.boardList.length; i++) {
        if (state.boardList[i].boardno == boardno) {
          state.boardList.splice(i, 1);
          break;
        }
      }
    },
    ////////APT////////
    SET_SIDO_LIST(state, sidos) {
      sidos.forEach((sido) => {
        state.sidos.push({ value: sido.code, text: sido.name });
      });
    },
    SET_GUGUN_LIST(state, guguns) {
      guguns.forEach((gugun) => {
        state.guguns.push({ value: gugun.code, text: gugun.name.substr(5) });
      });
    },
    CLEAR_SIDO_LIST(state) {
      state.sidos = [{ value: null, text: "선택하세요" }];
    },
    CLEAR_APT_LIST(state) {
      state.houses = [];
      state.house = null;
    },
    CLEAR_GUGUN_LIST(state) {
      state.guguns = [{ value: null, text: "선택하세요" }];
    },
    SET_HOUSE_LIST(state, houses) {
      state.houses = houses;
    },
    SET_DETAIL_HOUSE(state, house) {
      state.house = house;
    },
    SET_USER_STARS(state, starList) {
      state.starList = starList;
    },
    ADD_USER_STARS(state, star) {
      state.starList.push(star);
    },
    DELETE_USER_STARS(state, star) {
      for (let i = 0; i < state.starList.length; i++) {
        if (state.starList[i].houseCode == star.houseCode) {
          state.starList.splice(i, 1);
          break;
        }
      }
    },
    SET_COMMENT_LIST(state, commentList) {
      state.commentList = commentList;
    },
    ADD_COMMENT_LIST(state, comment) {
      state.commentList.push(comment);
    },
    DELETE_COMMENT(state, cmNum) {
      for (let i = 0; i < state.commentList.length; i++) {
        if (state.commentList[i].cmNum == cmNum) {
          state.commentList.splice(i, 1);
          break;
        }
      }
    },
    SET_HOUSE_CODE(state, houseCode) {
      console.log("SET_HOUSE_CODE", houseCode);
      state.houseCode = houseCode;
    },
  },
  actions: {
    //회원가입
    createUser: function ({ context }, user) {
      axios({
        url: API_USER_URL + `/regist`,
        method: "POST",
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
        .then(async (res) => {
          // console.log(res.data.msg);
          // console.log(res.data.user);
          if (res.data.msg == "success") {
            alert("로그인 성공!");
            // console.log("action"+user.userid);
            await commit("SET_LOGIN_USER", res.data.user);
            router.push({ name: "main" });
          } else {
            alert("로그인 실패");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    //로그아웃
    setLogout: function ({ commit }) {
      commit("DELETE_LOGIN_USER");
      router.push({ name: "main" });
      alert("로그아웃");
    },
    //회원정보 수정
    updateUser: function ({ commit }, user) {
      axios({
        url: API_USER_URL,
        method: "PUT",
        data: user,
      })
        .then((res) => {
          if (res.data.msg == "success") {
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
    deleteUser: function ({ commit, state }) {
      axios({
        url: API_USER_URL,
        method: "DELETE",
        data: state.loginUser,
      })
        .then((res) => {
          if (res.data.msg == "success") {
            alert("삭제 완료!");
            commit("DELETE_LOGIN_USER");
            router.push("/");
          } else {
            alert("삭제 실패");
            console.log(res.data.msg);
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
          if (res.data.msg == "success") {
            commit("GET_BOARD_LIST", res.data.boardList);
          } else {
            alert("글 불러오기 실패");
            console.log(res.data.msg);
            router.push("/");
          }
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
          if (res.data.msg == "success") {
            // console.log("글작성 성공, 라우터 list로 이동");
            commit("CREATE_BOARD", board);
            alert("글 작성 성공");
            router.push("/board/list");
          } else {
            alert("글 작성 실패");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    selectBoard({ commit }, board) {
      // console.log(board);
      commit("SET_BOARD", board);
    },
    updateBoard({ commit }, board) {
      axios({
        url: API_BOARD_URL,
        method: "put",
        data: board,
      })
        .then((res) => {
          if (res.data.msg == "success") {
            commit("SET_BOARD", board);
            router.push("/board/view");
          } else {
            alert("글 수정 실패");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    deleteBoard({ commit }, board) {
      axios({
        url: API_BOARD_URL + "/" + board.boardno,
        method: "delete",
      })
        .then((res) => {
          if (res.data.msg == "success") {
            commit("DELETE_BOARD", board.boardno);
            router.push("/board");
          } else {
            alert("글 삭제 실패");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },

    ////////APT////////
    getSido({ commit }) {
      const url = "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes";
      let params = "regcode_pattern=" + "*00000000" + "&is_ignore_zero=true";
      fetch(`${url}?${params}`)
        .then((response) => response.json())
        .then((data) => {
          // console.log(data.regcodes);
          commit("SET_SIDO_LIST", data.regcodes);
        });
    },
    getGugun({ commit }, sidoCode) {
      const url = "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes";
      let params = "regcode_pattern=" + sidoCode.substr(0, 2) + "*00000" + "&is_ignore_zero=true";
      fetch(`${url}?${params}`)
        .then((response) => response.json())
        .then((data) => {
          // console.log(data.regcodes);
          commit("SET_GUGUN_LIST", data.regcodes);
        });
    },
    getHouseList({ commit }, option) {
      // vue cli enviroment variables 검색
      //.env.local file 생성.
      // 반드시 VUE_APP으로 시작해야 한다.
      //매매 완료정보 (공공 API)
      // console.log("aciton");
      console.log(option);

      let house_list = [];
      if (option.dealType == "done" || "all") {
        let SERVICE_KEY;
        let SERVICE_URL;
        switch (option.houseType) {
          //아파트 검색
          case "apt":
            SERVICE_KEY = process.env.VUE_APP_APT_DEAL_API_KEY;
            // const SERVICE_KEY =
            //   "######################## Service Key ########################";
            SERVICE_URL =
              "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev";
            break;
          //빌라(연립)
          case "villa":
            break;
          //원룸,투룸
          default:
            break;
        }
        const params = {
          LAWD_CD: option.gugunCode.substr(0, 5),
          DEAL_YMD: option.year.substr(0, option.year.length - 1) + option.month.substr(0, option.month.length - 1),
          serviceKey: decodeURIComponent(SERVICE_KEY),
          numOfRows: 20,
        };
        http
          .get(SERVICE_URL, { params })
          .then(({ data }) => {
            house_list = Object.values(data.response.body.items.item);
            // console.log(house_list);
            if (option.dealType == "all") {
              let db_param;
              switch (option.houseType) {
                //아파트 검색
                case "apt":
                  db_param = "apt";
                  break;
                //빌라(연립)
                case "villa":
                  db_param = "villa";
                  break;
                //원룸,투룸
                default:
                  db_param = "ot";
                  break;
              }
              axios({
                url: API_APT_URL,
                method: "get",
                params: {
                  houseType: db_param,
                },
              })
                .then((res) => {
                  // console.log(res);
                  house_list.push(res.data.list);
                  for (let i = 0; i < house_list.length; i++) {
                    if (option.inputSearch) {
                      if (!house_list[i].includes(option.inputSearch)) {
                        //delete
                        house_list.splice(i, 1);
                        i--;
                        break;
                      }
                    }
                    if (option.priceMin) {
                      if (house_list[i].거래금액 < option.priceMin) {
                        //delete
                        house_list.splice(i, 1);
                        i--;
                        break;
                      }
                    }
                    if (option.priceMax) {
                      if (house_list[i].거래금액 > option.priceMax) {
                        //delete
                        house_list.splice(i, 1);
                        i--;
                        break;
                      }
                    }
                  }
                  commit("SET_HOUSE_LIST", house_list);
                })
                .catch((err) => {
                  console.log(err);
                });
            } else {
              //필터
              for (let i = 0; i < house_list.length; i++) {
                if (option.inputSearch) {
                  if (!house_list[i].includes(option.inputSearch)) {
                    //delete
                    house_list.splice(i, 1);
                    i--;
                    break;
                  }
                }
                if (option.priceMin) {
                  if (house_list[i].거래금액 < option.priceMin) {
                    //delete
                    house_list.splice(i, 1);
                    i--;
                    break;
                  }
                }
                if (option.priceMax) {
                  if (house_list[i].거래금액 > option.priceMax) {
                    //delete
                    house_list.splice(i, 1);
                    i--;
                    break;
                  }
                }
              }
              // console.log("요기", house_list);
              commit("SET_HOUSE_LIST", house_list);
              eventBus.$emit("housList", house_list);
            }
          })
          .catch((error) => {
            console.log(error);
          });
      }
      //업자 매물 (디비 rest API)
      else if (option.dealType == "on") {
        let db_param;
        switch (option.houseType) {
          //아파트 검색
          case "apt":
            db_param = "apt";
            break;
          //빌라(연립)
          case "villa":
            db_param = "villa";
            break;
          //원룸,투룸
          default:
            db_param = "ot";
            break;
        }
        axios({
          url: API_APT_URL,
          method: "get",
          params: {
            houseType: db_param,
          },
        })
          .then((res) => {
            // console.log(res);
            house_list.push(res.data.list);
            for (let i = 0; i < house_list.length; i++) {
              if (option.inputSearch) {
                if (!house_list[i].includes(option.inputSearch)) {
                  //delete
                  house_list.splice(i, 1);
                  i--;
                  break;
                }
              }
              if (option.priceMin) {
                if (house_list[i].거래금액 < option.priceMin) {
                  //delete
                  house_list.splice(i, 1);
                  i--;
                  break;
                }
              }
              if (option.priceMax) {
                if (house_list[i].거래금액 > option.priceMax) {
                  //delete
                  house_list.splice(i, 1);
                  i--;
                  break;
                }
              }
            }
            commit("SET_HOUSE_LIST", house_list);
          })
          .catch((err) => {
            console.log(err);
          });
      }
    },
    detailHouse({ commit }, house) {
      // 나중에 house.일련번호를 이용하여 API 호출
      // console.log(commit, house);
      commit("SET_DETAIL_HOUSE", house);
    },

    ///////////////bookmark////////////////////////
    getStars: async function ({ commit, state }) {
      axios({
        url: API_STAR_URL + "/" + state.loginUser.userid,
        method: "GET",
      })
        .then((res) => {
          if (res.data.msg == "success") {
            commit("SET_USER_STARS", res.data.starList);
          } else {
            alert("스타 불러오기 실패");
            router.push("/");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    addStar: function ({ commit, state }, star) {
      axios({
        url: API_STAR_URL,
        method: "post",
        data: star,
      })
        .then((res) => {
          if (res.data.msg == "success") {
            commit("ADD_USER_STARS", star);
          } else {
            alert("스타 추가 실패");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    deleteStar: function ({ commit, state }, star) {
      axios({
        url: API_STAR_URL,
        method: "delete",
        data: star,
      })
        .then((res) => {
          if (res.data.msg == "success") {
            commit("DELETE_USER_STARS", star);
          } else {
            alert("스타 삭제 실패");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },

    ///////////////comment////////////////////////
    addComment: function ({ commit, state }, comment) {
      // console.log("액션애드코멘트", comment);
      axios({
        url: API_COMMNET_URL,
        method: "post",
        data: comment,
      })
        .then((res) => {
          if (res.data.msg == "success") {
            alert("댓글 작성 성공");
            comment.cmNum = res.data.cmNum;
            console.log("받아온 num", res.data.cmNum);
            console.log(comment);
            commit("ADD_COMMENT_LIST", comment);
          } else {
            alert("댓글 작성 실패");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    modifyComment: function ({ commit, state }, comment) {
      //cmNum 을 찾아서 content만 바꿈
      axios({
        url: API_COMMNET_URL,
        method: "put",
        data: comment,
      })
        .then((res) => {
          if (res.data.msg == "success") {
            alert("댓글 수정 성공");
          } else {
            alert("댓글 수정 실패");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getCommentList: function ({ commit, state }, houseCode) {
      //houseCode 와 userid가 일치하는거 가져옴
      // console.log("액션 댓글", houseCode);
      let params = {
        houseCode: houseCode,
        userid: state.loginUser.userid,
      };
      axios({
        url: API_COMMNET_URL,
        method: "get",
        params: params,
      })
        .then((res) => {
          if (res.data.msg == "success") {
            // console.log("커밋");
            commit("SET_COMMENT_LIST", res.data.commentList);
            commit("SET_HOUSE_CODE", houseCode);
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    deleteComment: function ({ commit, state }, cmNum) {
      //houseCode 와 userid가 일치하는거 가져옴
      console.log("액션 댓글", cmNum);
      axios({
        url: API_COMMNET_URL,
        method: "delete",
        data: cmNum,
      })
        .then((res) => {
          if (res.data.msg == "success") {
            commit("DELETE_COMMENT", cmNum);
            alert("삭제 성공");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  modules: {},
  plugins: [createPersistedState()],
});
