<template>
    <div>
        <Divider>产品管理</Divider>
        <Table border :columns="columns" :data="product">

            <template slot-scope="{row}" slot="action">
                <Button type="primary" size="small" style="margin-right: 5px" @click="shanjia(row.productName,row.isDelete)">上架</Button>
                <Button type="error" size="small" @click="xiajia(row.productName,row.isDelete)">下架</Button>
            </template>
        </Table>
        <Page :total="productNum" :current="currentPage" @on-change="pageNum=>getPagePro(pageNum)"/>
    </div>
</template>

<script>
    import {getPageProduct,getProductNum} from '../request/productModule/getProduct'
    export default {
        name: "managerProduct",
        data(){
            return{
                columns:[
                    {
                        title: '大类名称',
                        key: 'categoryName',
                    },
                    {
                        title:'商品名称',
                        key:'productName',
                    },
                    {
                        title: '押金',
                        key:'deposit'
                    },
                    {
                        title: '日租金',
                        key:'dailyPrice'
                    },
                    {
                        title: '打折后租金',
                        key:'discountDailyPrice'
                    },
                    {
                        title:'当前库存',
                        key:'currentInventory'
                    },
                    {
                        title: '总库存',
                        key: 'totalInventory'
                    },
                    {
                        title: '商品简介',
                        key:'introduce'
                    },
                    {
                        title: '商品参数',
                        key:'parameter'
                    },
                    {
                        title: '是否下架（1已下架）',
                        key: 'isDelete'
                    },
                    {
                        title: 'Action',
                        slot: 'action',
                        width: 150,
                        align: 'center'
                    }
                ],
                product:[],
                productNum:0,
                currentPage:1,



            }
        },
        methods:{
            shanjia(name,isDelete){
                if (isDelete===0){
                    this.$Message.info("该商品已经上架");
                    return
                }
            },
            xiajia(name,isDelete){
                if (isDelete===1){
                    this.$Message.info("该商品已经下架");
                    return
                }

            },
            getAllNum(){
                getProductNum().then(res=>{
                    this.productNum = res;
                })
            },
            getPagePro(page){
                getPageProduct(page).then(res=>{
                    this.product = res;
                    this.currentPage = page;
                })
            }
        },
        mounted() {
            this.getAllNum();
            this.getPagePro(1);
        }
    }
</script>

<style scoped>

</style>
