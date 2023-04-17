# Excuses de développeur

## Présentation

Excuses est un projet de test technique pour l'entreprise Symbol-IT. Il s'agit d'une application fullstack avec un frontend en React et un backend en Spring Boot.

## Objectif

L'objectif du projet est de fournir une application qui génère des excuses pour les utilisateurs. L'application propose plusieurs catégories d'excuses, ainsi que la possibilité de soumettre de nouvelles excuses via le backend.

## Configuration requise

- Java 17 ou supérieur
- Maven

## Lancement de l'application

Pour lancer l'application, vous pouvez utiliser la commande suivante:

```bash
mvn spring-boot:run
```

L'application sera accessible à l'adresse http://localhost:8080.

## Tests
Les tests de l'application sont écrits avec JUnit et peuvent être exécutés avec la commande suivante:

```bash
mvn test
```

J'ai aussi fais des tests de requêtes HTTP avec Postman.

## Technologies utilisées

- Java 17
- Spring Boot
- H2 Database Engine
- Maven
- JUnit

## Plus d'informations

- Base de donnée automatiquement créé grâce à JPA et Hibernate.
- Les données sont stockées localement dans la mémoire avec h2.
- Le projet possède un fichier json avec lequel on initialise la base de donnée.

## Problème

La requête HTTP Post écrase l'ancienne donnée s'il ont le même ID.

## Auteur

Robin Hotton - [Github](https://github.com/Gerob59)
