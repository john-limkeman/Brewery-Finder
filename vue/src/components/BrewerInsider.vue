<template>
  <div id='brewerInsiderBox' >
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
      <!-- loop through events here -->
      <div id='BTbuttons'>
      <button class="btn btn-primary" v-on:click='addBeer()'>Add Beer</button>
      <button class='btn btn-primary' v-on:click='addEvent()'>Add Event</button>
      <button class='btn btn-primary' id='updateBreweryInformationButton' v-on:click='toggleVis()'> Update Brewery Information</button>
      </div>
    </div>
    

      <form id="updateBreweryForm" v-if='Vis'>
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
      brewery: {

      },
      Vis: false
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
    addEvent(){
      //function to add new event
    },
    toggleVis(){
      if(this.Vis == true){
        this.Vis = false;
      } else{
        this.Vis = true;
      }
    }

  },
  created() {
    
    BreweryService.getBreweryByBrewer(this.$store.state.user.id).then(
      (response) => {
        this.brewery = response.data;
    console.log(`this is the BrewerInsider component ${this.brewery.id}`)
       

    BreweryService.getBeerByBrewery(this.brewery.id).then((response) => {
        this.beers = response.data
        this.currentBeer = {}
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
  align-items: start;
  justify-content: space-between;
  height: 100%;
}
#BrewBeerList{
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-evenly;
  width: 30%;
  height: 700px;
  border-right: black 5px solid;
  margin-right: 5px;
}
#beerSideBar{

  display: flex;
  justify-content: start;
  align-items: center;
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