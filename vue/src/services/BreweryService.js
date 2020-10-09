import axios from 'axios';

const http = axios.create({ baseURL: 'http://localhost:8080' })

export default {

    getBreweryList() {
        return http.get('/breweries');
    },
    getBreweryById(id) {
        return http.get(`/brewery/${id}`)
    },
    getBreweryByBrewer(id){
        return http.get(`/brewery/brewer/${id}`)
    },
    getBeerList() {
        return http.get('/beer');
    },
    getBeerById(id) {
        return http.get(`/beer/${id}`)
    },
    getBeerByBrewery(id) {
        return http.get(`/brewery/${id}/beers`)
    },
    addBrewery(brewery) {
        return http.post("/addBrewery", brewery)
    },
    updateBrewery(brewery) {
        return http.put(`/brewery/${brewery.id}`, brewery)
    },
    addBeer(beer) {
        return http.post("/addBeer", beer)
    },
    updateBeer(beer) {
        return http.put(`/beer/${beer.id}`, beer)
    },
    getReviewByBeer(id) {
        return http.get(`/beer/${id}/reviews`)
    },
    getReviewByBrewery(id) {
        return http.get(`/brewery/${id}/reviews`)
    },
    addReview(review) {
        return http.post("/new-review", review)
    },
    deleteReview(review) {
        return http.delete('/delete-review', review)
    },
    getUser(userId) {
        return http.get(`/user/${userId}`)
    },
    sendBrewerRequest(breweryId, user) {
        return http.post(`/brewery/${breweryId}`, user)

    },
    getReviewByUser(userId) {
        return http.get(`/user/${userId}/reviews`)
    },
    getAllBrewerRequests() {
        return http.get("/brewerRequest")
    },
    SendPendingBreweryRequest(request){
        return http.post("/GET FROM BRAD", request)
    },
    getAllPendingBreweryRequests(){
        return http.get("/GET FROM BRAD")
    }





}
