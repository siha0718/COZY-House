<template>

  <div id="app">
    <the-header></the-header>
    <router-view/>
  </div>

  
</template>
<script>
import TheHeader from "@/components/TheHeader.vue";

export default {
  components: {
    TheHeader,
  }
  
}
</script>

<style >
body{
  /* background-color: #d2d3fd!important; */
}


#app {
  /* font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;*/
  font-family: Georgia, 'Times New Roman', Times, serif;
  text-align: center;
  color: #2c3e50;
  /* background-color: rgb(255, 252, 248); */
}

.header {
  /* background-image: "@/assets/main.jpg"; */
  background-color: #d2d3fd!important;

  background-size: contain;
  height:200px;
  line-height: 50px;
  font-style: italic;
  font-size: 30px;  
  

}


h1 {
  font-style: italic;

}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}

.btn {
  background-color: #ffffff!important;
  color:#000000!important;
  border: none!important;
}

a {
  color: #2c3034!important;
  text-shadow: 1px 1px 1px gray;
}


.absBtn label {
    text-align : left;
}
.absBtn a {
    color: #2c3034!important;

}

.absBtn {
    width:450px;
    margin:auto;
}

/* .board{
    padding-left: 50px;
} */


.table-striped tbody tr:nth-of-type(odd) {
    /* background-color: rgba(0,0,0,.05); */
    background-color:#fff!important;
}

#article-list a{
    text-shadow: none;
}
</style>


