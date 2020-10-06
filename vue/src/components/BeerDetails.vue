<template>
  <div>
      <h2>{{beer.name}} <span> {{beer.rating}} </span></h2> 
      <h4 v-bind='getBrewery()'>
          {{brewery.name}} 
      </h4>
      <!-- <img src='{{beer.imgUrl}}'/> -->
      <ul>
          <li>
              {{beer.type}}
          </li>
          <li>
              ABV : {{beer.abv}}
          </li>
          <li>
              IBU : {{beer.ibu}}
          </li>
          <li>
               {{this.setStatus}}
          </li>
      </ul>
      <p> {{beer.description}} </p>
  </div>
</template>

<script>
import breweryServices from "../services/BreweryService.js"
export default {
    data() {
        return {
            beer: {},
            brewery: '',

        }
    },
    computed: {
        setStatus(){
            if (this.beer.current){
                return "This beer is currently on tap!";
                
            } else {
                return "This beer is currently not on tap.";
            }
        }
    },
    methods : {
        getBrewery(){
            breweryServices.getBreweryById(this.beer.breweryId).then((response) => {
                this.brewery = response.data;
            })

        }
    },
    created() {
        breweryServices.getBeerById(this.$route.params.id).then((response) => {
            this.beer = response.data;
            console.log(this.beer.breweryId)
        })
        
    }
}
</script>

<style>


</style>