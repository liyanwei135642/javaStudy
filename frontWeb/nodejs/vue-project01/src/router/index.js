import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: "/emp"
  },
  {
    path: '/button',
    name: 'button',
    component: () => import('../views/element/ElementButton.vue')
  },
  {
    path: '/dialog',
    name: 'dialog',
    component: () => import('../views/element/ElementDialog.vue')
  },
  {
    path: '/pagination',
    name: 'pagination',
    component: () => import('../views/element/ElementPagination.vue')
  },
  {
    path: '/table',
    name: 'table',
    component: () => import('../views/element/ElementTable.vue')
  },
  {
    path: '/emp',
    name: 'emp',
    component: () => import('../views/empview/EmpView.vue')
  },
  {
    path: '*',
    name: 'error',
    component: () => import('../views/ErrorView.vue')
  },
]

const router = new VueRouter({
  routes
})

export default router
