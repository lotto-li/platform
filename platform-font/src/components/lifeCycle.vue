<template>
  <div class="lifeCycle">
    <h1>{{ msg }}</h1>
  </div>
</template>

<script>
export default {
  name: 'lifeCycle',
  data () {
    return {
      msg: 'lifeCycle'
    }
  },
  beforeCreate () {
    console.info('————beforeCreate')
  },
  created () {
    console.info('————created')
  },
  beforeMount () {
    console.info('————beforeMount')
  },
  mounted () {
    console.info('————mounted')
  },
  beforeUpdate () {
    console.info('————beforeUpdate')
  },
  updated () {
    console.info('————updated')
  },
  beforeDestroy () {
    console.info('————beforeDestroy')
  },
  destroyed () {
    console.info('————destroyed')
  },
  methods: {
    function1 () {
      console.info('————function1')
    },
    function2 () {
      console.info('————function2')
    }
  }
}
</script>

<style scoped>
</style>
