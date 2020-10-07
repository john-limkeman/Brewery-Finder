<template>
  <div
    id="addBeer"
    class="contaner col-xl-5 mx-auto border border-dark rounded"
  >
    <h2 class="text-center">Add a Beer</h2>
    <beerForm/>
    
  </div>
</template>

<script>
import beerForm from "../components/BeerForm";

export default {
  data() {
    return {
     
    };
  },
  components: {
    beerForm,
  },
  methods: {
    
  },
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