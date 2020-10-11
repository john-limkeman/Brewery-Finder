<template>
  <div id="breweryNews">
      <h3>Brewery News</h3>
          <div class="newsContainer" v-for='news in News' v-bind:Key="news.id">
              <title id="newsTitle">{{news.title}}</title>
              <p id="newsbody">{{news.body}}</p>
              <p id="author">Written By: {{news.author}}</p>
              <img v-bind:src="news.newsImageUrl">




          </div>


  </div>
</template>

<script>
import BreweryService from "@/services/BreweryService.js";

export default {
    data(){
        return{
            News: [],


        }
    },

    created(){
        BreweryService.getNewsByBrewery(this.$route.params.id).then(
            (response) => {
                this.News = response.data
            }
        )
    } 

};

</script>

<style>
.newsContainer {
    border-bottom: 3px, solid, black;
}
</style>