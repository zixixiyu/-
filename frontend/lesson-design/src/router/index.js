import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/login',
    name: 'Login',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/login.vue')
  },
  {
    path: '/managerLogin',
    name: 'ManagerLogin',
    component: ()=>import('../management/managerLogin')
  },

  {
    path: "/managerHome",
    name: "managerHome",
    component: () => import("../management/managerHome"),
    redirect: '/managerHome/managerUser',//页面默认加载的路由
    children: [
      {
        path: "managerUser",
        name: "managerUser",
        component: () => import("../management/managerUser")
      },
      {
        path: "managerProduct",
        name: "managerProduct",
        component: () => import("../management/managerProduct")
      },
      {
        path: "managerOrder",
        name: "managerOrder",
        component: () => import("../management/managerOrder")
      }

    ]
  } ,
  {
    path: '/allProduct',
    name: 'allProduct',
    component: ()=>import('../views/allProduct')
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
