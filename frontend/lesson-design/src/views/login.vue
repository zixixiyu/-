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
          <Input type="text" @on-blur="sameUsername()" placeholder="Username" v-model = registryInfo.username />
          <span :style="usernameMessageClass">{{usernameMessage}}</span>
        </div>
        <div class="inputText">
          <span class="">密码：</span>
          <Input type="password" placeholder="Password" v-model = registryInfo.password />
        </div>
        <div class="inputText">
          <span class="" >确认密码：</span>
          <Input type="password" @on-blur="samePassword()" placeholder="Verify Password" v-model = registryInfo.verifyPassword />
          <span :style="passwordMessageClass">{{passwordMessage}}</span>
        </div>
        <div class="inputText">
          <span class="">邮箱：</span>
          <Input type="text" placeholder="Email" v-model = registryInfo.email />
        </div>
        <div class="inputText">
          <span class="">手机号：</span>
          <Input type="text" placeholder="Mobile" v-model = registryInfo.mobile />
        </div>
      </div>

    </Modal>

  </div>
</template>

<script>
  import {distinctUsername,registry} from '../request/userModule/UserOperate';

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
          verifyPassword:'',
          email:'',
          mobile:''
        },
        usernameMessage:'',
        usernameMessageClass:'',
        passwordMessage:'',
        passwordMessageClass:''
      }
    },
    components: {

    },
    methods:{
      loginTheWeb(){

      },
      registryTheUser(){
          if (this.registryInfo.password!==this.registryInfo.verifyPassword){
            this.$Message.error("两次密码不一致")
            return
          }

          let mobileRegex = /^(13[0-9]{9})|(15[0-9]{9})|(17[0-9]{9})|(18[0-9]{9})|(19[0-9]{9})$/;
          if (!mobileRegex.test(this.registryInfo.mobile)){
            this.$Message.error("手机号格式不正确")
            return
          }
          let emailRegex = /^[a-z0-9](\w|\.|-)*@([a-z0-9]+-?[a-z0-9]+\.){1,3}[a-z]{2,4}$/i;
          if (!emailRegex.test(this.registryInfo.email)){
            this.$Message.error("邮箱格式不正确")
            return;
          }
          registry(this.registryInfo.username,this.registryInfo.password,this.registryInfo.email,this.registryInfo.mobile).then(res=>{
              if (res){
                this.$Message.info("注册成功")
              }
              this.registryInfo = {}

          })
      },
      samePassword(){
        if (this.registryInfo.password!==this.registryInfo.verifyPassword){
          this.passwordMessage = "两次密码不一致"
          this.passwordMessageClass={color:'red'}
        }
      },
      sameUsername(){
        this.usernameMessage=''
        distinctUsername(this.registryInfo.username).then(res=>{
          if (res===false){
            this.usernameMessageClass={color:'red'}
            this.usernameMessage='该用户已经存在，请更换其他用户名'
          }else {
            this.usernameMessageClass={color:'green'}
            this.usernameMessage='该用户名可用'
          }

        })

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
