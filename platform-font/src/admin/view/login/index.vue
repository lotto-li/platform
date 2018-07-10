<template>
  <div class="login">
    <h1>{{ msg }}</h1>
    <!-- <router-link to="/home">Go to home</router-link> -->
    <el-input v-model="username" type="text" placeholder="请输入帐号"></el-input>
    <el-input v-model="password" type="password" placeholder="请输入密码"></el-input>
    <el-button type="primary" @click="login()">login</el-button>
  </div>
</template>

<script>
export default {
  name: 'login',
  data () {
    return {
      msg: 'login',
      username: '',
      password: ''
    }
  },
  created () {
  },
  methods: {
    login () {
      this.axios.get('/api/getSysUser', {
        params: {
          username: this.username,
          password: this.password
        }
      }).then((response) => {
        // console.log(response.data[0])
        if (response.data[0] != null) {
          this.$router.push({path: '/home'})
        }
      })
    }
  }
}
</script>

<style scoped>
</style>
