import Vue from 'vue'
import App from './App.vue'
//引入路由
import router from '@/router'
import ElementUI from 'element-ui'; 
import 'element-ui/lib/theme-chalk/index.css';           
import axios from 'axios'
import echarts from 'echarts'
// 将自动注册所有组件为全局组件
import dataV from '@jiaminghi/data-view'
Vue.prototype.$echarts = echarts
Vue.use(dataV)
// axios.defaults.baseURL = '/api'
Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.prototype.$axios = axios   
new Vue({
  render: h => h(App),
  router,
  //注册仓库,组件的实例身上都拥有$Store
}).$mount('#app')
