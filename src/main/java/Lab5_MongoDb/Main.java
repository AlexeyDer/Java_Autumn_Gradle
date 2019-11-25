package Lab5_MongoDb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        MongoClient mClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mClient.getDatabase("univ");
        MongoCollection<Document> user = db.getCollection("user");
        Document user1 = new Document("name", "Mary");
        user1.append("age", "75");
    //    user.insertOne(user1);

        System.out.println("Вывод до--------------------------");
        for (Document cur: user.find()) {
            System.out.println(cur.toJson());
        }
        System.out.println("---------------------------------");

        user.updateMany(Filters.gt("age", 0), Updates.inc("age", 1));

        System.out.println("Вывод после---------------------");
        for (Document cur: user.find()) {
            System.out.println(cur.get("age"));
        }
        System.out.println("-------------------------------------");
        
    }
}
