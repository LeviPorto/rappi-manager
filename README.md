# RAPPI-MANAGER

## Motivation

To isolate principal entities of rappi (like restaurants, foods, promotions...), rappi-manager was 
created. To isolate principal entities domain, in objective of safe database store, we saw 
necessity of create this micro-service, using SQL database, instead of NO-SQL, because of the
importance of integrity of those entities.

# Domain

There are a big domain: Combo, ComboItem, DeliveryMan, Food, Promotion, PromotionItem, Restaurant and User.
Each entity has strongly relation each other, see code to get more information

# Architecture and Technologies

rappi-manager is a micro-service, that is discovered by Eureka, to communicate with 
others micro-services. Made in Java, feign to communicate with others micro-services, kafka to produce and cosume
messages, redis to cache, MySql to store data. This micro-service uses event-driven 
pattern to communicate with others micro-services. This micro-service use a little bit of Java 
Reflection, also

# Flux

Base end point is {host}/manager/. To test, we considering localhost.
 
* We can send pattern REST request to CRUD (POST, GET, PUT, DELETE) each domain entity (save, update, findById, findAll, delete)
in (Combo, ComboItem, DeliveryMan, Food, Promotion, PromotionItem, Restaurant and User). 
See a code to get more information
* We can find combos, foods and promotions by restaurant, sending GET/POST (depending of entity) manager/{entity}/{restaurantId}.
* We can find filtered combos, promotions, foods and restaurants, sending GET {entity}/search.
In combos, foods and promotions, we pass userCity, userId and searchedName in request parameter, but
in restaurant, we pass, in a request body, search entity, to get restaurants dynamically filtered
* We can find deliverers of any restaurant that is WAITING_ACCEPTANCE for job, to manager of restaurant
accept that order, sending GET deliveryMan/{restaurantId}/waitingAcceptance
* We can accept job, that manager of restaurant send to delivery man begin any deliverer of any order,
sending PUT to /{id}/acceptJob.
* We can find restaurant by delivery man, sending GET to /restaurant/deliveryMan/{deliveryManId}

# Dependencies

* RAPPI-EUREKA
* RAPPI-CONFIG
* RAPPI-DELIVERER
* RAPPI-EVALUATOR
* RAPPI-TRACKER
* Redis
* Kafka
* Mongo
