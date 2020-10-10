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
export default {
    data(){
        return{
            News: [],


        }
    }

};

</script>

<style>

</style>