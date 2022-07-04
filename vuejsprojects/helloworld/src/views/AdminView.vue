<template>
  <a type="button" href="/create-menadzer" class="btn btn-primary">Kreiraj Menadžera</a>
  <a type="button" href="/create-dostavljac" class="btn btn-primary">Kreiraj Dostavljača</a>
  <a type="button" href="/create-restoran" class="btn btn-primary">Kreiraj Restoran</a>
  <a type="button" href="/profile" class="btn btn-primary">Moj profil</a>
  <a type="button" v-on=click="logout()"  class="btn btn-primary">Izloguj se</a>

  <div class="input-group">
    <select v-model="filter" class="form-select" aria-label="Default select example">
      <option selected>Choose</option>
      <option value="korisnicko">By Username</option>
      <option value="ime">By First Name</option>
      <option value="prezime">By Second Name</option>
    </select>
    <input v-model="value" type="search" v-on=keyup="search(filter,value)" id="myInput" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
  </div>

  <table class="table">
    <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Korisnicko ime</th>
      <th scope="col">Ime</th>
      <th scope="col">Prezime</th>
      <th scope="col">Pol</th>
      <th scope="col">Uloga</th>
      <th scope="col">Datum rodjenja</th>
    </tr>
    </thead>
    <tbody>
    <tr  v-for="user in users" :key="user.id">
      <th scope="row">{{user.id}}</th>
      <td>{{user.korisnicko}}</td>
      <td>{{user.ime}}</td>
      <td>{{user.prezime}}</td>
      <td>{{user.pol}}</td>
      <td>{{user.uloga}}</td>
      <td>{{user.datum_rodjenja}}</td>
    </tr>
    </tbody>
  </table>
</template>

<script>
import axios from "axios";
export default {
  name: "Admin Vue",
  data: function () {
    return {
      users: [],
      filter : "",
      value : ""
    };
  },
  mounted: function () {
    axios
        .get("http://localhost:8081/korisnici", {withCredentials:true})
        .then((res) => {
          this.users = res.data
        })
        .catch((err) =>{
          console.log(err)
        })
  },
  methods: {
    search : function(filter, value){
      axios
          .get("http://localhost:8081/korisnici?search=" + filter + ":" + value, {withCredentials:true})
          .then((res) => {
            this.users = res.data
          })
          .catch((err) =>{
            console.log(err)
          })
    }
  },

};
</script>

<style scoped>
</style>
