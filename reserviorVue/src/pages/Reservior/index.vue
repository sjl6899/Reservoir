<template>
  <div class="content home">
    <dv-full-screen-container>
      <HomeTitle></HomeTitle>
      <ReserviorMain></ReserviorMain>
    </dv-full-screen-container>
  </div>
</template>
    
  <script>
import HomeTitle from "@/pages/Home/HomeTitle";
import ReserviorMain from "@/pages/Reservior/ReserviorMain";
export default {
  name: "Reservior",
  components: {
    HomeTitle,
    ReserviorMain,
  },
  data() {
    return {
      zjreserviorInfo: [],
    };
  },
  mounted() {
    this.init();
  },
  methods: {
    init() {
      this.$axios
        .post("http://localhost:8089/zjreservoir/select")
        .then((res) => {
          //将后端返回来的json格式的数据转换为String格式
          var zjreservoirInfo = JSON.stringify(res.data);
          //通过localStorage保存到本地中,命名为localData
          localStorage.setItem("zjreservoirInfo", zjreservoirInfo);
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