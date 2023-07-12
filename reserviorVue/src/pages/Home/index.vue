<template>
  <div class="content home">
    <dv-full-screen-container>
      <HomeTitle></HomeTitle>
      <HomeMain></HomeMain>
      <HomeBottom></HomeBottom>
    </dv-full-screen-container>
  </div>
</template>
  
<script>
import HomeTitle from "@/pages/Home/HomeTitle";
import HomeMain from "@/pages/Home/HomeMain";
import HomeBottom from "@/pages/Home/HomeBottom";
export default {
  name: "Home",
  components: {
    HomeTitle,
    HomeMain,
    HomeBottom,
  },
  data() {
    return {
      reserviorInfo: [],
    };
  },
  mounted() {
    this.init();
  },
  methods: {
    init() {
      console.log("info");
      this.$axios.post("http://localhost:8089/reservoir/select").then((res) => {
        //将后端返回来的json格式的数据转换为String格式
        var reservoirInfo = JSON.stringify(res.data);
        //通过localStorage保存到本地中,命名为localData
        localStorage.setItem("reservoirInfo", reservoirInfo);
      });
    },
  },
};
</script>
  
<style>
* {
  margin: 0;
  padding: 0;
}
.content {
  width: 100%;
  height: 100vh;
  color: #d3d6dd;
  background-color: black;
}
.home {
  background: url(../../assets/bg.png) no-repeat center center;
  background-size: cover;
}
.modul-box {
  display: flex;
  justify-content: space-between;
  margin: 5px;
}
.d-flex {
  display: flex;
}
</style>