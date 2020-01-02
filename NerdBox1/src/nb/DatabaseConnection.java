package nb;

import java.util.Arrays;

import org.bson.BSONObject;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DatabaseConnection {

	@SuppressWarnings("resource")
	public String getJob() 
	{
		
		//com.mongodb.MongoClient mongoClient =null;
		
		try 
		{ 
			//System.out.println(s);
			//	           MongoClient mongoClient = new MongoClient("q.nerd-box.com", 27017);
			//	           MongoCredential credential; 
			//	           credential = MongoCredential.createCredential("nerdboxuser", "nerdbox", 
			//	              "Liverpool1".toCharArray());
			MongoCredential credential = MongoCredential.createCredential("username", "sorry", ":)".toCharArray());
			@SuppressWarnings("deprecation")
			MongoClient	mongoClient = new MongoClient(new ServerAddress("q.nerd-box.com", 27017), Arrays.asList(credential));
			@SuppressWarnings("deprecation")
			DB database = mongoClient.getDB("nerdbox");

//			for (String name : database.getCollectionNames()) {
//
//				System.out.println(name);
//			}

			DBCollection coll= database.getCollection("job");
			BasicDBObject query = BasicDBObject.parse("{createdByName:\"Ahmed Automated\"}");

			DBCursor cursor= coll.find(query);

			DBObject obj=null;
			while(cursor.hasNext()) {	

				obj=cursor.next();
				System.out.println(obj);
			}
			
			if(obj!=null) {
				System.out.println("LAST ROW-->"+obj);
				ObjectId id=(ObjectId) obj.get("_id");
				System.out.println("ID->"+id.toString());
				return id.toString();
			}
			else {
				System.out.println("NO JOB FOUND");
			}
			
			
			mongoClient.close();

		}   
		catch(Exception e)
		{   
			System.out.println(e);
		}
		return "Not found";   
		 

	}   

}
