<template>
  <div>
    <div id="BrewBeerList">
      <h4>{{ brewery.name }} Beers</h4>
      <div v-for="beer in beers" v-bind:key="beer.id">
        {{ beer.name }}
      </div>
    </div>
  </div>
</template>

<script>
import BreweryService from "@/services/BreweryService.js";
export default {
  data() {
    return {
      beers: [],
      brewery: {},
    };
  },
  computed: {},
  methods: {
    getBeers() {
      let mybeers = [];
      BreweryService.getBeerByBrewery(this.brewery.id).then((response) => {
        for (let i = 0; i < response.data.length; i++) {
          mybeers[i] = response.data[i];
        }
      })
      return mybeers;
    },
  },
  created() {
    BreweryService.getBreweryByBrewer(this.$store.state.user.id).then(
      (response) => {
        this.brewery = response.data;
        BreweryService.getBeerByBrewery(this.brewery.id).then((response) => {
          this.beers = response.data
      })
      });
  },
};
</script>

<style>
</style>