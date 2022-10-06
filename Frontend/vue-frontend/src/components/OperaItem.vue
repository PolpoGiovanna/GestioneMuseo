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
         <h3> Aggiungi opera:</h3>
         Codice univoco: <input v-model="opera.codiceUnivoco" type="text"/>
         <br/><br/>
         Nome: <input v-model="opera.nome" type="text"/>
         <br/><br/>
         Dimensioni: <input v-model="opera.dimensioni" type="text"/>
         <br/><br/>
         Data: <input v-model="opera.data" type="date"/>
         <br/><br/>
         Artista:<select id="artista">
                     <option v-for="(art) in artisti" :key="art.id" :value="`${art.id}`">
                        {{art.nome}} {{art.cognome}}
                     </option>
                  </select>
         <br/><br/>
         Tipo opera:<select id="tipo">
                        <option v-for="(tipo) in tipi" :key="tipo.id" :value="`${tipo.id}`">
                           {{tipo.nome}}
                        </option>
                    </select>
         <br/><br/>
         Luogo:<select id="luogo">
                  <option v-for="(luogo) in luoghi" :key="luogo.id" :value="`${luogo.id}`">
                        {{luogo.luogo}}
                  </option>
               </select>
         <br/><br/>
         <input type="submit" value="INVIA" @click="addOpera()"/>
      </div>
      <br/><br/><br/>
      <div>
         <h3>
               Lista opere:
           </h3>
         <table>
            <tr>
               <th>CODICE UNIVOCO</th>
               <th>NOME</th>
               <th>DIMENSIONI</th>
               <th>DATA</th>
               <th>ARTISTA</th>
               <th>TIPO OPERA</th>
               <th>LUOGO</th>
            </tr>

            <tr  v-for="(op, index) in opere" :key="op.id">
                  <td>
                     <div :class="[`index--${index}`]" style="display: inline;">
                            {{op.codiceUnivoco}}
                        </div>

                        <div :class="[`mostra${index}`]" style="display: none;">
                            <input v-model="op.codiceUnivoco" type="text"/>
                        </div>
                  </td>

                  <td>
                     <div :class="[`index--${index}`]" style="display: inline;">
                            {{op.nome}}
                        </div>

                        <div :class="[`mostra${index}`]" style="display: none;">
                            <input v-model="op.nome" type="text"/>
                        </div>
                  </td>

                  <td>
                     <div :class="[`index--${index}`]" style="display: inline;">
                            {{op.dimensioni}}
                        </div>

                        <div :class="[`mostra${index}`]" style="display: none;">
                            <input v-model="op.dimensioni" type="text"/>
                        </div>
                  </td>

                  <td>
                     <div :class="[`index--${index}`]" style="display: inline;">
                            {{op.data}}
                        </div>

                        <div :class="[`mostra${index}`]" style="display: none;">
                            <input v-model="op.data" type="text"/>
                        </div>
                  </td>

                  <td>
                     <div :class="[`index--${index}`]" style="display: inline;">
                        {{op.artista.nome}} {{op.artista.cognome}}
                     </div>

                     <div :class="[`mostra${index}`]" style="display: none;">
                        <select id="artista2">
                           <option v-for="(art) in artisti" :key="art.id" :value="`${art.id}`">
                              {{art.nome}} {{art.cognome}}
                           </option>
                        </select>
                     </div>
                  </td>

                  <td>
                     <div :class="[`index--${index}`]" style="display: inline;">
                            {{op.tipo.nome}}
                        </div>

                        <div :class="[`mostra${index}`]" style="display: none;">
                           <select id="tipo2">
                              <option v-for="(tipo) in tipi" :key="tipo.id" :value="`${tipo.id}`">
                                 {{tipo.nome}}
                              </option>
                           </select>
                        </div>
                  </td>

                  <td>
                     <div :class="[`index--${index}`]" style="display: inline;">
                        {{op.posizione.luogo}}
                     </div>

                     <div :class="[`mostra${index}`]" style="display: none;">
                        <select id="luogo2">
                           <option v-for="(luogo) in luoghi" :key="luogo.id" :value="`${luogo.id}`">
                                 {{luogo.luogo}}
                           </option>
                        </select>
                     </div>
                  </td>

                  <td>
                        <div :class="[`index--${index}`]">
                            <div>
                                <input type="button" value="MODIFICA" @click="mostranascondi(index)"/>
                            </div>
                            <div>
                                <input type="submit" value="ELIMINA" @click="delArtista(op.id)"/>
                            </div>
                        </div>

                        <div :class="[`mostra${index}`]" style="display: none;">
                            <div>
                                <input type="submit" value="CONFERMA MODIFICA" @click="modArtista(op.id, op.codiceUnivoco, op.nome, op.dimensioni, op.data)"/>
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
            let items= await axios.post("http://localhost:8080/opera/lista");
            this.opere=items.data.listaOpera;

            let items2= await axios.post("http://localhost:8080/artista/lista");
            this.artisti=items2.data.listaArtista;

            let items3= await axios.post("http://localhost:8080/tipo/lista");
            this.tipi=items3.data.listaTipoOPera;

            let items4= await axios.post("http://localhost:8080/posizione/lista");
            this.luoghi=items4.data.listaPosizione;
       },
       data(){
           return{
               opere:[],
               tipi:[],
               artisti:[],
               luoghi:[],
               opera:{}
           }
       },
      methods:{
         addOpera(){
            var select = document.getElementById('artista');
            var select2 = document.getElementById('tipo');
            var select3 = document.getElementById('luogo');

            var artista = select.options[select.selectedIndex].value;
            var tipo = select2.options[select2.selectedIndex].value;
            var luogo = select3.options[select3.selectedIndex].value;

            let operaDaInserire={};
            operaDaInserire.nome = this.opera.nome;
            operaDaInserire.data = this.opera.data;
            operaDaInserire.dimensioni = this.opera.dimensioni;
            operaDaInserire.codiceUnivoco = this.opera.codiceUnivoco;
            operaDaInserire.idPosizione = luogo;
            operaDaInserire.idTipoOpera = tipo;
            operaDaInserire.idArtista = artista;
            axios.post("http://localhost:8080/opera/aggiungi", operaDaInserire)
            .then((response) => {
                    if(response.status==200){
                        location.reload();
                        alert("Opera inserita!!!")
                    }
                })
                .catch(function (error) {
                    if(error.response.status==409){
                            alert("Dati inseriti sono sbagliati!!!")
                    }else if(error.response.status==403){
                        alert("Uno o più campi vuoti!!!")
                    }
                })
         },
         
         delArtista(idT){
            axios.post("http://localhost:8080/opera/elimina",{idOpera: idT})
            location.reload();
            alert("Opera eliminata!!!");
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
         modArtista(idA, cu, n, d, da){
            var select = document.getElementById('artista2');
            var select2 = document.getElementById('tipo2');
            var select3 = document.getElementById('luogo2');

            var artista = select.options[select.selectedIndex].value;
            var tipo = select2.options[select2.selectedIndex].value;
            var luogo = select3.options[select3.selectedIndex].value;

            let artistaModifica={};
            artistaModifica.idOpera = idA;
            artistaModifica.nome = n;
            artistaModifica.data = da;
            artistaModifica.dimensioni = d;
            artistaModifica.codiceUnivoco = cu;
            artistaModifica.idPosizione = luogo;
            artistaModifica.idTipoOpera = tipo;
            artistaModifica.idArtista = artista;
            axios.post("http://localhost:8080/opera/modifica", artistaModifica)
            .then((response) => {
               if(response.status==200){
                  location.reload();
                  alert("Opera modificata!!!")
               }
            })
            .catch(function (error) {
               if(error.response.status==409){
                  alert("Dati inseriti sono sbagliati!!!")
               }else if(error.response.status==403){
                  alert("Uno o più campi sono vuoti!!!")
               }
            })
         }
      }
   }
</script>

<style>

</style>
