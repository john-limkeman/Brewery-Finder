<template>
  <div class='container text-center col-xl-12 mx-auto rounded'>
      <h2>The secret Brewer Hangout</h2>
      <div id='brewerInsider' v-if='isRole() == "BREWER"' >
          <h3>Im a brewer!</h3>

      </div>

      <div id='brewerOutsider' v-if='isRole() == "USER"'>
          <h3>I'm not a brewer :( </h3>
          <p>Looking to join our community of Denver Breweries? Submit this form and our Admin will be in touch!</p>
    <div class="breweryFormComponent">
    <form id="newBreweryForm" v-if='vis'>
      <label for="name">Brewery name</label>
      <input
        v-model="newBrewery.name"
        type="text"
        name="name"
        placeholder="Brewery name"
      />
      <br />
      <label for="address">Address</label>
      <input
        v-model="newBrewery.address"
        type="text"
        name="address"
        placeholder="Address"
      />
      <br />
      <label for="description">Description</label>
      <input
        v-model="newBrewery.description"
        type="text"
        name="description"
        placeholder="Description"
      />
      <br />
      <label for="image">Image url</label>
      <input
        v-model="newBrewery.image"
        type="text"
        name="image"
        placeholder="Image url"
      />
      <br />
      <label for="brewery_url">Brewery url</label>
      <input
        v-model="newBrewery.brewery_url"
        type="text"
        name="brewery_url"
        placeholder="Brewery url"
      />
      <br />
      <label for="phone">Phone number</label>
      <input
        v-model="newBrewery.phone"
        type="text"
        name="phone"
        placeholder="Phone number"
      />
      <br />
      <label for="hours">Hours</label>
      <input
        v-model="newBrewery.hours"
        type="text"
        name="hours"
        placeholder="Hours"
      />
      <br />
      <label for="active">Active</label>
      <input
        v-model="newBrewery.active"
        type="checkbox"
        name="active"
        placeholder="Active"
      />
      <br />
      <button
        v-on:click="SendRequest"
      >
        Request Brewery
      </button>
      <button v-on:click="CancelForm">Cancel</button>
      <br />
    </form>
  </div>
       <div v-if='!vis'>
         <h3>Thanks for submitting you request!</h3>
         <p>Our team will review your request and will be reaching out shortly.</p>
         <p class='navlink' v-on:click='ResetForm'>Have another Brewery to add?</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
    data(){
        return{
          newBrewery : {
          
          },
          vis: true,
        }
    },
    methods:{
         isRole(){
     
        if (this.$store.state.user.authorities[0].name == 'ROLE_BREWER' || this.$store.state.user.authorities[0].name == 'ROLE_ADMIN') {
          return "BREWER";
        }
         else if (this.$store.state.user.authorities[0].name == 'ROLE_ADMIN') {
        return "ADMIN";
      } else if (this.$store.state.user.authorities[0].name == 'ROLE_USER'){
        return "USER";
      }
    },
     LoggedIn(){
            if(!this.$store.state.logIn){
            this.$router.push({name: 'login'})
            }
        },
        CancelForm(){
            this.newBrewery = {};
            this.$router.push('/');
        },
        SendRequest(){
            this.newBrewery.brewerUsername = this.$store.state.user.username;
            this.newBrewery.UserId = this.$store.state.user.username;
            this.newBrewery.processed = false;
            
            
            this.vis = false;
        },
        ResetForm(){
          this.vis = true;
          this.newBrewery = {}
        }
    },
    components:{
    },
    created(){
      this.vis = true;
      this.newBrewery = {}
    }
}
</script>

<style>

</style>
