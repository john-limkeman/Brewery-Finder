<template>
  <div
    id="addBeer"
    class="contaner col-xl-5 mx-auto border border-dark rounded"
  >
    <h2 class="text-center">Add a Beer</h2>
    <beerForm/>
    <button v-on:click="saveBeer()" type="submit">Submit</button> <br />
    
  </div>
</template>

<script>
import beerForm from "../components/BeerForm";
import BreweryService from "../services/BreweryService"
export default {
  data() {
    return {
       
     
    };
  },
  components: {
    beerForm,
  },
  methods: {
     saveBeer() {
      BreweryService.addBeer(this.newBeer);
      this.$router.push({ name: "BreweryBeers" });
    },
  },
  created() {
    BreweryService.getBreweryById(this.$route.params.id).then((response) => {
      this.newBeer.breweryId = response.data.id;
    });
  }
};
</script>

<style>
#addBrewery {
  display: flex;
  flex-direction: column;
  border: 1px, solid, black;
  background-color: wheat;
  width: 70%;
}
#newBreweryForm {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}
div > button {
  width: 100px;
  align-items: center;
}
</style>