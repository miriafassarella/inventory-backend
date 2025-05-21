# Inventaire d'Équipements Informatiques

Ce projet est une application **backend** développée avec **Java** et le framework **Spring Boot**, utilisant **Maven** comme outil de gestion de dépendances. Le projet a pour objectif de permettre un suivi rigoureux du matériel (ordinateurs, accessoires, etc.), en facilitant l’inventaire, la mise à jour des informations et le contrôle d’accès selon le rôle des utilisateurs.

🔗 **Application déployée en production (hébergement AWS) :**  
👉 [http://3.95.208.110/login]

## ✅ Technologies utilisées

- Java 17+
- Spring Boot
- Maven
- Spring Web
- Spring Data JPA
- Spring Security
- JWT
- MySQL
- Flyway
- Lombok

## 📦 Structure du projet
```text
src/
 └── main/
     ├── java/
     │   └── inventory/api/
     │       ├── confi.property/
     │       ├── controller/
     │       ├── core.config/
     │       ├── cors/
     │       ├── domain/
     │       ├── handler/
     │       ├── model/
     │       ├── security/
     │       └── token/
     └── resources/
         ├── db.migration/
         └── application.properties

```

## 🚀 Comment exécuter le projet

### Prérequis

Avant de lancer le projet, vous devez avoir installé :

- [Java JDK 17+](https://adoptium.net/)
- [Maven 3.8+](https://maven.apache.org/)
- Une base de données (MySQL)

---

### Étapes :

1. **Cloner le dépôt :**

   ```bash
   git clone https://github.com/miriafassarella/inventory-backend.git
   cd inventory-backend

---

2. **Configurer la base de données :**

## ⚙️ Configuration de la base de données

Le fichier `application.properties` doit contenir les paramètres suivants :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nom_de_la_base
spring.datasource.username=utilisateur
spring.datasource.password=motdepasse
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
---