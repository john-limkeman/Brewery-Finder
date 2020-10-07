<template>
  <div class='review-card'>
      <h4> {{review.title}}</h4>
      <p>{{review.rating}}</p>
      <h6>{{this.username}}</h6>
    <p> {{review.overall}}</p>
    <p>{{review.color}}</p>
    <p>{{review.taste}}</p>
    <p>{{review.head}}</p>
    <p>{{review.smell}}</p>
    <p>{{review.reviewDate}}</p>
    <p>{{review.reviewImgUrl}}</p>

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

</style>