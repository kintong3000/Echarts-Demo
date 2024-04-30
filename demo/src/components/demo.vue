<script setup>
import VChart, { THEME_KEY } from 'vue-echarts';
import { ref, provide } from 'vue';

import { use } from 'echarts/core'
import { PieChart } from 'echarts/charts'
import {
  TitleComponent,
  TooltipComponent,
  LegendComponent
} from 'echarts/components'
import { CanvasRenderer } from 'echarts/renderers'
import axios from "axios";

use([
  TitleComponent,
  TooltipComponent,
  LegendComponent,
  PieChart,
  CanvasRenderer
])

// const data = axios.get("http://localhost:8080/education")
// console.log(data)


const option = ref({
  title: {
    text: 'Referer of a Website',
    subtext: 'Fake Data',
    left: 'center'
  },
  tooltip: {
    trigger: 'item'
  },
  legend: {
    orient: 'vertical',
    left: 'left'
  },
  series: [
    {
      name: 'Access From',
      type: 'pie',
      radius: '50%',
      data: [
        { value: 1048, name: 'Search Engine' },
        { value: 735, name: 'Direct' },
        { value: 580, name: 'Email' },
        { value: 484, name: 'Union Ads' },
        { value: 300, name: 'Video Ads' }
      ],
      emphasis: {
        itemStyle: {
          shadowBlur: 10,
          shadowOffsetX: 0,
          shadowColor: 'rgba(0, 0, 0, 0.5)'
        }
      },
      label: {
        formatter: '{b}: {d}%'
      }
    }
  ]
});


axios.get("http://localhost:8080/education")
    .then(response => {
      const educationData = response.data.data; // Assuming the data structure from the API
      option.value.series[0].data = educationData.map(item => ({
        value: Math.round(item.ratio * 1000), // Convert ratio to percentage and round
        name: item.eduction // Correct the property name to match the API response
      }));
      console.log(option.value.series[0].data); // Log the updated option object
    })
    .catch(error => {
      console.error('Error fetching education data:', error);
    });
</script>

<template>
  <v-chart class="chart" :option="option" theme="dark" autoresize />
</template>

<style scoped>

</style>
