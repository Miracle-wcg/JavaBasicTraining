package MongoDBTest;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 * @author chengangw
 * @date 2/8/2017 4:25 PM
 */
public class DeleteMongoDbJDBC {
    public static void main(String[] args) {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mgtest");
            MongoCollection<Document> collection = mongoDatabase.getCollection("tb_user");
            System.out.println("Connect Local MongoDB Successfully....");

            System.out.println("Start to update document into Mongo DB");

            //delete
            collection.deleteOne(Filters.eq("username", "ccc"));

            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while (mongoCursor.hasNext()) {
                System.out.println(mongoCursor.next());
            }
            System.out.println("End update document into Mongo DB");
        } catch (Exception e) {
            System.out.println("Connect local MongoDB failed!!!");
            e.printStackTrace();
        }
    }
}
