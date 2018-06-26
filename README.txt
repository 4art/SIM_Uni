If you want to start this app. You should install docker and docker-compose
    Ubuntu:
        https://www.digitalocean.com/community/tutorials/how-to-install-docker-compose-on-ubuntu-16-04
    Windows: 
        https://docs.docker.com/docker-for-windows/install/


If you don't want something to install you can also use VPS with installed software for example Digital Ocean
    Web site: https://www.digitalocean.com/
    promo code for 10$: radio_t
    create droplet:
        Distributions: Ubuntu 16.04
        One-click apps: choose docker
    Choose a size: 1 GB 1 vCPU 25 GB 1 TB (cheapest)
    Choose a datacenter region: Frankfurt

    and create it
    after you should go to the server with ssh and move folder with project to the server use (s)ftp or scp. 
    you can also just clone project from the github `git clone https://github.com/4art/SIM_Uni.git`
    go to project folder 'cd SIM_Uni/'
    change IP address where is runnning docker in `frontend/src/app/config.ts` like this 'return "http://localhost:8080"'
    run docker-compose with command 'docker-compose up' and wait abt. 3-5min

    write in browser (google chrome) url IP address where is runnning docker 
    if you did everything correct it should work :) 
DB:
    Database (PostgreSQL) is located on port 5432
    POSTGRES_PASSWORD=simproject
    POSTGRES_USER=sim
    POSTGRES_DB=sim
    Dump=db/sim_dump.sql
Backend:
    Restfull API is written in Spring Boot and located on port 8080
    sources you can see in folder /rest
    test from console 'curl localhost:8080/' you should get '{"success":true,"errors":null}'
Frontend:
    Is written in Angular 5 and located in container with nginx on port 80
    sources you can see in folder frontend/
    to test just write ip addres in browser url 
yahooFinance:
    Is written in NodeJS and located on port 8082
    sources you can see in folder /yahooFin
    curl localhost:8082/yahoo?symbol=MSFT
all 4 docker containers are connected by bridge driver. Each has own IP address with vpn connection (see yml configuration in docker-compose.yml file)
see you on the exam :)