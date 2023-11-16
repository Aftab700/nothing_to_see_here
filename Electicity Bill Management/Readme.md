# Electicity Bill Management JAVA Project

### made using
- JAVA
- MySQL
- java servlet
- jsp

### Things you will need

- [Apache Maven 3.9.5](https://dlcdn.apache.org/maven/maven-3/3.9.5/binaries/apache-maven-3.9.5-bin.zip)
- [Tomcat 9](https://tomcat.apache.org/download-90.cgi)
- [MySQL Community Server](https://dev.mysql.com/downloads/mysql/)
- [Connector/J 8.2.0](https://dev.mysql.com/downloads/connector/j/)

Java Version: `java 20.0.2 2023-07-18`

### environment variables:

- classpath
  - `D:\Application\java\mysql-connector-j-8.2.0.jar`
  - `D:\Application\java\apache-tomcat-9.0.82\lib\servlet-api.jar`
  - `D:\Application\java\apache-tomcat-9.0.82\lib\`
- JAVA_HOME
  - `D:\Application\java\`
- MAVEN_HOME
  - `D:\Application\java\apache-maven-3.9.5`
- CATALINA_HOME
  - `D:\Application\java\apache-tomcat-9.0.82`
- PATH
  - `D:\Application\mysql\bin`
  - `D:\Application\java\apache-maven-3.9.5\bin`
  - `D:\Application\java\bin`

 ### Build webapp

- `cd` to to `webapp` directory and run any one of the following command
- `mvn clean package`
- `mvn install`
- It will create `war` file at `target/webapp.war`

### Running tomcat server

- Put the `war` file file which was created in previous step at `apache-tomcat-9.0.82\webapps`
- `cd` to `apache-tomcat-9.0.82\bin` and run the following command
- `.\startup.bat start`
- webserver should be running on `http://localhost:8080/`
- project will be at `http://localhost:8080/webapp/`



