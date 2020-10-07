<template>
  <div class="beerForm">
    <form id="addBeerForm">
      <label for="name">Beer Name</label>
      <input
        v-model="newBeer.name"
        type="text"
        name="name"
        placeholder="Beer name"
      />
      <br />
      <label for="type">Type</label>
      <input
        v-model="newBeer.type"
        type="text"
        name="type"
        placeholder="Type"
      />
      <br />
      <label for="description">Description</label>
      <input
        v-model="newBeer.description"
        type="text"
        name="description"
        placeholder="Beer description"
      />

      <br />
      <label for="abv">abv</label>
      <input v-model="newBeer.abv" type="text" name="abv" placeholder="abv" />

      <br />

      <label for="ibu">ibu</label>
      <input v-model="newBeer.ibu" type="text" name="ibu" placeholder="ibu" />
      <br />
      <label for="image">Image URL</label>
      <input
        v-model="newBeer.imgUrl"
        type="text"
        name="active"
        placeholder="Image URL"
      />
      <br />
      <label for="Current">Available</label>
      <input
        v-model="newBeer.current"
        type="checkbox"
        name="description"
        placeholder="Beer description"
      />
      <br />

      <button v-on:click="saveBeer" v-if="this.$route.params.beerId == null">
        Add
      </button>
      <button v-on:click="updateBeer" v-else>Update</button>
      <button v-on:click="cancel">Cancel</button>
    </form>
  </div>
</template>

<script>
import breweryService from "../services/BreweryService.js";

export default {
  data() {
    return {
      newBeer: {
          breweryId: this.$route.params.id,
      },
    };
  },
  methods: {
    saveBeer() {
      breweryService.addBeer(this.newBeer);
      this.$router.push({ name: "BreweryBeers" });
    },
    updateBeer() {
      breweryService.updateBeer(this.newBeer);
      this.$router.push({ name: "BreweryBeers" });
    },
    cancel() {
      this.$router.push({ name: "BreweryBeers" });
    },
  },
  created() {
    if (this.$route.params.beerId != null) {
      breweryService.getBeerById(this.$route.params.beerId).then((response) => {
        this.newBeer = response.data;
      });
    } 
  },
};
</script>

<style>
.beerForm {
  display: flex;
  flex-direction: column;
  border: 1px, solid, black;
  background-color: wheat;
  width: 100%;
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