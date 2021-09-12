<template>
    <div>
        <my-header/>
        <Row>
            <Col span="2" class="towBord"></Col>
            <Col span="10">
                <img height="600px" width="100%" v-bind:src="$picHost+product.picUrl">
            </Col>
            <Col span="10">
                <div>
                    <p class="nameClass">{{product.name}}</p>
                </div>
                <div>
                    <Card style="width:400px;margin-left: 95px">
                        <p slot="title">
                            <Icon type="ios-film-outline"></Icon>
                            价格
                        </p>
                        <p class="">押金：{{product.deposit*orderItem.productNum}}</p>
                        <p class="">原价：{{product.dailyPrice}}</p>
                        <p class="">现租价：{{product.discountDailyPrice}}</p>
                    </Card>

                </div>
                <div>
                    <Card style="width:400px;margin-left: 95px">
                        <p slot="title">
                            <Icon type="ios-film-outline"></Icon>
                            数量
                        </p>
                        <InputNumber :min=0 :max="product.currentInventory" size="large" v-model="orderItem.productNum"
                                     controls-outside></InputNumber>
                        <span class="">剩余数量：{{product.currentInventory}}</span>
                    </Card>
                </div>
                <div>
                    <Card style="width:400px;margin-left: 95px">
                        <p slot="title">
                            <Icon type="ios-film-outline"></Icon>
                            租赁时间
                        </p>
                        <DatePicker v-model="orderItem.beginAndEndTime" type="daterange" placement="bottom-end"
                                    placeholder="Select date" style="width: 200px"></DatePicker>
                    </Card>
                </div>
                <div>
                    <Card style="width:400px;margin-left: 95px">
                        <p slot="title">
                            <Icon type="ios-film-outline"></Icon>
                            操作
                        </p>
                        <Button type="primary" @click="buyThis()">购买</Button>
                    </Card>
                </div>
            </Col>
            <Col span="2" class="towBord"></Col>
        </Row>
        <div>
            <p class="nameClass">{{product.introduce}}</p>
        </div>
        <my-footer/>

        <Modal
                v-model="payModel"
                title="确认支付"
                ok-text="确认支付"
                @on-ok="verifyPay()">
            <Card style="width:500px">
                <p slot="title">
                    <Icon type="ios-film-outline"></Icon>
                    订单详情
                </p>
                <p>产品名称：{{product.name}}</p>
                <p>产品数量：{{orderItem.productNum}}</p>
                <p> 租期：{{orderItem.beginTime}}---{{orderItem.endTime}}</p>
                <p>总租金：{{totalMessage.totalDailyPrice}}</p>
                <p>总押金:{{totalMessage.totalDeposit}}</p>
                <p>总价格:{{totalMessage.totalPrice}}</p>
            </Card>
        </Modal>
    </div>
</template>

<script>
    import myFooter from "../components/footer";
    import myHeader from "../components/header";
    import {getOneProduct} from "../request/productModule/getProduct"
    import {certifyPay} from "../request/orderModule/orderOperate"

    export default {
        name: "productDetail",
        components: {
            myFooter, myHeader
        },
        data() {
            return {
                product: '',
                orderItem: {
                    productId: '',
                    productNum: 0,
                    beginAndEndTime: '',
                    beginTime: '',
                    endTime: ''
                },
                payModel: false,
                totalMessage: {
                    totalDeposit: 0.0,
                    totalDailyPrice: 0.0,
                    totalPrice: 0.0
                }
            }
        },
        methods: {
            getOne() {
                getOneProduct(this.$route.params.productId).then(res => {
                    this.product = res;
                })
            },
            buyThis: function () {
                this.orderItem.beginTime = this.orderItem.beginAndEndTime[0];
                this.orderItem.endTime = this.orderItem.beginAndEndTime[1];
                this.orderItem.productId = this.product.id;
                console.log(this.orderItem.beginTime);
                let beginDate = this.orderItem.beginTime
                let endDate = this.orderItem.endTime

                let days = (endDate - beginDate) / (24 * 60 * 60 * 1000);
                this.totalMessage.totalDeposit = this.product.deposit * this.orderItem.productNum;
                this.totalMessage.totalDailyPrice = this.orderItem.productNum * this.product.discountDailyPrice * days;
                this.totalMessage.totalPrice = this.totalMessage.totalDeposit + this.totalMessage.totalDailyPrice
                console.log(this.orderItem)
                this.payModel = true
            },
            verifyPay() {
                //确认支付，后端需要的值，
                certifyPay(this.orderItem.productId, this.orderItem.beginTime, this.orderItem.endTime, this.orderItem.productNum).then(res => {
                    if (res) {
                        this.product.currentInventory = this.product.currentInventory - this.orderItem.productNum
                        this.$Message.info("支付成功")
                    }
                })
            }
        },
        mounted() {
            //没有这个参数就返回主页面
            if (this.$route.params.productId === null) {
                this.$router.push('/')
            } else {
                this.getOne()
            }

        }
    }
</script>

<style scoped>
    .towBord {
        background-color: #f1f3f4;
    }

    .nameClass {
        font-size: 50px;
        color: #00C1B6;
    }

</style>
