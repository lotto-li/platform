import Vue from 'vue'
import Router from 'vue-router'

import login from '@/admin/view/login/index'
import home from '@/admin/view/home/index'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/home',
      name: 'home',
      component: home
    }
  ]
})
