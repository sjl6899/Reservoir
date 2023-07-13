<template>
  <div ref="chart" style="width: 100%; height: 400px"></div>
</template>
   
<script>
import * as echarts from "echarts";
import "echarts-gl";
export default {
  data() {
    return {
      //国家水坝数据
      list: [
      ],
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
      this.list = JSON.parse(getLocalData);
      //从jsonObj中提取我们想要的数据
      //数据
      let ds = this.list;

      //指定配置项
      option = {
        backgroundColor: "",
        globe: {
          baseTexture: require("./img/baseTexture.jpg"),
          shading: "lambert",
          // environment: require("./img/heightTexture.jpg"),
          atmosphere: {
            show: true,
            glowPower: 6,
          },
          light: {
            ambient: {
              intensity: 0.3,
            },
            main: {
              intensity: 1.5,
            },
          },
        },
        series: series,
      };

      // 图标点配置信息
      let series = ds.map((item) => {
        return {
          //name: item.name, // 是否显示左上角图例
          type: "scatter3D",
          coordinateSystem: "globe",
          //blendMode: "lighter",
          symbolSize: 12, // 点位大小
          data: ds.map(function (itemOpt) {
            return {
              value: [
                parseFloat(itemOpt.longitude), //经度
                parseFloat(itemOpt.latitude), //维度
              ],
              label: {
                show: true, // 是否显示字体
                position: "left", // 字体位置。top、left、right、bottom
                formatter: itemOpt.country + "-" + itemOpt.name, // 具体显示的值
                textStyle: {
                  backgroundColor: "#000000",
                  color: "#fff", // 字体颜色
                  borderWidth: 0, // 字体边框宽度
                  borderColor: "#fff", // 字体边框颜色
                  fontFamily: "sans-serif", // 字体格式
                  fontSize: 12, // 字体大小
                  fontWeight: 0, // 字体加粗
                },
              },
              itemStyle: {
                //地图区域的多边形
                normal: {
                  //borderColor: "#07919e",  // 边框颜色
                  //areaColor:"#000",    //  区域颜色
                  //textStyle: {             // 文字颜色
                  //    color: "#fff"
                  //},
                  color:itemOpt.stability==="稳定" ? "white":"red",
                  shadowBlur: 5, // 图形阴影的模糊大小
                  shadowOffsetX: 5, // 阴影水平方向上的偏移距离。
                },
              },
              tooltip: {
                //仅在 options中最外层的 tooltip.trigger 为 'item'时有效
                position: "bottom", //提示框位置,仅在 options中最外层的 tooltip.trigger 为 'item'时有效
                formatter: function (params, ticket, callback) {
                  var strHtml = "<div>";
                  strHtml += '<table class="table">';
                  strHtml +=
                    '<tr><td colspan="4" style="text-align:center">国内外堰塞坝基本信息</td></tr>';
                  strHtml +=
                    "<tr><td>堰塞坝编号：</td><td>" +
                    itemOpt.reservoirId +
                    "</td><td>堰塞坝高度/(m)：</td><td>" +
                    itemOpt.height +
                    "</td></tr>";
                  strHtml +=
                    "<tr><td>堰塞坝长度/(m)：</td><td>" +
                    itemOpt.longer +
                    "</td></tr>";
                  strHtml +=
                    "<tr><td>堰塞坝宽度/(m)：</td><td>" +
                    itemOpt.width +
                    "</td></tr>";
                  strHtml +=
                    "<tr><td>物质组成：</td><td>" +
                    itemOpt.component +
                    "</td></tr>";
                  strHtml += "</table>";
                  strHtml += "</div>";
                  return strHtml;
                },
              },
            };
          }),
        };
      });
      myChart.setOption({
        tooltip: {
          show: true,
          trigger: "item",
          showContent: true, //是否显示提示框浮层，默认显示
          alwaysShowContent: false, //是否永远显示提示框内容，默认情况下在移出可触发提示框区域后 一定时间 后隐藏，设置为 true 可以保证一直显示提示框内容
          hideDelay: 0, //鼠标移出坐标点时，浮层隐藏的延迟时间，单位为 ms，在 alwaysShowContent 为 true 的时候无效
        },
        // 图例设置
        legend: {
          selectedMode: "multiple",
          x: "right",
          y: "bottom",
          data: ds.map((item) => {
            return item.country; // 数据来源
          }),
          padding: [0, 550, 140, 0], // 填充位置,上、右、下、左
          orient: "vertical", // 排列方式，vertical:垂直排列
          textStyle: {
            color: "#fff", // 文字颜色
          },
        },
        // 地球参数设置
        globe: {
          viewControl: {
            autoRotate: true, // 是否开启视角绕物体的自动旋转查看
            autoRotateSpeed: 7, //物体自转的速度,单位为角度 / 秒，默认为10 ，也就是36秒转一圈。
            autoRotateAfterStill: 4, // 在鼠标静止操作后恢复自动旋转的时间间隔,默认 3s
            rotateSensitivity: 5, // 旋转操作的灵敏度，值越大越灵敏.设置为0后无法旋转。[1, 0]只能横向旋转.[0, 1]只能纵向旋转
            targetCoord: [116.457, 40.2527], // 定位到北京
          },
        },
        // 地球文字显示信息配置
        series: series,
      });
      //指定配置的
      option && myChart.setOption(option);
    },
  },
};
</script>
<style>
</style>