<template>
  <div id='replyCard'>
      <h4>{{reply.username}}</h4>
      <h5>{{reply.title}}</h5>
    <p>{{reply.reply}}</p>
  </div>
</template>

<script>
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
    }
}
</script>

<style>

</style>