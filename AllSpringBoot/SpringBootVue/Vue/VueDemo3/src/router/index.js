import Vue from 'vue'
import VueRouter from "vue-router";
import login from "../views/login";
import home from "../views/home";
Vue.use(VueRouter)
export default new VueRouter({
  routes:[
    {
      path: '/login',
      name:'login',
      component:login
    },
    {
      path:'/home',
      name:'home',
      component:home
    }
  ]
})
