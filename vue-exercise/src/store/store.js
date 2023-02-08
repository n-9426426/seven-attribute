// import { useRouter } from 'vue-router'
import router from '../router/router'
import { createStore } from 'vuex'
import {
  BIRTHDAY_FORMAT,
  HOBBIES_TO_ARRAY,
  HOBBIES_TO_STRING,
  UPDATE_PAGE_TITLE,
  GO_LIST,
  GO_ADD,
  GO_UPDATE,
  ONSUBMIT,
  HANDLE_CHANGE,
  HANDLE_REMOVE
} from './mutation-types'

const axios = require('axios')
axios.defaults.baseURL = 'http://192.168.140.16/'
const store = createStore({
  state: {
    user: {
      id: 0,
      name: '',
      age: '',
      birthday: '',
      hobbies: '',
      sex: '',
      photo: ''
    }
  },
  getters: {
    [HOBBIES_TO_ARRAY]: (state) => {
      return state.user.hobbies.split(',')
    }
  },
  mutations: {
    [BIRTHDAY_FORMAT] (state, payload) {
      const date = new Date(payload.birthday)
      const y = date.getFullYear()
      let m = date.getMonth() + 1
      m = m < 10 ? ('0' + m) : m
      let d = date.getDate()
      d = d < 10 ? ('0' + d) : d
      const birthday = y + '-' + m + '-' + d
      state.user.birthday = birthday
    },
    [HOBBIES_TO_STRING] (state, payload) {
      state.user.hobbies = payload.hobbies.join(',')
    },
    [HANDLE_CHANGE] (state, file) {
      state.fileList = []
      state.fileList.push(file)
    },
    [HANDLE_REMOVE] (state, file) {
      state.fileList = file
    },
    [UPDATE_PAGE_TITLE] (state, payload) {
      document.title = payload.name
      const link = document.querySelector("link[rel*='icon']") || document.createElement('link')
      link.type = 'image/x-icon'
      link.rel = 'shortcut icon'
      link.href = payload.img
      document.getElementsByTagName('head')[0].appendChild(link)
    },
    [GO_LIST] (state) {
      router.push('/list')
      Object.keys(state.user).forEach((key) => (state.user[key] = ''))
    },
    [GO_ADD] (state) {
      Object.keys(state.user).forEach((key) => (state.user[key] = ''))
      router.push('/add')
    },
    [GO_UPDATE] (state) {
      router.push('/update')
    }
  },
  actions: {
    [ONSUBMIT] ({ commit, state }, payload) {
      const params = new FormData()
      state.fileList.forEach(item => {
        params.append('photo', item.raw)
      })
      // 将输入表单数据添加到params表单中
      params.append('id', state.user.id)
      params.append('name', state.user.name)
      params.append('age', state.user.age)
      params.append('birthday', state.user.birthday)
      params.append('hobby', state.user.hobbies)
      params.append('sex', state.user.sex)
      axios({
        method: 'post',
        url: 'user/' + payload.method,
        data: params
      }).then((resp) => {
        commit('GO_LIST')
      })
    },
    [GO_UPDATE] ({ commit, state }, payload) {
      Object.keys(state.user).forEach((key) => (state.user[key] = ''))
      axios({
        method: 'post',
        url: 'user/findUserById',
        params: {
          id: payload.id
        }
      }).then((resp) => {
        state.user = resp.data
        commit('GO_UPDATE')
      })
    }
  },
  modules: {
  }
})

export default store
