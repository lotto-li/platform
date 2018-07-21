<template>

  <!-- <div class="home">
    <h1>{{ msg }}</h1>
    <h2><router-link to="/">Go to login</router-link></h2>
    <el-button @click="change()">change-lifeCycle</el-button>
    <lifeCycle v-if="!isdestroy"></lifeCycle>
  </div> -->

  <el-container id="theme">
    <el-header id="header">

    </el-header>
    <el-container id="content">
      <el-aside width="200px" id="aside">
        <router-link to="/home/page1">Go to page1</router-link>
        <router-link to="/home/page2">Go to page2</router-link>
        <!-- <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b">
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>导航一</span>
            </template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="1-1">选项1</el-menu-item>
              <el-menu-item index="1-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
              <template slot="title">选项4</template>
              <el-menu-item index="1-4-1">选项1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-menu-item index="2">
            <i class="el-icon-menu"></i>
            <span slot="title">导航二</span>
          </el-menu-item>
          <el-menu-item index="3" disabled>
            <i class="el-icon-document"></i>
            <span slot="title">导航三</span>
          </el-menu-item>
          <el-menu-item index="4">
            <i class="el-icon-setting"></i>
            <span slot="title">导航四</span>
          </el-menu-item>
        </el-menu> -->
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
      isdestroy: false
    }
  },
  methods: {
    change () {
      this.isdestroy = !this.isdestroy
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
</style>
