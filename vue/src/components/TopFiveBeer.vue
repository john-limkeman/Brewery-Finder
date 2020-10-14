<template>
    <div>
        <H4 id="topFiveHeader">Top 5 Beers</H4>
            <div id="topFiveContainer" v-for="beer in beers" v-bind:Key="beer.id">
                <H5>{{beer.name}}</H5>
            </div>

    </div>
  
</template>

<script>
import BreweryService from "@/services/BreweryService.js"
export default {
    data(){
        return{
          beers: [],
        }
    },

    created(){
        BreweryService.getTopFiveBeers().then(
            (response) => {
                    this.beers = response.data;
              
            }
        )
    }


}
</script>

<style>
#topFiveHeader{
    text-decoration: underline;
}
</style>