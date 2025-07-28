# Employee Service - Microservices Architecture

This project is a part of a microservices-based architecture demonstrating inter-service communication. The **Employee Service** consumes the **Address Service** using REST, and service discovery is handled via **Eureka Server** for load balancing and dynamic service lookup.

---

## 🧩 Project Structure

- **Employee Service**
  - Exposes REST APIs to fetch employee details.
  - Calls Address Service to enrich employee data with address.
- **Address Service**
  - Provides address information for employees.
- **Eureka Server**
  - Acts as a service registry for discovery and load balancing.

---

## 🚀 Technologies Used

- Java 17+
- Spring Boot
- Spring Cloud Netflix Eureka
- REST APIs
- Maven

---

## ⚙️ How It Works

1. **Service Registration**  
   Both Employee and Address services register themselves with the Eureka Server at startup.

2. **Service Discovery**  
   Employee Service looks up the Address Service using the Eureka registry instead of a hard-coded URL.

3. **Load Balancing**  
   Eureka provides basic round-robin load balancing when multiple instances of Address Service are registered.

4. **REST Communication**  
   Employee Service communicates with Address Service using `RestTemplate` or `WebClient` with service discovery.

---

## 🏁 Getting Started

### Prerequisites

- JDK 17+
- Maven 3.6+
- Git

### Clone the Repository

```bash
git clone https://github.com/ak011096/microservices.git
