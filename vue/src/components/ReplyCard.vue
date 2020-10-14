<template>
  <div id='replyCard'>
      <h4>{{reply.username}}</h4>
      <h5>{{reply.title}}</h5>
    <p>{{reply.reply}}</p>
  </div>
</template>

<script>
// import breweryService from '@/services/BreweryService.js'
export default {
    data(){
        return{
            reply : this.replyData
        }
    },
    props: ['replyData'],
    // watch : {
    //     reply: function(newVal, oldVal) { // watch it
    //       console.log('Prop changed: ', newVal, ' | was: ', oldVal);
    //       breweryService.getBreweryById(this.brewid).then(
    //         (response) => {
    //           this.newBrewery = response.data;
    //         }
    //       );
    //  console.log(this.brewid)
    // }    
    // },
}
</script>

<style>

</style>