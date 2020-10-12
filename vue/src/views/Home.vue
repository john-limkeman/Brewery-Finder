<template>
<div>
    <aside class="container">Something
      
    </aside>
  <div
    class="home container text-center col-xl-5 mx-auto border border-dark rounded"
  >
    <h1>Welcome to Denver Brew Finder</h1>
    <img src="@/Resources/output-onlinepngtools.png" id="main-page-logo" />
    <h3 class="newsContainer">Brewery News</h3>
    <div class="newsContainer" v-for="item in news" v-bind:Key="item.id">
      <h3>Brewery: {{ item.breweryName }}</h3>
      <title id="newsTitle">{{ item.newsTitle }}</title>
      <p id="newsbody">{{ item.body }}</p>
     
      <img v-bind:src="item.newsImageUrl" />
    </div>
  </div>
</div>
</template>

<script>
import breweryServices from "../services/BreweryService.js";
export default {
  name: "home",
  data() {
    return {
      news: [],
      counter: 1,
    };
  },
  components: {},
  created() {
    breweryServices.getAllNews().then((response) => {
      this.news = response.data.reverse();
      for (let i = 0; i < this.news.length && i < 5; i++) {
        console.log(this.news[i])

        breweryServices
          .getBreweryById(this.news[i].breweryId)
          .then((response) => {
            console.log(response.data)
            this.news[i].breweryName = response.data.name;
            console.log(this.news[i])
          });
      }
    });
  },
  methods: {
    getBreweryName(id) {
      return breweryServices.getBreweryById(id).then((response) => {
        return response.data.name;
      });
    },
  },
};
</script>
<style>
.home {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin-top: 50px;
}
#main-page-logo {
  width: 400px;
  height: auto;
}
.home > h1 {
  font-family: cursive;
}
.newsContainer {
  border-bottom: 3px solid black;
}
</style>