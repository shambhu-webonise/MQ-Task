# MQ-Task (Producer module)
This is a web project having interface to write message and submit to the server. Server is integrated with all required configuration for Active MQ.

##prerequisites
- Java 8
- Maven 3+
- App server (tomcat, tomee, glassfish, jetty etc)
- Active MQ 5.12.0 (currently tested with version 5.12, can work on other version)

##Setup & Run
1. Clone the repository
2. navigate to the MQ-Task directory (project home directory)
3. Build by using maven (mvn clean install)
4. Rename warfile to "mq"
5. Run the app server
6. Deploy the war file to server
7. Open the application in browser e.g http://localhost:8080/mq
8. Insert the message and submit


OR

This can be import into the Eclipse or STS by following steps
1. clone the repository
2. import the project as maven project
3. integrate Tomcat to Eclipse.STS or any other app server
4. Run on sever
5. Open the application in browser e.g http://localhost:8080/mq
6. Insert the message and submit

The message submitted will be enqued to the ACTIVE MQ. One can verify on Active MQ Admin Console
@ http://localhost:8161/admin/queues.jsp 

