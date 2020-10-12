<template>
  <div class= 'container text-center col-xl-12 mx-auto rounded'>
      <h4>Are you sure you wish to delete {{beer.name}}?</h4>
      <button class="btn btn-danger" v-on:click='DeleteBeer(beer)'>Yes</button>
        <button class="btn btn-primary" v-on:click='Cancel'>Cancel</button>
  </div>
</template>

<script>
import BreweryService from '../services/BreweryService'
export default {
    data(){
        return{
            beer : {}
        }
    },
    methods: {
        DeleteBeer(beer){
            BreweryService.deleteBeer(beer.id).then(
                () => {
            window.alert(`${beer.name} has been deleted!`)
            this.$router.push({name : 'BrewerTools'})
            }
            )},
        Cancel(){
            this.$router.push({name : 'BrewerTools'})
        }
    },
    created(){
        BreweryService.getBeerById(this.$route.params.beerId).then(
            (response) => {
                this.beer = response.data;
            }
        )
    }
}
</script>

<style>

</style>