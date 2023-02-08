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
      <el-form-item label="上传文件">
        <el-upload
          ref="upload"
          class="upload-demo"
          action="http://aozhang.chn/user/add"
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
        <el-button type="primary" @click="store.dispatch('ONSUBMIT', { method: 'add'})">添加</el-button>
        <el-button @click="store.commit('GO_LIST')">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup>
import { ref, watch } from 'vue'
import { useStore } from 'vuex'
const store = useStore()

const birthday = ref('')
watch(birthday, (val) => {
  store.commit('BIRTHDAY_FORMAT', { birthday: val })
}, { deep: true })

const hobbies = ref([])
watch(hobbies, (val) => {
  store.commit('HOBBIES_TO_STRING', { hobbies: val })
}, { deep: true })
const handleChange = (file) => {
  store.commit('HANDLE_CHANGE', file)
}

const handleRemove = (file) => {
  store.commit('HANDLE_REMOVE', file)
}

store.commit('UPDATE_PAGE_TITLE', {
  name: '添加',
  img: '../assets/add.jpg'
})
</script>

<style scoped>

</style>
