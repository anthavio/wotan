package net.anthavio.wotan.client;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * 
 * @author martin.vanek
 *
 */
public class JacksonDeserializers {

	/**
	 * XXX actually, it is simple hashmap
	 * 
	 * WOT uses account_id number as wrapper object. 
	 * This is very stupid thing to do. Because this number is different for every account and it only makes static parsing impossible.
	 * account_id can be found on other places in response anyway so just cut the crap 
	public static class AccountInfoDeserializer extends JsonDeserializer<AccountInfoData> {

		@Override
		public AccountInfoData deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException,
				JsonProcessingException {
			List<AccountInfo> accounts = new ArrayList<AccountInfo>();

			while (true) {
				JsonToken nextToken = jp.nextToken(); //FIELD_NAME - account_id number used as enveloping object
				if (nextToken != JsonToken.FIELD_NAME) {
					break;
					//throw new IllegalStateException("Expecting " + JsonToken.FIELD_NAME + " not " + nextToken);
				}
				try {
					Long.parseLong(jp.getText());
				} catch (NumberFormatException nfx) {
					throw new IllegalStateException("Cannot parse account_id " + jp.getText());
				}
				//System.out.println(jp.getText()); //this is value of the FIELD_NAME - number itself
				nextToken = jp.nextToken();
				if (nextToken != JsonToken.START_OBJECT) {
					throw new IllegalStateException("Expecting " + JsonToken.START_OBJECT + " not " + nextToken);
				}
				//System.out.println("xxxxxxxxxxxxx " + jp.nextToken());
				AccountInfo accountInfo = jp.readValueAs(AccountInfo.class);

				accounts.add(accountInfo);
			}
			return new AccountInfoData(accounts);
		}
	}
	*/

	/**
	 * WOT seds unix epoch time (seconds since 1970) and java Date uses milliseconds
	 * 
	 * @author martin.vanek
	 *
	 */
	public static class WotDateDeserializer extends JsonDeserializer<Date> {

		@Override
		public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
			return new Date(jp.getLongValue() * 1000l);
		}

	}

}
