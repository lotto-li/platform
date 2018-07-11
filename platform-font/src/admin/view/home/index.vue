<template>
  <div class="home">
    <h1>{{ msg }}</h1>
    <h2><router-link to="/">Go to login</router-link></h2>
    <el-button @click="change()">change-lifeCycle</el-button>
    <lifeCycle v-if="!isdestroy"></lifeCycle>
  </div>
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
</style>
