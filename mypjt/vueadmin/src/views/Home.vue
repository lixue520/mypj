<template>
  <el-container style="height: 100%; border: 1px solid #eee">
    <el-aside width="200px" style="">
      <el-avatar :size="45" src="https://empty">
      <img src="https://picb.zhimg.com/v2-8a25a1d83225584dd8598f15da68b253_r.jpg"/>
    </el-avatar>
      <side-menu></side-menu>
    </el-aside>
    <el-container>
      <el-header style="text-align: right; font-size: 12px">

      </el-header>
      <el-main>
        <carousel-editing></carousel-editing>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import CarouselEditing from '@/components/CarouselEditing.vue'
import SideMenu from './SideMenu.vue'

export default {
  components: { SideMenu, CarouselEditing },
  name: 'MyHome',

}
</script>

<style>
@import "@/views/ins.scss";
</style>
