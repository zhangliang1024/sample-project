import Vue from 'vue'

Vue.prototype.$lzxConfig = {
  appTitle: '演示系统'
}

document.title = Vue.prototype.$lzxConfig.appTitle
