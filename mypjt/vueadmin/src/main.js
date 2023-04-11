import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

import Element from 'element-ui'
import "element-ui/lib/theme-chalk/index.css"
import axios from 'axios'

axios.defaults.baseURL = 'http://localhost:8999';
// axios.defaults.headers.common['Authorization'] = AUTH_TOKEN;
axios.defaults.headers.post['Content-Type'] = 'application/json';

Vue.prototype.$axios = axios //
Vue.use(Element)

new Vue({
  render: h => h(App),
}).$mount('#app')
