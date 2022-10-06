<template>
   <div id="cont">
      <div>
         <h1>Login</h1>
         Email:<input v-model="utente.email" type="text"/>
         <br/>
         Password:<input v-model="utente.password" type="password" />
         <br/><br/>
         <input id="sub" value="LOGIN" type="submit" @click="loginUtente"/>
      </div>
      <br/><br/>
      <div> 
         <router-link to="/registrati">Se non hai un account, registrati</router-link>
     </div>
     <br/>
   </div>
</template>
     
<script>
   import axios from 'axios';
   export default {
      data() {
         return {
         show:false,
         utente:{},
      }
      },
      methods: {
         loginUtente(){
            let credenziali={};
            credenziali.email = this.utente.email
            credenziali.password = this.utente.password
            axios.post("http://localhost:8080/utente/login", credenziali)
            .then((response) => {
               if(response.status==200){
                  window.location.href = 'http://localhost:8081/#/home'
               }
            })
            .catch(function (error) {
                  if(error.response.status==409){
                        alert("Dati inseriti sono sbagliati!!!")
                  }else if(error.response.status==403){
                     alert("Uno o più campi vuoti!!!")
                  }
            })
         }
      }
   }
</script>
 
<style>
   #cont{
      border-style: solid;
      text-align: center;
      margin-top: 15%;
      font-size: 25px;
      margin-left: 30%;
      margin-right: 30%;
   }
   #sub{
      height: 30px;
      width: 150px;
      font-size: 15px;
   }
   input{
      width: 200px;
   }
</style>