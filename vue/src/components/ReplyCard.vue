<template>
  <div id='replyCard'>
      <h4>{{reply.username}}</h4>
      <h5>{{reply.title}}</h5>
    <p>{{reply.reply}}</p>
    <button class="btn btn-danger deleteReply" v-if="isAdmin()" v-on:click="deleteReply()">Delete Reply</button>
  </div>
</template>

<script>
import BreweryService from '../services/BreweryService';
export default {
    data(){
        return{
            reply : this.replyData
        }
    },
    props: ['replyData'],
watch: {
    replyData: function(newVal, oldVal) { // watch it
          console.log('Prop changed: ', newVal, ' | was: ', oldVal);
        this.reply = this.replyData;
    }    
  },
    created(){
        console.log(this.replyData)
    },
  methods: {
    isAdmin() {
      if (this.$store.state.logIn) {
        if (this.$store.state.user.authorities[0].name == 'ROLE_ADMIN') {
          return true;
        }
      } else {
        return false;
      }
    },
    deleteReply() {
      BreweryService.deleteReplies(this.reply).then(() => {})
    }
  }
}
</script>

<style>
.deleteReply {
  width: 150px;
}
</style>