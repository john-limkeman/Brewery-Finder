<template>
  <div>
      <h3> Reviews </h3>
      <div>
          <!-- to contain reviewCards -->
      </div>
      <div>
          <ReviewForm /> 
      </div>
  </div>
</template>

<script>
import BreweryService from '@/services/BreweryService.vue'
import ReviewForm from '@/components/ReviewForm.vue'
export default {
    data(){
        return{
            reviews: []
        }
    },
    components: {
        ReviewForm
    },
    created(){
        BreweryService
    }
}
</script>

<style>

</style>