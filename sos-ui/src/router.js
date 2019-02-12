import Vue from 'vue'
import Router from 'vue-router'
import Start from './views/Start.vue'
import Name from './views/Name.vue';
import Connect from './views/Connect.vue';
import Channel from "./views/Channel.vue";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: Start
    },
    {
      path: '/connect',
      name: 'connect',
      component: Connect
    },
    {
      path: '/name',
      name: 'name',
      component: Name
    },
    {
      path: '/channel/:id',
      name: 'channel',
      component: Channel
    }
  ]
})
