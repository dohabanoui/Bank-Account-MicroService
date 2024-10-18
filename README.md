# Microservice de Gestion des Comptes Bancaires

Ce projet est un microservice développé avec Spring Boot permettant de gérer des comptes bancaires. Il intègre des services `RESTful` ainsi que des endpoints `GraphQL` pour effectuer des opérations liées aux comptes bancaires. Le microservice a été testé avec `Postman` et la documentation des API a été générée avec `Swagger`.

## Table des Matières
- [Fonctionnalités](#fonctionnalités)
- [Technologies Utilisées](#technologies-utilisées)
- [Instructions d'Installation](#instructions-dinstallation)
- [Utilisation](#utilisation)
- [Endpoints de l'API](#endpoints-de-lapi)
- [Utilisation de GraphQL](#utilisation-de-graphql)

## Fonctionnalités
- Services web RESTful pour la gestion des comptes bancaires.
- Opérations CRUD sur les comptes et les clients.
- Intégration de GraphQL pour gérer les requêtes et mutations.
- Base de données H2 en mémoire pour le développement et les tests.
- Documentation de l'API avec Swagger.
- Utilisation de projections pour limiter les champs retournés.

## Technologies Utilisées
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database**
- **Lombok**
- **GraphQL**
- **Swagger**
- **Postman (pour les tests)**

## Instructions d'Installation

### 1. Créer un projet Spring Boot
Utilisez [start.spring.io](https://start.spring.io/) pour générer votre projet avec les dépendances suivantes :
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- GraphQL

![Configuration du projet](./pictures/projet.png)


### 2. Exécution de l'application
Lancez l'application et accédez à la console H2 via l'URL : `http://localhost:8081/h2-console`. Indiquez le nom de la base de données spécifié dans `application.properties`.

![Console H2](./pictures/affichage.png)
![](./pictures/affichage1.png)


### 3. Documentation de l'API
Accédez à la documentation Swagger via l'URL : `http://localhost:8081/swagger-ui/index.html`.

![Swagger UI](./pictures/affichage2.png)

## Utilisation

### Endpoints RESTful
- **GET** tous les comptes : `http://localhost:8081/v3/api-docs`
  ![](./pictures/get.png)
   ![](./pictures/postman.png)
- **POST** un nouveau compte :
  ![](./pictures/post.png)

Vous pouvez tester ces endpoints à l'aide de Postman.
### Projection
pour afficher seulement les attributs ce qu’on veut et pour la recherche on met : `http://localhost:8081/bankAccounts?projection=p1`
dans ce cas nous voulons seulement afficher `id` et le `type`
![](./pictures/projection.png)
si on ajoute une méthode dans le repository et on veut faire la recherche 
![](./pictures/search.png)

### Utilisation de GraphQL
1. Accédez à l'interface GraphiQL via `http://localhost:8081/graphiql`.
2. Testez les requêtes et mutations pour gérer les comptes.
![](./pictures/graphQl.png)
![](./pictures/graphQlId.png)
![](./pictures/mutation.png)
![](./pictures/definitParametrs.png)
![](./pictures/affichageCustomer.png)






