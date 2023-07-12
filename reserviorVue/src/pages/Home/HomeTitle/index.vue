<template>
  <div>
    <div class="modul-box">
      <!-- 二等分 -->
      <div style="flex: 0 1 30%">
        <dv-decoration-10 style="width: 100%; height: 5px" />
        <div style="width: 100%; height: 45px; padding-top: 10px">
          <dv-decoration-7
            style="width: 50%; height: 30px; float: left; bottom: 0"
            ><el-button type="text" @click="toDam">国内外堰塞坝案例</el-button></dv-decoration-7
          >
          <dv-decoration-7 style="width: 50%; height: 30px; float: left"
            ><el-button type="text" @click="toReservior">浙江省内水库</el-button></dv-decoration-7
          >
        </div>
      </div>
      <div style="flex: 0 1 40%">
        <!-- 三等分 -->
        <div class="d-flex">
          <dv-decoration-8 style="width: 300px; height: 50px; flex: 1" />
          <dv-decoration-11 style="width: 200px; height: 50px"
            >水库安全智能评估系统</dv-decoration-11
          >
          <dv-decoration-8
            :reverse="true"
            style="width: 300px; height: 50px; flex: 1"
          />
        </div>
      </div>
      <div style="flex: 0 1 30%">
        <dv-decoration-10
          style="width: 100%; height: 5px; transform: rotateY(180deg)"
        />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeTitle",
  components: {},
  methods:{
    toDam(){
      this.$router.push({ path: "/home" });
    },
    toReservior(){
      this.$router.push({ path: "/reservior" });
    }
  }
};
</script>

<style>
</style>