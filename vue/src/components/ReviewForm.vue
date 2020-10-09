<template>
  <div>
      <button v-on:click='ChangeVis' >Add A review</button>
      <form v-on:submit.prevent ='AddReview' v-if='visibility == true'>
            <label for="title">Title</label>
            <input
                v-model="review.title"
                type="text"
                name="title"
                placeholder="Witty Title Here"
            /> <br>
            <label for="overall">Overall</label>
            <input
                v-model="review.overall"
                type="text"
                name="overall"
                placeholder="What is your overall impression of this brew?"
            /><br>
            <label for="color">Color</label>
            <input
                v-model="review.color"
                type="text"
                name="color"
                placeholder="What's it look like?"
            /><br>
            <label for="taste">Taste</label>
            <input
                v-model="review.taste"
                type="text"
                name="taste"
                placeholder="How's it taste?"
            /><br>
            <label for="head">Head</label>
            <input
                v-model="review.head"
                type="text"
                name="head"
                placeholder="Foamy or no?"
            /><br>
            <label for="smell">Smell</label>
            <input
                v-model="review.smell"
                type="text"
                name="smell"
                placeholder="Use those olfactory sense!"
            /><br>
            <label for="rating">Rating</label>
            <select
                v-model="review.rating"
                type="text"
                name="rating"
               >
                <option value = 1> One Star </option>
                <option value = 2> Two Stars </option>
                <option value = 3> Three Stars </option>
                <option value = 4> Four Stars </option>
                <option value = 5> Five Stars </option>
            </select>
             /<br>
            <label for="image">Picture URL</label>
            <input
                v-model="review.reviewImgUrl"
                type="text"
                name="image"
                placeholder="Pics or it didn't happen!"
            />
            <button>Submit</button>
            <button v-on:click='Cancel'>Cancel</button>
      </form>
  </div>
</template>

<script>
import BreweryService from '@/services/BreweryService.js'
export default {
    data(){
        return{
            review : {
                userId : this.$store.state.user.id,
                beerId : this.$route.params.id,
                breweryId : this.beer.breweryId,
                reviewDate : ""

            },
            visibility: false
        }
    },
     props : ['beer'],
    methods: {
        AddReview(){
            this.review.reviewDate = new Date();
            BreweryService.addReview(this.review).then( () => {
                this.$router.push({ name: 'UserPage', params: { id: this.$store.state.user.id }  })
            })
        },
        Cancel(){
            this.review = {
                userId : this.$store.state.user.id,
                beerId : this.$route.params.id,
                breweryId : this.beer.breweryId,
            };
            
            this.visibility = false;
        },
        ChangeVis(){
            if(this.$store.state.logIn){
            this.visibility = true;
            }
            else{
                this.$router.push({name: 'login'})
            }
        },
     
     created() {
         if (this.$route.params.userId != null) {
             BreweryService.getReviewByUser(this.$route.param.userId).then((response) => {
                 this.newReview = response.data;
             }
             )
         } 
             
     }



    }
}
</script>

<style>

</style>