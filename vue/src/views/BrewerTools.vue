<template>
  <div >
      <div id='brewerInsider' v-if='isRole() == "BREWER"' >
          <BrewerInsider :key='RenderKey' v-on:finished='finished()'/>
      </div>

      <div id='brewerOutsider' v-if='isRole() == "USER"'>
        <BrewerOutsider />
    </div>
  </div>
</template>

<script>
import BrewerOutsider from '@/components/BrewerOutsider.vue'
import BrewerInsider from '@/components/BrewerInsider.vue'
export default {
    data(){
        return{
          Renderkey : 0
        }
    },
    methods:{
         isRole(){
     
        if (this.$store.state.user.authorities[0].name == 'ROLE_BREWER' || this.$store.state.user.authorities[0].name == 'ROLE_ADMIN') {
          return "BREWER";
        }
         else if (this.$store.state.user.authorities[0].name == 'ROLE_ADMIN') {
        return "ADMIN";
      } else if (this.$store.state.user.authorities[0].name == 'ROLE_USER'){
        return "USER";
      }
    },
    finished(){
      this.RenderKey += 1;
    }
    
       
    },
    components:{
      BrewerOutsider,
      BrewerInsider
    },
    created(){
    }
}
</script>

<style>
</style>
