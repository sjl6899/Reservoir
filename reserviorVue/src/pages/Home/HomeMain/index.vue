<template>
  <div>
    <div class="modul-box">
      <div style="flex: 0 1 30%">
        <dv-border-box-11
          title="最大水力梯度"
          style="width: 100%; height: 250px"
        >
          <dv-scroll-ranking-board
            :config="maxhg"
            style="width: 94%; height: 185px; padding: 40px 2.5% 20px 3.5%"
          />
        </dv-border-box-11>
        <dv-border-box-11 title="堰塞坝体积" style="width: 100%; height: 250px">
          <dv-scroll-ranking-board
            :config="bulk"
            style="width: 94%; height: 185px; padding: 40px 2.5% 20px 3.5%"
          />
        </dv-border-box-11>
      </div>
      <div style="flex: 0 1 40%">
        <dv-border-box-13 style="width: 100%; height: 100px">
          <div class="gnwreservior" style="padding-top:10px 5px;">
            <dv-border-box-7 class="gnwreserviormessage">
              <span style="margin-left: 5px">水库总数</span>
              <span class="warnmessagenum">6</span>
            </dv-border-box-7>
            <dv-border-box-7 class="gnwreserviormessage">
              <span style="margin-left: 5px">大型</span>
              <span class="warnmessagenum">4</span>
            </dv-border-box-7>
            <dv-border-box-7 class="gnwreserviormessage">
              <span style="margin-left: 5px">小型</span>
              <span class="warnmessagenum">2</span>
            </dv-border-box-7>
          </div>
        </dv-border-box-13>
        <dv-border-box-8 style="width: 100%; height: 400px">
          <Map3d></Map3d>
        </dv-border-box-8>
      </div>
      <div style="flex: 0 1 30%">
        <dv-border-box-11 title="堰塞湖库容" style="width: 100%; height: 250px">
          <dv-scroll-ranking-board
            :config="inventory"
            style="width: 94%; height: 185px; padding: 40px 2.5% 20px 3.5%"
          />
        </dv-border-box-11>
        <dv-border-box-11 title="流域面积" style="width: 100%; height: 250px">
          <dv-scroll-ranking-board
            :config="area"
            style="width: 94%; height: 185px; padding: 40px 2.5% 20px 3.5%"
          />
        </dv-border-box-11>
      </div>
    </div>
  </div>
</template>

<script>
import Map3d from "../charts/map3d.vue";
export default {
  name: "HomeMain",
  components: {
    Map3d,
  },
  data() {
    return {
      maxhg: {
        data: [],
        //unit: "最大水力梯度",
      },
      bulk: {
        data: [],
        unit: "/(10^6 m^3)",
      },
      inventory: {
        data: [],
        unit: "/(10^6 m^3)",
      },
      area: {
        data: [],
        unit: "/(km^2)",
      },
      component1:0,
      component2:0 ,
      component3:0,
    };
  },
  mounted() {
    this.init();
  },
  methods: {
    init() {
      //读取本地的字符串数据
      var getLocalData = localStorage.getItem("reservoirInfo");
      //将字符串类转换为json格式
      var reservoirInfo = JSON.parse(getLocalData);
      for (var i = 0; i < reservoirInfo.length; i++) {
        if(reservoirInfo[i].component==='块石型'){
          this.component1++
        }else if(reservoirInfo[i].component==='混合型'){
          this.component2++
        }else{
          this.component3++
        }
        //存放maxhg表数据
        var maxhginfo = {
          name: reservoirInfo[i].name,
          value: reservoirInfo[i].maxhg,
        };
        this.maxhg.data[i] = maxhginfo;

        //存放bluk表数据
        var bulkinfo = {
          name: reservoirInfo[i].name,
          value: reservoirInfo[i].bulk,
        };
        this.bulk.data[i] = bulkinfo;

        //存放inventory表数据
        var inventoryginfo = {
          name: reservoirInfo[i].name,
          value: reservoirInfo[i].inventory,
        };
        this.inventory.data[i] = inventoryginfo;

        //存放area表数据
        var areainfo = {
          name: reservoirInfo[i].name,
          value: reservoirInfo[i].area,
        };
        this.area.data[i] = areainfo;
      }
      this.maxhg = { ...this.maxhg };
      this.bulk = { ...this.bulk };
      this.inventory = { ...this.inventory };
      this.area = { ...this.area };
    },
  },
};
</script>

<style>
.el-row{
  padding-top: 0px;
}
.el-statistic .head {
  color: #28f7fa;
}
.el-statistic .con {
  color: #28f7fa;
}

.gnwreservior {
  width: 100%;
  height: 40px;
  padding: 15px;
}
.gnwreserviormessage {
  float: left;
  width: 28%;
  height: 40px;
  margin: 10px;
  line-height: 40px;
}

.warnmessagenum {
  margin-right: 15px;
  color: #28f7fa;
  float: right;
  font-size: 20px;
}
</style>