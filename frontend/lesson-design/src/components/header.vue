<template>
    <Row id="headerRow">
        <Col span = "2" class="headerCol">长沙</Col>
        <Col span="20" class="headerCol"></Col>
        <Col span = "2" class="headerCol"><span @click="toLogin()">登录/注册</span></Col>
    </Row>
</template>

<script>
    export default {
        name: "myHeader",
        methods:{
            toLogin(){
                this.$router.push('/login')
            }
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