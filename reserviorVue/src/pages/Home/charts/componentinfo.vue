<template>
  <div ref="chart" style="width: 100%; height: 200px"></div>
</template>
     
<script>
import * as echarts from "echarts";
export default {
  data() {
    return {
      list: [],
    };
  },
  mounted() {
    this.initMychart();
  },
  methods: {
    initMychart() {
      var myChart = echarts.init(this.$refs.chart);
      var option;
      //读取本地的字符串数据
      var getLocalData = localStorage.getItem("reservoirInfo");
      //将字符串类转换为json格式
      var reservoirInfo = JSON.parse(getLocalData);
      for (var i = 0; i < reservoirInfo.length; i++) {
        //存放表数据
        var componentinfo = {
          name: reservoirInfo[i].name,
          value: reservoirInfo[i].component,
        };
        this.list[i] = componentinfo;
      }
      this.list = { ...this.list };

      option = {
        legend: {
          top: "bottom",
        },
        toolbox: {
          show: true,
          feature: {
            mark: { show: true },
            dataView: { show: true, readOnly: false },
            restore: { show: true },
            saveAsImage: { show: true },
          },
        },
        series: [
          {
            name: "Nightingale Chart",
            type: "pie",
            radius: [50, 250],
            center: ["50%", "50%"],
            roseType: "area",
            itemStyle: {
              borderRadius: 8,
            },
            data: this.list,
          },
        ],
      };

      //指定配置的
      option && myChart.setOption(option);
    },
  },
};
</script>
  <style>
</style>