<template>
  <el-container id="theme">
    <el-header id="theme_header">
      <div class="title-text">
        <span @click="jumpTo('/index')">后台管理系统</span>
      </div>
      <div class="user-info">
        <el-dropdown trigger="click">
          <span class="el-dropdown-link">用户：{{username}}<i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>
              <div @click="jumpTo('/userinfo')"><span>个人信息</span></div>
            </el-dropdown-item>
            <el-dropdown-item>
              <div @click="jumpTo('/changePwd')"><span>修改密码</span></div>
            </el-dropdown-item>
            <el-dropdown-item divided @click.native="logout">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </el-header>
    <el-container id="theme_container">
      <div class="menuBtn" v-show="!showMenu" @click="cBar()">目录</div>
      <el-aside width="200px" id="theme_aside" v-show="showMenu">
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b">
          <el-submenu index="0">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>商城</span>
            </template>
            <el-menu-item index="0-1" @click="jumpTo('/shop')">
              <i class="el-icon-menu"></i>
              <span slot="title">商城</span>
            </el-menu-item>
            <el-menu-item index="0-2" @click="jumpTo('/order')">
              <i class="el-icon-menu"></i>
              <span slot="title">我的订单</span>
            </el-menu-item>
          </el-submenu>
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>个人信息</span>
            </template>
            <el-menu-item index="1-1" @click="jumpTo('/userinfo')">
              <i class="el-icon-menu"></i>
              <span slot="title">个人信息</span>
            </el-menu-item>
            <el-menu-item index="1-2" @click="jumpTo('/changePwd')">
              <i class="el-icon-menu"></i>
              <span slot="title">修改密码</span>
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main id="theme_main" @click.native="cBar()">
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import lifeCycle from '@/components/lifeCycle'
export default {
  name: 'index',
  components: {
    lifeCycle
  },
  data () {
    return {
      username: '',
      showMenu: false
    }
  },
  methods: {
    jumpTo (page) {
      this.$router.push(page)
    },
    handleOpen () {

    },
    handleClose () {

    },
    cBar () {
      this.showMenu = !this.showMenu
    },
    logout () {
      let _this = this
      this.$confirm('确认退出吗?', '提示', {
        confirmButtonClass: 'el-button--warning'
      }).then(() => {
        // 确认
        _this.loading = true
        localStorage.removeItem('access-user')
        _this.$router.replace('/') // 用go刷新
        // _this.$router.go({
        //   path: '/abc',
        //   replace: true
        // })
      })
    }
  },
  mounted () {
    let user = localStorage.getItem('access-user')
    if (user) {
      user = JSON.parse(user)
      this.username = user.username || ''
    }
  }
}
</script>

<style scoped>
#theme{
  height: 100%;
}
#theme_header{
  background-color: #2b3643;
  color: #ffffff;
}
#theme_container .menuBtn{
  position: fixed;
  bottom: 50px;
  left: 5px;
  width: 50px;
  height: 50px;
  background-color: #2b3643;
  border-radius: 5px;
  box-shadow: 0 0 4px rgba(0,0,0,.5);
}
#theme_container .menuBtn::after{
  position: absolute;
  left: 0;
  top: 13px;
  content: "";
  height: 2px;
  width: 30px;
  background-color: white;
  margin-left: 10px;
  box-shadow: 0 10px 0 0 white,0 20px 0 0 white;
}
#theme_aside{
  background-color: #364150;
  color: #ffffff;
  text-align: left;
  transition: all .5s;
}
#theme_main{
  background-color: #ffffff;
}
#theme_header .title-text{
  color: #fff;
  font-size: 25px;
  line-height: 60px;
  display: inline-block;
  position: absolute;
  left: 30px;
  cursor: pointer;
}
#theme_header .user-info{
  display: inline-block;
  position: absolute;
  right: 10px;
  line-height: 60px;
}
#theme_header .el-dropdown-link{
  color: #fff;
  cursor: pointer;
}
.hideMenu{
  width: 0;
}
</style>
