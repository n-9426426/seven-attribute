<template>
  <div class="primary">
    <el-form :model="store.state.user" label-width="120px" ref="form1">
      <el-form-item label="姓名">
        <el-input v-model="store.state.user.name" />
      </el-form-item>
      <el-form-item label="年龄">
        <el-input v-model="store.state.user.age" />
      </el-form-item>
      <el-form-item label="生日">
        <el-col :span="11">
          <el-date-picker
            v-model="birthday"
            type="date"
            placeholder="Pick a date"
            style="width: 100%"
          />
        </el-col>
      </el-form-item>
      <el-form-item label="爱好">
        <el-checkbox-group v-model="hobbies">
          <el-checkbox label="吃" name="hobby" />
          <el-checkbox label="喝" name="hobby" />
          <el-checkbox label="玩" name="hobby" />
          <el-checkbox label="乐" name="hobby" />
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="性别">
        <el-radio-group v-model="store.state.user.sex">
          <el-radio label="男" />
          <el-radio label="女" />
        </el-radio-group>
      </el-form-item>
      <el-form-item label="原图">
        <img v-if="store.state.user.photopath != null" :src="'http://192.168.140.16/' + store.state.user.photopath"/>
      </el-form-item>
      <el-form-item label="上传文件">
        <el-upload
          ref="upload"
          class="upload-demo"
          action
          :limit="1"
          :on-change="handleChange"
          :on-remove="handleRemove"
          :auto-upload="false"
        >
          <template #trigger>
            <el-button type="primary">select file</el-button>
          </template>
          <el-button class="ml-3" type="success" @click="submitUpload">
            upload to server
          </el-button>
          <template #tip>
            <div class="el-upload__tip text-red">
              limit 1 file, new file will cover the old file
            </div>
          </template>
        </el-upload>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="store.dispatch('ONSUBMIT', { method: 'update'})">修改</el-button>
        <el-button @click="store.commit('GO_LIST')">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup>
import { useStore } from 'vuex'
import { ref, watch } from 'vue'
import { onBeforeRouteLeave } from 'vue-router'
const store = useStore()

const birthday = ref(store.state.user.birthday)
watch(birthday, (val) => {
  store.commit('BIRTHDAY_FORMAT', { birthday: val })
}, { deep: true })

const hobbies = ref(store.state.user.hobbies.split(','))
console.log(hobbies)
watch(hobbies, (val) => {
  store.commit('HOBBIES_TO_STRING', { hobbies: val })
}, { deep: true })
const handleChange = (file) => {
  store.commit('HANDLE_CHANGE', file)
}
const handleRemove = (file) => {
  store.commit('HANDLE_REMOVE', file)
}

onBeforeRouteLeave((to, from, next) => {
  Object.keys(store.state.user).forEach((key) => (store.state.user[key] = ''))
  next()
})

store.commit('UPDATE_PAGE_TITLE', {
  name: '更新',
  img: '../assets/list.jpg'
})
</script>

<style scoped>
img{
  width: 80px;
}
</style>
