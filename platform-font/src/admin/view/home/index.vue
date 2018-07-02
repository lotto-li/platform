<template>
  <div class="home">
    <h1>{{ msg }}</h1>
    <router-link to="/">Go to login</router-link>
    <btn123></btn123>
  </div>
</template>

<script>

import btn123 from '@/components/btn123'

export default {
  name: 'home',
  components: {
    btn123
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
