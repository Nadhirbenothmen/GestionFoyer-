# Application de Gestion des Foyers



Cette application est conçue pour gérer les foyers, avec des fonctionnalités permettant d'enregistrer, de modifier, de supprimer et de consulter les informations des résidents et des foyers. L'application est développée avec Spring Boot et utilise MySQL pour la gestion des données, accessible via phpMyAdmin. Postman est utilisé pour tester les API RESTful.


## Fonctionnalités 
- **Ajout de Résidents** : Créez de nouveaux résidents avec leurs informations personnelles.
- **Gestion des Foyers** : Créez, mettez à jour et supprimez des foyers.
- **Recherche des Résidents** : Recherchez des résidents par foyer, nom ou date d'inscription.
- **Gestion des Paiements** : Suivi des paiements mensuels pour chaque résident.
- **Rapports** : Génération de rapports sur les foyers et les paiements.

## Architecture
- **Spring Boot** : Framework backend utilisé pour créer les API RESTful.
- **MySQL** : Base de données pour stocker les informations des foyers et des résidents, gérée via phpMyAdmin.
- **Postman** : Utilisé pour tester les endpoints de l'API.

## Prérequis
- **Java** : Version 11 ou plus récente.
- **Spring Boot** : Version 2.5 ou plus récente.
- **MySQL** : Version 5.7 ou plus récente.
- **phpMyAdmin** : Pour la gestion de la base de données.
- **Postman** : Pour tester les API.

## Installation
1. **Clonez le dépôt :**
   ```bash
   git clone https://github.com/nom-utilisateur/gestion-des-foyers.git
   cd gestion-des-foyers
