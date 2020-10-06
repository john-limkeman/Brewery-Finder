<template>
  <div id="beerlist" class="contaner text-center col-xl-5 mx-auto border border-dark rounded">
    <h2>Breweries</h2>
    <div v-for="brewery in breweries" v-bind:key="brewery.id" class='brewery'>
        <img v-bind:src='brewery.imgUrl' width="180px" height="auto"/>
      <h3>
        <router-link v-bind:to="{ name: 'BreweryBeers', params: {id:brewery.id} }" class='brewery-name'>
         
          {{brewery.name}}
          
          </router-link>
      </h3>
    </div>
    <button id="addBreweryBtn" v-on:click="addBrewery">Add a brewery</button>
  </div>
</template>

<script>
import BreweryService from "@/services/BreweryService.js";

export default {
  name: "BreweryList",
  data() {
    return {
      breweries: [],
    };
  },
  components: {},
  created() {
    BreweryService.getBreweryList().then((response) => {
      this.breweries = response.data;
    });
  },
  methods: {
    addBrewery() {
      this.$router.push("/brewery/add")
    }
  },
};
</script>

<style>
.container {
display: flex;
flex-direction: column;
  border: 1px, solid, black;
  background-color: wheat;
  width: 70%;
  position: fixed;
  top: 25px;
}
#beerlist {
  background-color: wheat;
}

div > img {
  max-width: 100%;
  max-height: 100%;
}
.brewery{
    display: flex;
    align-items: center;
    margin: 15px;
}
h2{
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    text-align: center;
    font-weight: bold;
}
.brewery-name{
    color:black;
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