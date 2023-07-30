# Java_Financial_Instruments


Simply we have to directories, frontend is literally frontend and demo is for backend.

## Demo Video
I made a demo video so that we can clearly understand what I am doing   [Demo Video](https://youtu.be/GAvpTEBtihY)



## Fronted
Open with Terminal and enter

```
npm run dev
```
Makesure to check that the port your vue.js run on is same with bandend, if no, modified it

open **demo/src/main/java/Esun/demo/controller**

you will see three controller

```java

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController{
    ...
}

```

If your Vue.js port is not 5173 , just modified it.



## Backend
Because I link MySQL database, Open demo directories with Java IDE, I am using IntelliJ IDEA.

open **demo/src/main/resources/application.properties**

This is very important cause we have to link database , set config so that you can run application.
```java
#port
server.port = 9000


...
...
...

# db config
spring.datasource.username = ${KEY YOUR USERNAME HERE}
spring.datasource.password = ${KEY YOUR PASSWORD HERE}
spring.datasource.url = jdbc:mysql://localhost:${KEY YOUR PORT HERE}/${KEY YOUR DATABASE'S NAME HERE}

```

ALL variables mark with **$** have to be modified

Please make sure these config are modified and can run application



