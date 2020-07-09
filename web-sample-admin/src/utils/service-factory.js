import axios from 'axios'
import { Message } from 'element-ui'
import { getToken } from '@/utils/auth'
import store from '../store'

axios.defaults.baseURL = '/api'

// request拦截器
function installRequestFilter(service) {
  service.interceptors.request.use(
    config => {
      if (store.getters.token) {
        config.headers['X-Token'] = getToken() // 让每个请求携带自定义token 请根据实际情况自行修改
      }
      return config
    },
    error => {
      // Do something with request error
      console.log(error) // for debug
      Promise.reject(error)
    }
  )
}

// response 拦截器
function installResponseFilter(service) {
  service.interceptors.response.use(
    response => {
      if (response.status !== 200) {
        Message({
          message: response.data.message,
          type: 'error',
          duration: 5 * 1000
        })

        // if (res.code === 500) {
        //   MessageBox.confirm(
        //     '你已被登出，可以取消继续留在该页面，或者重新登录',
        //     '确定登出',
        //     {
        //       confirmButtonText: '重新登录',
        //       cancelButtonText: '取消',
        //       type: 'warning'
        //     }
        //   ).then(() => {
        //     store.dispatch('FedLogOut').then(() => {
        //       location.reload() // 为了重新实例化vue-router对象 避免bug
        //     })
        //   })
        // }
        return Promise.reject('error')
      } else {
        return response
      }
    },
    error => {
      console.log('err', error.response) // for debug
      Message({
        message: error.response.data.message || error.message,
        type: 'error',
        duration: 5 * 1000
      })
      return Promise.reject(error)
    }
  )
}

function createService(serviceName) {
  const svc = axios.create({
    baseURL: axios.defaults.baseURL + serviceName,
    timeout: 10000
  })
  installRequestFilter(svc)
  installResponseFilter(svc)
  return svc
}

export default createService
