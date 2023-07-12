<template>
  <div>
    <div class="modul-box">
      <div style="flex: 0 1 30%">
        <div class="bg" title="水库概况" style="width: 98%; height: 150px">
          <div class="title">水库概况</div>
          <dv-decoration-6
            style="width: 25%; height: 8px; text-align: center; margin: 0 auto"
          />
          <el-row :gutter="24">
            <el-col :span="8">
              <div>
                <el-statistic title="水库总数">
                  <template slot="formatter"
                    ><span style="font-size: 14px">8</span></template
                  >
                </el-statistic>
              </div>
            </el-col>
            <el-col :span="8">
              <div>
                <el-statistic title="大型">
                  <template slot="formatter"
                    ><span style="font-size: 14px">5</span></template
                  >
                </el-statistic>
              </div>
            </el-col>
            <el-col :span="8">
              <div>
                <el-statistic title="小型">
                  <template slot="formatter"
                    ><span style="font-size: 14px">10</span></template
                  >
                </el-statistic>
              </div>
            </el-col>
          </el-row>
          <el-row :gutter="24">
            <el-col :span="8">
              <div>
                <el-statistic title="水库总数">
                  <template slot="formatter"
                    ><span style="font-size: 14px">8</span></template
                  >
                </el-statistic>
              </div>
            </el-col>
            <el-col :span="8">
              <div>
                <el-statistic title="大型">
                  <template slot="formatter"
                    ><span style="font-size: 14px">5</span></template
                  >
                </el-statistic>
              </div>
            </el-col>
            <el-col :span="8">
              <div>
                <el-statistic title="小型">
                  <template slot="formatter"
                    ><span style="font-size: 14px">10</span></template
                  >
                </el-statistic>
              </div>
            </el-col>
          </el-row>

          <!-- <dv-border-box-13 style="width:100%;height:40px;">水库概况</dv-border-box-13> -->
        </div>
        <div class="bg" title="大坝概况" style="width: 98%; height: 230px">
          <div class="title">大坝概况</div>
          <dv-decoration-6
            style="width: 25%; height: 8px; text-align: center; margin: 0 auto"
          />
          <dv-decoration-9 class="decoration">66%</dv-decoration-9>
          <dv-decoration-9 class="decoration">50%</dv-decoration-9>
          <el-row :gutter="24">
            <el-col :span="12">
              <div>
                <el-statistic title="正常">
                  <template slot="formatter">20个</template>
                </el-statistic>
              </div>
            </el-col>
            <el-col :span="12">
              <div>
                <el-statistic title="异常">
                  <template slot="formatter"
                    ><span style="color: #f89c55">30个</span></template
                  >
                </el-statistic>
              </div>
            </el-col>
          </el-row>
        </div>
        <div class="bg" style="width: 98%; height: calc(95vh - 435px)">
          <div class="title">水库超汛期</div>
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
          <div class="title">报警信息</div>
          <dv-decoration-6
            style="width: 20%; height: 8px; text-align: center; margin: 0 auto"
          />
          <div style="width: 100%; height: calc(95vh - 520px)">
            <div style="width: 25%; height: calc(95vh - 520px); float: left">
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
            <div style="width: 75%; height: calc(95vh - 520px); float: right">
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
          <div class="title">天气预报</div>
          <dv-decoration-6
            style="width: 25%; height: 8px; text-align: center; margin: 0 auto"
          />
          <!-- 引入天气预报API -->
          <div style="width: 100%; height: 135px; color: white">
            <div id="he-plugin-standard"></div>
            <!-- <iframe
            scrolling="no"
            src="https://tianqiapi.com/api.php?style=tg&skin=baidu"
            frameborder="0"
            city="湖州"
            width="400"
            color="FFFFFF"
            height="60"
            allowtransparency="true"
          ></iframe> -->
          </div>
        </div>
        <div class="bg" style="width: 98%; height: 200px">
          <div class="title">水位预测</div>
          <dv-decoration-6
            style="width: 25%; height: 8px; text-align: center; margin: 0 auto"
          />
        </div>
        <div class="bg" style="width: 98%; height: calc(95vh - 400px)">
          <div class="title">新闻公告</div>
          <dv-decoration-6
            style="width: 25%; height: 8px; text-align: center; margin: 0 auto"
          />
          <dv-scroll-board
            :config="news"
            style="width: 95%; height: calc(95vh - 500px); margin: auto"
          />
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
      floodseason: {
        header: [
          '<span style="color:#28f7fa;">水库名称</span>',
          '<span style="color:#28f7fa;">当前水位</span>',
          '<span style="color:#28f7fa;">超汛期</span>',
        ],
        data: [
          ["行1列1", "行1列2", "行1列3"],
          ["行2列1", "行2列2", "行2列3"],
          ["行3列1", "行3列2", "行3列3"],
          ["行4列1", "行4列2", "行4列3"],
          ["行5列1", "行5列2", "行5列3"],
          ["行6列1", "行6列2", "行6列3"],
          ["行7列1", "行7列2", "行7列3"],
          ["行8列1", "行8列2", "行8列3"],
          ["行9列1", "行9列2", "行9列3"],
          ["行10列1", "行10列2", "行10列3"],
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
      news: {
        data: [
          ["行1列1", "行1列2", "行1列3"],
          ["行2列1", "行2列2", "行2列3"],
          ["行3列1", "行3列2", "行3列3"],
          ["行4列1", "行4列2", "行4列3"],
          ["行5列1", "行5列2", "行5列3"],
          ["行6列1", "行6列2", "行6列3"],
          ["行7列1", "行7列2", "行7列3"],
          ["行8列1", "行8列2", "行8列3"],
          ["行9列1", "行9列2", "行9列3"],
          ["行10列1", "行10列2", "行10列3"],
        ],
        headerBGC: "",
        oddRowBGC: "",
        evenRowBGC: "",
        hoverPause: true,
      },
      warnmessage: {
        header: [
          '<span style="color:#28f7fa;">水库名称</span>',
          '<span style="color:#28f7fa;">当前水位</span>',
          '<span style="color:#28f7fa;">超汛期</span>',
        ],
        data: [
          ["行1列1", "行1列2", "行1列3"],
          ["行2列1", "行2列2", "行2列3"],
          ["行3列1", "行3列2", "行3列3"],
          ["行4列1", "行4列2", "行4列3"],
          ["行5列1", "行5列2", "行5列3"],
          ["行6列1", "行6列2", "行6列3"],
          ["行7列1", "行7列2", "行7列3"],
          ["行8列1", "行8列2", "行8列3"],
          ["行9列1", "行9列2", "行9列3"],
          ["行10列1", "行10列2", "行10列3"],
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
      zjlist:[],
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
    init() {
      // //读取本地的字符串数据
      // var getLocalData = localStorage.getItem("zjreservoirInfo");
      // //将字符串类转换为json格式
      // var zjreservoirInfo = JSON.parse(getLocalData);
      // console.log(zjreservoirInfo);
      // this.zjlist=zjreservoirInfo
      
      // for (var i = 0; i < reservoirInfo.length; i++) {
      
      //   //存放maxhg表数据
      //   var maxhginfo = {
      //     name: reservoirInfo[i].name,
      //     value: reservoirInfo[i].maxhg,
      //   };
      //   this.maxhg.data[i] = maxhginfo;
       
      // }
      // this.maxhg = { ...this.maxhg };
    },
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

.title {
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

.warnmessage {
  width: 100%;
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

#mobile05 {
  color: aliceblue;
}
</style>