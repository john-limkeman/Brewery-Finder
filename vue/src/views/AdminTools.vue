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
      <span class="navlink" v-on:click="approve(user)">Approve</span
      >&nbsp;||&nbsp;
      <span class="navlink" v-on:click="decline(user)">Decline</span>
    </div>
    <h2>Pending Brewery Requests</h2>
    <p>Request Id || User Id</p>
    <div
      v-bind:class="{ first: index === 0 }"
      v-for="brewery in pendingBreweries"
      v-bind:key="brewery.id"
    >
      <div id="breweryInfoTop" class="text-center col-xl-12 mx-auto rounded">
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
      <p>
        {{ brewery.id }} || {{ brewery.userId }} ||
        <span class="navlink" v-on:click="approveBrewery(brewery)">Approve</span
        >&nbsp;||&nbsp;
        <span class="navlink" v-on:click="declineBrewery(brewery)"
          >Decline</span
        >
      </p>
    </div>
    <h2>Processed Brewers Requests</h2>
    <div v-for="user in processedBrewers" v-bind:key="user.id">
      {{ user.id }} || {{ user.userId }} || {{ user.username }} ||
      {{ user.breweryId }}
    </div>
    <h2>Processed Brewery Requests</h2>
    <div v-for="brewery in processedBreweries" v-bind:key="brewery.id">
      <div id="breweryInfoBottum" class="text-center col-xl-12 mx-auto rounded">
        <!-- <p>Request Id || User Id || User Name</p>
        <p>
          {{ brewery.id }} || {{ brewery.userId }} ||
          {{ brewery.brewerUsername }}
        </p> -->
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
      userToUpdate: {},
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
    });
    breweryService.getAllBreweryRequests().then((response) => {
      for (let i = 0; i < response.data.length; i++) {
        if (response.data[i].processed) {
          this.processedBreweries.push(response.data[i]);
        } else {
          this.pendingBreweries.push(response.data[i]);
        }
      }
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
    approveBrewery(brewery) {
      brewery.processed = true;
      breweryService.getUser(brewery.userId).then((response) => {
        this.userToUpdate = response.data;
        this.userToUpdate.newRole = "ROLE_BREWER";
        breweryService
          .changeUserRole(this.userToUpdate.id, this.userToUpdate)
          .then((response) => {
            if (response.status == 200) {
              console.log("role changed");
            }
          });
      });
      breweryService.updateBreweryRequest(brewery).then((response) => {
        if (response.status == 200) {
          console.log("proccessed");
        }
      });
      brewery.brewerId = brewery.userId;
      brewery.active = true;
      breweryService.addBrewery(brewery).then((response) => {
        if (response.status == 201) {
          console.log("Brewery created");
        }
        breweryService.setBrewerToBrewery(this.userToUpdate).then((response) => {
          if (response.status == 200) {
          console.log("User added to brewery");
        }
        })
      })
    },
    declineBrewery(brewery) {
      brewery.processed = true;
      breweryService.updateBreweryRequest(brewery).then((response) => {
        if (response.status == 200) {
          console.log("proccessed");
        }
      });
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
#breweryInfoTop,
#breweryInfoBottum {
  display: grid;
  grid-template-columns: 1fr, 1fr;
  grid-template-areas: "img text";
  background: wheat;
  text-align: center;
  margin: 10px;
  border-style: solid;
  border-width: 3px;
  width: 90%;
  justify-content: center;
  align-items: center;
}

.first {
  margin-top: -50px;
}

#name {
  text-decoration: underline;
}
</style>