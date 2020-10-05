<template>
  <div>
      <h2>
      {{brewery.name}}
      </h2>
      <p>
          {{brewery.address}}
      </p>
      <p>
          {{brewery.number}}
      </p>
      <p>
          {{brewery.hours}}
      </p>
      <p>
          {{brewery.discription}}
      </p>
      <a v-bind:href="brewery.url">Web site</a> <br>
      <router-link v-bind:to="{ name: 'BreweryBeers', params: {id:brewery.id}}">View our beers</router-link>
  </div>
</template>

<script>
import BreweryService from "@/services/BreweryService.js";
export default {
    data() {
        return {
            brewery: {}
        }
    },
    created() {
        BreweryService.getBreweryById(this.$route.params.id).then((responce) => {
            this.brewery = responce.data;
        }) 
    }
}
</script>

<style>

</style>