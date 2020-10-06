<template>
  <div>
      <h2>{{beer.name}}</h2>
      <h4>
          {{beer.brewery_id}} <!-- need to pull from $store to get name-->
      </h4>
      <ul>
          <li>
              {{beer.type}}
          </li>
          <li>
              {{beer.abv}}
          </li>
          <li>
              {{beer.ibu}}
          </li>
          <li>
               {{this.setStatus}}
          </li>
      </ul>
  </div>
</template>

<script>
import breweryServices from "../services/BreweryService.js"
export default {
    data() {
        return {
            beer: {},
            status: ""
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
    created() {
        breweryServices.getBeerById(this.$route.params.id).then((response) => {
            this.beer = response.data;
        })
    }
}
</script>

<style>

</style>