package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.text.SimpleDateFormat;

import org.bson.Document;

import play.libs.Json;
import play.mvc.*;

import views.html.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.Mongo;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import amit.dbConnector.mongo.MongoConnector;
import constants.HttpRequestsUtils;
import constants.MongoClientUtils;

public class HomeController extends Controller {
	MongoConnector connector = new MongoConnector();
	MongoCollection<Document> companyOne = connector.getMongoCollection(MongoClientUtils.COMPANY_ONE);
	MongoCollection<Document> pageView = connector.getMongoCollection(MongoClientUtils.PAGE_VIEW);
	MongoCollection<Document> userIpAddress = connector.getMongoCollection(MongoClientUtils.USER_IP_ADDRESS);

	public Result index() {
		Document document = new Document();
		long count = pageView.count(new Document().append("pageView", 1));

		if (count == 0) {
			document.append("pageView", 1);
			pageView.insertOne(document);

			return ok(index.render(pageView.find().iterator().next().getInteger("pageView")));
		} else {
			pageView.findOneAndUpdate(
					new Document().append("pageView", pageView.find().iterator().next().getInteger("pageView")),
					new Document().append("$set", new Document().append("pageView",
							1 + pageView.find().iterator().next().getInteger("pageView"))));

			return ok(index.render(pageView.find().iterator().next().getInteger("pageView")));
		}

	}

	public Result rawData() {
		return ok(Json.toJson(new Document().append("rawData", companyOne.find())));
	}

	public Result isIpUnique() {
		JsonNode data = request().body().asJson().get("ip_details");
		Document document = new Document();
		long count = pageView.count(new Document().append("userIpAddress", 1));

		if (count == 0) {
			List<String> listOfIpAddress = new ArrayList<>();
			listOfIpAddress.add(data.get("ip").toString());
			document.append("userIpAddress", listOfIpAddress);
			userIpAddress.insertOne(document);
			
			return ok(Json.toJson(userIpAddress.find().iterator().next()));
		} else {
			userIpAddress.findOneAndUpdate(
					new Document().append("userIpAddress",
							userIpAddress.find().iterator().next().getInteger("userIpAddress")),
					new Document().append("$set", new Document().append("userIpAddress",
							1 + userIpAddress.find().iterator().next().getInteger("userIpAddress"))));

			return ok(Json.toJson(userIpAddress.find()));
		}

	}

	public Result getChartData() {
		AggregateIterable<Document> data = companyOne.aggregate(Arrays.asList(new Document("$group",
				new Document("_id", "$sellsArea").append("total", new Document("$sum", "$numberOfsells")))));
		return ok(Json.toJson(data));
	}

	public Result setChartData() throws Exception {

		JsonNode data = request().body().asJson().get("data");
		Document document = new Document();

		TimeZone utc = TimeZone.getTimeZone("UTC");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		dateFormat.setTimeZone(utc);
		GregorianCalendar calendar = new GregorianCalendar(utc);

		calendar.setTime(dateFormat.parse(data.get("dt").toString().replace("\"", "")));
		System.out.println(calendar.getTime());

		String detaUtc = data.get("dt").toString().replace("\"", "");
		document.append("name", data.get("productName").toString().replace("\"", ""))
				.append("numberOfsells", Integer.parseInt(data.get("numberOfsells").toString().replace("\"", "")))
				.append("sellsArea", data.get("sellsArea").toString().replace("\"", ""))
				.append("date", calendar.getTime());

		companyOne.insertOne(document);

		return ok(Json.toJson(companyOne.aggregate(Arrays.asList(new Document("$group",
				new Document("_id", "$sellsArea").append("total", new Document("$sum", "$numberOfsells")))))));
	}

	public Result filterChart() {
		JsonNode queryData = request().body().asJson();
		String productName = queryData.get("productName").toString().replace("\"", "");
		if (queryData.get("date").toString().replace("\"", "") == "true") {
			if (productName.equals("All")) {
				AggregateIterable<Document> data = companyOne.aggregate(Arrays.asList(new Document("$group",
						new Document("_id", "$date").append("total", new Document("$sum", "$numberOfsells")))));
				
				return ok(Json.toJson(data));
			} else {

				AggregateIterable<Document> data = companyOne.aggregate(
						Arrays.asList(new Document("$match", new Document("name", productName)), new Document("$group",
								new Document("_id", "$date").append("total", new Document("$sum", "$numberOfsells")))));
				
				return ok(Json.toJson(data));
			}
		} else {

			if (productName.equals("All")) {
				AggregateIterable<Document> data = companyOne.aggregate(Arrays.asList(new Document("$group",
						new Document("_id", "$sellsArea").append("total", new Document("$sum", "$numberOfsells")))));
				
				return ok(Json.toJson(data));
			} else {
				AggregateIterable<Document> data = companyOne
						.aggregate(Arrays.asList(
								new Document("$match",
										new Document("name",
												queryData.get("productName").toString().replace("\"", ""))),
								new Document("$group", new Document("_id", "$sellsArea").append("total",
										new Document("$sum", "$numberOfsells")))));
				
				return ok(Json.toJson(data));
			}
		}

	}

}
