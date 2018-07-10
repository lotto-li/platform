<template>
  <div class="home">
    <h1>{{ msg }}</h1>
    <router-link to="/">Go to login</router-link>
  </div>
</template>

<script>
export default {
  name: 'home',
  components: {

  },
  data () {
    return {
      msg: 'home'
    }
  }
}
</script>

<style scoped>
</style>
