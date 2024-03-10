//package CircuitBreakerImplementation;
//
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//
//public class Proxy {
//
//    Service service;
//    LocalDateTime proxyCallingTime;
//    LocalDateTime proxyServingTime;
//
//    void serviceMethod(CircuitBreaker circuitBreaker){
//        proxyCallingTime = LocalDateTime.now();
//        if(circuitBreaker.isOpen && circuitBreaker.failureCount>=circuitBreaker.failureThreshold) {
//            service.serviceMethod();
//
//        }
//    }
//
//
//
//
//}
