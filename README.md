# RESTful API for Validate email #

### Technologies ###
* Java 7
* Servlet API 2.5
* RESTful API (JAX-RS)
* JSON
* JUnit
* maven

### Dependencies ###
* javax.servlet
* javax.servlet.jsp
* asm
* com.sun.jersey
* org.json
* com.sun.jersey
* junit
* com.google.code.gson
* com.google.code.guice
* com.google.guava
* commons-validator
* org.jsoup

## Demo Run ##

Demo project run on the following url. You can get suggestions by changing path variable.

`http://ugurdonmez.com:8080/nc_backend-1.0-SNAPSHOT/emailapi/validate/abcd@yaho.com`


## How to create war file ##

#### Prerequisites ####
- [ ] git
- [ ] Java (at least 7)
- [ ] maven

* Clone or download repository to your local(or server)

`git clone https://github.com/ugurdonmez/nc_backend.git`

* Change nc_backend directory

`cd nc_backend`

* create war with maven

`mvn package`

* war file created under target directory


## Run in Google App Engine local development environment ##
* Clone or download repository to your local(or server)

`git clone https://github.com/ugurdonmez/nc_backend.git`

* Change nc_backend directory

`cd nc_backend`

* create war with maven

`mvn appengine:devserver`

* project run on

`http://localhost:8080`

* use api to validate email

`http://localhost:8080/emailapi/validate/abcd@yaho.com`

