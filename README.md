# Activité Pratique N°1 - Développement d'un micro-service

## Description
Ce projet est un microservice de gestion de comptes bancaires et de clients, développé avec Spring Boot. Il inclut des fonctionnalités pour créer, mettre à jour, supprimer et consulter des comptes bancaires et des clients via des API REST et GraphQL.

## Prérequis
- Java 17 ou supérieur
- Maven 3.6 ou supérieur
- IDE (IntelliJ IDEA recommandé)

## Installation
1. Clonez le dépôt:
    ```sh
    git clone https://github.com/Lee4real/dev-micro-service-tp1.git
    cd dev-micro-service-tp1
    ```

2. Compilez le projet avec Maven:
    ```sh
    mvn clean install
    ```

3. Démarrez l'application:
    ```sh
    mvn spring-boot:run
    ```

## Utilisation
### API REST
- **Obtenir tous les comptes bancaires:**
    ```sh
    GET /accounts
    ```

- **Obtenir un compte bancaire par numéro:**
    ```sh
    GET /accounts/{accountNumber}
    ```

- **Créer un nouveau compte bancaire:**
    ```sh
    POST /BankAccounts
    ```
  Exemple de corps de requête:
    ```json
    {
        "balance": 1000.0,
        "currency": "USD",
        "type": "CURRENT_ACCOUNT"
    }
    ```

- **Mettre à jour un compte bancaire:**
    ```sh
    PUT /BankAccounts/{accountNumber}
    ```
  Exemple de corps de requête:
    ```json
    {
        "balance": 2000.0,
        "currency": "EUR",
        "type": "SAVINGS_ACCOUNT"
    }
    ```

- **Supprimer un compte bancaire:**
    ```sh
    DELETE /BankAccounts/{accountNumber}
    ```

### API GraphQL
- **Obtenir tous les comptes bancaires:**
    ```graphql
    query {
        accounts {
            accountNumber
            createdAt
            balance
            currency
            type
            customer {
                id
                name
            }
        }
    }
    ```

- **Obtenir un compte bancaire par ID:**
    ```graphql
    query {
        bankAccountById(id: "some-id") {
            accountNumber
            createdAt
            balance
            currency
            type
            customer {
                id
                name
            }
        }
    }
    ```

- **Ajouter un nouveau compte bancaire:**
    ```graphql
    mutation {
        addAccount(bankAccount: {
            balance: 1000.0,
            currency: "USD",
            type: "CURRENT_ACCOUNT"
        }) {
            accountNumber
            createdAt
            balance
            currency
            type
        }
    }
    ```

- **Mettre à jour un compte bancaire:**
    ```graphql
    mutation {
        updateAccount(id: "some-id", bankAccount: {
            balance: 2000.0,
            currency: "EUR",
            type: "SAVINGS_ACCOUNT"
        }) {
            accountNumber
            createdAt
            balance
            currency
            type
        }
    }
    ```

- **Supprimer un compte bancaire:**
    ```graphql
    mutation {
        deleteAccount(id: "some-id")
    }
    ```

## Structure du Projet
- `src/main/java/ma/enset/devmicroservicetp1/DevMicroServiceTp1Application.java`: Point d'entrée de l'application.
- `src/main/java/ma/enset/devmicroservicetp1/entities/`: Contient les entités JPA.
- `src/main/java/ma/enset/devmicroservicetp1/repositories/`: Contient les interfaces des repositories JPA.
- `src/main/java/ma/enset/devmicroservicetp1/services/`: Contient les services de l'application.
- `src/main/java/ma/enset/devmicroservicetp1/web/`: Contient les contrôleurs REST et GraphQL.
- `src/main/resources/graphql/schema.graphqls`: Définition du schéma GraphQL.

## Auteur
Lee4real

## Licence
Ce projet est sous licence MIT.