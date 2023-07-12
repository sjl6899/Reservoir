<template>
  <div class="login">
    <div
      v-loading="loading"
      element-loading-text="登录中..."
      element-loading-spinner="el-icon-loading"
      element-loading-background="rgba(0, 0, 0, 0.6)"
      class="login-container"
    >
      <el-form
        ref="loginForm"
        :model="loginForm"
        :rules="loginRules"
        class="login-form"
        auto-complete="on"
        label-position="left"
      >
        <!-- 头像区域 -->
        <div v-if="TxStatus" class="avatar-box">
          <img src="../../assets/user.png" alt="" />
        </div>

        <div class="title-container">
          <h3 class="title">后台管理系统</h3>
        </div>

        <el-form-item prop="username">
          <el-input
            ref="username"
            v-model="loginForm.username"
            placeholder="Username"
            name="username"
            type="text"
            tabindex="1"
            auto-complete="on"
          />
        </el-form-item>

        <el-form-item prop="password">
          <el-input
            :key="passwordType"
            ref="password"
            v-model="loginForm.password"
            :type="passwordType"
            placeholder="Password"
            name="password"
            tabindex="2"
            auto-complete="on"
            @keyup.enter.native="handleLogin"
          />
          <span class="show-pwd" @click="showPwd"> </span>
        </el-form-item>
        <div style="padding-left: 55px">
          <el-button
            type="primary"
            style="width: 95%; margin-bottom: 20px"
            @click.native.prevent="handleLogin"
            >登录</el-button
          >
        </div>
        <div class="tips">
          <span style="margin-right: 20px"
            >如果您还没有账号请先
            <span style="color: #409eff; cursor: pointer" @click="register"
              >注册</span
            ></span
          >
        </div>
      </el-form>
    </div>
  </div>
</template>
<script>
import { validUsername } from "@/utils/validate";
export default {
  name: "Login",
  data() {
    const validateUsername = (rule, value, callback) => {
      if (!validUsername(value)) {
        callback(new Error("用户名不存在！"));
      } else {
        callback();
      }
    };
    const validatePassword = (rule, value, callback) => {
      if (value.length < 3) {
        callback(new Error("密码最少为3位字符！"));
      } else {
        callback();
      }
    };
    return {
      // 头像状态
      TxStatus: true,
      loginForm: {
        username: "",
        password: "",
      },
      // 登录规则
      loginRules: {
        username: [
          { required: true, trigger: "blur", validator: validateUsername },
        ],
        password: [
          { required: true, trigger: "blur", validator: validatePassword },
        ],
      },
      loading: false,
      passwordType: "password",
      redirect: undefined,
    };
  },
  watch: {
    $route: {
      handler: function (route) {
        this.redirect = route.query && route.query.redirect;
      },
      immediate: true,
    },
  },
  methods: {
    showPwd() {
      if (this.passwordType === "password") {
        this.passwordType = "";
      } else {
        this.passwordType = "password";
      }
      this.$nextTick(() => {
        this.$refs.password.focus();
      });
    },
    // 登录业务
    handleLogin() {
      this.$refs.loginForm.validate((valid) => {
        // 如果符合验证规则
        if (valid) {
          this.loading = true;
          setTimeout(() => {
            this.$axios
              .post("http://localhost:8089/user/login", {
                username: this.loginForm.username,
                password: this.loginForm.password,
              })
              .then((res) => {
                if (res.data === 'success') {
                  this.$router.push({ path: "/reservior" });
                }else if(res.data==='err'){
                  alert("密码错误")
                  this.loading = false;
                }else{
                  alert("用户不存在")
                  this.loading = false;
                }
              })
          }, 500);
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    // 跳转注册业务
    register() {
      this.$router.push({ path: "/register" });
    },
  },
};
</script>
  
  <style>
.login {
  width: 99%;
  height: 98%;
  background-image: url(../../assets/background.jpg);
  background-size: cover; /* 使图片平铺满整个浏览器（从宽和高的最大需求方面来满足，会使某些部分无法显示在区域中） */
  position: absolute;
  z-index: -1;
  background-repeat: no-repeat;
}
.el-loading-mask{
  width: 100%;
  min-height: calc(98vh);
}

.el-form-item__error {
  color: #f56c6c;
  font-size: 16px;
  line-height: 1;
  padding-top: 4px;
  position: absolute;
  top: 100%;
  left: 40%;
  text-align: center;
}
.login-form {
  position: relative;
  width: 520px;
  max-width: 100%;
  padding: 160px 35px 0;
  margin: 0 auto;
  overflow: hidden;
}
input {
  background: transparent;
  border: 0px;
  border-radius: 0px;
  padding: 12px 5px 12px 15px;
  color: #fff;
  height: 47px;
  caret-color: #fff;
}

.el-input {
  display: inline-block;
  padding-left: 55px;
  height: 47px;
  width: 85%;
}

.tips {
  font-size: 18px;
  text-align: center;
  color: #000;
  margin-bottom: 10px;
}

.svg-container {
  padding: 6px 5px 6px 15px;
  color: #eee;
  vertical-align: middle;
  width: 30px;
  display: inline-block;
}

.avatar-box {
  margin: 0 auto;
  width: 120px;
  height: 120px;
  border-radius: 50%;
  border: 1px solid #409eff;
  box-shadow: 0 0 10px #409eff;
  position: relative;
  bottom: 20px;
}

img {
  width: 100%;
  height: 100%;
  border-radius: 50%;
}

.title-container {
  position: relative;
}

.title {
  font-size: 30px;
  color: #409eff;
  margin: 0px auto 40px auto;
  text-align: center;
  font-weight: 500;
}

.show-pwd {
  position: absolute;
  right: 10px;
  top: 7px;
  font-size: 16px;
  color: #eee;
  cursor: pointer;
  user-select: none;
}
</style>