import Vue from 'vue'
import createService from './utils/service-factory'

Vue.prototype.$svc_platform_user = createService('/svc-platform-user')
Vue.prototype.$svc_platform_order = createService('/svc-platform-order')
