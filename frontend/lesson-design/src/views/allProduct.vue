<template>
    <div>
        <my-header></my-header>
        <Row>
            <Col span="2"></Col>
            <Col span="20">
                <template>
                    <Tabs :value="selectedTab" @on-click="name=>clickTab(name)">
                        <TabPane label="不限" name="noneLimit">
                            <Row>
                                <template v-for="item in product" >
                                    <Col span="4" :key="item.id">
                                        <router-link :to="'/productDetail/'+item.id">
                                            <div class="finashoji-top" style="margin-bottom: 50px">
                                                <img v-bind:src="$picHost+item.picUrl" width="200px" height="150px">
                                                <p class="name3">{{item.name}}</p>
                                                <p class="guanggaoci">{{item.parameter}}</p>
                                                <p class="price4">原价：{{item.dailyPrice}}元/天</p>
                                                <p class="price4" >折扣价：{{item.discountDailyPrice}}元/天</p>
                                            </div>
                                        </router-link>>
                                    </Col>
                                </template>
                            </Row>

                        </TabPane>
                        <TabPane label="智能手机" name="phone">
                            <Row>
                                <template v-for="item in product" >
                                    <Col span="4" :key="item.id">
                                        <router-link :to="'/productDetail/'+item.id">
                                            <div class="finashoji-top" style="margin-bottom: 50px">
                                                <img v-bind:src="$picHost+item.picUrl" width="200px" height="150px">
                                                <p class="name3">{{item.name}}</p>
                                                <p class="guanggaoci">{{item.parameter}}</p>
                                                <p class="price4">原价：{{item.dailyPrice}}元/天</p>
                                                <p class="price4" >折扣价：{{item.discountDailyPrice}}元/天</p>
                                            </div>
                                        </router-link>>
                                    </Col>
                                </template>
                            </Row>
                        </TabPane>
                        <TabPane label="智能机器人" name="robot">
                            <Row>
                                <template v-for="item in product" >
                                    <Col span="4" :key="item.id">
                                        <router-link :to="'/productDetail/'+item.id">
                                            <div class="finashoji-top" style="margin-bottom: 50px">
                                                <img v-bind:src="$picHost+item.picUrl" width="200px" height="150px">
                                                <p class="name3">{{item.name}}</p>
                                                <p class="guanggaoci">{{item.parameter}}</p>
                                                <p class="price4">原价：{{item.dailyPrice}}元/天</p>
                                                <p class="price4" >折扣价：{{item.discountDailyPrice}}元/天</p>
                                            </div>
                                        </router-link>>
                                    </Col>
                                </template>
                            </Row>
                        </TabPane>
                        <TabPane label="笔记本电脑" name="pc">
                            <Row>
                                <template v-for="item in product" >
                                    <Col span="4" :key="item.id">
                                        <router-link :to="'/productDetail/'+item.id">
                                            <div class="finashoji-top" style="margin-bottom: 50px">
                                                <img v-bind:src="$picHost+item.picUrl" width="200px" height="150px">
                                                <p class="name3">{{item.name}}</p>
                                                <p class="guanggaoci">{{item.parameter}}</p>
                                                <p class="price4">原价：{{item.dailyPrice}}元/天</p>
                                                <p class="price4" >折扣价：{{item.discountDailyPrice}}元/天</p>
                                            </div>
                                        </router-link>>
                                    </Col>
                                </template>
                            </Row>
                        </TabPane>
                        <TabPane label="无人机" name="UAV">
                            <Row>
                                <template v-for="item in product" >
                                    <Col span="4" :key="item.id">
                                        <router-link :to="'/productDetail/'+item.id">
                                            <div class="finashoji-top" style="margin-bottom: 50px">
                                                <img v-bind:src="$picHost+item.picUrl" width="200px" height="150px">
                                                <p class="name3">{{item.name}}</p>
                                                <p class="guanggaoci">{{item.parameter}}</p>
                                                <p class="price4">原价：{{item.dailyPrice}}元/天</p>
                                                <p class="price4" >折扣价：{{item.discountDailyPrice}}元/天</p>
                                            </div>
                                        </router-link>>
                                    </Col>
                                </template>
                            </Row>
                        </TabPane>
                        <TabPane label="智能摄像机" name="camera">
                            <Row>
                                <template v-for="item in product" >
                                    <Col span="4" :key="item.id">
                                        <router-link :to="'/productDetail/'+item.id">
                                            <div class="finashoji-top" style="margin-bottom: 50px">
                                                <img v-bind:src="$picHost+item.picUrl" width="200px" height="150px">
                                                <p class="name3">{{item.name}}</p>
                                                <p class="guanggaoci">{{item.parameter}}</p>
                                                <p class="price4">原价：{{item.dailyPrice}}元/天</p>
                                                <p class="price4" >折扣价：{{item.discountDailyPrice}}元/天</p>
                                            </div>
                                        </router-link>>
                                    </Col>
                                </template>
                            </Row>
                        </TabPane>
                    </Tabs>
                </template>

            </Col>
            <Col span="2"></Col>
        </Row>


        <my-footer></my-footer>
    </div>
</template>

<script>
    import myHeader from "../components/header.vue";
    import myFooter from "../components/footer.vue";
    import {getAllProduct} from '../request/productModule/getProduct'
    export default {
        name: "allProduct",
        components:{
           myHeader,myFooter
        },
        data(){
            return {
                selectedTab:this.$route.params.selected,
                product:[]
            }
        },
        methods:{
            getAllPro(category){
                getAllProduct(category).then(res=>{
                    this.product = res;
                })
            },
            clickTab(name){
                this.getAllPro(name);
            }
        },
        mounted() {

            if (typeof(this.$route.params.selected)==='undefined'){
                this.getAllPro("noneLimit")
            }else {
                this.getAllPro(this.$route.params.selected);
            }

        }

    }
</script>

<style scoped>
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
