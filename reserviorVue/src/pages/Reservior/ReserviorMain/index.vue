<template>
  <div>
    <div class="modul-box">
      <div style="flex: 0 1 30%">
        <div class="bg" title="水库概况" style="width: 98%; height: 150px">
          <div class="zjtitle">水库概况</div>
          <dv-decoration-6
            style="width: 25%; height: 8px; text-align: center; margin: 0 auto"
          />
          <div class="zjreservior">
            <dv-border-box-7 class="zjreserviormessage">
              <span style="margin-left: 5px">水库总数</span>
              <span class="warnmessagenum">6</span>
            </dv-border-box-7>
            <dv-border-box-7 class="zjreserviormessage">
              <span style="margin-left: 5px">大型</span>
              <span class="warnmessagenum">4</span>
            </dv-border-box-7>
            <dv-border-box-7 class="zjreserviormessage">
              <span style="margin-left: 5px">小型</span>
              <span class="warnmessagenum">2</span>
            </dv-border-box-7>
          </div>
          <div class="zjreservior">
            <dv-border-box-7 class="zjreserviormessage">
              <span style="margin-left: 5px">大坝总数</span>
              <span class="warnmessagenum">12</span>
            </dv-border-box-7>
            <dv-border-box-7 class="zjreserviormessage">
              <span style="margin-left: 5px">超汛期</span>
              <span class="warnmessagenum">0</span>
            </dv-border-box-7>
            <dv-border-box-7 class="zjreserviormessage">
              <span style="margin-left: 5px">淹坝</span>
              <span class="warnmessagenum">0</span>
            </dv-border-box-7>
          </div>

          <!-- <dv-border-box-13 style="width:100%;height:40px;">水库概况</dv-border-box-13> -->
        </div>
        <div class="bg" title="大坝概况" style="width: 98%; height: 230px">
          <div class="zjtitle">大坝概况</div>
          <dv-decoration-6
            style="width: 25%; height: 8px; text-align: center; margin: 0 auto"
          />
          <dv-decoration-9 class="decoration">67%</dv-decoration-9>
          <dv-decoration-9 class="decoration">33%</dv-decoration-9>
          <dv-border-box-7 class="bammessage">
            <span style="margin-left: 5px">正常</span>
            <span class="warnmessagenum">4</span>
          </dv-border-box-7>
          <dv-border-box-7 class="bammessage">
            <span style="margin-left: 5px">异常</span>
            <span class="warnmessagenum">2</span>
          </dv-border-box-7>
        </div>
        <div class="bg" style="width: 98%; height: calc(95vh - 435px)">
          <div class="zjtitle">水库超汛期</div>
          <dv-decoration-6
            style="width: 25%; height: 8px; text-align: center; margin: 0 auto"
          />
          <dv-scroll-board
            :config="floodseason"
            style="width: 100%; height: 200px"
          />
        </div>
      </div>
      <div style="flex: 0 1 40%">
        <div class="bg" style="width: 98%; height: 450px">
          <zjMap></zjMap>
        </div>
        <div class="bg" style="width: 98%; height: calc(95vh - 500px)">
          <div class="zjtitle">报警信息</div>
          <dv-decoration-6
            style="width: 20%; height: 8px; text-align: center; margin: 0 auto"
          />
          <div style="width: 100%; height: calc(95vh - 520px)">
            
            <div style="width: 98%; height: calc(95vh - 520px); float: right">
              <dv-scroll-board
                :config="warnmessage"
                style="width: 100%; height: calc(95vh - 540px)"
              />
            </div>
          </div>
        </div>
      </div>
      <div style="flex: 0 1 30%">
        <div class="bg" style="width: 98%; height: 200px">
          <div class="zjtitle">天气预报</div>
          <dv-decoration-6
            style="width: 25%; height: 8px; text-align: center; margin: 0 auto"
          />
          <!-- 引入天气预报API -->
          <div style="width: 100%; height: 135px; color: white">
            <div id="he-plugin-standard"></div>
          </div>
        </div>
        <div class="bg" style="width: 98%; height: 80px">
          <div style="width: 100%; height: 50px; float: left">
              <dv-border-box-7 class="warnmessage">
                <span style="margin-left: 5px">水雨情</span>
                <span class="warnmessagenum">2</span>
              </dv-border-box-7>
              <dv-border-box-7 class="warnmessage">
                <span style="margin-left: 5px">大坝安全</span>
                <span class="warnmessagenum">1</span>
              </dv-border-box-7>
              <dv-border-box-7 class="warnmessage">
                <span style="margin-left: 5px">流量</span>
                <span class="warnmessagenum">0</span>
              </dv-border-box-7>
            </div>
        </div>
        <div class="bg" style="width: 98%; height: calc(95vh - 200px)">
          <div class="zjtitle">水位模型训练</div>
          <dv-decoration-6
            style="width: 25%; height: 8px; text-align: center; margin: 0 auto"
          />
          <!--动态将图片轮播图的容器高度设置成与图片一致-->
          <el-carousel indicator-position="outside" class="flow">
            <el-carousel-item v-for="(img, index) in imgList" :key="index">
              <img :src="img.url" width="100%" height="100%" style="border-radius: 0;" />
            </el-carousel-item>
          </el-carousel>
          
        </div>
        <!-- <div class="bg" style="width: 98%; height: calc(95vh - 400px)">
          <div class="zjtitle">新闻公告</div>
          <dv-decoration-6
            style="width: 25%; height: 8px; text-align: center; margin: 0 auto"
          />
          <dv-scroll-board
            :config="news"
            style="width: 95%; height: calc(95vh - 500px); margin: auto"
          />
        </div> -->
      </div>
    </div>
  </div>
</template>
  
<script>
import zjMap from "../Map/zjMap.vue";
export default {
  name: "ReserviorMain",
  components: {
    zjMap,
  },
  data() {
    return {
      floodseason: {
        header: [
          '<span style="color:#28f7fa;">水库名称</span>',
          '<span style="color:#28f7fa;">当前水位(m)</span>',
          '<span style="color:#28f7fa;">超汛期(m)</span>',
        ],
        data: [
          ["余杭水库", "35", "——"],
          ["千岛湖水库", "26", "——"],
          ["牛头山水库", "275", "——"],
          ["老虎潭水库", "54", "——"],
          ["长潭水库", "200", "——"],
          ["珊溪水库", "30", "——"],
        ],
        indexHeader: '<span style="color:#28f7fa;">排名</span>',
        index: true,
        columnWidth: [50],
        align: ["center"],
        headerBGC: "",
        oddRowBGC: "",
        evenRowBGC: "",
        hoverPause: true,
      },
      warnmessage: {
        // header: [
        //   '<span style="color:#28f7fa;">水库名称</span>',
        //   '<span style="color:#28f7fa;">当前水位</span>',
        //   '<span style="color:#28f7fa;">超汛期</span>',
        // ],
        data: [
          ["珊溪水库", "2017-10-15 10:00:00", "日降水量：200"],
          ["牛头山水库", "2017-11-11 11:12:00", "日降水量：100"],
          ["千岛湖水库", "2018-1-5 10:00:00", "日降水量：60"],
          ["长潭水库", "2018-1-15 10:00:00", "日降水量：0"],
          ["牛头山水库", "2018-3-12 07:40:00", "日降水量：0"],
          ["余杭水库", "2018-10-15 10:00:00", "日降水量：70"],
          ["老虎潭水库", "2019-10-15 10:00:00", "日降水量：45"],
          ["珊溪水库", "2019-9-05 12:35:00", "日降水量：123"],
          ["千岛湖水库", "2019-11-11 5:00:00", "日降水量：23"],
        ],
        //indexHeader: '<span style="color:#28f7fa;">排名</span>',
        index: true,
        columnWidth: [50],
        align: ["center"],
        headerBGC: "",
        oddRowBGC: "",
        evenRowBGC: "",
        hoverPause: true,
      },
      zjlist: [],
      imgList: [
        {
          url: require("@/assets/pyimg/1.png"), //url: '../assets/lake.jpg'
        },
        {
          url: require("@/assets/pyimg/2.png"), //url: '../assets/build.jpg'
        },
        {
          url: require("@/assets/pyimg/3.png"), //url: '../assets/road.jpg'
        },
        {
          url: require("@/assets/pyimg/4.png"), //url: '../assets/sea.jpg'
        },
        {
          url: require("@/assets/pyimg/3.png"), //url: '../assets/road.jpg'
        },
        {
          url: require("@/assets/pyimg/4.png"), //url: '../assets/sea.jpg'
        },
      ],
    };
  },
  mounted() {
    this.init();
    window.WIDGET = {
      CONFIG: {
        layout: "1",
        width: "450",
        height: "150",
        background: "5",
        dataColor: "FFFFFF",
        language: "zh",
        aqiColor: "FFFFFF",
        borderRadius: "5",
        key: "89fa162c7a9a45b7ab35ff2469a66826",
      },
    };
    let script = document.createElement("script");
    script.type = "text/javascript";
    script.src =
      "https://widget.qweather.net/standard/static/js/he-standard-common.js?v=2.0";
    document.getElementsByTagName("head")[0].appendChild(script);
  },
  methods: {
    init() {},
  },
};
</script>
  
<style>
.bg {
  background-color: rgba(11, 36, 64, 0.4);
  margin: 5px;
}

.el-row {
  padding-top: 0;
}
.el-statistic .head {
  color: white;
  padding-top: 10px;
}
.el-statistic .con {
  color: #28f7fa;
}

.zjtitle {
  text-align: center;
  padding: 5px 10px 0 10px;
  font-size: 14px;
  font-weight: 700;
}

.decoration {
  width: 38%;
  height: 120px;
  float: left;
  margin: 15px 5% 0 5%;
}

.zjreservior {
  width: 100%;
  height: 40px;
}
.zjreserviormessage {
  float: left;
  width: 28%;
  height: 40px;
  margin: 10px;
  line-height: 40px;
}

.bammessage {
  float: left;
  width: 30%;
  height: 40px;
  margin: 10px 40px;
  line-height: 40px;
}

.warnmessage {
  float: left;
  width: 28%;
  height: 40px;
  margin: 15px 11px;
  line-height: 40px;
}

.warnmessagenum {
  margin-right: 15px;
  color: #28f7fa;
  float: right;
  font-size: 20px;
}

#mobile05 {
  color: aliceblue;
}

/* 走马灯 */
.flow{
  padding: 10px;
}

.img{
  border-radius: 0;
}
</style>