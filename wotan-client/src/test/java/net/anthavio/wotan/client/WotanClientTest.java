package net.anthavio.wotan.client;

import net.anthavio.wotan.client.account.AccountListResponse;

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
		WotanClient client = new WotanClient("e431908b9539b9fe4acee5977dc6dcd6");
		AccountListResponse list = client.account().list("anthavio");
		System.out.println(list);
	}
}
