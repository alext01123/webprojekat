<template>
  <h1>Registracija</h1>
  <div>
    <label for="ime" class="form-label">Ime</label>
    <input v-model="korisnik.ime" class="form-control" />
  </div>
  <div>
    <label for="prezime" class="form-label">Prezime</label>
    <input v-model="korisnik.prezime" class="form-control" />
  </div>
  <div>
    <label for="korisnicko" class="form-label">Korisničko ime</label>
    <input v-model="korisnik.korisnickoIme" class="form-control" />
  </div>

  <div>
    <label for="lozinka" class="form-label">Lozinka</label>
    <input v-model="korisnik.lozinka" type="password" class="form-control" />
  </div>
  <label for="">Pol:</label> <br>
  <div class="form-check form-check-inline">
    <input
        class="form-check-input"
        type="radio"
        name="inlineRadioOptions"
        id="inlineRadio1"
        value=0
        v-model="korisnik.pol"
    />
    <label class="form-check-label" for="inlineRadio1">Muški</label>
  </div>
  <div class="form-check form-check-inline">
    <input
        class="form-check-input"
        type="radio"
        name="inlineRadioOptions"
        id="inlineRadio2"
        value=1
        v-model = "korisnik.pol"
    />
    <label class="form-check-label" for="inlineRadio2">Ženski</label>
  </div>
  <br>
  <label>Datum rodjenja:</label> <br>
  <input  v-model = "korisnik.datum_rodjenja" type="date" />
  <div class="col-12">
    <button v-on:click="registrujSe()" class="btn btn-primary">
      Prijava
    </button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "RegisterView",
  data: function() {
    return {
      korisnik: {
        ime: "",
        prezime: "",
        korisnicko: "",
        lozinka: "",
        pol : null,
        datum_rodjenja : ""
      }
    };
  },
  methods: {
    registrujSe: function() {
      axios
          .post("http://localhost:8081/register", this.korisnik, {
            withCredentials: true
          })
          .then(res => {
            console.log(res);

            this.$router.push("/login");
            alert("Uspesno");
          })
          .catch(error => {
            console.log(error.response);
            alert("Neuspesno");
          });
    }
  }
};
</script>

<style>
h1 {
  color: cornflowerblue;
}
form {
  margin: 5% auto;
  width: 30%;
}
input {
  width: 30%;
  margin: 15px auto;
}
</style>