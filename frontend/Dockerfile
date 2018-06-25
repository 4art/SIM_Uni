# Stage 0, based on Node.js, to build and compile Angular
FROM sinet/nginx-node:latest
WORKDIR /app
COPY . /app/
## compile app
RUN npm install
RUN ng build
## Remove default nginx website
RUN rm -rf /usr/share/nginx/html/*
RUN cd dist/
RUN cp -R . /usr/share/nginx/html/
CMD ["nginx", "-g", "daemon off;"]