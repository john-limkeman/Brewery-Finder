<template>
  <div>
          <h2> Breweries </h2>
      <div v-for='brewery in breweries' v-bind:key='brewery.id'>
          {{brewery.name}}
          </div>
</div>
</template>

<script>
import BreweryService from '@/services/BreweryService.js';

export default {
    name: 'BreweryList',
    data(){
        return {
            breweries : []
        }
    },
    components : {

    },
    created(){
        BreweryService.getBreweryList().then(
            (response) => {
                this.breweries = response.data;
            }
        )
    }
}
</script>

<style>

</style>