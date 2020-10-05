<template>
  <div>
      <h2>All Beers</h2>
<div v-for='beer in beers' v-bind:key='beer.id'>
    <router-link
        v-bind:to="{ name: 'BeerDetails', params: { id: beer.id } }"
      > {{beer.name}} </router-link>
</div>
  </div>
</template>

<script>
import BreweryService from '@/services/BreweryService.js'
export default {
    data(){
        return{
            beers : []
        }
    },
    created(){
        BreweryService.getBeerList().then(
            (response) => {
                this.beers = response.data;
            }
        )
        
    }
}
</script>

<style>

</style>