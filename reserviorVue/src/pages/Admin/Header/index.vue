<template>
  <div class="head">
    <div class="logo">
      <img src="../../../assets/logo.png" style="width:100%;" alt="">
    </div>
    <span class="header-title">reservior后台管理系统</span>
    <div class="right">
      <el-button style="background-color:transparent;border:0;color:aliceblue;font-size:18px" icon="el-icon-search" circle></el-button>
      <el-button style="background-color:transparent;border:0;color:aliceblue;font-size:22px;margin:0 5px" icon="el-icon-user-solid" circle></el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Header",
  components: {},
};
</script>

<style>
.head {
  width: 100%;
  height: 50px;
  background: #5433ff; /* fallback for old browsers */
  background: -webkit-linear-gradient(
    to left,
    #a5fecb,
    #20bdff,
    #5433ff
  ); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(
    to left,
    #a5fecb,
    #20bdff,
    #5433ff
  ); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}

.logo{
  float: left;
  width:30px;
  height:30px;
  padding:10px 5px 10px 10px;
  line-height:50px;
}

.header-title{
  line-height: 50px;
  color: aliceblue;
  font-size: 18px;
}

.right{
  float: right;
  line-height: 50px;
}
</style>