<template>
  <div>
    <BreweryDetails />
    <h2>Beers</h2>
    <div
      class="contaner text-center col-xl-12 mx-auto rounded"
      v-for="beer in beers"
      v-bind:key="beer.id"  
    >
      <router-link
        class="navlink"
        v-bind:to="{ name: 'BeerDetails', params: { id: beer.id } }"
      >
        {{ beer.name }}
      </router-link>
    </div>
  </div>
</template>

<script>
import BreweryDetails from "@/components/BreweryDetails.vue";
import BreweryService from "@/services/BreweryService.js";
export default {
  data() {
    return {
      beers: [],
    };
  },
  components: {
    BreweryDetails,
  },
  created() {
    BreweryService.getBeerByBrewery(this.$route.params.id).then((response) => {
      this.beers = response.data;
    });
  },
};
</script>

<style>
</style>