import { createApp } from 'vue'
import App from './App.vue'
import router from './router/router'
// import axios from 'axios'
import store from './store/store'
// import VueAxios from 'vue-axios'
import ElementPlus from 'element-plus'
import 'element-plus/theme-chalk/index.css'

// axios.defaults.baseURL = 'http://aozhang.chn/'
const app = createApp(App)
// app.config.productionTip = false
// 选项式
// app.config.globalProperties.$axios = axios
// 组合式
// app.provide('$axios', axios)
// app.use(VueAxios, axios)
app.use(router)
app.use(store)
// app.config.globalProperties.$router = router
app.use(ElementPlus)
app.mount('#app')
