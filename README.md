# Saga orchestrator microservice
This project intends to be a generic implementation of the [orchestration-based saga pattern](https://microservices.io/patterns/data/saga.html) as an independent microservice that you can plug into your projects.

It exposes the [eventuate-tram library](https://github.com/eventuate-tram/eventuate-tram-sagas) through a RESTful interface and allows the developers to create sagas by creating a data structure and saving it on the orchestrator microservice. After the saga is created, it can be triggered and will run to completion or, if it fails, will revert all transactions.

## Learn more

### Helpful articles
* [Azure design patterns - Saga distributed transactions pattern](https://docs.microsoft.com/en-us/azure/architecture/reference-architectures/saga/saga)
* [Microservices.io - Pattern: Saga](https://microservices.io/patterns/data/saga.html)

### Libs that implements the saga pattern
* [Java - Eventuate Tram (referenced on the chapter 4 of Microservices Patterns book)](https://github.com/eventuate-tram/eventuate-tram-sagas)
* [Elixir - Sage (Pure Elixir implementation of the pattern)](https://github.com/Nebo15/sage)

### Books
* [Manning - Microservices patterns](https://www.manning.com/books/microservices-patterns)
