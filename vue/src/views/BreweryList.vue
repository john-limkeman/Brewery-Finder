<template>
  <div>
    <div
      id="beerlist"
      class="container text-center col-xl-5 mx-auto border border-dark rounded"
    >
      <!--text-center col-xl-5 mx-auto border border-dark rounded-->
      <h2>Breweries</h2>
      <div v-for='brewery in faves' v-bind:key='brewery.id' id='favoritedBreweryCard' class='brewery'>
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
      <div v-for="brewery in nonFaves" v-bind:key="brewery.id" class="brewery">
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
  </div>
</template>

<script>
import BreweryService from "@/services/BreweryService.js";

export default {
  name: "BreweryList",
  data() {
    return {
      breweries: [],
      faves : []
    };
  },
  computed: {
    nonFaves(){
      let nonFaves = [];
      this.breweries.forEach((brewery) => {
        if (!this.faves.includes(brewery)){
          nonFaves.push(brewery);
        }
      })
      return nonFaves;
    }
  },
  components: {},
  created() {
    BreweryService.getBreweryList().then((response) => {
      this.breweries = response.data;
       BreweryService.getFavoritesByUser(this.$store.state.user.id).then(
        (response) => {
         let favesIDs = response.data;
           favesIDs.forEach((fav) => {
            this.breweries.forEach((brewery) => {
              if (fav.brewery_id == brewery.id) {
                this.faves.push(brewery);
              }
            });
          });
        }
      );
    });
  },
};
</script>

<style>
#favoritedBreweryCard{
  background-color: rgba(255, 215, 0, 0.5);
}
div > img {
  max-width: 100%;
  max-height: 100%;
}
.brewery {
  display: flex;
  align-items: center;
  margin: 15px;
}
h2 {
  font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
  text-align: center;
  font-weight: bold;
}
.brewery-name {
  color: black;
}
body {
  padding-top: 50px;
}
img {
  margin-right: 20px;
}
#addBreweryBtn {
  width: auto;
}
</style>