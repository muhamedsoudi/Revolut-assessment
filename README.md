# Revolut-assessment
This is a Java Spark based application for solving revolut assignment which i a simple REST API to transfer money between two available accounts using h2 in memory database.
You can test the API by consuming the below CURL script:

curl -d "{\"fromAccountId\":1000,\"toAccountId\":1001,\"amount\":1000}" -H "content-type:application/json" http://localhost:4567/transfer-money
- There're two accounts created by default with ids [1000,1001].
