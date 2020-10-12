<template>
  <div class="container text-center col-xl-5 mx-auto border border-dark rounded">
    <h2>Hello {{user.username}}</h2>
    <h2>Favorite Breweries</h2>
    <div>
      <div v-for="brewery in breweries" v-bind:key="brewery.id" class="brewery">
      <img v-bind:src="brewery.image" width="180px" height="auto" />
      <h3>
        <router-link
          v-bind:to="{ name: 'BreweryBeers', params: { id: brewery.id } }"
          class="brewery-name"
        >
          {{ brewery.name }}
        </router-link>
      </h3>
    </div>
    </div>
    <h2>Reviews</h2>
    <div v-for="card in reviews" v-bind:key="card.id">
      <reviewCard v-bind:chosen='card'> </reviewCard> 
    </div>
  </div>
</template>

<script>
import breweryService from "../services/BreweryService.js"
import reviewCard from "../components/ReviewCard.vue"
import BreweryService from '../services/BreweryService.js';
export default {
  data() {
    return {
      user: this.$store.state.user,
      reviews: [],
      breweries: []
    }
  },
  components: {
    reviewCard
  },
  created() {
    breweryService.getReviewByUser(this.user.id).then((response) => {
      this.reviews = response.data;
      BreweryService.getFavoritesByUser(this.user.id).then(
        (response) => {
          let results = response.data;
          results.forEach((result) => {
            BreweryService.getBreweryById(result.brewery_id).then(
              (response) => {
                let brewery = response.data;
                this.breweries.push(brewery);
              }
            )
          })
        }
      )
    });
   
  }
};
</script>

<style>
</style>