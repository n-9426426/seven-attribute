<template>
  <div class="primary">
    <el-table :data="data.userList.list" style="width: 100%" stripe="true">
      <el-table-column align="center">
        <template #header>
          <input type="text" v-model="search" @keyup.enter="getList(1)" placeholder="按下回车搜索">
          <button @click="getList(1)">搜索</button>
        </template>
        <el-table-column label="姓名" prop="name" align="center" />
        <el-table-column label="年龄" prop="age" align="center" />
        <el-table-column label="生日" prop="birthday" align="center" />
        <el-table-column label="爱好" prop="hobbies" align="center" />
        <el-table-column label="性别" prop="sex" align="center" />
        <el-table-column label="图片" prop="photopath" align="center">
          <template #default="scope">
            <img :src="'http://192.168.140.16/'+scope.row.photopath">
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center" width="120">
          <template #default="scope">
            <el-button type="primary" :icon="Edit" circle @click="store.dispatch('GO_UPDATE', { id: scope.row.id})"/>
            <el-button type="danger" :icon="Delete" circle @click="del(scope.row.id)"/>
          </template>
        </el-table-column>
      </el-table-column>
    </el-table>
    <div class="button">
      <button @click="getUserList(1)">首页</button>
      <button @click="getUserList(data.userList.prePage)">上一页</button>
      <button @click="getUserList(data.userList.nextPage != 0 ? data.userList.nextPage : data.userList.pages)">下一页</button>
      <button @click="getUserList(data.userList.pages)">尾页</button>
    </div>
  </div>
</template>

<script setup>
import { reactive, onMounted, nextTick } from 'vue'
import { useStore } from 'vuex'
import { Delete, Edit } from '@element-plus/icons-vue'
// import { useRouter } from 'vue-router'

const store = useStore()
const axios = require('axios')
const data = reactive({
  userList: {}
})

const getUserList = (curPage) => {
  axios({
    method: 'get',
    url: 'user/list',
    params: {
      curPage: curPage,
      find: null
    }
  }).then((resp) => {
    data.userList = resp.data
    console.log(data.userList)
  })
}

const del = (id) => {
  axios({
    method: 'get',
    url: 'user/del',
    params: {
      id: id
    }
  }).then((resp) => {
    nextTick(() => {
      getUserList(data.userList.pageNum)
    })
  })
}

onMounted(() => {
  getUserList(1)
})

store.commit('UPDATE_PAGE_TITLE', {
  name: '列表',
  img: '../assets/list.jpg'
})

</script>

<style scoped>
img{
  width: 80px;
}
.button{
  position: absolute;
  top: 400px;
  left: 285px;
}
</style>
