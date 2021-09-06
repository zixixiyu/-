<template>
  <div class="home">
    <my-header/>


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
  }
}
</script>
