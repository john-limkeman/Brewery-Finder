<template>
  <div id="app">
    <div id="nav" class="navbar navbar-expand-lg navbar-dark py-lg-2 navbar-fixed-top">
      <div>
        <router-link class="navlink" v-bind:to="{ name: 'home' }">Home</router-link
        >&nbsp;|&nbsp;
        <router-link class="navlink"
          v-bind:to="{ name: 'UserPage' }"
          >My page</router-link
        >&nbsp;|&nbsp;
        <router-link class="navlink" v-bind:to="{ name: 'BreweryList' }">Breweries</router-link
        >&nbsp;|&nbsp;
        <router-link class="navlink" v-bind:to="{ name: 'AllBeers' }">Beers</router-link>
      </div>
      <div>
        <router-link class="navlink"
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout</router-link
        >
        <router-link class="navlink" v-else v-bind:to="{ name: 'login' }">Login</router-link
        >&nbsp;|&nbsp;
      </div>
    </div>
    <router-view />
  </div>
</template>

<script>
export default {};
</script>

<style>
#nav {
  display: flex;
  justify-content: space-between;
  font-family: Arial, Helvetica, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  background-color: goldenrod;
  color: whitesmoke;
  width: 100%;
  position: absolute;
  top: 0;
  font-size: 16pt;
}
.navlink {
  color: black;
}
body {
  padding-top: 50px;
}
body.custom-background {
  background-color: #dddddd;
}
</style>