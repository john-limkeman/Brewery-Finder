<template>
  <div  class="container text-center col-xl-5 mx-auto border border-dark rounded">
      <router-link class="navlink" v-bind:to="{name: 'AddBrewery'}">Add a brewery</router-link>
      <pending-brewer-request />
      <pending-brewery-request />
      <processed-brewer-reuest />
      <processed-brewery-request />
  </div>
</template>

<script>
import PendingBrewerRequest from "../components/PendingBrewerReuests.vue"
import PendingBreweryRequest from "../components/PendingBreweryRequests.vue"
import ProcessedBrewerReuest from "../components/ProcessedBrewerRequests.vue"
import ProcessedBreweryRequest from "../components/ProcessedBreweryRequests.vue"
export default {
    components: {
        PendingBrewerRequest,
        PendingBreweryRequest,
        ProcessedBrewerReuest,
        ProcessedBreweryRequest
    },
}
</script>

<style>
.flexLeft {
  display: flex;
  grid-area: img;
}
.felxRight {
  display: flex;
  grid-area: text;
}
#breweryInfoTop,
#breweryInfoBottum {
  display: grid;
  grid-template-columns: 1fr, 1fr;
  grid-template-areas: "img text";
  background: wheat;
  text-align: center;
  margin: 10px;
  border-style: solid;
  border-width: 3px;
  width: 90%;
  justify-content: center;
  align-items: center;
}

#name {
  text-decoration: underline;
}
</style>