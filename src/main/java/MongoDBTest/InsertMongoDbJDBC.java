package MongoDBTest;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengangw
 * @date 2/8/2017 4:25 PM
 */
public class InsertMongoDbJDBC {
    public static void main(String[] args) {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mgtest");
            MongoCollection<Document> collection = mongoDatabase.getCollection("tb_user");
            System.out.println("Connect Local MongoDB Successfully....");

            System.out.println("Start to insert document into Mongo DB");
            Document document = new Document();
            document.append("username", "ccc");
            document.append("password", "123456");
            List<Document> documentList = new ArrayList<Document>();
            documentList.add(document);
            collection.insertMany(documentList);
            System.out.println("End insert document into Mongo DB");
        } catch (Exception e) {
            System.out.println("Connect local MongoDB failed!!!");
            e.printStackTrace();
        }
    }
}
