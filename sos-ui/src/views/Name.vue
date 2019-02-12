<template>
    <div class="content">
        <div class="name">
            <div>
                <label class="label" for="nickname">Enter your name</label>
            </div>
            <div>
                <input class="input" id="nickname" type="text" placeholder="My name" v-model="nickname"/>
            </div>
        </div>
        <div>
            <button class="go button" v-on:click="go">Go</button>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Name",
        data: function () {
            return {
                nickname: ''
            }
        },
        methods: {
            go() {
                this.$store.commit('setNickName', this.nickname);
                this.$router.push('/channel/' + this.$store.state.channel);
            }
        }
    }
</script>

<style scoped>
    .label {
        font-family: Arial;
        font-size: 12px;
    }

    .content {
        text-align: center;
    }

    .input {
        padding: 7px 15px 7px 15px;
        border-radius: 5px 5px 5px 5px;
        background-color: white;
        border: 1px solid black;
        font-family: Arial;
        font-size: 16px;
    }

    .button {
        padding: 7px 15px 7px 15px;
        border-radius: 15px 15px 15px 15px;
        background-color: white;
        border: 1px solid;
        font-family: Arial;
        font-size: 16px;
    }

    .go {
        border-color: blue;
        color: blue;
    }

    .name {
        margin-bottom: 30px;
    }
</style>