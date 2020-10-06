<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'BreweryList' }">Breweries</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'AllBeers' }">Beers</router-link>
    </div>
    <router-view />
  </div>
</template>

<script>
export default {

}
</script>

<style>
#nav {
  font-family: Arial, Helvetica, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  background-color: goldenrod;
  color:whitesmoke;
  width: 100%;
     position: absolute;
     top: 0;
     }


body.custom-background {
    background-color: #dddddd;
}

</style>