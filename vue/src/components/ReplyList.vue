<template>
  <div>
        <div v-for='reply in AllReplies' v-bind:key='reply.id' id='replyCard'>
           <ReplyCard v-bind:replyData='reply'/>

        </div>
  </div>
</template>

<script>
import ReplyCard from '@/components/ReplyCard.vue'
export default {
    data(){
        return{
            AllReplies : this.replies
        }
    },
    props: ['replies'],
     components : {
        ReplyCard
    },
      watch: {
    replies: function(newVal, oldVal) { // watch it
          console.log('Prop changed: ', newVal, ' | was: ', oldVal);
        this.AllReplies = this.replies;
    }    
  },
}
</script>

<style>

</style>