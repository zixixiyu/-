<template>
  <div class="login">
    <div id="bigBox">
      <h1>LOGIN</h1>
      <div class="inputBox" >
        <div class="inputText">
          <span class=""></span>
          <input type="text" placeholder="Username" v-model = loginInfo.username />
        </div>
        <div class="inputText">
          <span class=""></span>
          <input type="password" placeholder="Password" v-model = loginInfo.password />
        </div>
      </div>
      <input class="loginButton" type="button" value="Login" @click = "loginTheWeb()"/>
      <input class="loginButton" type="button" value="cancel" />
      <input class="loginButton" type="button" value="registry" @click="registryModal = true" />
  </div>

    <Modal
            v-model="registryModal"
            title="注册"
            @on-ok="registryTheUser()">

      <div class="inputBox" >
        <div class="inputText">
          <span class="">用户名：</span>
          <Input type="text" placeholder="Username" v-model = registryInfo.username />
        </div>
        <div class="inputText">
          <span class="">密码：</span>
          <Input type="password" placeholder="Password" v-model = registryInfo.password />
        </div>
        <div class="inputText">
          <span class="">确认密码：</span>
          <Input type="password" placeholder="Verify Password" v-model = registryInfo.verifyPassword />
        </div>
      </div>

    </Modal>

  </div>
</template>

<script>


  export default {
    name: 'Login',
    data(){
      return {
        loginInfo:{
            username:'',
            password:''
        },
        registryModal:false,
        registryInfo:{
          username: '',
          password: '',
          verifyPassword:''
        }
      }
    },
    components: {

    },
    methods:{
      loginTheWeb(){

      },
      registryTheUser(){

      }
    }
  }
</script>

<style>

  .login{
    margin: 0;
    padding: 0;
    background-image: url(../assets/bgimg.jpg);	/* 背景图片 */
    background-repeat: no-repeat;	/* 背景图片不重复 */
    width:100%;
    height:100%;
    position:fixed;
    background-size:100% 100%;
  }

  #bigBox{
    margin: 0 auto;	/* login框剧中 */
    margin-top: 200px; /* login框与顶部的距离 */
    padding: 20px 50px;	/* login框内部的距离(内部与输入框和按钮的距离) */
    background-color: #00000090;	/* login框背景颜色和透明度 */
    width: 400px;
    height: 300px;
    border-radius: 10px;	/* 圆角边 */
    text-align: center;	/* 框内所有内容剧中 */
  }

  #bigBox h1
  {
    color: white;	/* LOGIN字体颜色 */
  }

  #bigBox .inputBox
  {
    margin-top: 50px;	/* 输入框顶部与LOGIN标题的间距 */
  }

  #bigBox .inputBox .inputText
  {
    margin-top: 20px;	/* 输入框之间的距离 */
  }

  #bigBox .inputBox .inputText span
  {
    color: white;	/* icon颜色 */
  }

  #bigBox .inputBox .inputText input
  {
    border: 0;	/* 删除输入框边框 */
    padding: 10px 10px;	/* 输入框内的间距 */
    border-bottom: 1px solid white;	/* 输入框白色下划线 */
    background-color: #00000000;	/* 输入框透明 */
    color: white;	/* 输入字体的颜色 */
  }

  #bigBox .loginButton
  {
    margin-top: 30px;	/* 按钮顶部与输入框的距离 */
    width: 80px;
    height: 25px;
    color: white;	/* 按钮字体颜色 */
    border: 0; /* 删除按钮边框 */
    border-radius: 20px;	/* 按钮圆角边 */
    background-image: linear-gradient(to right, #b8cbb8 0%, #b8cbb8 0%, #b465da 0%, #cf6cc9 33%, #ee609c 66%, #ee609c 100%);	/* 按钮颜色 */
  }



</style>
