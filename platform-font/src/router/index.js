import Vue from 'vue'
import Router from 'vue-router'

// import login from '@/admin/view/login/index'
// import home from '@/admin/view/home/index'

Vue.use(Router)

export default new Router({
  mode: 'hash',
  routes: [
    {
      path: '/',
      name: 'login',
      component: resolve => require(['@/admin/view/login/index'], resolve)// 使用懒加载
    },
    {
      path: '/home',
      name: 'home',
      component: resolve => require(['@/admin/view/home/index'], resolve)
    }
  ]
})
