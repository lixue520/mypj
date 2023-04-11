<template>
  <el-menu default-active="2"  class="el-menu-vertical-demo"
        background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-picture"></i>
            <span>轮播图编辑</span>
          </template>
        </el-submenu>
      </el-menu>
</template>

<script>

export default {
   
    name: "SideMenu",
    
}
</script>

<style scoped>
@import "@/views/ins.scss";
</style>