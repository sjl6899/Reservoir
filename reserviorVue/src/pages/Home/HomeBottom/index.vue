<template>
  <div>
    <div class="modul-box">
      <div style="flex: 0 1 100%">
        <dv-border-box-7 style="width: 100%; height: calc(95vh - 550px)">
          <div
            ref="chart"
            style="width: 100%; height: calc(95vh - 550px)"
          ></div>
        </dv-border-box-7>
      </div>
    </div>
  </div>
</template>

<script>
import * as echarts from "echarts";
export default {
  name: "HomeMain",
  components: {},
  data() {
    return {
      infolist: {
        data: [],
        //stability: [],
      },
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
        //存放maxhg表数据
        var areaginfo = {
          value: [reservoirInfo[i].height, reservoirInfo[i].area],
          stability: reservoirInfo[i].stability,
          country:reservoirInfo[i].country,
          name:reservoirInfo[i].name
        };
        this.infolist.data[i] = areaginfo;
      }
      //console.log(this.infolist.data);
      var myChart = echarts.init(this.$refs.chart);
      var option;

      option = {
        xAxis: {
          axisLabel: {
            show: true,
            textStyle: {
              color: "white", //更改坐标轴文字颜色
              fontSize: 12, //更改坐标轴文字大小
            },
          },
        },
        yAxis: {
          axisLabel: {
            show: true,
            textStyle: {
              color: "white", //更改坐标轴文字颜色
              fontSize: 12, //更改坐标轴文字大小
            },
          },
        },
        grid: {
          x: 50,
          y: 30,
          x2: 30,
          y2: 30,
          borderWidth: 1,
        },
        tooltip: {
          trigger: "item",
          formatter: (params) => {
            console.log(params);
            return `${params.marker}${params.data.country+'-'+params.data.name}`;
          },
        },
        series: [
          {
            symbolSize: 15,
            data: this.infolist.data,
            type: "scatter",
            itemStyle: {
              normal: {
                color: function (params) {
                  if (params.data.stability === "稳定") {
                    return "white";
                  } else {
                    return "red";
                  }
                },
              },
            },
            tooltip: {},
          },
        ],
      };

      option && myChart.setOption(option);
    },
  },
};
</script>

<style>
</style>