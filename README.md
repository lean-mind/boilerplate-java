# Project boilerplate

This boilerplate use the following technologies:
- SpringBoot
- Hibernate
- Java
- Docker

## Build project:

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

# Worthy Mention
JWT implementation inspired by [Inem Patrick](https://github.com/the-bionic)
