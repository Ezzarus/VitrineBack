# Dépôt du Back-end du Projet de fin d'études Vitrine interactive

## Master 2 E-Services 2020/2021

Cette partie de l'application est développée en Java avec le framework Spring-Boot.

### Documentation Technique

Pour lancer l'application: 
- Aller dans le dossier api
- sudo ./mvnw clean spring-boot:run

#### Configuration

Version de Java: 11

Version de Maven: 3.6.0

Vous pouvez changer le port de l'application en changeant la valeur **server.port** dans le fichier src/main/resources/**application.properties**.

Les configurations liées à la base de données sont dans le fichier src/main/resources/**application.properties**.

#### Code

##### API

Les classes du package **model** sont les tables de la base de données (à savoir que le type de base de données utilisé n'a rien à voir avec le code de l'application).

Les classes du package **repository** permettent d'accéder à la base de données via l'utilisation de méthodes Java (sauf volonté de personnalisation, **l'écriture de requêtes SQL n'est pas nécessaire**).

Les classes du package **controller** permettent de réceptionner les appels HTTP. Les verbes acceptés sont définis via une annonation au dessus de chaque fonction. 
Le corps des appels est défini avec l'annotation **@RequestBody** dans les paramètres de la fonction appelée. 
Les variables dans les URL (comme des id par exemple) sont mis entre accolades dans le chemin de la fonction et sont définies avec l'annotation **@PathVariable** dans les paramètres de la fonction appelée.
Les routes utilisables de l'API sont celles du CRUD (Create, Read, Update, Delete) et une qui permet de retirer seuleemnt un produit du stock.

Les classes du package **service** permettent de faire le lien entre les controllers et les repository, et éventuellement de modifier/filtrer les données pendant la transmission de celles-ci.

La classe **ApiApplication** est la classe qui permet de lancer l'application.

##### Converter

La classe **CurrencyConverter** est la classe ou les prix en euro sont convertis dans d'autres devises selon le taux actuellement en vigueur. Le taux est mis à jour via un appel à une API se basant sur les taux de la Banque Centrale Européenne (plus d'infos ici: https://exchangeratesapi.io).

La classe **RatesPOJO** sert à récupérer la réponse de l'API utilisée par CurrencyConverter et à fournir le taux sous forme de float.

##### Tester l'application

L'API peut être testée en lançant l'application et en important la collection **pfe Product.postman_collection.json** dans Postman.

### Problèmes connus

Cette partie de l'application ne possède aucune sécurité, n'importe qui peut faire des requêtes dessus.

La modification d'un produit implique de réécrire tous les champs du produit dans l'appel, sinon seuls les champs renseignés et l'id seront enregistrés et les autres données perdues.

### Travail pouvant encore être effectué

Ajout de la sécurité à l'application.

Un envoi des données selon la langue utilisée peut être implémenté selon l'URL utilisée.

Ajouter plus de monnaies à l'application (suivre le modèle de la méthode **convert_EUR_to_USD** peut être utile).
