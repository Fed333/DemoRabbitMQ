# RappidClothes Microservices Application
RappidClothes is an Order Processing System built on microservice architecture of manufacturing and selling different kind of clothes.

## Clothes categories
* Shoes
* Pants
* Outwear
* Hats

## Service roles
* Manufactures
* Distributors

### Manufactures
- Design clothes line
- Take orders from distributors
- Produce clothes

### Distributors
- Order required clothes from manufactures
- Take orders from target clients
- Sell purchased clothes

## List of microservice applications
### Manufactures
- **Nike**:
  * Shoes
- **Adidas**:
  * Shoes
  * Pants
- **Columbia**:
  * Outwear
- **Gap**:
  * Hats

### Distributors
- **Lids**:
  * Gap - hats
- **Footlocker**:
  * Nike - shoes
  * Adidas - pants, shoes
- **Intertop**:
  * Columbia - outwear
  * Adidas - pants

## Technologies
RappidClothes uses a variety of technologies to implement the microservice architecture:

- Microservices: Individual services for each manufacturer and distributor, programmed with their specific responsibilities and logic.
- RabbitMQ: Message broker that enables asynchronous communication between the manufacturer and distributor services.
- Docker: Containerization of the microservices to enable isolated, scalable, and easily deployable services.
- Docker Compose: Simplification of the Docker container deployment process through the use of a unified configuration file (docker-compose.yml).

Each manufacturer and distributor service may use different databases, depending on the needs of the specific microservice application.

## Launch
The application is docker containerized. There is the configuration in `docker-compose.yml` file.<br>
To launch the application run `docker-compose up --build`
