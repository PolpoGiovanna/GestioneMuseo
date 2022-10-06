import { createApp } from 'vue'
import App from './App.vue'
import LoginUser from './components/LoginUser.vue'
import RegisterUser from './components/RegisterUser.vue'
import HomeUser from './components/HomeUser.vue'
import ArtistaOpera from './components/ArtistaOpera.vue'
import TipoOpera from './components/TipoOpera.vue'
import LuogoOpera from './components/LuogoOpera.vue'
import OperaItem from './components/OperaItem.vue'

import { createWebHashHistory,createRouter} from 'vue-router'

const routes = [
    {path:'/', component: LoginUser},
    {path:'/registrati', component: RegisterUser},
    {path: '/home', component: HomeUser},
    {path:'/artista', component: ArtistaOpera},
    {path:'/tipo', component: TipoOpera},
    {path:'/luogo', component: LuogoOpera},
    {path:'/opera', component: OperaItem}
]


const router = createRouter({
    history: createWebHashHistory(),
    routes,
})
createApp(App).use(router).mount('#app')
