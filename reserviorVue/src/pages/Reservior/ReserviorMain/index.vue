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
        <!-- 视频监测 -->
        <div class="bg" style="width: 98%; height: calc(95vh - 200px)">
          <div class="zjtitle">视频监测</div>
          <dv-decoration-6
            style="width: 25%; height: 8px; text-align: center; margin: 0 auto"
          />
          <!--动态将图片轮播图的容器高度设置成与图片一致-->
          <!-- <el-carousel indicator-position="outside" class="flow">
            <el-carousel-item v-for="(img, index) in imgList" :key="index">
              <img :src="img.url" width="100%" height="100%" style="border-radius: 0;" />
            </el-carousel-item>
          </el-carousel> -->
          <video-player
            class="video-player vjs-custom-skin"
            ref="videoPlayer"
            :playsinline="true"
            :options="playerOptions"
          ></video-player>
        </div>
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
      playerOptions: {
        playbackRates: [0.7, 1.0, 1.5, 2.0], //播放速度
        autoplay: true, //如果true,浏览器准备好时开始回放。
        muted: true, // 默认情况下将会消除任何音频。
        loop: true, // 导致视频一结束就重新开始。
        preload: "auto", // 建议浏览器在<video>加载元素后是否应该开始下载视频数据。auto浏览器选择最佳行为,立即开始加载视频（如果浏览器支持）
        language: "zh-CN",
        aspectRatio: "4:3", // 将播放器置于流畅模式，并在计算播放器的动态大小时使用该值。值应该代表一个比例 - 用冒号分隔的两个数字（例如"16:9"或"4:3"）
        fluid: true, // 当true时，Video.js player将拥有流体大小。换句话说，它将按比例缩放以适应其容器。
        sources: [
          {
            type: "video/mp4", //这里的种类支持很多种：基本视频格式、直播、流媒体等，具体可以参看git网址项目
            src: require("../../../assets/video/zjreservior.mp4"), //url地址
          },
        ],
        poster: "../../../assets/background.jpg", //你的封面地址
        // width: document.documentElement.clientWidth, //播放器宽度
        notSupportedMessage: "此视频暂无法播放，请稍后再试", //允许覆盖Video.js无法播放媒体源时显示的默认信息。
        controlBar: {
          timeDivider: true,
          durationDisplay: true,
          remainingTimeDisplay: false,
          fullscreenToggle: true, //全屏按钮
        },
      },
      floodseason: {
        header: [
          '<span style="color:#28f7fa;">水库名称</span>',
          '<span style="color:#28f7fa;">当前水位(m)</span>',
          '<span style="color:#28f7fa;">超汛期(m)</span>',
        ],
        data: [
          ["余杭水库", "46.2", "46.5"],
          ["千岛湖水库", "31.5", "32"],
          ["牛头山水库", "136.3", "137"],
          ["老虎潭水库", "83.5", "84"],
          ["长潭水库", "236.3", "236.4"],
          ["珊溪水库", "236.8", "237"],
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
          url: require("@/assets/pyimg/flow/yuhang.png"), 
        },
        {
          url: require("@/assets/pyimg/flow/qiandaohu.png"), 
        },
        {
          url: require("@/assets/pyimg/flow/niutoushan.png"), 
        },
        {
          url: require("@/assets/pyimg/flow/laohutan.png"), 
        },
        {
          url: require("@/assets/pyimg/flow/changtan.png"), 
        },
        {
          url: require("@/assets/pyimg/flow/shanxi.png"),
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
.video-js {
  background-color: "";
}

.video-js .vjs-icon-placeholder {
    width: 100%;
    height: 100%;
    display: block;
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
.flow {
  padding: 10px;
}

.img {
  border-radius: 0;
}
</style>