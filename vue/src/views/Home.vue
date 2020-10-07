<template>
  <div class="home">
    <h1>Denver Brew Finder</h1>
    <img src="@/Resources/output-onlinepngtools.png" id='main-page-logo'/>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>
<style>
.home{
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content:center;
  margin-top: 50px;
}
#main-page-logo{
  width: 400px;
}
.home > h1{
  font-family:cursive;
}
</style>