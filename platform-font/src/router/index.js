import Vue from 'vue'
import Router from 'vue-router'

// import login from '@/admin/view/login'
// import index from '@/admin/view/index'

Vue.use(Router)

export default new Router({
  // mode: 'history',
  routes: [
    {
      path: '/',
      name: 'login',
      component: resolve => require(['@/admin/view/login'], resolve)// 使用懒加载
    },
    {
      path: '/index',
      name: 'index',
      component: resolve => require(['@/admin/view/index'], resolve),
      // 重定向
      // redirect: '/index',
      children: [
        {
          path: '/index',
          component: resolve => require(['@/admin/view/homepage/index'], resolve)
        },
        {
          path: '/shop',
          component: resolve => require(['@/admin/view/shop/shop'], resolve)
        },
        {
          path: '/order',
          component: resolve => require(['@/admin/view/shop/order'], resolve)
        },
        {
          path: '/userinfo',
          component: resolve => require(['@/admin/view/user/userinfo'], resolve)
        },
        {
          path: '/changePwd',
          component: resolve => require(['@/admin/view/user/changePwd'], resolve)
        }
      ]
    }
  ]
})
