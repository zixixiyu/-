<template>
    <div class="home">
        <my-header/>
        <Row class="bigPic">
            <Col span="2" class="towBord"></Col>
            <Col span="4" class="first">
                <div>
                    <router-link :to="{ name: 'allProduct', params: { selected: 'phone'}}">智能手机</router-link>
                </div>
                <div>
                    <router-link :to="{ name: 'allProduct', params: { selected: 'robot'}}">智能机器人</router-link>
                </div>
                <div>
                    <router-link :to="{ name: 'allProduct', params: { selected: 'pc'}}">笔记本电脑</router-link>
                </div>
                <div>
                    <router-link :to="{ name: 'allProduct', params: { selected: 'UAV'}}">无人机</router-link>
                </div>
                <div>
                    <router-link :to="{ name: 'allProduct', params: { selected: 'camera'}}">智能摄像机</router-link>
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
            <Col span="2">手机</Col>
            <Col span="16" style="height: 20px;"></Col>
            <Col span="2"><router-link :to="{ name: 'allProduct', params: { selected: 'phone'}}">查看更多</router-link></Col>
            <Col span="2" class="towBord"></Col>
        </Row>
        <Row>
            <Col span="2" class="towBord"></Col>
            <template v-for="item in phone" >

                <Col span="4" :key="item.id">
                    <router-link :to="'/productDetail/'+item.id">
                        <div class="finashoji-top">
                            <img v-bind:src="$picHost+item.picUrl" width="200px" height="150px">
                            <p class="name3">{{item.name}}</p>
                            <p class="guanggaoci">{{item.parameter}}</p>
                            <p class="price4">原价：{{item.dailyPrice}}元/天</p>
                            <p class="price4">折扣价：{{item.discountDailyPrice}}元/天</p>
                        </div>
                    </router-link>
                </Col>

            </template>
            <Col span="2" class="towBord"></Col>
        </Row>

        <Row>
            <Col span="2" class="towBord"></Col>
            <Col span="20" style="height: 200px;"></Col>
            <Col span="2" class="towBord"></Col>
        </Row>

        <Row>
            <Col span="2" class="towBord"></Col>
            <Col span="2">智能机器人</Col>
            <Col span="16" style="height: 20px;"></Col>
            <Col span="2"><router-link :to="{ name: 'allProduct', params: { selected: 'robot'}}">查看更多</router-link></Col>
            <Col span="2" class="towBord"></Col>
        </Row>
        <Row>
            <Col span="2" class="towBord"></Col>
            <template v-for="item in robot" >
                <Col span="4" :key="item.id">
                    <router-link :to="'/productDetail/'+item.id">
                        <div class="finashoji-top">
                            <img v-bind:src="$picHost+item.picUrl" width="200px" height="150px">
                            <p class="name3">{{item.name}}</p>
                            <p class="guanggaoci">{{item.parameter}}</p>
                            <p class="price4">原价：{{item.dailyPrice}}元/天</p>
                            <p class="price4">折扣价：{{item.discountDailyPrice}}元/天</p>
                        </div>
                    </router-link>
                </Col>

            </template>
            <Col span="2" class="towBord"></Col>
        </Row>

        <Row>
            <Col span="2" class="towBord"></Col>
            <Col span="20" style="height: 200px;"></Col>
            <Col span="2" class="towBord"></Col>
        </Row>

        <Row>
            <Col span="2" class="towBord"></Col>
            <Col span="2">笔记本电脑</Col>
            <Col span="16" style="height: 20px;"></Col>
            <Col span="2"><router-link :to="{ name: 'allProduct', params: { selected: 'pc'}}">查看更多</router-link></Col>
            <Col span="2" class="towBord"></Col>
        </Row>
        <Row>
            <Col span="2" class="towBord"></Col>
            <template v-for="item in pc" >
                <Col span="4" :key="item.id">
                    <router-link :to="'/productDetail/'+item.id">
                        <div class="finashoji-top">
                            <img v-bind:src="$picHost+item.picUrl" width="200px" height="150px">
                            <p class="name3">{{item.name}}</p>
                            <p class="guanggaoci">{{item.parameter}}</p>
                            <p class="price4">原价：{{item.dailyPrice}}元/天</p>
                            <p class="price4">折扣价：{{item.discountDailyPrice}}元/天</p>
                        </div>
                    </router-link>
                </Col>

            </template>
            <Col span="2" class="towBord"></Col>
        </Row>

        <Row>
            <Col span="2" class="towBord"></Col>
            <Col span="20" style="height: 200px;"></Col>
            <Col span="2" class="towBord"></Col>
        </Row>

        <Row>
            <Col span="2" class="towBord"></Col>
            <Col span="2">无人机</Col>
            <Col span="16" style="height: 20px;"></Col>
            <Col span="2"><router-link :to="{ name: 'allProduct', params: { selected: 'UAV'}}">查看更多</router-link></Col>
            <Col span="2" class="towBord"></Col>
        </Row>
        <Row>
            <Col span="2" class="towBord"></Col>
            <template v-for="item in UAV" >
                <Col span="4" :key="item.id">
                    <router-link :to="'/productDetail/'+item.id">
                        <div class="finashoji-top">
                            <img v-bind:src="$picHost+item.picUrl" width="200px" height="150px">
                            <p class="name3">{{item.name}}</p>
                            <p class="guanggaoci">{{item.parameter}}</p>
                            <p class="price4">原价：{{item.dailyPrice}}元/天</p>
                            <p class="price4">折扣价：{{item.discountDailyPrice}}元/天</p>
                        </div>
                    </router-link>
                </Col>

            </template>
            <Col span="2" class="towBord"></Col>
        </Row>

        <Row>
            <Col span="2" class="towBord"></Col>
            <Col span="20" style="height: 200px;"></Col>
            <Col span="2" class="towBord"></Col>
        </Row>

        <Row>
            <Col span="2" class="towBord"></Col>
            <Col span="2">智能摄像机</Col>
            <Col span="16" style="height: 20px;"></Col>
            <Col span="2"><router-link :to="{ name: 'allProduct', params: { selected: 'camera'}}">查看更多</router-link></Col>
            <Col span="2" class="towBord"></Col>
        </Row>
        <Row>
            <Col span="2" class="towBord"></Col>
            <template v-for="item in camera" >
                <Col span="4" :key="item.id">
                    <router-link :to="'/productDetail/'+item.id">
                        <div class="finashoji-top">
                            <img v-bind:src="$picHost+item.picUrl" width="200px" height="150px">
                            <p class="name3">{{item.name}}</p>
                            <p class="guanggaoci">{{item.parameter}}</p>
                            <p class="price4">原价：{{item.dailyPrice}}元/天</p>
                            <p class="price4">折扣价：{{item.discountDailyPrice}}元/天</p>
                        </div>
                    </router-link>
                </Col>

            </template>
            <Col span="2" class="towBord"></Col>
        </Row>

        <my-footer/>
    </div>
</template>

<script>
    import myHeader from "../components/header.vue";
    import myFooter from "../components/footer.vue";
    import {frontGetProduct} from "../request/productModule/getProduct";


    export default {

        name: 'Home',
        components: {
            myHeader, myFooter
        },
        data() {
            return {
                phone: [],
                robot:[],
                pc:[],
                UAV:[],
                camera:[]
            }
        },
        mounted() {
            this.getPhone();
            this.getRobot();
            this.getPc();
            this.getUAV();
            this.getCamera();
        },
        methods: {
            getPhone() {
                frontGetProduct("phone").then(res => {
                    this.phone = res;
                })
            },
            getRobot() {
                frontGetProduct("robot").then(res => {
                    this.robot = res;
                })
            },

            getPc() {
                frontGetProduct("pc").then(res => {
                    this.pc = res;
                })
            },
            getUAV() {
                frontGetProduct("UAV").then(res => {
                    this.UAV = res;
                })
            },
            getCamera(){
                frontGetProduct("camera").then(res => {
                    this.camera = res;
                })
            }
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

    .name3 {
        font-size: 15px;
        text-align: center;
        color: black;
        margin-top: 20px;
    }

    .guanggaoci {
        font-size: 3px;
        text-align: center;
        color: rgb(153, 148, 148);
        margin-top: 20px;
    }

    .finashoji-top {
        width: 230px;
        height: 295px;
        background-color: white;
        margin-top: 10px;
    }

    .finashoji-top:hover {
        margin-top: -2px;
        margin-left: -1px;
        box-shadow: 2px 2px 6px 0px rgba(0, 0, 0, .18);
    }

    .price4 {
        color: #ff6700;
        text-align: center;
        font-size: 15px;
        margin-top: 20px;
    }
</style>
