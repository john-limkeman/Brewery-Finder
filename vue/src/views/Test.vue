<template>
  <div  class="container text-center col-xl-5 mx-auto border border-dark rounded">
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
    }
}
</script>

<style>

</style>