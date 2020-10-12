<template>
<div> 
    <H3>Brewery Events</H3>
<div v-for="event in events" v-bind:key="event.id">
    


</div>




</div>
  
</template>

<script>
import BreweryService from "@/services/BreweryService.js"
export default {
    data(){
        return{
            events: [],
        }
    },
    created () {
        BreweryService.getEventsById(this.$route.params.id).then(
            (response) => {
                this.events = response.data;
            }
        )


    }
}
</script>

<style>

</style>