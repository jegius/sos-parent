import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    nickname: null,
    channel: null,
    messages: []
  },
  mutations: {
    setNickName (state, nickname) {
      state.nickname = nickname;
    },
    setChannel (state, channel) {
      state.channel = channel;
    },
    addMessage (state, message) {
      state.messages.push(message);
    },
    clearMessages(state) {
      state.messages = [];
    }
  },
  actions: {

  }
});