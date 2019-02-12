<template>
    <div class="content">
        <div class="header">
            Channel {{$route.params.id}}
        </div>
        <div>
            <div class="messages">
                <div v-if="$store.state.messages.length">
                    <div v-for="message of $store.state.messages" class="message_wrapper">
                        <div class="text">
                            <code class="author">{{message.author}}</code>:
                            <span class="message"><code class="message_text">{{message.text}}</code></span>
                        </div>
                    </div>
                </div>
                <div v-else-if="!$store.state.messages.length" class="empty">
                    No messages
                </div>
            </div>
        </div>
        <div class="input">
            <div class="menu">
                <button class="send button" v-on:click="send" :disabled="!newMessage">Send</button>
            </div>
            <textarea class="textarea" v-model="newMessage"></textarea>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Channel",
        beforeCreate() {
            this.$store.commit('setChannel', this.$route.params.id);
            if(!this.$store.state.nickname) {
                this.$router.push('/name');
            }
        },
        data: function () {
            return {
                newMessage: ''
            };
        },
        methods: {
            send() {
                this.$store.commit('addMessage', {
                    text: this.newMessage,
                    author: this.$store.state.nickname
                });

                this.newMessage = '';
            }
        }
    }
</script>

<style scoped>
    .text {
        display: table;
    }

    .content {
        text-align: center;
    }

    .header {
        font-family: Arial;
        font-size: 16px;
    }

    .input {
        display: inline-block;
        vertical-align: top;
    }

    .message {
        display: table-cell;
        white-space: pre-line;
    }

    code {
        font-family: Arial;
        font-size: 16px;
    }

    .messages {
        display: inline-block;
        width: 360px;
        text-align: left;
        border-top: 1px solid black;
        border-bottom: 1px solid black;
        margin-top: 10px;
        margin-bottom: 10px;
    }

    .menu {
        text-align: right;
    }

    .button {
        padding: 7px 15px 7px 15px;
        border-radius: 15px 15px 15px 15px;
        background-color: white;
        border: 1px solid;
        font-family: Arial;
        font-size: 16px;
    }

    .send {
        color: blue;
        border-color: blue;
        margin-bottom: 10px;
        margin-left: 10px;
    }

    .textarea {
        width: 340px;
        height: 42px;
        border-radius: 5px 5px 5px 5px;
        background-color: white;
        border: 1px solid black;
        font-family: Arial;
        font-size: 14px;
        resize: none;
    }

    .message_wrapper {
        padding: 5px 0 5px 0;
    }

    .author {
        display: table-cell;
        font-weight: bold;
    }

    .empty {
        font-family: Arial;
        font-size: 14px;
        color: lightgray;
        text-align: center;
        padding: 10px;
    }

</style>