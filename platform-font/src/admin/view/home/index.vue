<template>

  <!-- <div class="home">
    <h1>{{ msg }}</h1>
    <h2><router-link to="/">Go to login</router-link></h2>
    <el-button @click="change()">change-lifeCycle</el-button>
    <lifeCycle v-if="!isdestroy"></lifeCycle>
  </div> -->

  <el-container id="theme">
    <el-header id="header">
      <div class="title-text">
        <span>后台管理系统</span>
      </div>
      <div class="user-info">
        <el-dropdown trigger="click">
          <span class="el-dropdown-link">用户：{{username}}<i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>
              <div @click="jumpTo('/user/profile')"><span>个人信息</span></div>
            </el-dropdown-item>
            <el-dropdown-item>
              <div @click="jumpTo('/user/changepwd')"><span>修改密码</span></div>
            </el-dropdown-item>
            <el-dropdown-item divided @click.native="logout">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </el-header>
    <el-container id="content">
      <el-aside width="200px" id="aside">
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          background-color="#364150"
          text-color="#fff"
          active-text-color="#ffd04b">

          <el-menu-item index="1" @click="jumpTo('/home/page1')">
            <i class="el-icon-menu"></i>
            <span slot="title">page1</span>
          </el-menu-item>
          <el-menu-item index="2" @click="jumpTo('/home/page2')">
            <i class="el-icon-menu"></i>
            <span slot="title">page2</span>
          </el-menu-item>
          <el-menu-item index="3" @click="jumpTo('/home/page1')">
            <i class="el-icon-menu"></i>
            <span slot="title">page3</span>
          </el-menu-item>
          <el-menu-item index="4" @click="jumpTo('/home/page2')">
            <i class="el-icon-menu"></i>
            <span slot="title">page4</span>
          </el-menu-item>

          <el-submenu index="5">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>Go to 5</span>
            </template>
              <el-menu-item index="5-1">选项1</el-menu-item>
              <el-menu-item index="5-2">选项2</el-menu-item>
              <el-menu-item index="5-3">选项3</el-menu-item>
          </el-submenu>

        </el-menu>
      </el-aside>
      <el-main id="main">
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import lifeCycle from '@/components/lifeCycle'
export default {
  name: 'home',
  components: {
    lifeCycle
  },
  data () {
    return {
      msg: 'home',
      isdestroy: false,
      username: ''
    }
  },
  methods: {
    change () {
      this.isdestroy = !this.isdestroy
    },
    jumpTo (page) {
      this.$router.push(page)
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
#header{
  background-color: #2b3643;
  color: #ffffff;
}
#aside{
  background-color: #364150;
  color: #ffffff;
}
#main{
  background-color: #ffffff;
}

#header .title-text{
  color: #fff;
  font-size: 25px;
  line-height: 60px;
  display: inline-block;
  position: absolute;
  left: 30px;
}
#header .user-info{
  display: inline-block;
  position: absolute;
  right: 10px;
  line-height: 60px;
}
#header .el-dropdown-link{
  color: #fff;
}
</style>
