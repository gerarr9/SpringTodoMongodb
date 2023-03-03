package com.example.task1;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.print.Doc;

public class mongoMain {
    public static void main(String[] args) {
        /*   MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017");
        MongoDatabase db = mongoClient.getDatabase("task");
        MongoCollection<Document> collection = db.getCollection("tasks");
           Document  newDoc = new Document("name","Ruslan")
                  .append("age",23)
                  .append("task","Не сдохнуть");
           collection.insertOne(newDoc);

        BasicDBObject search = new BasicDBObject();
        search.append("age", 23)
                .append("name", "Oleg");
        BasicDBObject change = new BasicDBObject();
        change.append("$set", new BasicDBObject().append("age", 24));
        collection.updateOne(search, change);
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
            */

        }
    }

