import Vue from 'vue'
import App from './myApp.vue'
import router from './router'
//为了配置element后加入的
import ElementUI from 'element-ui'
import "element-ui/lib/theme-chalk/index.css"

Vue.config.productionTip = false

//为了配置element后加入的
Vue.use(ElementUI)

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
