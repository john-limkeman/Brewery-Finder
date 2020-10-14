<template>
  <div>
    

    <div
      class="home container text-center col-5 mx-auto border border-dark rounded"
    >
      <h1>Denver Brew Finder</h1>
      <img src="@/Resources/output-onlinepngtools.png" id="main-page-logo" />
    </div>

     <div class="container col-5 mx-auto border border-dark rounded" v-for="item in news" v-bind:Key="item.id">
       <h3 class="newsContainer">Brewery News</h3>
        <h3>Brewery: {{ item.breweryName }}</h3>
        <h4 id="newsTitle">Title: {{ item.newstitle }}</h4>
        <p id="newsbody">{{ item.body }}</p>
        <img id="newsImage" v-bind:src="item.newsImageUrl" />
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
  font-family: 'Bungee Shade';
  font-size: 70px;
}
.newsContainer {


}
#newsImage{
  width: 400px;
}

</style>