<template>
    <div class="">
        <Header></Header>
        <Nav></Nav>
        <Show></Show>
    </div>
</template>
    
<script>
  import Header from "@/pages/Admin/Header";
  import Nav from "@/pages/Admin/Nav";
  import Show from "@/pages/Admin/Show";
  export default {
    name: "Admin",
    components: {
        Header,
        Nav,
        Show,
    },
    data() {
      return {
        reserviorInfo: [],
      };
    },
    mounted() {
      this.init();
    },
    methods: {
      init() {
        console.log("info");
    
      },
    },
  };
  </script>
    
  <style>
  * {
    margin: 0;
    padding: 0;
  }
  
  </style>