<template>
   <div>
       <div id="nav2"> 
           |<router-link to="/home">Home</router-link> |
           <router-link to="/artista">Artista</router-link> |
           <router-link to="/tipo">Tipo Opera</router-link> |
           <router-link to="/luogo">Luogo</router-link> |
           <router-link to="/opera">Opera</router-link>|
       </div>

       <div>
           <h2>
               Scegli cosa vuoi fare :
           </h2>
       </div>
      
       <div id="cont2">
           <h3>Aggiungi tipo dell'opera</h3>
           Nome: <input v-model="tipo.nome" type="text"/>
           <br/><br/>
           <input type="submit" value="INVIA" @click="addTipo"/>
       </div>
       <div id="listaArt"> 
           <h3>
               Lista tipi opera:
           </h3>
           <table>
               <tr>
                   <th>NOME</th>
               </tr>
               <tr v-for="(t, index) in tipi" :key="t.id" >
                   <td>
                       <div :class="[`index--${index}`]" style="display: inline;">
                           {{t.nome}}
                       </div>

                       <div :class="[`mostra${index}`]" style="display: none;">
                           <input v-model="t.nome" type="text"/>
                       </div>
                   </td>
                  
                   <td>
                       <div :class="[`index--${index}`]">
                           <div>
                               <input type="button" value="MODIFICA" @click="mostranascondi(index)"/>
                           </div>
                           <div>
                               <input type="submit" value="ELIMINA" @click="delTipo(t.id)"/>
                           </div>
                       </div>

                       <div :class="[`mostra${index}`]" style="display: none;">
                           <div>
                               <input type="submit" value="CONFERMA MODIFICA" @click="modTipo(t.id, t.nome)"/>
                           </div>
                           <div>
                               <input type="submit" value="INDIETRO" @click="mostranascondi(index)"/>
                           </div>
                       </div>
                   </td>
                   
               </tr> 
           </table>
       </div>
   </div> 
</template>

<script>
   import axios from 'axios';
   export default {
       mounted: async function(){
           let items= await axios.post("http://localhost:8080/tipo/lista");
           this.tipi=items.data.listaTipoOPera;
       },
       data(){
           return{
               tipi:[],
               tipo:{}
           }
       },
      methods:{
         addTipo(){
            let tipoDaInserire={};
            tipoDaInserire.nome = this.tipo.nome;
            axios.post("http://localhost:8080/tipo/inserisci", tipoDaInserire)
            .then((response) => {
               if(response.status==200){
                  location.reload();
                  alert("Tipo inserito!!!")
               }
            })
            .catch(function (error) {
               if(error.response.status==409){
                  alert("Campo vuoto!!!")
               }else if(error.response.status==403){
                  alert("Campo inserito sbagliato!!!")
               }
            })
         },

         delTipo(idT){
            axios.post("http://localhost:8080/tipo/elimina",{id: idT})
            location.reload();
            alert("Tipo eliminato!!!")
         },
         
         mostranascondi(id){
            let index = `index--${id}`;
            let index2 = `mostra${id}`;

            let array = document.getElementsByClassName(index);
            let array2 = document.getElementsByClassName(index2);

            if(array[0].style.display != 'none'){
               for (var i = 0; i < array.length; i ++) {
                  array[i].style.display = 'none';
                  array2[i].style.display = 'block';
               }
            }else{
                  location.reload();
            }
         },
         modTipo(idT, nomeT){
            let tipoModifica={};
            tipoModifica.id = idT;
            tipoModifica.nome = nomeT;
            axios.post("http://localhost:8080/tipo/modifica", tipoModifica)
            .then((response) => {
               if(response.status==200){
                  location.reload();
                  alert("Tipo modificato!!!")
               }
            })
            .catch(function (error) {
               if(error.response.status==409){
                  alert("Campo inserito sbagliato!!!")
               }else if(error.response.status==403){
                  alert("Campo vuoto!!!")
               }
            })
         }
      }
   }
</script>

<style>
   table, th, td {
       border:1px solid black;
       text-align: center;
   }
</style>
