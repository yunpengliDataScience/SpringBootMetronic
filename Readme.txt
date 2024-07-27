To access application:
http://localhost:8082/SpringBootMetronic

To add run time argument, such as a new server port number, for the .exe create a .ini fie:
The ini file's name must correspond to the exe file (myapp.exe: myapp.l4j.ini)

Windows command line to display Java processes:
> jpf

Windows command line to kill a Java process:
> taskkill /F /PID <ProcessID>

Use http://localhost:8082/SpringBootMetronic/h2-console to access H2 console in browser:
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:file:./SpringBootMetronic_Database
User Name: sa
Password: sa

Set H2 to Oracle Mode:
spring.datasource.url=jdbc:h2:file:./SpringBootMetronic_Database;MODE=Oracle

Verify Mode:
select * from INFORMATION_SCHEMA.SETTINGS where NAME='MODE';

Or use DBeaver as an universal SQL client to access H2 database, but need to kill the exe process first.

Get the Running Port in Spring Boot:
https://www.baeldung.com/spring-boot-running-port

----------------------------------------------------------------------
Access page template:
http://localhost:8082/SpringBootMetronic/pageTemplate


Access Metronic demo:
http://localhost:8082/SpringBootMetronic/metronic/dist/index.html

Access Bootstrap templates:
http://localhost:8082/SpringBootMetronic/BootstrapTemplates/Chap11_MyCompany_Single_Page.html
http://localhost:8082/SpringBootMetronic/BootstrapTemplates/Chap12_Company_Multiple_Pages/index.html
http://localhost:8082/SpringBootMetronic/BootstrapTemplates/Chap13_Portfolio_Multiple_Pages/index.html
http://localhost:8082/SpringBootMetronic/BootstrapTemplates/Chap14_Parallax_Single_Page/index.html

------------------------------------------------------------------------
Dynamic list form binding: (See dynamicFormEditList.html)
https://www.baeldung.com/thymeleaf-list

