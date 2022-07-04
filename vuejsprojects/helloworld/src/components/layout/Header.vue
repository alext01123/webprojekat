<template>
  <header class="header">
    <h1>Dostava brze hrane NS</h1>
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/login">Login</router-link> |
      <router-link to="/Register">Register</router-link> |
      <router-link to="/admin">Admin</router-link> |
      <router-link to="/create-menadzer">Napravi Menadzera</router-link> |
      <router-link to="/create-dostavljac">Napravi Dostavljaca</router-link> |
      <router-link to="/create-restoran">Napravi Restoran</router-link> |
      <router-link to="/korpa">Korpa</router-link> |
      <router-link to="/profile">Profil</router-link> |
    </nav>
  </header>

  <img src="/assets/fastfood.jpg" alt="">


</template>

<script>
export default
{
  name: "HeadeR"
}

</script>

<style scoped>
.header {
  background: #3B3B58;
  color: #CF9893;
  text-align: center;
  padding: 15px;
  font-family: "Century Gothic";
  font-size: x-large;
}

.header a {
  color: #CF9893;
  padding-right: 15px;
  text-decoration: none;
}
</style>
