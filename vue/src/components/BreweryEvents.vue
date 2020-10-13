<template>
<div> 
    <H3>Brewery Events</H3>
    <div id="eventCard" v-for="event in events" v-bind:key="event.event_id">
    <h3 id="eventTitle">{{event.event_title}}</h3>
    <h4 id="eventDate"> {{event.event_date}}</h4>
    <p id="description">{{event.description}}</p>
    <img id='event-picture' v-bind:src="event.picture"/>
    </div>




</div>
  
</template>

<script>
import BreweryService from "@/services/BreweryService.js"
export default {
    data(){
        return{
            events: [

            ],
            brewery: {},
        }
    },
    created () {
        BreweryService.getEventsById(this.$route.params.id).then(
            (response) => {
                this.events = response.data;
            }
        )

        BreweryService.getBreweryById(this.$route.params.id).then(
            (response) => {
                this.brewery = response.data;
                this.events.breweryId = this.$route.params.id;
            }
        )

    }
}
</script>

<style>

</style>