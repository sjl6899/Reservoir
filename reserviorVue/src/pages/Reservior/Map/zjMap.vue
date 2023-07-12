<template>
  <div ref="charts" class="map"></div>
</template>

<script>
import * as echarts from "echarts";
import { getMap } from "../../../assets/js/maputil";
export default {
  data() {
    return {
      zjlist: [],
    };
  },
  mounted() {
    this.initCharts();
  },
  methods: {
    initCharts() {
      const charts = echarts.init(this.$refs.charts);
      //读取本地的字符串数据
      var getLocalData = localStorage.getItem("zjreservoirInfo");
      //将字符串类转换为json格式
      var zjreservoirInfo = JSON.parse(getLocalData);
      this.zjlist = zjreservoirInfo;
       //数据
       let ds = this.zjlist;
      
      // 图标点配置信息
      let series = ds.map((item) => {
        return {
          type: "scatter",
          coordinateSystem: "geo",
          symbolSize: 14, // 点位大小
          data: ds.map(function (itemOpt) {
            return {
              value: [
                parseFloat(itemOpt.longitude), //经度
                parseFloat(itemOpt.latitude), //维度
              ],
              label: {
                show: true, // 是否显示字体
                position: "left", // 字体位置。top、left、right、bottom
                formatter: itemOpt.name, // 具体显示的值
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
                  color: "red",
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
      const option = {
        // 背景颜色
        backgroundColor: "",
        // 提示浮窗样式
        tooltip: {
          show: true,
          trigger: "item",
          alwaysShowContent: false,
          backgroundColor: "#0C121C",
          borderColor: "rgba(0, 0, 0, 0.16)",
          hideDelay: 100,
          triggerOn: "mousemove",
          enterable: true,
          textStyle: {
            color: "#DADADA",
            fontSize: "12",
            width: 15,
            height: 15,
            overflow: "break",
          },
          showDelay: 100,
        },
        // 地图配置
        geo: {
          map: "jiaxing",
          label: {
            // 通常状态下的样式
            normal: {
              show: true,
              textStyle: {
                fontSize: 12,
                color: "#fff",
              },
            },
            // 鼠标放上去的样式
            emphasis: {
              textStyle: {
                color: "#fff",
              },
            },
          },
          // 地图区域的样式设置
          itemStyle: {
            normal: {
              borderColor: "rgba(147, 235, 248, 1)",
              borderWidth: 1,
              areaColor: {
                type: "radial",
                x: 0.5,
                y: 0.5,
                r: 0.8,
                colorStops: [
                  {
                    offset: 0,
                    color: "rgba(147, 235, 248, 0)", // 0% 处的颜色
                  },
                  {
                    offset: 1,
                    color: "rgba(147, 235, 248, .2)", // 100% 处的颜色
                  },
                ],
                globalCoord: false, // 缺省为 false
              },
              shadowColor: "rgba(128, 217, 248, 1)",
              shadowOffsetX: -2,
              shadowOffsetY: 2,
              shadowBlur: 10,
            },
            // 鼠标放上去高亮的样式
            emphasis: {
              areaColor: "#389BB7",
              borderWidth: 0,
            },
          },
        },
        graphic: [
          {
            type: "text",
            left: "50%",
            top: "5%",
            style: {
              textStyle: {
                fontSize: 12,
              },
              text: "浙江省",
              font: 'bolder 1.5rem "Microsoft YaHei", sans-serif',
              fill: "#fff",
            },
          },
        ],
        visualMap: {
          // 是否展示左下角，即是是false，也仅是不显示，不影响数据的映射
          show: true,
          // 上下端文字
          text: ["高", "低"],
          // 最小值和最大值，必须指定
          min: 0,
          max: 6000,
          // 位置
          left: "10%",
          bottom: "10%",
          // 是否展示滑块
          calculable: true,
          // 指定映射的数据，对应的是option.series，这里根据自己的实际需要进行配置
          seriesIndex: [0],
          // 从下到上的颜色
          inRange: {
            color: ["#00467F", "#A5CC82"],
          },
          // 字体颜色
          textStyle: {
            color: "#fff",
            map: "china",
          },
        },
        series: series,
      };

      console.log(getMap());
      // 获得数据
      const [mapName, mapJson] = getMap();
      option.geo.map = mapName;
      // 地图注册，第一个参数的名字必须和option.geo.map一致
      echarts.registerMap(mapName, mapJson);

      charts.setOption(option);

      //点击事件
      charts.on("click", ({ name }) => {
        // 如果option.graphic里已经有了城市名称，则不进行任何操作，防止频繁点击
        // const index = option.graphic.findIndex((i) => i.style.text === name);
        // if (!name || index !== -1) return;

        const [mapName, mapJson] = getMap(name);
        // 修改option的配置，可以继续自定义
        option.geo.zoom = 0.8;
        // 这里必须要和注册地图时的名字一致
        option.geo.map = mapName;

        option.graphic.text = name;
        // 为了重新定位，这里使用了length
        const idx = option.graphic.length + 1;
        // option.graphic.push({
        //   type: "text",
        //   left: `${idx * 10}%`,
        //   top: "10%",
        //   style: {
        //     text: name,
        //     font: 'bolder 1.5rem "Microsoft YaHei", sans-serif',
        //     fill: "#fff",
        //   },
        // });

        // 注册地图
        echarts.registerMap(mapName, mapJson);
        // 渲染
        charts.setOption(option, true);
      });
    },
  },
};
</script>

<style>
.map {
  width: 100%;
  height: 100%;
}
</style>