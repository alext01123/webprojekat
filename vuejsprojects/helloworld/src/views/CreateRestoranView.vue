<template>
  <label for="naziv">Naziv restorana:</label>
  <input v-model="restoran.naziv" type = "text"/><br />
  <label for="tip">Tip restorana:</label>
  <input v-model="restoran.tip" type = "text"/><br />
  <h4>Lokacija restorana</h4>
  <label for="lokacije">Lokacija:</label>
  <input v-model="restoran.lokacije" type ="text"/><br />

  <button v-on:click="submit()" class="btn btn-primary">submit</button>
</template>

<script>
import axios from "axios"
export default {
  name: "CreateRestoranView",
  data: function () {
    return {
      restoran: {
        "naziv" : "",
        "tip" : "",
        "lokacije" : "",
      },
      restorani : []
    };
  },
  mounted: function () {
  },
  methods: {
    submit: function () {

      axios
          .post("http://localhost:8081/add/restoran", this.restoran, {withCredentials: true})
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