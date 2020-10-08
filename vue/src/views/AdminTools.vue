<template>
  <div class="container text-center col-xl-5 mx-auto border border-dark rounded">
    <h2>Pending requests</h2>
    <div v-for="user in pending" v-bind:key="user.id">
      <!-- Need to make sure the are work with the java object -->
      {{user.id}} || {{user.username}} || {{user.authorities[0].name}} {{breweryId}}
      <router-link class="navlink" v-on:click="approve">Approve</router-link>
      <router-link class="navlink" v-on:click="decline">Decline</router-link>
    </div>
    <h2>Processed requests</h2>
    <div v-for="user in processed" v-bind:key="user.id">
      {{user.id}} || {{user.username}} || {{user.authorities[0].name}} {{breweryId}}
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pending: [],
      processed: []
    }
  },
  created() {

  },
  methods: {
    approve() {

    },
    decline() {

    }
  }
};
</script>

<style>
</style>