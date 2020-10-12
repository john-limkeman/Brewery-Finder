<template>
  <div
    id="breweryInfo"
    class="container contaner text-center col-xl-12 mx-auto rounded"
  >
    <div class="flexLeft">
      <img v-bind:src="brewery.image" width="180px" height="auto" />
    </div>
    <div class="flexRight">
      <h2 id="name">
        {{ brewery.name }}
      </h2>
      <p id="address">
        {{ brewery.address }}
      </p>
      <p id="phone">
        {{ brewery.phone }}
      </p>
      <p id="hours">
        {{ brewery.hours }}
      </p>
      <p id="description">
        {{ brewery.description }}
      </p>
      <a class="navlink" v-bind:href="brewery.brewery_url">Web site</a> <br />
      <br />
      <a target="blank" class="navlink" v-bind:href="directions + brewery.address">Directions</a>
      <router-link
        class="navlink"
        v-bind:to="{ name: 'UpdateBrewery', params: { id: brewery.id } }"
        v-if="isAdmin()" 
      >
        Update Brewery
      </router-link>
      <br />
      <router-link
        class="navlink"
        v-bind:to="{ name: 'AddBeer', params: { id: brewery.id } }"
        v-if="isAdmin()" 
      >
        Add Beer
      </router-link>
      <br />
      <span class="navlink" v-if="brewery.brewerId == ''" v-on:click="brewerRequest">
        Claim this brewery
      </span>
    </div>
  </div>
</template>

<script>
import BreweryService from "@/services/BreweryService.js";
export default {
  data() {
    return {
      brewery: {},
      directions: "https://www.google.com/maps/place/"
    };
  },
  created() {
    BreweryService.getBreweryById(this.$route.params.id).then((response) => {
      this.brewery = response.data;
    });
  },
  methods: {
    brewerRequest() {
      BreweryService.brewerRequest(
        this.$route.params.id,
        this.$store.state.user
      ).then((response) => {
        if (response.status === 200) {
          alert("Request Sent");
        }
      });
    },
    isAdmin() {
      if (this.$store.state.logIn) {
        if (this.$store.state.user.authorities[0].name == 'ROLE_ADMIN') {
          return true;
        }
      } else {
        return false;
      }
    },
  },
};
</script>

<style>
.flexLeft {
  display: flex;
  grid-area: img;
}
.felxRight {
  display: flex;
  grid-area: text;
}
#breweryInfo {
  display: grid;
  grid-template-columns: 1fr, 1fr;
  grid-template-areas: "img text";
  background: wheat;
  text-align: center;
  padding: 50px;
  margin: 10px;
  border-style: solid;
  border-width: 3px;
  width: 60%;
  justify-content: center;
  align-items: center;
}

#name {
  text-decoration: underline;
}
</style>