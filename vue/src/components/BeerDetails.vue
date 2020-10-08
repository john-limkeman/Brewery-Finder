<template>
  <div id="beerInfo" class=" container contaner text-center col-xl-12 mx-auto rounded">
    <h2>
      {{ beer.name }} <span> {{ beer.rating }} </span>
    </h2>
    <h4 v-bind="getBrewery()">
      <router-link
        class="navlink"
        v-bind:to="{ name: 'BreweryBeers', params: { id: brewery.id } }"
      >
        {{ brewery.name }}
      </router-link>
    </h4>
    <img v-bind:src="beer.imgUrl" width="180px" height="auto" />
    <ul>
      <li>
        {{ beer.type }}
      </li>
      <li>ABV : {{ beer.abv }}</li>
      <li>IBU : {{ beer.ibu }}</li>
      <li>
        {{ this.setStatus }}
      </li>
    </ul>
    <p>{{ beer.description }}</p>
    <router-link
        class="navlink"
        v-bind:to="{ name: 'UpdateBeer', params: {id: beer.breweryId, beerId: beer.id } }"
      >
        Edit this beer
      </router-link>
    <ReviewList />
  </div>
</template>

<script>
import ReviewList from '@/components/ReviewList.vue'
import breweryServices from "../services/BreweryService.js";
export default {
  data() {
    return {
      beer: {},
      brewery: "",
    };
  },
  computed: {
    setStatus() {
      if (this.beer.current) {
        return "This beer is currently on tap!";
      } else {
        return "This beer is currently not on tap.";
      }
    },
  },
  methods: {
    getBrewery() {
      breweryServices.getBreweryById(this.beer.breweryId).then((response) => {
        this.brewery = response.data;
      });
    },
  },
  created() {
    breweryServices.getBeerById(this.$route.params.id).then((response) => {
      this.beer = response.data;
      console.log(this.beer.breweryId);
    });
    
  },
  components: {
    ReviewList
  }
};
</script>

<style>
#beerInfo {
  background: wheat;
  text-align: center;
  padding: 50px;
  margin: 10px;
  border-style: solid;
  border-width: 3px;
  width: 60%;
  justify-content: center;
  align-items: center;
}
li {
  list-style-type: none;
}
div > img {
  margin: 10px;
}
</style>