<template>
    <div>
        <Divider>订单管理</Divider>
        用户名：<Input v-model="username" placeholder="username" style="width: 300px"/>
        <Button type="primary" @click="queryOrder()">查找</Button>
        <Table border :columns="columns" :data="order">
            <template slot-scope="{row}" slot="action">
                <Button type="primary" size="small" style="margin-right: 5px" @click="orderDetail(row.id)">查看订单详情
                </Button>
            </template>
        </Table>
        <Page :total="orderNum" :page-size="pageSize" :current="currentPage" @on-change="pageNum=>getOrder(pageNum)"/>

        <Modal
                v-model="orderItemModel"
                title="订单项查看">

            <template v-for="(item,index) in orderItemVos">
                <Card style="width:350px" :key=index>
                    <p slot="title">
                        <Icon type="ios-film-outline"></Icon>
                        订单编号：{{currentOrderId}}
                    </p>
                    <p>产品名称：{{item.productName}}</p>
                    <p>当时租赁价格：{{item.price}}</p>
                    <p>租赁时间：{{item.beginTime}}--{{item.endTime}}</p>
                    <p>租赁天数：{{item.days}}</p>
                    <p>数量：{{item.quantity}}</p>
                    <p>总价格：{{item.totalPrice}}</p>

                </Card>
            </template>


        </Modal>
    </div>
</template>

<script>
    import {getOrderByUsername, getOrderNumByUserName, getOrderItemByOrderId} from '../request/orderModule/orderOperate'


    export default {
        name: "managerOrder",
        data() {
            return {
                columns: [
                    {
                        title: '订单编号',
                        key: 'id'
                    },
                    {
                        title: "用户名",
                        key: "username"
                    },
                    {
                        title: "订单创建时间",
                        key: "orderTime"
                    },
                    {
                        title: "订单总价",
                        key: "orderTotalPrice"
                    },
                    {
                        title: 'Action',
                        slot: 'action',
                        width: 150,
                        align: 'center'
                    }
                ],
                order: [],
                username: '',
                orderNum: 0,
                currentPage: 1,
                orderItemVos: [
                ],
                orderItemModel: false,
                currentOrderId: 0,
                pageSize: 5
            }
        },
        methods: {
            getOrderNum() {
                getOrderNumByUserName(this.username).then(res => {
                    this.orderNum = res;
                })
            },
            queryOrder() {
                this.getOrderNum();
                this.getOrder(1);
            },
            orderDetail(orderId) {
                getOrderItemByOrderId(orderId).then(res => {
                    this.orderItemVos = res;
                    this.currentOrderId = orderId;
                    this.orderItemModel = true;
                })

            },
            getOrder(pageNum) {
                getOrderByUsername(this.username, pageNum).then(res => {
                    this.order = res;
                })
            }
        }
    }
</script>

<style scoped>

</style>
