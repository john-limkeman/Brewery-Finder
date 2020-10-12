<template>
  <div>
    <div id="BrewBeerList">
      <h4>{{ brewery.name }} Beers</h4>
      <div v-for="beer in beers" v-bind:key="beer.id">
       <p>{{ beer.name }} 
           <button class="btn btn-primary" v-on:click='getCurrentBeer(beer)' >Edit</button>
           <button class="btn btn-danger" v-on:click='deleteBeer(beer)' >Delete</button>
        </p> 
      </div>
      <button class="btn btn-primary" v-on:click='addBeer()'>Add Beer</button>
    </div>
    
<div id="BreweryList">
      <form id="newBreweryForm">
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
      <label for="active">Active</label>
      <input
        v-model="brewery.active"
        type="checkbox"
        name="active"
        placeholder="Active"
      />
      <br />
      <button class="btn btn-primary" v-on:click.prevent="updateBrewery" >Update</button>
      <button class="btn btn-primary" v-on:click.prevent="clearForm">Clear</button>
      <br />
    </form>
  

    <!-- <BreweryForm v-bind:brewid="settingBreweryId"/> -->


  </div > 

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
</style>