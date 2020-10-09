<template>
  <div>
    <div id="BrewBeerList">
      <h4>{{ brewery.name }} Beers</h4>
      <div v-for="beer in beers" v-bind:key="beer.id">
       <p>{{ beer.name }} 
           <button v-on:click='getCurrentBeer(beer)' >Edit</button>
           <button v-on:click='deleteBeer(beer)' >Delete</button>
        </p> 
      </div>
      <button v-on:click='addBeer()'>Add Beer</button>
    </div>
    
  </div>
</template>

<script>

import BreweryService from "@/services/BreweryService.js";
export default {
  data() {
    return {
    currentBeer : {},
      beers: [],
      brewery: {},
    };
  },
  computed: {},
  methods: {
    getCurrentBeer(beer){
        this.currentBeer = beer;
        this.$router.push({name: 'UpdateBeer', params : {id: this.brewery.id , beerId : this.currentBeer.id}})
    },
    addBeer(){
        this.currentBeer = {};
        this.$router.push({name: 'AddBeer', params : {id: this.brewery.id}})
    },
    deleteBeer(beer){
        this.currentBeer = beer;
        this.$router.push({name : 'ConfirmDelete', params : {beerId : this.currentBeer.id}})
        
    }
  },
  created() {
    BreweryService.getBreweryByBrewer(this.$store.state.user.id).then(
      (response) => {
        this.brewery = response.data;
        BreweryService.getBeerByBrewery(this.brewery.id).then((response) => {
          this.beers = response.data
          this.currentBeer = {}
      })
      });
  },
  components: {
    
  }
};
</script>

<style>
</style>