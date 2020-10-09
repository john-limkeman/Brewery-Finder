<template>
  <div class="container text-center col-xl-5 mx-auto border border-dark rounded">
    <router-link class="navlink" v-bind:to="{name: 'AddBrewery'}">Add a brewery</router-link>
    <h2>Pending requests</h2>
    <div v-for="user in pending" v-bind:key="user.id">
      <!-- Need to make sure the are work with the java object -->
      {{user.id}} || {{user.userId}} || {{user.username}} || {{user.breweryId}}
      <span class="navlink" v-on:click="approve">Approve || </span>
      <span class="navlink" v-on:click="decline">Decline</span>
    </div>
    <h2>Processed requests</h2>
    <div v-for="user in processed" v-bind:key="user.id">
      {{user.id}} || {{user.userId}} || {{user.username}} || {{user.breweryId}}
    </div>
  </div>
</template>

<script>
import breweryService from "../services/BreweryService"
export default {
  data() {
    return {
      pending: [],
      processed: []
    }
  },
  created() {
    breweryService.getAllBrewerRequests().then((response) => {
      console.log(response.data)
      for (let i = 0; i < response.data.length; i++) {
        if (response.data[i].processed) {
          this.processed.push(response.data[i])
        } else {
          this.pending.push(response.data[i])
        }
      }
    })
  },
  methods: {
    addBrewery() {
      this.$router.push("/brewery/add");
    },
    approve() {

    },
    decline() {

    }
  }
};
</script>

<style>
</style>