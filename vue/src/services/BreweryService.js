import axios from 'axios';

const http = axios.create({baseURL: 'http://localhost:8080'})

export default {

 getBreweryList(){
     return http.get('/breweries');
 },
 getBreweryById(id){
     return http.get(`/brewery/${id}`)
 },
 getBeerList(){
    return http.get('/beer');
},
getBeerById(id){
    return http.get(`/beer/${id}`)
},

}
