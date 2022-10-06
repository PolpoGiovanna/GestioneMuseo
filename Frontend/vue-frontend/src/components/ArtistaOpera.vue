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
            <h3>Aggiungi artista</h3>
            Nome: <input v-model="artista.nome" type="text"/>
            <br/><br/>
            Cognome: <input v-model="artista.cognome" type="text"/>
            <br/><br/>
            Data di Nascita: <input v-model="artista.dataNascita" type="date"/>
            <br/><br/>
            Data di morte: <input v-model="artista.dataMorte" type="date"/>
            <br/><br/>
            <input type="submit" value="INVIA" @click="addArtista"/>
        </div>
        <div id="listaArt" > 
            <h3>
                Lista artisti:
            </h3>
            <table style="width: 95%;">
                <tr>
                    <th>NOME</th>
                    <th>COGNOME</th>
                    <th>DATA DI NASCITA</th>
                    <th>DATA DI MORTE</th>
                </tr>
                <tr v-for="(art, index) in artisti" :key="art.id" >
                    <td>
                        <div :class="[`index--${index}`]" style="display: inline;">
                            {{art.nome}}
                        </div>

                        <div :class="[`mostra${index}`]" style="display: none;">
                            <input v-model="art.nome" type="text"/>
                        </div>
                    </td>
                    <td>
                        <div :class="[`index--${index}`]" style="display: inline;">
                            {{art.cognome}}
                        </div>

                        <div :class="[`mostra${index}`]" style="display: none;">
                            <input v-model="art.cognome" type="text"/>
                        </div>
                    </td>
                    <td>
                        <div :class="[`index--${index}`]" style="display: inline;">
                            {{art.dataNascita}}
                        </div>

                        <div :class="[`mostra${index}`]" style="display: none;"> 
                            <input v-model="art.dataNascita" type="date"/>
                        </div>
                    </td>
                    <td>
                        <div :class="[`index--${index}`]" style="display: inline;">
                            {{art.dataMorte}}
                        </div>

                        <div :class="[`mostra${index}`]" style="display: none;">
                            <input v-model="art.dataMorte" type="date"/>
                        </div>
                    </td>
                    <td>
                        <div :class="[`index--${index}`]">
                            <div>
                                <input type="button" value="MODIFICA" @click="mostranascondi(index)"/>
                            </div>
                            <div>
                                <input type="submit" value="ELIMINA" @click="delArtista(art.id)"/>
                            </div>
                        </div>

                        <div :class="[`mostra${index}`]" style="display: none;">
                            <div>
                                <input type="submit" value="CONFERMA MODIFICA" @click="modArtista(art.id, art.nome, art.cognome,
                                                                                                  art.dataNascita, art.dataMorte)"/>
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
            let items= await axios.post("http://localhost:8080/artista/lista");
            this.artisti=items.data.listaArtista;
        },
        data(){
            return{
                artista:{},
                artisti:[]
            }
        },
        methods:{
            addArtista(){
                let artistaDaInserire={};
                artistaDaInserire.nome = this.artista.nome;
                if(this.artista.cognome==null){
                    artistaDaInserire.cognome = " "
                }else{
                    artistaDaInserire.cognome = this.artista.cognome;
                }
                artistaDaInserire.dataNascita = this.artista.dataNascita;
                artistaDaInserire.dataMorte = this.artista.dataMorte;
                axios.post("http://localhost:8080/artista/inserisci", artistaDaInserire)
                .then((response) => {
                    if(response.status==200){
                        location.reload();
                        alert("Artista inserito!!!")
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

            delArtista(idA){
                axios.post("http://localhost:8080/artista/elimina",{id: idA})
                location.reload();
                alert("Artista eliminato!!!")
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
            modArtista(idA, nomeA, cognomeA, datanA, datamA){
                let artistaModifica={};
                artistaModifica.id = idA;
                artistaModifica.nome = nomeA;
                if(cognomeA==null){
                    artistaModifica.cognome = " ";
                }else{
                    artistaModifica.cognome = cognomeA;
                }
                artistaModifica.dataNascita = datanA;
                artistaModifica.dataMorte = datamA;
                axios.post("http://localhost:8080/artista/modifica", artistaModifica)
                .then((response) => {
                    if(response.status==200){
                        location.reload();
                        alert("Artista modificato!!!")
                    }
                })
                .catch(function (error) {
                    if(error.response.status==409){
                            alert("Dati inseriti sono sbagliati!!!")
                    }else if(error.response.status==403){
                        alert("Uno o più campi obbligatori sono vuoti!!!")
                    }
                })
            }
        }
    }
 </script>
 
<style>
    table{
        border:1px solid black;
        text-align: center;
        margin-left: auto;
        margin-right: auto;
    }
    h2, h3{
        text-align: center;
    }
    #cont2{
        font-size: 20px;
    }
    #nav2{
        margin-right: auto;
        margin-left: auto;
        text-align: center;
        font-size: 50px;
    }
</style>
 