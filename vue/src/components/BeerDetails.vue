<template>
  <div>
      <h2>{{beer.name}}</h2>
  </div>
</template>

<script>
import breweryServices from "../services/BreweryService.js"
export default {
    data() {
        return {
            beer: {}
        }
    },
    created() {
        breweryServices.getBeerById(this.$route.params.id).then((response) => {
            this.beer = response.data;
        })
    }
}
</script>

<style>

</style>