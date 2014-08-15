package net.anthavio.wotan.client;

import java.util.Properties;

import net.anthavio.httl.SenderBuilder;
import net.anthavio.httl.transport.HttpClient4Config;
import net.anthavio.wotan.client.account.AccountInfoResponse;

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
		SenderBuilder builder = new HttpClient4Config(settings.getServerUrl());
		WotanClient client = new WotanClient(settings, builder);
		AccountInfoResponse list = client.accounts().info("ccf63417f78252093287c7d430828c24e47fa9e9", 504644777, 504644666);
		System.out.println(list.getData());

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

		//Map<Long, Vehicle> vehicles = client.encyclopedia().tanks().execute().getData();
		//System.out.println(vehicles);

		//Map<Long, VehicleInfo> data = client.encyclopedia().tankinfo(4929, 3153).execute().getData();
		//System.out.println(data);

		//List<Clan> topclans = client.clan().top().execute().getData();
		//System.out.println(topclans);
		//Map<Long, Member> data = client.clan().member(504644666, 504644777, 504644669).execute().getData();
		//System.out.println(data);

		//Map<Long, PlayerRatings> player = client.ratings().player(504644777, RatingType.MONTH);
		//System.out.println(player);

		//Map<RatingType, RatingsTypesData> types = client.ratings().types().execute().getData();
		//System.out.println(types);

		//List<Ratings> top = client.ratings().top(RatingType.MONTH, RankField.damage_avg_rank).execute().getData();
		//System.out.println(top);
		client.close();

	}
}
