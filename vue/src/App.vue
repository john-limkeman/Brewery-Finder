<template>
  <div id="app">
    <div
      id="nav"
      class="navbar navbar-expand-lg navbar-dark py-lg-2 navbar-fixed-top"
    >
      <div>
        <router-link class="navlink" v-bind:to="{ name: 'home' }"
          ><img src="@/Resources/output-onlinepngtools.png" /></router-link
        >&nbsp;|&nbsp;
        <router-link class="navlink" v-bind:to="{ name: 'UserPage', params: { id: this.$store.state.user.id }  }"
          >My page</router-link
        >&nbsp;|&nbsp;
        <router-link class="navlink" v-bind:to="{ name: 'BreweryList' }"
          >Breweries</router-link
        >&nbsp;|&nbsp;
        <router-link class="navlink" v-bind:to="{ name: 'AllBeers' }"
          >Beers</router-link
        >&nbsp;&nbsp;
        <router-link
          class="navlink"
          v-bind:to="{ name: 'AdminTools' }"
          v-if="isAdmin()" 
          >Admin Tools</router-link 
        >
      </div>
      <div id='right-side-nav'>
      <div>
           <router-link
          class="navlink"
          v-bind:to="{ name: 'BrewerTools' }"
          v-if="isBrewer()"
          >Brewer Tools</router-link
        >
          <router-link class="navlink" v-else v-bind:to="{ name: 'BrewerTools' }"
          >Add Your Brewery</router-link
        >&nbsp;|&nbsp;
        </div>
        <div>
        <router-link
          class="navlink"
          v-bind:to="{ name: 'logout' }"
          v-if="this.$store.state.logIn"
          >Logout</router-link
        >
        <router-link class="navlink" v-else v-bind:to="{ name: 'login' }"
          >Login</router-link
        >&nbsp;|&nbsp;
      </div>
    </div>
    </div>
    <router-view />
  </div>
</template>

<script>
export default {
  methods: {
    isAdmin() {
      if (this.$store.state.logIn) {
        if (this.$store.state.user.authorities[0].name == 'ROLE_ADMIN') {
          return true;
        }
      } else {
        return false;
      }
    },
    isBrewer(){
      if (this.$store.state.logIn) {
        if (this.$store.state.user.authorities[0].name == 'ROLE_BREWER' || this.$store.state.user.authorities[0].name == 'ROLE_ADMIN') {
          return true;
        }
      } else {
        return false;
      }
    }
  }
};
</script>

<style>
#nav {
  display: flex;
  justify-content: space-between;
  font-family: Arial, Helvetica, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  background-color: goldenrod;
  color: whitesmoke;
  width: 100%;
  position: fixed;
  top: 0;
  font-size: 16pt;
  z-index: 5;
}
#nav img {
  width: 75px;
  height: auto;
}

#right-side-nav{
  display: flex;
}
.navlink {
  color: black;
}
.navlink:hover {
  color: whitesmoke;
}
.navlink:visited {
  color: #630f0f;
}
.navlink:visited:hover {
  color: whitesmoke;
}
.whitelink {
  color: whitesmoke;
}
.whitelink:visited {
  color: wheat;
}
.whitelink:hover {
  color: goldenrod;
}
.whitelink:visited:hover {
  color: goldenrod;
}
body {
  padding-top: 50px;
  background-image: url("https://skookumbrewery.com/wp-content/uploads/2019/05/cropped-IMG_4560-6.jpg");
  background-repeat: no-repeat;
  background-attachment: fixed;
}
.container {
  display: flex;
  flex-direction: column;
  border: 1px, solid, black;
  background-color: wheat;
  width: 50%;
  position: absolute;
  top: 50px;
  padding: 10px;
}
</style>