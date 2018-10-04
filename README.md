# Cloud plays - ribon && feign && rx

Current configuration

- BooksApplication, ports:
    - 8081
    - 8081
    
- CustomerApplication, ports:
    - 8083

- GatewayApplication, ports:
    - 8080
 
- Zipkin server, port: 9411

Please run 

1) curl -i http://localhost:8080/customer/1

2) Go to http://localhost:9411/zipkin/
