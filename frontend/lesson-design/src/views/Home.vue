<template>
    <div class="home">
        <my-header/>
        <Row class="bigPic">
            <Col span="2" class="towBord"></Col>
            <Col span="4" class="first">
                <div>
                    <router-link to="/foo">智能手机</router-link>
                </div>
                <div>
                    <router-link to="/foo">智能机器人</router-link>
                </div>
                <div>
                    <router-link to="/foo">笔记本电脑</router-link>
                </div>
                <div>
                    <router-link to="/foo">无人机</router-link>
                </div>
                <div>
                    <router-link to="/foo">智能摄像机</router-link>
                </div>
            </Col>
            <Col span="12" class="second">
                <Carousel autoplay loop>
                    <CarouselItem>
                        <div class="demo-carousel">
                            <img src="../assets/fir.png">
                        </div>
                    </CarouselItem>
                    <CarouselItem>
                        <div class="demo-carousel">
                            <img src="../assets/sec.png">
                        </div>
                    </CarouselItem>
                    <CarouselItem>
                        <div class="demo-carousel">
                            <img src="../assets/thi.png">
                        </div>
                    </CarouselItem>
                    <CarouselItem>
                        <div class="demo-carousel">
                            <img src="../assets/four.png">
                        </div>
                    </CarouselItem>
                </Carousel>
            </Col>
            <Col span="4" class="third">
                <div style="height: 200px">
                    <img style="max-width:100%;max-height: 100%;" src="../assets/logo.jpg">
                </div>
                <div style="margin-top: 10px;background-color:#f1f3f4;height: 10px"></div>
            </Col>
            <Col span="2" class="towBord">
            </Col>
        </Row>
        <Row>
            <Col span="2" class="towBord"></Col>
            <Col span="20" style="height: 200px;"></Col>
            <Col span="2" class="towBord"></Col>
        </Row>
        <Row>
            <Col span="2" class="towBord"></Col>
            <Col span="2" >手机</Col>
            <Col span="16" style="height: 20px;"></Col>
            <Col span="2" >查看更多</Col>
            <Col span="2" class="towBord"></Col>
        </Row>
        <Row>
            <Col span="2" class="towBord"></Col>

            <Col span="4">
                <a href="">
                    <div class="finashoji-top">
                        <img src="../assets/fir.png" width="200px" height="150px">
                        <p class="name3">小米10至尊纪念版</p>
                        <p class="guanggaoci">120X 变焦/120W秒充/120HZ屏幕</p>
                        <p class="price4">5299元起</p>
                    </div>
                </a>
            </Col>
            <Col span="4">
                <a href="">
                    <div class="finashoji-top">
                        <img src="../assets/fir.png" width="200px" height="150px">
                        <p class="name3">小米10至尊纪念版</p>
                        <p class="guanggaoci">120X 变焦/120W秒充/120HZ屏幕</p>
                        <p class="price4">5299元起</p>
                    </div>
                </a>
            </Col>
            <Col span="4">
                <a href="">
                    <div class="finashoji-top">
                        <img src="../assets/fir.png" width="200px" height="150px">
                        <p class="name3">小米10至尊纪念版</p>
                        <p class="guanggaoci">120X 变焦/120W秒充/120HZ屏幕</p>
                        <p class="price4">5299元起</p>
                    </div>
                </a>
            </Col>
            <Col span="4">
                <a href="">
                    <div class="finashoji-top">
                        <img src="../assets/fir.png" width="200px" height="150px">
                        <p class="name3">小米10至尊纪念版</p>
                        <p class="guanggaoci">120X 变焦/120W秒充/120HZ屏幕</p>
                        <p class="price4">5299元起</p>
                    </div>
                </a>
            </Col>
            <Col span="4">
                <a href="">
                    <div class="finashoji-top">
                        <img src="../assets/fir.png" width="200px" height="150px">
                        <p class="name3">小米10至尊纪念版</p>
                        <p class="guanggaoci">120X 变焦/120W秒充/120HZ屏幕</p>
                        <p class="price4">5299元起</p>
                    </div>
                </a>
            </Col>
            <Col span="2" class="towBord"></Col>
        </Row>


        <my-footer/>
    </div>
</template>

<script>
    import myHeader from "../components/header.vue";
    import myFooter from "../components/footer.vue"

    export default {

        name: 'Home',
        components: {
            myHeader, myFooter
        },
        data() {
            return {

            }
        },
        mounted() {

        },
        methods: {

        }
    }
</script>
<style>
    .bigPic {
        height: 500px;

        margin: 0 auto;
        display: flex;
        justify-content: center;
        #background-color: blue;
    }

    .first {

    }

    .second {


    }

    .third {

        #background-color: yellow;
    }

    .first div {
        height: 100px;
        #background-color: gold;

        display: flex;
        justify-content: center; /* 水平居中 */
        align-items: center; /* 垂直居中 */
    }




    .demo-carousel {
        height: 500px;
    }

    .demo-carousel img {
        width: 100%;
        height: 100%;
        object-fit: fill;
    }

    .towBord {
        background-color: #f1f3f4;
    }

    .name3{
        font-size: 15px;
        text-align: center;
        color: black;
        margin-top: 20px;
    }
    .guanggaoci{
        font-size: 3px;
        text-align: center;
        color: rgb(153, 148, 148);
        margin-top: 20px;
    }
    .finashoji-top{
        width: 230px;
        height: 295px;
        background-color: white;
        margin-top: 10px;
    }
    .finashoji-top:hover{
        margin-top: -2px;
        margin-left: -1px;
        box-shadow:2px 2px  6px 0px rgba(0,0,0,.18);
    }

    .price4{
        color: #ff6700;
        text-align: center;
        font-size: 5px;
        margin-top: 20px;
    }
</style>
