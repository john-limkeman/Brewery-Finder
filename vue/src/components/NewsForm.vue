<template>
  <div class="outterNewsForm mx-auto border border-dark rounded">
    <div class="newsForm">
      <h2>Add some news!</h2>
      <form id="addNewsForm">
        <label for="newstitle">Event Title</label>
        <input
          v-model="newNews.newstitle"
          type="text"
          name="title"
          placeholder="News Title"
        />
        <label for="body">Body</label>
        <input
          v-model="newNews.body"
          type="text"
          name="text"
          placeholder="Body"
        />
        <label for="picture">Image URL</label>
        <input
          v-model="newNews.newsImageUrl"
          type="text"
          name="active"
          placeholder="News Picture"
        />
        <br />
        <div class="newsBtn">
          <button
            class="btn btn-primary newsBtnBtn"
            v-on:click.prevent="addNews"
          >
            Add
          </button>
          <button
            class="btn btn-primary newsBtnBtn"
            v-on:click.prevent="updateNews"
          >
            Update
          </button>
          <button
            class="btn btn-danger newsBtnBtn"
            v-on:click.prevent="cancel"
          >
            Cancel
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import BreweryService from "@/services/BreweryService.js";
export default {
    data() {
        return{
            newNews:{
                breweryId: this.$route.params.id,
            },
            brewery:{},

        };
    },
     created() {
    if (this.$route.params.newsId != null) {
      BreweryService.getNewsByNewsId(this.$route.params.newsId).then((response) => {
        this.newNews = response.data;
      });
    } 
      BreweryService.getBreweryById(this.newNews.breweryId).then((response) => {
        this.brewery = response.data;
      });
    
  },
  methods: {
    addNews() {
      BreweryService.addNews(this.newNews).then(() => {
        this.$router.push({ name: "BrewerTools" });
      });
    },
    cancel() {
      if (this.$store.state.user.authorities[0].name == "ROLE_BREWER") {
        this.$router.push({ name: "BrewerTools" });
      } else {
        this.$router.push({ name: "BreweryBeers" });
      }
    },
     updateNews() {
      BreweryService.updateNews(this.newNews.newsId, this.newNews);
      if (this.$store.state.user.authorities[0].name == 'ROLE_BREWER'){
        this.$router.push({ name: "BrewerTools" });
      } else {
        this.$router.push({ name: "BreweryBeers" });
      }
    },
  },
};
</script>

<style>
.outterNewsForm {
  display: flex;
  justify-content: center;
}
.newsForm {
  display: flex;
  flex-direction: column;
  border: 1px, solid, black;
  background-color: rgba(245, 222, 179, 0.7);
  width: 60%;
  margin-top: 50px;
  padding: 20px;
}
#addNewsForm {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}
.newsBtn {
  display: flex;
  align-items: center;
}
.newsBtnBtn {
  margin: 10px;
}
</style>