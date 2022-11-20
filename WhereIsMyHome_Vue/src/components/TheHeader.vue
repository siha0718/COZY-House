<!-- 자식이 없는 vue -> TheName.vue -->
<template>
  <div>
    <div class="header">
      <router-link to="/">
        main
        <!-- <img src="@/assets/main.jpg" style="height:300px " alt="" /> -->
      </router-link>
      
      <!-- <div class="boardTitle">>
        <router-link to="/board">Board</router-link>
      </div> -->
    
    </div>

    <div>
      <!-- <router-link to="/user">로그인</router-link> -->
      <!-- <router-link to="/board">게시판</router-link> -->
      <b-navbar toggleable="lg" type="dark" class="menu">
        <b-navbar-brand href="#">Menu</b-navbar-brand>

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
          <!-- 
          <b-navbar-nav>
            <b-nav-item :to="'/'">Home -</b-nav-item>
          </b-navbar-nav> 
        -->

          <!-- Right aligned nav items -->
          <b-navbar-nav class="ml-auto">

            <b-nav-item-dropdown text="Board" right>
              <b-dropdown-item :to="'/board'">글 목록보기</b-dropdown-item>
              <b-dropdown-item :to="'/board/write'">글 작성하기</b-dropdown-item>
            </b-nav-item-dropdown>

            <b-nav-item-dropdown text="User">
              <b-dropdown-item :to="'/user/login'">로그인</b-dropdown-item>
              <b-dropdown-item :to="'/user/regist'">회원가입</b-dropdown-item>
            </b-nav-item-dropdown>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </div>

  </div>
    

  
</template>

<script>
export default {
    name: "TheHeader",
}
</script>

<style>
.header {
  /* padding: 30px; */
  text-align: center;
  box-shadow: 0px 1px 10px rgba(159, 157, 157, 0.3);
  /* background-image: "@/assets/main.jpg"; */
  /* background-size: cover; */
  /* height: 150px; */
}
a {
  font-weight: bold;
  color: #0d1218;
}
a:hover {
  color: #42b983;
}

.boardTitle {
  padding-top :65px;
}


.boardTitle a { 
  color:#fff!important;
  
}

.menu {
  background-color: #d2d3fd!important;

}

.menu a {
  color:#fff!important;
}
</style>
