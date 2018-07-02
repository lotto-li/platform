<template>
  <div class="login">
    <h1>{{ msg }}</h1>
    <router-link to="/home">Go to home</router-link>
  </div>
</template>

<script>
export default {
  name: 'login',
  data () {
    return {
      msg: 'login'
    }
  }
}
</script>

<style scoped>
</style>
