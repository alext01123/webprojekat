<template>
  <label for="korisnicko">Korisnicko ime:</label>
  <input v-model="dostavljac.korisnicko" /><br />
  <label for="lozinka">Lozinka:</label>
  <input v-model="dostavljac.lozinka" type = "password"/><br />
  <label for="ime">Ime:</label>
  <input v-model="dostavljac.ime" maxlength = "20"/><br />
  <label for="prezime">Prezime:</label>
  <input v-model="dostavljac.prezime" maxlength = "20"/><br />
  <div>Pol:
    <select v-model="dostavljac.pol">
      <option value = "" selected disabled>Odaberite pol:</option>
      <option value = 0>Muski</option>
      <option value = 1>Zenski</option>
    </select>
  </div>
  <br />
  <label for="datum_rodjenja">Datum rodjenja:</label>
  <input type="date" v-model="dostavljac.datum_rodjenja" placeholder="dd/mm/yyyy"/><br />
  <button v-on:click="submit()" class="btn btn-primary">submit</button>
</template>

<script>
import axios from "axios"
export default {
  name: "CreateDostavljacView",
  data: function () {
    return {
      dostavljac: {
        korisnickoIme : "",
        lozinka : "",
        ime : "",
        prezime : "",
        pol : null,
        datumRodjenja : ""
      },
    };
  },
  methods: {
    submit: function () {

      axios
          .post("http://localhost:8081/add/dostavljac", this.dostavljac, {withCredentials: true})
          .then((res) => {
            console.log(res);
            this.$router.push("/admin");
          })
          .catch((error) => {
            console.log(error.response)
            alert("Greska!");
          });
    },
  },
};
</script>
<style>
input,
select {
  width: 200px;
  height: 25px;
  margin: 2px;
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}
</style>