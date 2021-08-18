<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'App',
  methods:{
    regist:function (){
      this.axios({
        method:'get',
        url:'http://localhost:8888/regist?mail='+this.mail+'&password='+this.password
      }).then(function (response){
        console.log(response.data)
      })
    }
  }
}
</script>

<style>

</style>
