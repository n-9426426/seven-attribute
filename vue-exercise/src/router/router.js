import { createRouter, createWebHistory } from 'vue-router'
import store from '../store/store'
console.log(4, store)
const routes = [
  {
    path: '/list',
    name: 'SevenList',
    component: () => import('../components/SevenList.vue')
  }, {
    path: '/add',
    name: 'SevenAdd',
    component: () => import('../components/SevenAdd.vue')
  }, {
    path: '/update',
    name: 'SevenUpdate',
    component: () => import('../components/SevenUpdate.vue'),
    beforeEnter: (to, from, next) => {
      console.log(store)
      if (store.state.user.id === 0 || store.state.user.id === '' || store.state.user.id === null) {
        router.push('/list')
      }
      next()
    }
  }
]
const routerHistory = createWebHistory()
const router = createRouter({
  history: routerHistory,
  routes
})
export default router
