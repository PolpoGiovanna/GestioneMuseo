<template>
   <div ID="cont">
      <div>
         <div>
            <h1>Inserisci i dati</h1>
            Nome: <input v-model="utente.nome" type="text"/>
            <br/>
            Cognome: <input v-model="utente.cognome" type="text"/>
            <br/>
            Email: <input v-model="utente.email" type="text"/>
            <br/>
            Password: <input v-model="utente.pwd" type="text"/>
            <br/><br/>
            <input type="submit" value="REGISTRATI" @click="register"/>
         </div>
         <br/><br/>
         <div> 
            <router-link to="/">Torna indietro</router-link>
         </div>
         <br/>
    </div>
   </div> 
 </template>
 
<script>
import axios from 'axios';
export default {
   data() {
      return {
         utente:{}
      }
   },
      methods: {
      register() {
         
         let utenteIns = {};
         utenteIns.nome = this.utente.nome;
         utenteIns.cognome = this.utente.cognome;
         utenteIns.email = this.utente.email;
         utenteIns.password = this.utente.pwd;
         axios.post("http://localhost:8080/utente/registra", utenteIns)
         .then((response)=>{
            if(response.status==200){
               window.location.href = 'http://localhost:8081/#/'
               alert("Account creato con successo")
            }
         })
         .catch(function(error){
            if (error.response) {
                  if(error.response.status==409){
                        alert("Dati inseriti sono sbagliati!!!")
                  }else if(error.response.status==403){
                     alert("Uno o più campi vuoti!!!")
                  }
               }
         })
      }
   }
}
</script>
 
 <style>
 
 </style>
 