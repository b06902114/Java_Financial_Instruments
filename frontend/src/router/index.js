import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/Login.vue'
import { compile } from 'vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/editList/:num/:sn/:id',
      name: 'UpdateList',
      component: ()=>import('../views/UpdateList.vue')
    },
    {
      path: '/home/addlist/:id/:no',
      name: 'AddList',
      component: ()=>import('../views/AddList.vue')
    },
    {
      path: '/home/list/:id',
      name: 'FavoriteList',
      component: ()=>import('../views/List.vue')
    },
    {
      path: '/home/menu/:id',
      name: 'Menu',
      component: ()=>import('../views/Menu.vue')
    },
    {
      path: '/home/menu/ADMIN',
      name: 'ADMIN',
      component: ()=>import('../views/ADMIN.vue')
    },
    {
      path: '/add_product',
      name: 'Add_Product',
      component: ()=>import('../views/AddProduct.vue')
    },
    {
      path: '/add_user',
      name: 'Add_User',
      component: ()=>import('../views/AddUser.vue')
     
    },
    {
      path: '/RegisterPage',
      name: 'RegisterPage',
      component: ()=>import('../views/Register.vue')
    },
    {
      path: '/edit/:id/:email/:account',
      name: 'edit',
      component: ()=>import('../views/UpdateUser.vue')
    },
  ]
})

export default router
