<template>
  <div>
    HELLO
  </div>
</template>

<script>
export default {
  created() {
    console.log(this.$store.state.user)
  }
};
</script>

<style>
</style>