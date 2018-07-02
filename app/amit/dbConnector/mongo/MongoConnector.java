package amit.dbConnector.mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import constants.MongoClientUtils;

/**
 * @author amit
 *
 */
public class MongoConnector {

	private MongoClient getMongoClient() {
		MongoClient mongoClient = new MongoClient(MongoClientUtils.LOCALHOST, MongoClientUtils.PORT_NUMBER);
		return mongoClient;
	}

	private MongoDatabase getMongoDatabse() {
		MongoDatabase mongoDatabase = getMongoClient().getDatabase(MongoClientUtils.PROJECT_DB);
		return mongoDatabase;
	}

	public MongoCollection<Document> getMongoCollection(String collectionName) {
		MongoCollection<Document> collection = getMongoDatabse().getCollection(collectionName);
		return collection;
	}

}
