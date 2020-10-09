<template>
  <div class='container text-center col-xl-12 mx-auto rounded'>
      <h2>The secret Brewer Hangout</h2>
      <div id='brewerInsider' v-if='isBrewer()'>
          <h3>Im a brewer!</h3>

      </div>
      <div id='brewerOutsider' v-else >
          <h3>I'm not a brewer :( </h3>
          <p>Looking to join our community of Denver Breweries? Submit this form and our Admin will be in touch!</p>
        <BreweryForm />
      </div>
  </div>
</template>

<script>
import BreweryForm from '@/components/BreweryFrom.vue'
export default {
    data(){
        return{

        }
    },
    methods:{
         isBrewer(){
      if (this.$store.state.logIn) {
        if (this.$store.state.user.authorities[0].name == 'ROLE_BREWER' || this.$store.state.user.authorities[0].name == 'ROLE_ADMIN') {
          return true;
        }
      } else {
        return false;
      }
    }
    },
    components:{
        BreweryForm
    }
}
</script>

<style>

</style>
