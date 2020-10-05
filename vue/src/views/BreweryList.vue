<template>
  <div class="container">
    <h2>Breweries</h2>
    <div v-for="brewery in breweries" v-bind:key="brewery.id">
      <h3>
        <router-link v-bind:to="{ name: 'breweryDetails', params: {id:brewery.id} }">{{
          brewery.name
        }}</router-link>
      </h3>
    </div>
  </div>
</template>

<script>
import BreweryService from "@/services/BreweryService.js";

export default {
  name: "BreweryList",
  data() {
    return {
      breweries: [],
    };
  },
  components: {},
  created() {
    BreweryService.getBreweryList().then((response) => {
      this.breweries = response.data;
    });
  },
};
</script>

<style>
.container {
  border: 1px, solid, black;
  background-color: lightblue;
  width: 30%;
}
</style>