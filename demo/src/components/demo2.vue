<script setup>
import {ref} from "vue";
import VChart, { THEME_KEY } from 'vue-echarts';

import { use } from 'echarts/core'
import { BarChart, LineChart } from 'echarts/charts'
import {
  TooltipComponent,
  ToolboxComponent,
  LegendComponent,
  GridComponent
} from 'echarts/components'
import { CanvasRenderer } from 'echarts/renderers'

use([
  TooltipComponent,
  ToolboxComponent,
  LegendComponent,
  GridComponent,
  BarChart,
  LineChart,
  CanvasRenderer
])

const colors = ['#5470C6', '#91CC75', '#EE6666','#547677'];
const option = ref({
  color: colors,
  //鼠标交互
  tooltip: {
    trigger: 'axis',
    axisPointer: {
      type: 'cross'
    }
  },
  //xy轴
  grid: {
    right: '20%'
  },
  toolbox: {
    feature: {
      dataView: { show: true, readOnly: false },
      restore: { show: true },
      saveAsImage: { show: true }
    }
  },
  //图例
  legend: {
    data: ['Evaporation', 'Temperature','sb']
  },
  xAxis: [
    {
      type: 'category',
      axisTick: {
        alignWithLabel: true
      },
      // prettier-ignore
      data: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
    }
  ],
  yAxis: [
    {
      type: 'value',
      name: 'Evaporation',
      position: 'left',
      //对齐刻度
      alignTicks: true,
      axisLine: {
        show: true,
        lineStyle: {
          color: colors[0]
        }
      },
      axisLabel: {
        formatter: '{value} ml'
      }
    },
    {
      type: 'value',
      name: '完成率',
      max:100,
      min:0,
      interval:10,
      position: 'right',
      alignTicks: true,
      //刻度线相关配置
      axisLine: {
        show: true,
        lineStyle: {
          color: colors[2]
        }
      },
      axisLabel: {
        formatter: '{value} %'
      }
    }
  ],
  series: [
    {
      name: 'Evaporation',
      type: 'bar',
      stack: 'x',
      data: [
        2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3
      ]
    },
    {
      name: 'Precipitation',
      type: 'bar',
      stack: 'x',
      data: [
        2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3
      ]
    },
    {
      name: 'Temperature',
      type: 'line',
      yAxisIndex: 1,
      data: [20, 22, 33, 45, 63, 88, 66, 77, 25, 88, 99, 62]
    },
    {
      name: 'sb',
      type: 'line',
      yAxisIndex: 1,
      colorBy:'series',
      data: [13, 12, 43, 55, 43, 88, 46, 77, 85, 88, 69, 52]
    }
  ]
});
</script>

<template>
<v-chart :option="option" theme="dark" autoresize/>
</template>

<style scoped>

</style>
