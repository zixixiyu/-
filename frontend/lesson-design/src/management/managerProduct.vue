<template>
    <div>
        <Divider>产品管理</Divider>
        <Table border :columns="columns" :data="product"></Table>
    </div>
</template>

<script>
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
                        title: '是否下架',
                        key: 'isDelete'
                    }
                ]
            }
        },
    }
</script>

<style scoped>

</style>
