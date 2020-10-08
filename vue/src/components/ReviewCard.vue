<template>
<div class='revCardContainer'>
  <div class='review-card'>
      <h4 id='review-title'> "{{review.title}}"</h4>
      <p id='review-rating'>{{review.rating}}</p>
      <h6 id='review-user'><span>By:</span> {{this.username}}</h6>
     <p id='review-overall'> <span>Overall:</span> {{review.overall}}</p>
     <p id='review-color'><span>Color:</span> {{review.color}}</p>
     <p id='review-taste'><span>Taste:</span> {{review.taste}}</p>
     <p id='review-head'><span>Head:</span> {{review.head}}</p>
     <p id='review-smell'><span>Smell:</span> {{review.smell}}</p>
     <p id='review-date'><span>Submitted On:</span> {{review.reviewDate}}</p>
        <img id='review-img' v-bind:src='review.reviewImgUrl'/>
</div>
  </div>
</template>

<script>
import BreweryService from '../services/BreweryService'
export default {
    data(){
        return{
            username : 'Stand-in',
            review: this.chosen
        }
    },
    props : ['chosen'],
    created(){
        BreweryService.getUser(this.chosen.userId).then(
            (response) => {
                this.username = response.data.username;
            }
        )
    },
}
</script>

<style>
.review-card{
    display: grid;
    grid-template-columns: 1fr 2fr 2fr;
    grid-template-areas: 
    "title title rating"
    "username . img"
    "overall overall img"
    "color color img"
    "smell smell img"
    "taste taste img"
    "head head img"
    ". date date";
    text-align:left;
    border: solid 3px goldenrod;
    border-radius: 10px;
    margin: 2px;
    background-color:ivory;
    padding: 4px;
}

.review-card span{
    font-weight: bold;
    color: black;
    font-style:normal;
    font-size: 16px;
}
.review-card h4{
    font-weight:bold;
}
.review-card h6{
    font-style: italic;
    font-weight: bold;
    color:goldenrod;
    font-size: 20px;
}
#review-title{
    grid-area: title;
}
#review-rating{
    grid-area: rating;
}
#review-user{
    grid-area: username;
}
#review-overall{
    grid-area: overall;
}
#review-img{
    grid-area: img;
    height: 200px;
    align-items: right;
}
#review-color{
    grid-area: color;
}
#review-smell{
    grid-area: smell;
}
#review-taste{
    grid-area: taste;
}
#review-head{
    grid-area: head;
}
#review-date{
    grid-area: date;
    text-align: right;
    font-size: 12px;
}
.revCardContainer{
    display: block;
}
</style>