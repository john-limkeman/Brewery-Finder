<template>
  <div
    id="addBrewery"
    class="contaner col-xl-5 mx-auto border border-dark rounded"
  >
    <h2 class="text-center">Add a Brewery</h2>
    <breweryForm />
    
  </div>
</template>

<script>
import breweryForm from "../components/BreweryFrom";
import breweryService from "../services/BreweryService";
export default {
  data() {
    return {
      newBrewery: {},
    };
  },
  components: {
    breweryForm,
  },
  methods: {
    addBrewery() {
      breweryService.addBrewery(this.newBrewery);
      this.$router.push({ name: "BreweryList" });
    },
    
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
  margin-top: 50px;
}
#newBreweryForm {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}
div > button, div > input {
  width: 100px;
  align-items: center;
}
</style>