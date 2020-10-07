<template>
  <div>
      <h3> Reviews </h3>
      <div v-for='card in reviews' v-bind:key='card.id'>
          <ReviewCard chosen = card> </ReviewCard> 
     </div>
      <div>
          <ReviewForm /> 
      </div>
  </div>
</template>

<script>
import ReviewCard from '@/components/ReviewCard.vue'
import BreweryService from '@/services/BreweryService.js'
import ReviewForm from '@/components/ReviewForm.vue'
export default {
    data(){
        return{
            reviews: []
        }
    },
    components: {
        ReviewForm,
        ReviewCard
    },
    created(){
        BreweryService.getReviewByBeer(this.$route.params.id).then(
        (response) => {
            this.reviews = response.data;
        }
        )
    }
}
</script>

<style>

</style>