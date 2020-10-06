<template>
  <div class="breweryInfo">
      <h2 id="name">
      {{brewery.name}}
      </h2>
      <img v-bind:src='brewery.imgUrl'/>
      <p id="address">
          {{brewery.address}}
      </p>
      <p id="phone">
          {{brewery.number}}
      </p>
      <p id="hours">
          {{brewery.hours}}
      </p>
      <p id="description">
          {{brewery.description}}
      </p>
      <a v-bind:href="brewery.url">Web site</a> <br>
      <router-link v-bind:to="{ name: 'BreweryBeers', params: {id:brewery.id}}">View our beers</router-link>
  </div>
</template>

<script>
import BreweryService from "@/services/BreweryService.js";
export default {
    data() {
        return {
            brewery: {}
        }
    },
    created() {
        BreweryService.getBreweryById(this.$route.params.id).then((responce) => {
            this.brewery = responce.data;
        }) 
    }
}
</script>

<style>

.breweryInfo{

  text-align: center;
  padding: 50px;
  margin: 10px;
  border-style: solid;
}

#name{
    text-decoration: underline;
}


</style>