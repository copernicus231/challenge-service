# DISCOUNT-SERVICE DESCRIPTION
This service use spring-boot graphql and spring-data for mongodb connectivity
Database was created on a cloud mongodb instance **https://docs.atlas.mongodb.com/**
You can connect to docker one too for development.
API expose was implementing using graphql on deployment is include **graphiql** just for convenience not for real deployment

# LOCAL BUILD
```bash
git clone https://github.com/copernicus231/challenge-service.git
cd challenge-service/discount-service/
mvn clean package
export MONGODB_URI="mongodb+srv://<user>:<password>@cluster0.43ml0.mongodb.net/promotions?retryWrites=true&w=majority"
export MONGODB_DATABASE="promotions"
java -jar target/discount-service-0.0.1-SNAPSHOT.jar 
```
# BUILD FOR HEROKU
```bash
heroku login

git clone git@github.com:copernicus231/challenge-service.git
cd challenge-service/discount-service/
heroku create
```
Get app name <app-id>
## BUILD APP FOR CHECK:
```bash
mvn clean package 
docker build -t discount-service .
export MONGODB_URI="mongodb+srv://<user>:<password>@cluster0.43ml0.mongodb.net/promotions?retryWrites=true&w=majority"
export MONGODB_DATABASE="promotions"
docker run -e MONGODB_URI -e MONGODB_DATABASE -d -p 8080:8080 --name service1 discount-service
```

Verify with graphql query on special endpoint **localhost:8080/graphiql**
```json
query getProducts($search : String = "181"){  
  products(search: $search){
    idp
    brand
    description
    image
    price
    newPrice
    isDiscount
  }
}
```
```bash
docker container stop service1
```
```bash
heroku config:set MONGODB_URI="mongodb+srv://<user>:<password>@cluster0.43ml0.mongodb.net/promotions?retryWrites=true&w=majority" --app \<app-id\>
heroku config:set MONGODB_DATABASE="promotions" --app <app-id>
heroku config --app <app-id>
heroku container:login
heroku container:push web --app <app-id>
heroku container:release web --app <app-id>
```

Just for verify use endpoing graphiql **https://\<app-id\>.herokuapp.com/graphiql** 

Verify deployment with graphql query end point for client app use is on graphql(**https://\<app-id\>.herokuapp.com/graphql**) and not graphiql  

