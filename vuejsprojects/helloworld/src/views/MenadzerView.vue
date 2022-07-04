<template>
  <h1>Moj restoran</h1>
  <table class="table">
    <thead class="thead-dark">
    <tr>
      <th scope="col">Naziv</th>
      <th scope="col">Tip</th>
      <th scope="col">Status</th>
      <th scope="col">Lokacija</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>{{restoran.name}}</td>
      <td>{{restoran.tip}}</td>
      <td>{{restoran.status}}</td>
      <td>{{restoran.lokacije}}</td>
    </tr>
    </tbody>
  </table>
</template>

<script>
import axios from "axios";

export default {
  name: "MenadzerView",
  data: function() {
    return {
    };
  },
  methods: {
    mounted: function () {
      axios
          .get("http://localhost:8081/menadzer/restoran", {withCredentials:true})
          .then((res) => {
          })
          .catch((err) =>{
            console.log(err)
          })
    }
  }
};
</script>

<style>

</style>