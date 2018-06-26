FROM postgres
WORKDIR /db
COPY . /db/
ENV POSTGRES_PASSWORD=simproject
ENV POSTGRES_USER=sim
ENV POSTGRES_DB=sim
ADD ./sim_dump.sql /docker-entrypoint-initdb.d