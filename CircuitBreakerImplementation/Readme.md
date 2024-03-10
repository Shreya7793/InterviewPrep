States:

Closed - Service is healthy and all requests are served
Open - Service is unhealthy and no request is served
Partially-Open - Service transitioned from unhealthy to healthy and few requests are served

Foo is a Proxy that implements the Circuit Breaker design pattern and maintains the above-said states.

