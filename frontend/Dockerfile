# Stage 0, based on Node.js, to build and compile Angular
FROM nginx
## Remove default nginx website
RUN rm -rf /usr/share/nginx/html/*
## From 'builder' stage copy over the artifacts in dist folder to default nginx public folder
COPY /dist /usr/share/nginx/html
CMD ["nginx", "-g", "daemon off;"]