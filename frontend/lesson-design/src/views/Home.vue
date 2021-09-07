<template>
  <div class="home">
    <my-header/>
    <Row class="bigPic">
      <Col span="2"></Col>
      <Col span="4" class="first">
        <div>

          <Dropdown class="dropDown" style="margin-left: 20px" placement="right">
            <a href="javascript:void(0)" style="font-size: 20px">
              菜单(居中)
              <Icon type="ios-arrow-down"></Icon>
            </a>
            <DropdownMenu slot="list" class="dropDownMenu">
              <DropdownItem>驴打滚</DropdownItem>
              <DropdownItem>炸酱面</DropdownItem>
              <DropdownItem>豆汁儿</DropdownItem>
              <DropdownItem>冰糖葫芦</DropdownItem>
              <DropdownItem>北京烤鸭</DropdownItem>
            </DropdownMenu>
          </Dropdown>

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
      <Col span="4" class="third"></Col>
      <Col span="2"></Col>
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
    myHeader,myFooter
  },
  mounted() {

  },
  methods:{

  }
}
</script>
<style>
  .bigPic{
    height: 500px;

    margin: 0 auto;
    display: flex;
    justify-content: center;
    #background-color: blue;
  }
  .first{

  }
  .second{


  }
  .third{

    #background-color: yellow;
  }
  .first div{
    height: 100px;
    #background-color: gold;

    display: flex;
    justify-content: center; /* 水平居中 */
    align-items: center; /* 垂直居中 */
  }

  .dropDownMenu{
    display: flex;
    background-color:rgba(0,0,0,0.2);

  }



  .demo-carousel{
    height: 500px;
  }

  .demo-carousel img{
    width: 100%;
    height: 100%;
    object-fit:fill;
  }
</style>