<template>
<div class='revCardContainer'>
  <div class='review-card'>
      <h4 id='review-title'> "{{review.title}}"</h4>
      <div id= 'review-rating'>
       <img
          src="../Resources/star.png"
          v-bind:title="review.rating + ' Star Review'"
          id="ratingStar"
          v-for="n in review.rating"
          v-bind:key="n"
        />

        </div>
      
      <h6 id='review-user' v-if='!checkUser()'><span>By:</span> {{this.username}}</h6>
     <h6 id='review-beer' v-else><span>Reviewed:</span> <br><router-link class='navlink' id='reviewCardLink' v-bind:to='{name : "BeerDetails", params: {id : this.beer.id}}'>{{beer.name}}</router-link></h6>
     <p id='review-overall'> <span>Overall:</span> {{review.overall}}</p>
     <p id='review-color'><span>Color:</span> {{review.color}}</p>
     <p id='review-taste'><span>Taste:</span> {{review.taste}}</p>
     <p id='review-head'><span>Head:</span> {{review.head}}</p>
     <p id='review-smell'><span>Smell:</span> {{review.smell}}</p>
     <p id='review-date'><span>Submitted On:</span> {{review.reviewDate}}</p>
        <img id='review-img' v-bind:src='review.reviewImgUrl'/>
<<<<<<< HEAD
        <div v-for='reply in replies' v-bind:key='reply.id' id='replyCard'>
            <!-- <ReplyCard v-bind:repId='reply.id'/> -->
            <h4>{{reply.id}}</h4>
            <p> {{reply.reply}}</p>

        </div>
=======
        <div>
            <ReplyList v-bind:replies='this.replies'/>
            </div>
>>>>>>> 06015890dd557675a0074dc5825d0cba46825b46
           <button class="btn btn-primary" id= "review-reply" v-on:click="ChangeVis">Add Reply</button>

           <form id='review-reply-text' v-on:submit.prevent ='addReply' v-if='visibility' >
                 <label for="title">Title</label>
            <input
                v-model="reply.title"
                type="text"
                name="reviewTitle"
                placeholder="Title for Review reply"
            /> <br>
            <label for="reply">Reply</label>
            <input
                v-model="reply.reply"
                type="text"
                name="reply"
             placeholder="What is your reply?"
            /><br>
               <button class="btn btn-primary">Submit</button> 
            <button class="btn btn-primary" v-on:click.prevent='Cancel()'>Cancel</button> 
           </form> 
       
</div>
  </div>
</template>

<script>
import ReplyList from '@/components/ReplyList.vue'
import BreweryService from '../services/BreweryService'
export default {
    data(){
        return{

              reply: {

            userId : this.$store.state.user.id,
            reviewId: this.chosen.id,
            replyDate : "",
            title: "",
            reply:""
        },

            review: this.chosen,
            visibility: false,
            beer: {},
            username: "",
            replies: [],
        }

      
    },
    props : ['chosen'],
    methods: {

         ChangeVis(){
            if(this.$store.state.logIn){
            this.visibility = true;
            }
            else{
                this.$router.push({name: 'login'})
            }
        },

    addReply(){
            this.reply.replyDate = new Date();
            BreweryService.addReviewReply(this.reply).then( () => {
            } )

    },
    checkUser(){
        let url = this.$route.name
    if (url == 'UserPage'){
        return true;
    } else {
        return false;
    }
    },

            Cancel() {

         this.visibility = false;
          //  this.reply = {
       //         title : this.$store.state.user.id,
       //         reply : this.chosen.id,
       //     };
             
         
        },
    },
    components : {
        ReplyList
    },
    created(){
        BreweryService.getUser(this.chosen.userId).then(
            (response) => {
                this.username = response.data.username;
                BreweryService.getBeerById(this.chosen.beerId).then(
                    (response) => {
                        this.beer = response.data;
                        BreweryService.getRepliesByReviewId(this.chosen.id).then(
                            (response) => {
                                this.replies = response.data;
                            }
                        )
                        
                    }
                )
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
    "username username img"
    "overall overall img"
    "color color img"
    "smell smell img"
    "taste taste img"
    "head head img"
    ". date date"
    "repButton repButton ."
    "replyForm  replyForm ."
    "replies replies replies"
    "replies replies replies";
    text-align:left;
    border: solid 3px goldenrod;
    border-radius: 10px;
    margin: 2px;
    background-color:ivory;
    padding: 4px;
}

#reviewCardLink:hover{
    color:goldenrod
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
#ratingStar{
    width: 25px;
    height: auto;
}
#review-rating{
    grid-area: rating;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
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
    max-width: 300px;;
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
#review-beer{
    grid-area: username;
}
.revCardContainer{
    display: block;
}

#review-reply{
     grid-area: repButton;
}

#review-reply-text{
     grid-area: replyForm;
}

#replyCard{
    display: flex;
    flex-direction:column;
    grid-area: replies;
}

</style>