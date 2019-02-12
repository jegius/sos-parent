<template>
    <div class="content">
        <div class="channel">
            <div>
                <label class="label" for="channel">Enter channel number</label>
            </div>
            <div>
                <input class="input" type="text" placeholder="0000" id="channel" v-model="channel"/>
            </div>
        </div>
        <div>
            <button class="connect button" v-on:click="connect">Connect</button>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Connect",
        data: function () {
            return {
                channel: null
            }
        },
        methods: {
            connect: function () {
                this.$store.commit('setChannel', this.channel);
                this.$router.push('/name');
            }
        }
    }
</script>

<style scoped>
    .content {
        text-align: center;
    }

    .label {
        font-family: Arial;
        font-size: 12px;
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

    .connect {
        border-color: blue;
        color: blue;
    }

    .channel {
        margin-bottom: 30px;
    }

</style>