# Getting Started
Projeto de estudo implementado seguindo dois cursos específicos da [Alura](https://www.alura.com.br/)
* [Microservices com Spring Cloud: Registry, Config Server e Distributed Tracing](https://cursos.alura.com.br/course/microservices-spring-cloud-service-registry-config-server)
* [Microservices com Spring Cloud: Circuit Breaker, Hystrix e API Gateway](https://cursos.alura.com.br/course/microservices-spring-cloud-circuit-breaker-api-gateway)

### Funcionalidades estudadas e implementadas no projeto
- RestTemplate para executar requisições http
- CrudRepository para criação de repositórios
- Utilização da anotação @Repository
- [Service Discovery](https://spring.io/guides/gs/service-registration-and-discovery/) com Eureka Server e Eureka Client
- [Spring Cloud Config Server](https://cloud.spring.io/spring-cloud-config/reference/html/) para organizar e centralizar as configurações locais externos ao projeto (tanto no sistema de arquivos quanto no git)
- [Client Side Load Balancing (CSLB)](https://spring.io/guides/gs/client-side-load-balancing/), através das anotações @LoadBalanced na criação do @Bean de um RestTemplate. Como implementação do CSLB foi utilizado o projeto Ribbon que faz parte do [Spring Cloud Netflix](https://spring.io/projects/spring-cloud-netflix).
- [Spring Feign](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html) como alternativa ao RestTemplate para simplificação de chamadas HTTP. Ele exige apenas uma interface com a definição e mapeamento dos métodos que executarão a requisição. A implementação é gerada pelo próprio Spring Feign.
- Uso do Spring Sleuth para gerar rastreabilidade de logs distribuídos usando junto com o agregador de logs [papertrail](https://www.papertrail.com/)

### Insights
- Projeto atualmente utiliza o MariaDB. *Mudar para um banco em memória assim que possível*.
- [*Anotações Particulares*](https://docs.google.com/document/d/1sJFI5JYPc9hKKCoQTVgRIni93JC1qe3EI10H_xlIlng/edit)

