<template>
    <div>
        <div id="titolo">
            <h1>
                BENVENUTO
            </h1>
            <hr/>
        </div>
        <div id="sottotitolo"> 
            <h4>
                Scegli che sezione vuoi gestire
            </h4>
        </div>
        <div id="nav">
            |<router-link to="/artista">Artista</router-link> |
            <router-link to="/tipo">Tipo Opera</router-link> |
            <router-link to="/luogo">Luogo</router-link> |
            <router-link to="/opera">Opera</router-link>|
        </div>
        <div id="pie">
            <hr/>
            <h5> 
                piedipagina
            </h5>
        </div>
    </div>
</template>

<script>
    export default {
   
}
</script>

<style>
#nav{
    text-align: center;
    font-size: 50px;
    margin-bottom: 280px ;
    margin-top: 250px;
}
#titolo, #sottotitolo{
    text-align: center;
    font-size: 30px;
}
#pie {
   margin-top: 17%;
   text-align: center;
}
</style>
