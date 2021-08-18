<template>
  <div class="loginview" >
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <h3 class="logintitle">Welcome</h3>
        <el-form-item label="用户名" prop="name">
          <el-input v-model="form.name" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" v-model="form.password" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item align="center">
          <el-button type="primary" @click="onSubmit('form')">登录</el-button>
        </el-form-item>
      </el-form>
  </div>
</template>

<script>
export default {
  name: "login",
  data() {
    return {
      form: {
        name: '',
        password:''
      },
      rules:{
        name:[{
          required:true ,message:'请输入用户名',trigger:'blur'
        },
          {
            min:3,max:8,message: '用户名长度为3-8个字符',trigger: 'blur'
          }],
        password: [{
          required:true ,message:'请输入密码',trigger:'blur'
        },
          {
            min:3,max:8,message: '密码长度为3-8个字符',trigger: 'blur'
          }]
      }
    }
  },
  methods:{
    onSubmit: function (formName) {
      this.$refs[formName].$children[2].validate((valid) => {
        var vm = this
        if (valid) {
          //alert('submit!');10
          this.axios({
            method: 'get',
            url: 'http://localhost:8081/login?name=' + vm.form.name + '$password=' + vm.form.password,
          }).then(function (resp) {
            if (resp.data == "success") {
              vm.$router.push("/home")
            } else {
              vm.$message.error('用户名或密码错误')
            }
          })
        } else {
          vm.$message.error('用户名或密码格式错误')
          return false;
        }
      });
    },
    asd:function (){
      console.log("!!!!!!!!!!!!")
    }
  }
  }
</script>

<style scoped>
  .loginview{
    width: 500px;
    height: 300px;
    border: 1px solid #DCDFE6;
    margin: 150px auto;
    padding: 30px 50px 30px 30px;
    border-radius: 20px;
    box-shadow: 0px 0px 20px #DCDFE6;
  }
  .logintitle{
    text-align: center;
    margin-bottom: 40px;
  }
</style>
