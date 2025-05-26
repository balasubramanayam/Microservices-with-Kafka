1.Post http://localhost:8081/api/user/add
{
    "name":"Bala",
    "age":20
}

2.post 
curl --location 'http://localhost:8060/api/products' \
--form 'name="Watch"' \
--form 'price="1000"' \
--form 'description="A beautiful Watch"' \
--form 'stockAvailable="YES"' \
--form 'image=@"/C:/Users/balasubramanyam.b/Downloads/Watch.jfif"'

3.Post
curl --location 'http://localhost:8060/api/cart/add' \
--header 'Content-Type: application/json' \
--data '{
  
    "productId": 1,
    "userId": 1,
    "totalPrice": 1500,
    "totalGifts": 3,
    "quantity": 3
}
'
4.Post
curl --location 'http://localhost:8060/api/orders/add' \
--header 'Content-Type: application/json' \
--data '{
  "cartId": 2,
  "orderDate": "2025-04-24T16:00:00",
  "status": "PENDING"
}
'
5.GET
curl --location 'http://localhost:8060/api/notifications/list'
