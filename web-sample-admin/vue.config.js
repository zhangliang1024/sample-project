// const apiHost = 'http://101.89.91.168:8202/'
const apiHost = 'http://192.168.1.108:9201'

module.exports = {
  lintOnSave: false,
  devServer: {
    host: '0.0.0.0',
    port: 9080,
    proxy: {
      '/api': {
        target: apiHost,
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        },
        logLevel: 'debug'
      }
    }
  },
  chainWebpack: config => {
    // config.module
    //   .rule('js')
    //   .exclude.add(/NIM_Web_.*\.js/).end()
  },
  publicPath: '',
  outputDir: undefined,
  assetsDir: undefined,
  runtimeCompiler: undefined,
  productionSourceMap: false,
  parallel: undefined,
  css: {
    extract: false
  }
}
