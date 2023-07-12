<template>
  <div class="show">
 
  </div>
</template>

<script>
//首先引入三个包


export default {
  data() {
    return {
    	
    };
  },
  mounted() {
    this.init();
  },
  methods: {
    goBack() {
        this.$router.go(-1);
      },
    init() {
      
    },
  },
};


</script>

<style>
.show{
    width: 100%;
    background-color: white;
}
.el-page-header{
    line-height: 45px;
}
</style>