<template>
  <div class = "beerForm"> 
      <form id="addBeerForm">
          <label for="name">Beer Name</label>
            <input
                v-model="newBeer.name"
                type="text"
                name="name"
                placeholder="Beer name"
            />
            <br />
            <label for ="type">Type</label>
                <input
                v-model="newBeer.type"
                type="text"
                name="type"
                placeholder="Type"
            />
            <br />
            <label for ="description">Description</label>
                <input
                v-model="newBeer.description"
                type="text"
                name="description"
                placeholder="Beer description"
            />
             
            <br/>
            <label for ="abv">abv</label>
                <input
                v-model="newBeer.abv"
                type="text"
                name="abv"
                placeholder="abv"
            />
          
             <br />
             
             <label for ="ibu">ibu</label>
                <input
                v-model="newBeer.ibu"
                type="text"
                name="ibu"
                placeholder="ibu"
            />
             <br />
             <label for ="image">Image URL</label>
                <input
                v-model="newBeer.imgUrl"
                type="text"
                name="active"
                placeholder="Active"
            />
             <br />
             <label for ="Current">Available</label>
                <input
                v-model="newBeer.current"
                type="checkbox"
                name="description"
                placeholder="Beer description"
            />
             <br />

            <button v-on:click="saveBeer" >Submit</button>

      </form>
  </div>
</template>

<script>
import BreweryService from '../services/BreweryService.js'

export default {
    data(){
        return{
            newBeer: {},

        };
    },
    methods: {
     saveBeer() {
         console.log(this.newBeer);
      BreweryService.addBeer(this.newBeer);
      this.$router.push({ name: "BreweryBeers" });
    },
  },
  created() {
    BreweryService.getBreweryById(this.$route.params.id).then((response) => {
      this.newBeer.breweryId = response.data.id;
    });
  }


}
</script>

<style>
.beerForm {
  display: flex;
  flex-direction: column;
  border: 1px, solid, black;
  background-color: wheat;
  width: 70%;
}
#addBeerForm {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}
div > form > button {
  width: 80px;
  align-items: center;
}
</style>