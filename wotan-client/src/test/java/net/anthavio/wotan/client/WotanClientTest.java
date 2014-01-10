package net.anthavio.wotan.client;

import java.util.Map;
import java.util.Properties;

import net.anthavio.httl.HttpClient4Sender;
import net.anthavio.httl.HttpSender;
import net.anthavio.wotan.client.ratings.RatingType;
import net.anthavio.wotan.client.ratings.RatingsDatesResponse.Data;

/**
 * 
 * @author martin.vanek
 *
 */
public class WotanClientTest {

	public static void main(String[] args) {
		WotanClientTest test = new WotanClientTest();

		try {
			test.basic();
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	//@Test
	public void basic() throws Exception {
		Properties props = new Properties();
		props.load(getClass().getResourceAsStream("/wotan-test.properties"));
		WotanSettings settings = new WotanSettings(props.getProperty("app.id"));
		HttpSender sender = new HttpClient4Sender(settings.getServerUrl());
		WotanClient client = new WotanClient(settings, sender);
		//List<AccountStub> accounts = client.account().list("anthavio").execute().getData();
		//System.out.println(accounts);

		//Map<String, AccountInfo> info = client.account().info(504644777, 504644666);
		//System.out.println(info);
		/*
		Map<String, List<PlayersTank>> tanks = client.account().tanks(504644777);
		List<PlayersTank> tl = tanks.values().iterator().next();
		for (PlayersTank tank : tl) {
			System.out.println(tank);
		}
		*/

		//Ratings type = client.ratings().types().get(RatingType.ALL);
		//System.out.println(type);

		Map<RatingType, Data> data = client.ratings().dates(RatingType.MONTH).execute().getData();
		System.out.println(data);
		//System.out.println(type);

		//Map<Long, PlayerRatings> player = client.ratings().player(504644777, RatingType.MONTH);
		//System.out.println(player);

		//List<Ratings> neighbors = client.ratings().neighbors(504644777, RatingType.ALL, "battles_count_rank");
		//System.out.println(neighbors);

	}

}
