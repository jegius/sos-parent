<template>
    <div class="content">
        <div class="option">
            <button class="new button" v-on:click="createChannel">Make new channel</button>
        </div>
        <div class="option">
            <button class="connect button" v-on:click="$router.push('/connect')">Connect to channel</button>
        </div>
    </div>
</template>

<script>
export default {
    name: 'Start',
    methods: {
        createChannel: function () {
            this.$store.commit('setChannel', 42);
            this.$router.push('/name');
        }
    }
}
</script>

<style scoped>
    .content {
        text-align: center;
    }

    .option {
        margin-bottom: 30px;
    }

    .button {
        padding: 7px 15px 7px 15px;
        border-radius: 15px 15px 15px 15px;
        background-color: white;
        border: 1px solid;
        font-family: Arial;
        font-size: 16px;
    }

    .new {
        border-color: green;
        color: green;
    }

    .connect {
        border-color: blue;
        color: blue;
    }
</style>