<template>
  <div id="app">
    <div style="margin-bottom: 50px">
      Debug:
      <div>
        {{JSON.stringify($store.state)}}
      </div>
    </div>
    <router-view/>
  </div>
</template>

<style lang="less">

</style>
