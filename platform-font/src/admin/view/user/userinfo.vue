<template>
  <div>个人信息</div>

</template>

<script>
export default {
  data () {
    return {
    }
  },
  created () {
    let user = localStorage.getItem('access-user')
    console.info(user)
  },
  methods: {

  }
}
</script>

<style scoped>

</style>
