<template>
  <div>
    <div class="top">
      <img :src="logo" class="logo">
      <span class="title">
        {{ $lzxConfig.appTitle }}
      </span>
      <!-- <lang-select class="international right-menu-item" style="display: inline-block;"/> -->
      <span class="logout" @click="logout">
        退出系统
      </span>
      <!-- <el-dropdown class="avatar-container" trigger="click">
        <div class="avatar-wrapper">
          <img :src="avatar+'?imageView2/1/w/80/h/80'" class="user-avatar">
          <i class="el-icon-caret-bottom"/>
        </div>
        <el-dropdown-menu slot="dropdown" class="user-dropdown">
          <router-link class="inlineBlock" to="/">
            <el-dropdown-item>
              Home
            </el-dropdown-item>
          </router-link>
          <el-dropdown-item divided>
            <span style="display:block;" @click="logout">LogOut</span>
          </el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown> -->
    </div>
    <div :class="classObj" class="app-wrapper">
      <div v-if="device==='mobile'&&sidebar.opened" class="drawer-bg" @click="handleClickOutside" />
      <sidebar class="sidebar-container" />
      <div class="main-container">
        <tags-view />
        <app-main />
      </div>
    </div>
  </div>
</template>

<script>
import { Sidebar, AppMain, TagsView } from './components'
import ResizeMixin from './mixin/ResizeHandler'
import logo from '@/assets/img_logo.png'
import { mapGetters } from 'vuex'
// import LangSelect from '@/components/LangSelect'

export default {
  name: 'Layout',
  components: {
    Sidebar,
    AppMain,
    TagsView
  },
  mixins: [ResizeMixin],
  data() {
    return {
      logo: logo
    }
  },
  computed: {
    sidebar() {
      return this.$store.state.app.sidebar
    },
    device() {
      return this.$store.state.app.device
    },
    classObj() {
      return {
        hideSidebar: !this.sidebar.opened,
        openSidebar: this.sidebar.opened,
        withoutAnimation: this.sidebar.withoutAnimation,
        mobile: this.device === 'mobile'
      }
    },
    ...mapGetters([
      'sidebar',
      'avatar'
    ])
  },
  methods: {
    handleClickOutside() {
      this.$store.dispatch('CloseSideBar', { withoutAnimation: false })
    },
    logout() {
      this.$store.dispatch('LogOut').then(() => {
        location.reload() // 为了重新实例化vue-router对象 避免bug
      })
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  @import "src/styles/mixin.scss";
  @import "src/styles/variables.scss";
  .app-wrapper {
    @include clearfix;
    position: relative;
    height: calc(100% - #{$headerHeight});
    width: 100%;
    top: $headerHeight;
    &.mobile.openSidebar{
      position: fixed;
      top: 0;
    }
  }
  .drawer-bg {
    background: #000;
    opacity: 0.3;
    width: 100%;
    top: 0;
    height: 100%;
    position: absolute;
    z-index: 999;
  }
  .top {
    position: fixed;
    z-index: 1;
    background-color: $menuBg;
    color: $subMenuActiveText;
    top: 0;
    left: 0;
    width: 100%;
    padding-left: 20px;
    height: $headerHeight;
    vertical-align: top;
  }
  .logo {
    height: 50px;
    width: 50px;
  }
  .title {
    font-size: 20px;
    line-height: $headerHeight;
    vertical-align: text-bottom;
    margin-left: 20px;
    font-weight: 500;
  }
  .logout {
    font-size: 14px;
    font-weight: 500;
    line-height: $headerHeight;
    vertical-align: text-bottom;
    float: right;
    margin-right: 20px;
    cursor: pointer;
  }
  .avatar-container {
    height: 50px;
    display: inline-block;
    position: absolute;
    right: 35px;
    .avatar-wrapper {
      cursor: pointer;
      margin-top: 5px;
      position: relative;
      line-height: initial;
      .user-avatar {
        width: 40px;
        height: 40px;
        border-radius: 10px;
      }
      .el-icon-caret-bottom {
        position: absolute;
        right: -20px;
        top: 25px;
        font-size: 12px;
      }
    }
  }
</style>
