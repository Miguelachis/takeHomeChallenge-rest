Miguel Cachia take-home challenge
Note: please find the Postman calls in the Miguel Cachia take-home challenge.postman_collection.json file.

QA.
In this project, I used the Spring Framework with Maven as the build automation and dependency management tool. Spring was chosen due to its simplistic design,
lightweight nature, and the ability to build an MVC (Model-View-Controller) design project. I am mostly familiar with this design pattern due to my experience 
in .NET, where I worked on building MVC projects. Additionally, Spring's core concept of Dependency Injection made it easier to implement dependency injection
in this project.
Given the nature of this task, I decided to use the H2 database. The reasoning behind this decision is because it has a quick setup process, making it easier 
to run without requiring too much database configuration. It is also lightweight and fast, which suited the needs of the project.

The structure of the project follows the MVC design pattern. For the data layer, I implemented a Repository that uses Entity objects. The repository class was derived
from JpaRepository. This decision was made due to JpaRepository's out-of-the-box functionality, its ease of implementation, and the ability to create custom queries. 
For instance, I created a custom query to retrieve all the accreditations for a user. This approach was chosen because custom queries run directly at the SQL level, 
making them faster by fetching only the requested data rather than loading and filtering everything in memory. The results were then mapped directly into the custom 
DTO (Data Transfer Object) I created.
The service layer utilizes interfaces as this pattern allows for flexibility. This means that if I needed to change the implementation of the logic, I wouldn't have 
to refactor the entire project; I would only need to modify the service class and adjust which implementation class is used. This approach is also suitable for functional 
methods that require different logic to achieve the same outcome.
The view component, which I labeled as the controller, acts as the front-facing layer where the API endpoints are exposed. I used @RestController for this layer due 
to its simplicity in API development. It is specifically designed for RESTful API development, supports easy integration with HTTP status codes (e.g., returning 200 OK or other custom responses), 
and allows effortless use of variables and query parameters. This makes it easy to pass data via the URL or request body.

QB.
Audit logs can be implemented in many ways. One approach is to use Spring AOP (Aspect-Oriented Programming). This feature allows you to create functions that run automatically when a service 
(data layer) is executed. These functions can run either before or after the service method is invoked. The main benefit of this approach is that the code is standardized and can be reused in
the specified service. Additionally, it requires minimal changes to implement, making it efficient. Note that this approach is based on Spring’s design principles.
Another way to implement audit logs is on the SQL side, by creating a stored procedure that inserts data into both the object table and an audit table. This method ensures that all relevant
changes are tracked directly in the database.

QC.
To improve performance, a load balancer can be used to distribute traffic across multiple instances of a server. Different types of load balancers include hardware load balancers, where a 
physical device handles the distribution of traffic. This method is the most efficient but also the most expensive. A second option is to use cloud load balancers, such as those provided 
by Microsoft Azure. These handle incoming traffic through a managed service offered by the cloud provider, making them a cost-effective and scalable alternative.
