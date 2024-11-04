# california charlie's
Hello and welcome to California Charlie's Used Car Lot of Psycho fame. Here you will find a spring boot project for handling all your used car needs without having to worry about a police officer watching from across the street and breathing down your neck.

# setup
There are three microservices that involved here: Car, Order, and Inventory. 

## car service
The car microservice is responsible for dealing with individual cars and their specifications. Details are stored in a NoSQL database, which needs to be configured in [application.properties](car-service/src/main/resources/application.properties). I am using MongoDB for this service.
### cars
| Field       | Type     |
| ----------- | -------- |
| _id         | ObjectId |
| model       | string   |
| description | string   |
| price       | string   |

## order service
The order microservice is responsible for handling incoming car orders. Each car is a single, solitary, one-of-a-kind vehicle; however, when one has $40,000 in their back-pocket, one may wish to purchase multiple vehicles. Orders comprise of a list of vehicles to be purchased, and are stored in a MySQL database, which must be configured in [application.properties](order-service/src/main/resources/application.properties).
### orders
| Field        | Type   | Null |
| ------------ | ------ | ---- |
| id           | int    | No   |
| order_number | string | No   |

### order_items
| Field | Type    | Null |
| ----- | ------- | ---- |
| id    | int     | No   |
| price | decimal | Yes  |
| unit  | string  | Yes  |

## inventory service
