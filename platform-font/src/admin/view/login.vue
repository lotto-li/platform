<template>
  <div class="login">
    <h1>{{ msg }}</h1>
    <el-input class="l-input" v-model="username" type="text" placeholder="请输入帐号"></el-input>
    <el-input class="l-input" v-model="password" type="password" placeholder="请输入密码" @keyup.enter.native="login()"></el-input>
    <div class="psdBox"><el-checkbox v-model="rememberPsd">记住密码</el-checkbox></div>
    <el-button class="l-btn" type="primary" @click="login()">登录</el-button>
  </div>
</template>

<script>
export default {
  name: 'login',
  data () {
    return {
      msg: '登录',
      username: '',
      password: '',
      rememberPsd: false
    }
  },
  created () {
  },
  methods: {
    login () {
      let _this = this
      this.axios.get('/api/getSysUser', {
        params: {
          username: this.username,
          password: this.password
        }
      }).then((response) => {
        if (response.data[0] && response.data[0].id) {
          localStorage.setItem('access-user', JSON.stringify(response.data[0]))
          _this.$router.push({path: '/index'})
        } else {
          _this.$message.error({showClose: true, message: response.errmsg || '登录失败', duration: 2000})
        }
      })
    }
  }
}
</script>

<style scoped>
.login{
  width: 400px;
  height: 300px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  box-shadow: 0px 0px 10px 5px #eee;
}
.l-input{
  margin-bottom: 10px;
  width: 80%;
}
.l-btn{
  width: 80%;
  margin-top: 10px;
}
.psdBox{
  width: 80%;
  margin: auto;
  text-align: left;
}
</style>
