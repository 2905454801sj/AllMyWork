<template>
  <div id="app">
<!--    <div>
      <span>
        <router-link to="/Home">首页</router-link>
      </span>
      <span>
        <router-link to="/products">商品</router-link>
      </span>
    </div>
    <router-view></router-view>-->
    <div class="row">
     <ul class="nav nav-tabs">
       <li role="presentation"><router-link to="/Home">首页</router-link></li>
       <li role="presentation"><router-link to="/Aproducts/1">商品</router-link></li>
       <li role="presentation"><router-link to="/Bproducts/2">商品</router-link></li>
       <li role="presentation"><router-link to="/Cproducts/3">商品</router-link></li>
       <button type="button" @click="btnfn">点我</button>
     </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'app',
  data () {
    return {

    }
  },
  methods:{
    btnfn:function (){
      this.$router.push("/Aproducts/1")
    }
  }
}
</script>

<style>

</style>
