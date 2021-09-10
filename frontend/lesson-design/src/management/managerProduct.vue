<template>
    <div>
        <Divider>产品管理</Divider>
        <Row>
            <Col span="20"></Col>
            <Col span="4"><Button type = "primary" @click="insertProductModel=true" size = "small" style="margin-left: 0;margin-bottom: 50px">添加商品</Button></Col>
        </Row>
        <Table border :columns="columns" :data="product">
            <template slot-scope="{row,index}" slot="action">
                <Button type="primary" size="small" style="margin-right: 5px" @click="shanjia(row.productName,row.isDelete,index)">上架</Button>
                <Button type="error" size="small" @click="xiajia(row.productName,row.isDelete,index)">下架</Button>
            </template>
        </Table>
        <Page :total="productNum" :current="currentPage" @on-change="pageNum=>getPagePro(pageNum)"/>

        <Modal
                v-model="insertProductModel"
                title="增加商品"
                @on-ok="insertProduct()"
                width="800"
        >
            <Form :model="productInfo" label-position="right">
                <FormItem label="商品类别">
                    <RadioGroup v-model="productInfo.categoryName" type="button">
                        <Radio label="robot">
                            <span>智能机器人</span>
                        </Radio>
                        <Radio label="phone">
                            <span>智能手机</span>
                        </Radio>
                        <Radio label="pc">
                            <span>笔记本电脑</span>
                        </Radio>
                        <Radio label="UAV">
                            <span>无人机</span>
                        </Radio>
                        <Radio label="camera">
                            <span>智能摄像机</span>
                        </Radio>
                    </RadioGroup>
                </FormItem>
                <FormItem label="商品名称">
                    <Input v-model="productInfo.name" placeholder="product name" style="width: 300px" />
                </FormItem>
                <FormItem label="押金">
                    <InputNumber v-model="productInfo.deposit" placeholder="deposit" style="width: 300px" />
                </FormItem>
                <FormItem label="日租金">
                    <InputNumber v-model="productInfo.dailyPrice" placeholder="dailyPrice" style="width: 300px" />
                </FormItem>
                <FormItem label="折后日租金">
                    <InputNumber v-model="productInfo.discountDailyPrice" placeholder="discountDailyPrice" style="width: 300px" />
                </FormItem>
                <FormItem label="当前库存">
                    <InputNumber v-model="productInfo.currentInventory" placeholder="currentInventory" style="width: 300px" />
                </FormItem>

                <FormItem label="总库存">
                    <InputNumber v-model="productInfo.totalInventory" placeholder="currentInventory" style="width: 300px" />
                </FormItem>
                <FormItem label="商品简介">
                    <Input v-model="productInfo.introduce" placeholder="introduce" style="width: 300px" />
                </FormItem>
                <FormItem label="产品参数(使用/分割)">
                    <Input v-model="productInfo.parameter" placeholder="introduce" style="width: 300px" />
                </FormItem>
                <Upload
                        multiple
                        type="drag"
                        action=""
                        :before-upload="handleUpload"
                >
                    <div style="padding: 20px 0">
                        <Icon type="ios-cloud-upload" size="52" style="color: #3399ff"></Icon>
                        <p>点击上传图片</p>
                    </div>
                </Upload>
            </Form>


        </Modal>
    </div>
</template>

<script>
    import {getPageProduct,getProductNum,shanxiajia,postImage} from '../request/productModule/getProduct'
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
                insertProductModel:false,
                productInfo:{
                    categoryName:'',
                    name:'',
                    deposit:0.0,
                    dailyPrice:0.0,
                    discountDailyPrice:0.0,
                    currentInventory:0,
                    totalInventory:0,
                    introduce:'',
                    parameter:'',
                    pic:''

                }
            }
        },
        methods:{
            shanjia(name,isDelete,index){
                if (isDelete===0){
                    this.$Message.info("该商品已经上架");
                    return
                }
                shanxiajia(name).then(res=>{
                    if (res){
                        this.$Message.info("上架成功");
                        this.product[index].isDelete = 0;
                    }
                })
            },
            xiajia(name,isDelete,index){
                if (isDelete===1){
                    this.$Message.info("该商品已经下架");
                    return
                }
                shanxiajia(name).then(res=>{
                    if (res){
                        this.$Message.info("下架成功");
                        this.product[index].isDelete = 1;
                    }
                })
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
            },
            insertProduct(){
                //  将json转换为FormData类型的数据
                let formData = new FormData();
                for(let key in this.productInfo){
                    formData.append(key, this.productInfo[key])
                    console.log(key,this.productInfo[key]);
                }
                // 发送请求
                postImage(formData).then(res => {
                    if (res){
                        this.productInfo = ""
                        this.$router.go(0);
                    }
                })

            },
            handleUpload (file) {
                this.productInfo.pic = file;
                return false;
            },
        },
        mounted() {
            this.getAllNum();
            this.getPagePro(1);
        }
    }
</script>

<style scoped>

</style>
