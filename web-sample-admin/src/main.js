import Vue from 'vue'
import Cookies from 'js-cookie'
import 'normalize.css/normalize.css' // A modern alternative to CSS resets

import Element from 'element-ui'
import LzxDesktopUI from 'lzx-desktop-ui'
import 'element-ui/lib/theme-chalk/index.css'
import '@/styles/index.scss' // global css
import '@/icons/font-icon/iconfont.css'

import App from './App'
import store from './store'
import router from './router'

import i18n from './lang' // Internationalization
import './permission' // permission control
import './services'
import './lzx-config'

Vue.use(Element, {
  size: Cookies.get('size') || 'medium', // set element-ui default size
  i18n: (key, value) => i18n.t(key, value)
})
Vue.use(LzxDesktopUI)

Vue.config.productionTip = false

window.VuePrototype = Vue.prototype // 用于调试

new Vue({
  el: '#app',
  router,
  store,
  i18n,
  render: h => h(App)
})
