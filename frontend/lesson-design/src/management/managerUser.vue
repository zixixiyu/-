<template>
    <div >
        <Divider>用户管理</Divider>
        <Table border :columns="columns" :data="user"></Table>
        <Page :total="userNum" :current="currentPage" @on-change="pageNum=>getUser(pageNum)"/>
    </div>
</template>

<script>
    import {getAllUser,getUserNum} from '../request/userModule/UserOperate'
    export default {
        name: "managerUser",
        data(){
            return{
                columns:[
                    {
                        title: '用户名',
                        key: 'username'
                    },
                    {
                        title: '注册日期',
                        key: 'registryDate'
                    },
                    {
                        title: '手机号',
                        key: 'mobile'
                    },
                    {
                        title: '邮箱',
                        key: 'email',
                    }
                ],
                userArr:'',
                userNum:0,
                currentPage:1,
                user:[]
            }
        },
        methods:{
            getUserNum(){
                getUserNum().then(res=>{
                    this.userNum=res;
                })

            },
            getUser(pageNum){
                getAllUser(pageNum).then(res=>{
                    this.user=res;
                })
                this.currentPage = pageNum;
            }
        },
        mounted() {
            this.getUserNum();
            this.getUser(1);
        }
    }
</script>

<style scoped>

</style>
