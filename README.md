# GestioneMuseo
Piccolo gestionale di un museo con tutte le operazioni CRUD. Fatto con Java e Vue.js

## Cosa installare
In Ordine:
1) [JDK 11](https://www.oracle.com/it/java/technologies/javase/jdk11-archive-downloads.html)
2) [SpringBoot Suite](https://spring.io/tools)
3) [Node.Js](https://nodejs.org/it/download/)
4) [VS Code](https://code.visualstudio.com/download)
5) [MySQL (mysql-installer-community)](https://dev.mysql.com/downloads/installer/)

## Copia repository
```bash
git clone https://github.com/PolpoGiovanna/GestioneMuseo.git
```

## Come avviare il progetto
-Apri il terminale di MySQL e incolla:
```bash
create database museo;
```

-Importa la cartella contenuta dentro'Backend', chiamata 'GestioneMuseo', all'interno di SpringBoot Suite
  1) Aprire il file 'application.properties' situato dentro src/main/resources
  
  2) Modificare le credenziali in base a quelle che avete messo per accedere alla bash di MySQL e al percorso del databse (se avete lasciato tutto invariato per quanto riguarda il percorso di MySQL modificate solo le credenziali!!!)
  
  3) Avvia il progetto con il tasto verde trinagolare

-Aprire la cartella Frontend e trascinare la cartella 'vue-frontend' sopra l'icona di VS Code

  1) Premere il tasto di confermare della sicurezza del progetto
  
  2) Aprire un terminale e incollare:
  ```bash
  npm install
  ```
  
  3) Appena finita l'installazione incollare nel terminale:
  ```bash
  npm run serve -- --port 8081
  ```
  
  4) Ctrl + click su  ' http://localhost:8081/ '
# BUON DIVERTIMENTO :)
