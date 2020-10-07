<template>
  <div class="breweryFormComponent">
    <form id="newBreweryForm">
      <label for="name">Brewery name</label>
      <input
        v-model="newBrewery.name"
        type="text"
        name="name"
        placeholder="Brewery name"
      />
      <br />
      <label for="address">Address</label>
      <input
        v-model="newBrewery.address"
        type="text"
        name="address"
        placeholder="Address"
      />
      <br />
      <label for="description">Description</label>
      <input
        v-model="newBrewery.description"
        type="text"
        name="description"
        placeholder="Description"
      />
      <br />
      <label for="image">Image url</label>
      <input
        v-model="newBrewery.image"
        type="text"
        name="image"
        placeholder="Image url"
      />
      <br />
      <label for="brewery_url">Brewery url</label>
      <input
        v-model="newBrewery.brewery_url"
        type="text"
        name="brewery_url"
        placeholder="Brewery url"
      />
      <br />
      <label for="phone">Phone number</label>
      <input
        v-model="newBrewery.phone"
        type="text"
        name="phone"
        placeholder="Phone number"
      />
      <br />
      <label for="hours">Hours</label>
      <input
        v-model="newBrewery.hours"
        type="text"
        name="hours"
        placeholder="Hours"
      />
      <br />
      <label for="active">Active</label>
      <input
        v-model="newBrewery.active"
        type="checkbox"
        name="active"
        placeholder="Active"
      />
      <br />
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      newBrewery: {},
    };
  },
};
</script>

<style>
#breweryFormComponent {
  display: flex;
  flex-direction: column;
  border: 1px, solid, black;
  background-color: wheat;
  width: 70%;
}
#newBreweryForm {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}
div > form > button {
  width: 80px;
  align-items: center;
}
</style>