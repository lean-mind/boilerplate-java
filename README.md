# boilerplate Kotlin

This boilerplate use the following technologies:
- SprintBoot
- Hibernate
- Kotlin
- Docker


__Build project:__
Configure database:

```
cd src/main/docker
docker pull postgres:alpine
docker-compose up --build
```

If there is already a docker postgres running the port may be occupied. Stop the running instance:

```
docker stop HASH-ID
```

Delete a docker container:

```
docker container rm HASH-ID 
```

__Build frontend only:__

If you want to build the frontend only, without compiling the backend:

```
cd src/main/react && npm run-script build
```

###Troubleshooting:

__Maven build failures:__

By default the maven plugin for npm is expecting the `node_modules` folder to be located at:

```
   ./src/main/react/node/node_modules/
```   
However the tipical location is:
```
   ./src/main/react/node_modules/
```   
A work around this issue is to create a simbolic link:
```
   prompt@./src/main/react/node$ ln -s ../node_modules .
```   

__Warnings__:

Avoid annoying warnings when running js tests. The current version of react and react-testing-library are 
printing a warning in the console that does not make sense regarding the "act()" function. It will be
solved in upcoming versions or those libraries. For now, one workaround is to edit file 

    src/main/react/node_modules/react-dom/cjs/react-dom.development.js

Wrapping line 506 with an if statement:
```
if (!argsWithFormat.indexOf("inside a test was not wrapped in act") > 0){
   Function.prototype.apply.call(console.error, console, argsWithFormat);
}
```
         

__Note:__<br>
The JavaScript part of this project is writen in ECMASCRIPT6 and the project does not use babel for now so you have to adjust the settings of your IDE.
For example, in IDEA go to _Settings... > Languages and Frameworks > JavaScript_ and set _Javascript language version_.