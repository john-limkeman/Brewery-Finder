<template>
  <div id='brewerInsiderBox' class='container text-center col-xl-12 mx-auto border border-dark rounded' >
    <div id="BrewBeerList">
      <h2>{{ brewery.name }}</h2>
      <h4> Beers </h4>
      <div v-for="beer in beers" v-bind:key="beer.id" id='beerSideBar'>
      
       <p>{{ beer.name }} &nbsp;</p>
        
         <p>
           <button class="btn btn-primary" v-on:click='getCurrentBeer(beer)' >Edit</button>
           <button class="btn btn-danger" v-on:click='deleteBeer(beer)' >Delete</button>
           </p>
      
      </div>
      <h4>Events</h4>
            <div v-for="event in events" v-bind:key="event.id" id='beerSideBar'>
               <p>{{ beer.name }} &nbsp;</p>
        
         <p>
           <button class="btn btn-primary" v-on:click='getCurrentEvent(event)' >Edit</button>
           <button class="btn btn-danger" v-on:click='deleteEvent(event)' >Delete</button>
           </p>
           </div>
      <div id='BTbuttons'>
      <button class="btn btn-primary" v-on:click='addBeer()'>Add Beer</button>
      <button class='btn btn-primary' v-on:click='toggleVisEvent()'>Add Event</button>
      <button class='btn btn-primary' id='updateBreweryInformationButton' v-on:click='toggleVisUpdate()'> Update Brewery Information</button>
      </div>
    </div>
    

      <form id="updateBreweryForm" v-if='VisUpdate'>
      <label for="name">Brewery name</label>
      <input
        v-model="brewery.name"
        type="text"
        name="name"
        placeholder="Brewery name"
      />
      <br />
      <label for="address">Address</label>
      <input
        v-model="brewery.address"
        type="text"
        name="address"
        placeholder="Address"
      />
      <br />
      <label for="description">Description</label>
      <input
        v-model="brewery.description"
        type="text"
        name="description"
        placeholder="Description"
      />
      <br />
      <label for="image">Image url</label>
      <input
        v-model="brewery.image"
        type="text"
        name="image"
        placeholder="Image url"
      />
      <br />
      <label for="brewery_url">Brewery url</label>
      <input
        v-model="brewery.brewery_url"
        type="text"
        name="brewery_url"
        placeholder="Brewery url"
      />
      <br />
      <label for="phone">Phone number</label>
      <input
        v-model="brewery.phone"
        type="text"
        name="phone"
        placeholder="Phone number"
      />
      <br />
      <label for="hours">Hours</label>
      <input
        v-model="brewery.hours"
        type="text"
        name="hours"
        placeholder="Hours"
      />
      <br />
      <p>Active: <span>
      <input
        v-model="brewery.active"
        type="checkbox"
        name="active"
        placeholder="Active"
      /></span></p>
      <br />
      <button class="btn btn-primary" v-on:click.prevent="updateBrewery" >Update</button>
      <button class="btn btn-primary" v-on:click.prevent="clearForm">Clear</button>
      <br />
    </form>

      <form id="addEventForm" v-else-if='VisEvent'>
        <label for="event_title">Event Title</label>
            <input
             v-model="newEvent.event_title"
             type="text"
             name="title"
             placeholder="Event Title"
             />
        <label for="event_date">Date</label>
            <input
             v-model="newEvent.event_date"
             type="text"
             name="date"
             placeholder="Event Date"
             />
         <label for="description">Description</label>
            <input
             v-model="newEvent.description"
             type="text"
             name="description"
             placeholder="Event Description"
             />
         <label for="picture">Image URL</label>
            <input
             v-model="newEvent.picture"
             type="text"
             name="active"
             placeholder="Event Picture"
             />
             <br>
            <button class="btn btn-primary" v-on:click="addEvent">Add</button>
            <button class="btn btn-primary" v-on:click="updateEvent">Update</button>
            <button class="btn btn-primary" v-on:click="cancel">Cancel</button>
      </form>
    <img v-else v-bind:src='this.brewery.image'/>

    <!-- <BreweryForm v-bind:brewid="settingBreweryId"/> -->


  </div>
</template>

<script>
// import BreweryForm from "@/components/BreweryFrom.vue";
import BreweryService from "@/services/BreweryService.js";
export default {
  data() {
    return {
    currentBeer : {},
      beers: [],
      brewery: {},
      VisUpdate: false,
      events: [],
      currentEvent: {},
    };
  },
  computed: {
    settingBreweryId(){
      let id = this.brewery.id;
      return id;
    }
  },
  methods: {
    getCurrentBeer(beer){
        this.currentBeer = beer;
        this.$router.push({name: 'UpdateBeer', params : {id: this.brewery.id , beerId : this.currentBeer.id}})
    },
    addBeer(){
        this.currentBeer = {};
        this.$router.push({name: 'AddBeer', params : {id: this.brewery.id}})
    },
    deleteBeer(beer){
        this.currentBeer = beer;
        this.$router.push({name : 'ConfirmDelete', params : {beerId : this.currentBeer.id}})
        
    },
      clearForm() {
      this.brewery = {};
    },
        updateBrewery() {
      BreweryService.updateBrewery(this.brewery);
      this.$router.push({ name: "BreweryBeers", params: {id : this.brewery.id} });
    },
    getCurrentEvent(event){
      this.currentEvent = event;
      //to acquire current event and display edit form
    },
    deleteEvent(event){
      this.currentEvent = event;
      //to delete event from DB
    },
    addEvent(){
      //function to add new event
    },
    toggleVisUpdate(){
      if(this.VisUpdate == true){
        this.VisUpdate = false;
      } else{
        this.VisUpdate = true;
      }
    },
  toggleVisEvent(){
      if(this.VisEvent == true){
        this.VisEvent = false;
      } else{
        this.VisUpdate = false;
        this.VisEvent = true;
      }
    },
  },
  created() {
    
    BreweryService.getBreweryByBrewer(this.$store.state.user.id).then(
      (response) => {
        this.brewery = response.data;
          BreweryService.getBeerByBrewery(this.brewery.id).then((response) => {
            this.beers = response.data
             this.currentBeer = {}
             BreweryService.getEventsById(this.brewery.id).then(
          (response) => {
            this.events = response.data;
          }

             )
      })
      });
  },
  components: {
    // BreweryForm,
    
  }
};
</script>

<style>
#brewerInsiderBox{
  display: flex;
  flex-direction: row;
  align-items: flex-start;
  justify-content: space-between;
  height: 100%;
}
#BrewBeerList{
  display: flex;
  flex-direction: column;
  align-items: space-between;
  width: 30%;
  height: 700px;
  border-right: black 5px solid;
  margin-right: 5px;
}
#beerSideBar{
  font-weight: bold;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding-right: 10px;
}
#updateBreweryForm{
  display:flex;
  flex-direction: column;
  width: 70%;
}
#updateBreweryForm label{
  text-align: left;
  margin-left: 50px;
}
#updateBreweryForm p{
    text-align: left;
  margin-left: 50px
}
#updateBreweryForm input{
  margin-left: 50px;
  width: 50%
}
#brewerInsiderBox button{
  margin: 5px;
}
#brewerInsiderBox img{
  position: absolute;
  left: 50%;
  right: 50%;
  height: 500px;
  width: auto;
}
#updateBreweryInformationButton{
  width: auto;
}
</style>