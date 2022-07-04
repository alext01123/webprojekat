<template>
  <div class="home">
    <div class="logoVeliki">
      <p class="white-text">dostava<span class="span">019</span></p>
    </div>
    <a type="button" href="/login" class="btn btn-primary">Prijavite se</a>
    <p>Nemate nalog? <a href="/register">Registrujte se</a></p>
  </div>
</template>

<script>
import HelloWorld from "@/components/HelloWorld.vue";

export default {
  name: "HomeView",
  components: {
    HelloWorld
  }
};
</script>

<style scoped>
.logoVeliki {
  font-size: 60px;
  text-align: center;
  font-family: "Copperplate Gothic Bold";
  margin-top: 20%;
}

.logoMali {
  font-size: 15px;
  text-align: left;
  font-family: "Century Gothic";
}

.white-text {
  color: #CF9893;
}

.span {
  color: #7A5980;
}
a {
  text-decoration: none;
  margin-top: 15px;
}

p {
  margin-top: 5px;
}
</style>