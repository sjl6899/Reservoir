//配置路由的地方
import Vue from "vue";
import VueRouter from "vue-router";
//使用组件
Vue.use(VueRouter);
//引入路由组件
import Login from '@/pages/Login'
import Register from '@/pages/Register'
import Home from '@/pages/Home'
import Reservior from '@/pages/Reservior'
import Admin from '@/pages/Admin'

let originPush=VueRouter.prototype.push;
let originReplace=VueRouter.prototype.replace;

VueRouter.prototype.push=function(location,resolve,reject){
    if(resolve && reject){
       
        originPush.call(this,location,resolve,reject);
    }else{
        originPush.call(this,location,()=>{},()=>{});
    }
}
VueRouter.prototype.replace=function(location,resolve,reject){
    if(resolve && reject){
        originReplace.call(this,location,resolve,reject);
    }else{
        originReplace.call(this,location,()=>{},()=>{});
    }
}

export default new VueRouter({
    //配置路由
    routes:[
        {
            path:"/login",
            component: Login,
            meta: { show:false}
        },
        {
            path:"/register",
            component: Register,
            meta: { show:false}
        },
        {
            path:"/home",
            component: Home,
            meta: { show:false}
        },
        {
            path:"/reservior",
            component:Reservior,
            meta: { show:false}
        },
        {
            path:"/admin",
            component: Admin,
            meta: { show:false}
        },
        //重定向
        {
            path:"*",
            redirect: "/login"
        }
    ]
})