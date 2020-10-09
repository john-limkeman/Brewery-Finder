<template>
  <div
    class="container text-center col-xl-5 mx-auto border border-dark rounded"
  >
    <router-link class="navlink" v-bind:to="{ name: 'AddBrewery' }"
      >Add a brewery</router-link
    >
    <h2>Pending Brewers Requests</h2>
    <div v-for="user in pendingBrewers" v-bind:key="user.id">
      <!-- Need to make sure the are work with the java object -->
      {{ user.id }} || {{ user.userId }} || {{ user.username }} ||
      {{ user.breweryId }}
      <span class="navlink" v-on:click="approve(user)">Approve || </span>
      <span class="navlink" v-on:click="decline(user)">Decline</span>
    </div>
    <h2>Pending Brewery Requests</h2>
    <div v-for="brewery in pendingBreweries" v-bind:key="brewery.id">
      <div
        id="breweryInfo"
        class="container contaner text-center col-xl-12 mx-auto rounded"
      >
        <p>Request Id || User Id || User Name</p>
        <p>
          {{ brewery.id }} || {{ brewery.userId }} ||
          {{ brewery.brewerUsername }}
        </p>
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
          <a class="navlink" v-bind:href="brewery.brewery_url">Web site</a>
          <br />
          <br />
        </div>
      </div>
    </div>
    <h2 class="processedSection">Processed Brewers Requests</h2>
    <div v-for="user in processedBrewers" v-bind:key="user.id">
      {{ user.id }} || {{ user.userId }} || {{ user.username }} ||
      {{ user.breweryId }}
    </div>
    <h2>Processed Brewery Requests</h2>
    <div v-for="brewery in processedBreweries" v-bind:key="brewery.id">
      <div
        id="breweryInfo"
        class="container contaner text-center col-xl-12 mx-auto rounded"
      >
        <p>Request Id || User Id || User Name</p>
        <p>
          {{ brewery.id }} || {{ brewery.userId }} ||
          {{ brewery.brewerUsername }}
        </p>
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
          <a class="navlink" v-bind:href="brewery.brewery_url">Web site</a>
          <br />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import breweryService from "../services/BreweryService";
export default {
  data() {
    return {
      pendingBrewers: [],
      processedBrewers: [],
      pendingBreweries: [],
      processedBreweries: [],
    };
  },
  created() {
    breweryService.getAllBrewerRequests().then((response) => {
      for (let i = 0; i < response.data.length; i++) {
        if (response.data[i].processed) {
          this.processedBrewers.push(response.data[i]);
        } else {
          this.pendingBrewers.push(response.data[i]);
        }
      }
      breweryService.getAllBreweryRequests().then((response) => {
        for (let i = 0; i < response.data.length; i++) {
          if (response.data[i].processed) {
            this.processedBreweries.push(response.data[i]);
          } else {
            this.pendingBreweries.push(response.data[i]);
          }
        }
      });
    });
  },
  methods: {
    addBrewery() {
      this.$router.push("/brewery/add");
    },
    approve(user) {
      user.processed = true;
      user.newRole = "ROLE_BREWER";
      breweryService.switchProccessedStatus(user).then((response) => {
        if (response.status == 200) {
          console.log("proccessed");
        }
      });
      breweryService.changeUserRole(user.userId, user).then((response) => {
        if (response.status == 200) {
          console.log("role changed");
        }
      });
      breweryService.setBrewerToBrewery(user).then((response) => {
        if (response.status == 200) {
          console.log("Brewery updated");
        }
      });
    },
    decline(user) {
      user.processed = true;
      breweryService.switchProccessedStatus(user).then((response) => {
        if (response.status == 200) {
          console.log("proccessed");
        }
      });
    },
  },
};
</script>

<style>
.processedSection {
  margin-top: 50px;
}
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