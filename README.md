# microservices
Monolithic:
-----------
Monolithic applications are built as a single unit where all it's functionality deployed together inside a single server.We call this arhitecture approach as Monolithic.
Developers work with a single code base which is then packaged as EAR/WAR and deployed into single web/application server.
The entire application uses single database.

Monolithic applications are built as a single unit that includes all of the different components of the application, including APIs, services, databases, load balancers and so forth


Pros:
a. Simpler developement & deployment for smaller teams and applications.
b. Can implement fewer cross cutting concerns.
c. Performance is high due to no netork latency.

Cons:
a.Single code base and difficult to maintain.
b.Difficult to adopt new technologies
c.Not fault tolerance.
d.For any small change , need a full deployment.


