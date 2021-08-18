<template>
<div>
  {{id}}
  商品1
</div>
</template>

<script>
export default {
  name: "products",
  data(){
    return {
      id:this.$route.params.id
    }
  },
  created() {
    console.log(this.id)
  }
}
</script>

<style scoped>

</style>
