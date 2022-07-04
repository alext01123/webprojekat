<template>
  <h1>Prijava</h1>
  <div>
    <label for="korisnicko" class="form-label">Korisničko ime</label>
    <input v-model="korisnik.korisnickoIme" class="form-control" />
  </div>

  <div>
    <label for="lozinka" class="form-label">Lozinka</label>
    <input v-model="korisnik.lozinka" type="password" class="form-control" />
  </div>

  <div class="col-12">
    <button v-on:click="combination()" class="btn btn-primary">Prijava</button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "LoginView",
  data: function() {
    return {
      korisnik: {
        korisnicko: "",
        lozinka: ""
      },
      uloga: ""
    };
  },
  methods: {
    prijaviSe: function() {
      axios
          .post("http://localhost:8081/login", this.korisnik, {
            withCredentials: true
          })
          .then(res => {
            console.log(this.uloga);
            alert("Uspesno logovanje!");
            if(this.uloga == "Admin"){
              this.$router.push("/admin");
            }else if(this.uloga == "Dostavljac"){
              //this.$router.push("/dostavljac");
            }else if(this.uloga == "Menadzer"){
              this.$router.push("/menadzer");
            }else{
              //this.$router.push("/kupac");
            }
          })
          .catch(error => {
            console.log(error.response);
            alert("Neuspesno logovanje!");
          });
    },

    combination: function(){
      this.prijaviSe()
    }
  }
};
</script>

<style>
h1 {
  color: cornflowerblue;
  margin-top: 10%;
}
body {
  margin: auto;
}
input {
  width: 30%;
  margin: 5px auto;
}
</style>