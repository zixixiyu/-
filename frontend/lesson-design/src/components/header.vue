<template>
    <Row id="headerRow">
        <Col span = "2" class="headerCol">长沙</Col>
        <Col span="20" class="headerCol"></Col>
        <Col span = "2" class="headerCol">
            <template v-if="isLogin" >
                <span @click="toLogin()">登录/注册</span>
            </template>
            <template v-else>
                <span>已登录</span>
                <span @click="logOut()">/注销</span>
            </template>

        </Col>
    </Row>
</template>

<script>
    import {logout} from '../request/userModule/UserOperate'
    export default {
        name: "myHeader",
        data(){
            return{
                isLogin:false
            }
        },
        methods:{
            toLogin(){
                this.$router.push('/login')
            },
            changeLogin(){
                if(localStorage.getItem("uToken")===null){
                    this.isLogin = true;
                }
            },
            logOut(){

                logout().then(res=>{
                    if (res){
                        localStorage.removeItem("uToken");
                        this.$router.go(0);
                    }

                })
            }
        },
        mounted() {
            this.changeLogin()
        }
    }
</script>

<style scoped>
    #headerRow{
        background-color: aliceblue;
        border-bottom: 1px solid black;
        height: 50px;
        color: #3c3f41;
    }
    .headerCol{
        line-height: 50px;
    }
</style>
