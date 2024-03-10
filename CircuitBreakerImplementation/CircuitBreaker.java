//package CircuitBreakerImplementation;
//
//public class CircuitBreaker {
//    public static CircuitBreaker circuitBreaker;
//    int failureThreshold;
//    Long coolOffPeriod;
//    int failureCount;
//    boolean isOpen;
//
//    Service service;
//    private CircuitBreaker(){
//        this.failureThreshold=ApplicationConstants.DEFAULT_FAILURE_THRESHOLD; //taken from application.properties
//        this.coolOffPeriod=Long.valueOf(ApplicationConstants.DEFAULT_COOLOFF_PERIOD); //taken from application.properties
//        this.isOpen=false;
//        service=new Service();
//    }
//    public static CircuitBreaker getInstance(){
//        if(circuitBreaker ==null){
//            synchronized (CircuitBreaker.class){
//                if(circuitBreaker ==null)
//                    circuitBreaker =new CircuitBreaker();
//            }
//        }
//        return circuitBreaker;
//    }
//
//    synchronized void recordSuccess(){
//
//    }
//    synchronized void recordFailures(){
//        ++failureCount;
//        if(failureCount>=failureThreshold)
//            isOpen=true;
//    }
//
//    synchronized boolean allowRequest(){
//        return !isOpen;
//    }
//
//    synchronized void reset(){
//        failureCount=0;
//        isOpen=false;
//    }
//
//    void callService(){
//        if(service.serviceMethod();
//            th
//    }
//
//}
