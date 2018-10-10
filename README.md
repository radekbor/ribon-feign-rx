# Cloud plays - ribon && feign && rx

Current configuration when run via docker

- BooksApplication:
    - 172.18.0.2
    - 172.18.0.3
    
- CustomerApplication:
    - 172.18.0.4

- GatewayApplication:
    - 172.18.0.5
 
- Zipkin server
    - 172.18.0.9:9411

Please run 

1) curl -i http://localhost:8084/customer/details/1

2) Go to http://localhost:9411/zipkin/
