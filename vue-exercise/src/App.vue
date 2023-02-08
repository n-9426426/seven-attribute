<template>
  <div class="flex">
    <div @click="store.commit('GO_ADD')">
      添加
    </div>
    <div @click="store.commit('GO_LIST')">
      列表
    </div>
  </div>
  <div>
    <router-view></router-view>
  </div>
</template>

<script setup>
import { useStore } from 'vuex'
const store = useStore()
</script>

<style>
.primary{
  width: 50%;
  margin-left: 25%;
  position: relative;
}
.flex{
  position: fixed;
  top: 100px;
  right: 50px;
}
.flex > div {
  border: 1px solid orange;
  border-radius: 5px;
  width: 50px;
  height: 80px;
  line-height: 80px;
  text-align: center;
  cursor: pointer;
}
.flex > div:hover{
  background-color: orange;
  color: white;
}
</style>
