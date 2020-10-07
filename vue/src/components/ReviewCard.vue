<template>
<div class='revCardContainer'>
  <div class='review-card'>
      <h4 id='review-title'> {{review.title}}</h4>
      <p id='review-rating'>{{review.rating}}</p>
      <h6 id='review-user'>By: {{this.username}}</h6>
    <p id='review-overall'> Overall: {{review.overall}}</p>
    <p id='review-color'>Color: {{review.color}}</p>
    <p id='review-taste'>Taste: {{review.taste}}</p>
    <p id='review-head'>Head: {{review.head}}</p>
    <p id='review-smell'>Smell: {{review.smell}}</p>
    <p id='review-date'>Submitted On: {{review.reviewDate}}</p>
    <p id='review-img'>{{review.reviewImgUrl}}</p>
</div>
  </div>
</template>

<script>
export default {
    data(){
        return{
            username : 'Stand-in',
            review: this.chosen
        }
    },
    props : ['chosen'],
    created(){
        //get username from db
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
    border: solid 1px black;
    border-radius: 10px;
    margin: 2px;
    background-color:ivory;
    padding: 4px;
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
}
.revCardContainer{
    display: block;
}
</style>