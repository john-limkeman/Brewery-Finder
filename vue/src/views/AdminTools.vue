<template>
  <div id="adminTools" class="container text-center col-xl-10 mx-auto border border-dark rounded">
    <div class="adminBtn">
      <button class="btn btn-primary adminBtnBtn"  v-on:click="addBrewery">Add a brewery</button>
      <button class="btn btn-primary adminBtnBtn" v-on:click="viewAllUsers">View all users</button>
    </div>
      <pending-brewer-request class="pendingBrewer" />
      <pending-brewery-request class="pendingBrewery" />
      <processed-brewer-reuest class="processedBrewer" />
      <processed-brewery-request class="processedBrewery" />
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
    methods: {
      addBrewery() {
        this.$router.push({name: 'AddBrewery'})
      },
      viewAllUsers() {
        this.$router.push({name: 'AllUsers'})
      }
    }
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
#adminTools {
  display: grid;
  grid-template-columns: 1fr 3fr;
  grid-template-areas:
  "adminBtn adminBtn"
  "pendingBrewer pendingBrewery"
  "processedBrewer processedBrewery"
}
.adminBtnBtn {
  width: 150px;
  margin: 25px;
}
.adminBtn {
  grid-area: adminBtn;
  display: flex;
  justify-content: center;
}
.pendingBrewery{
  grid-area: pendingBrewery;
}
.pendingBrewer {
  grid-area: pendingBrewer;
}
.processedBrewer {
  grid-area: processedBrewer;
}
.processedBrewery {
  grid-area: processedBrewery;
}
#name {
  text-decoration: underline;
}
</style>