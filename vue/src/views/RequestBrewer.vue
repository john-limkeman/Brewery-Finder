<template>
  <div>
    
      <form id = "newBrewerForm">
          <label>Brewer Request Form</label>


      </form>

  </div>
</template>

<script>
export default {
    data() {
        return {
            newBrewer: {
                 breweryId: this.$route.params.id,
                 brewerId: this.$route.params.userId,



      },
    };
    },

methods : {
    sendRequest(){
        //send request to admin page.
        //set status as pending
        //user id, user name, user role, breweryid

    }
}
}
</script>

<style>

</style>