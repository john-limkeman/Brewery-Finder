<template>
  <div id="breweryNews">
      <H3>Brewery News<H3>
          <div class="newsContainer" v-for='news in News' v-bind:Key="news.id">
              <title id="newsTitle">{{news.title}}</title>
              <p id="newsbody">{{news.body}}</p>
              <p id="author">Written By: {{news.author}}</p>




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

</style>