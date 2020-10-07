<template>
  <div class = "beerForm"> 
      <form id="addBeerForm" v-on:submit="saveBeer()">
          <label for="name">Beer Name</label>
            <input
                v-model="this.newBeer.name"
                type="text"
                name="name"
                placeholder = "Beer name"
            />
            <br />
            <label for ="type">Type</label>
                <input
                v-model="this.newBeer.type"
                type="text"
                name="type"
                placeholder="Type"
            />
            <br />
            <label for ="description">Description</label>
                <input
                v-model="this.newBeer.description"
                type="text"
                name="description"
                placeholder="Beer description"
            />
             
            <br/>
            <label for ="abv">abv</label>
                <input
                v-model="this.newBeer.abv"
                type="text"
                name="abv"
                placeholder="abv"
            />
          
             <br />
             
             <label for ="ibu">ibu</label>
                <input
                v-model="this.newBeer.ibu"
                type="text"
                name="ibu"
                placeholder="ibu"
            />
             <br />
             <label for ="image">Image URL</label>
                <input
                v-model="this.newBeer.imgUrl"
                type="text"
                name="active"
                placeholder="Active"
            />
             <br />
             <label for ="Current">Available</label>
                <input
                v-model="this.newBeer.current"
                type="checkbox"
                name="description"
                placeholder="Beer description"
            />
             <br />


      </form>
  </div>
</template>

<script>
import BreweryService from "@/services/BreweryService.js"

export default {
    data(){
        return{
            newBeer: {},

        };
    },
    created() {
    BreweryService.getBreweryById(this.$route.params.id).then((response) => {
      this.newBeer.breweryId = response.data.id;
    });
  },
  methods : {
      saveBeer() {
      BreweryService.addBeer(this.newBeer);
      this.$router.push({ name: "BreweryBeers" });
    },

  }

}
</script>

<style>

</style>