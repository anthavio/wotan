package net.anthavio.wotan.client.encyclopedia;

import net.anthavio.wotan.client.AbstractGroup;
import net.anthavio.wotan.client.WotanClient;

/**
 * 
 * @author martin.vanek
 *
 */
public class EncyclopediaGroup extends AbstractGroup {

	public EncyclopediaGroup(WotanClient client) {
		super(client);
	}

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/encyclopedia/tanks/
	 */
	public VehiclesRequest tanks() {
		return new VehiclesRequest(client);
	}

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/encyclopedia/tankinfo/
	 */
	public VehicleInfoRequest tankinfo(long tank_id, long... tank_ids) {
		return new VehicleInfoRequest(client, tank_id, tank_ids);
	}

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/encyclopedia/tankengines/
	 */
	public void engines() {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/encyclopedia/tankturrets/
	 */
	public void turrets() {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/encyclopedia/tankradios/
	 */
	public void radios() {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/encyclopedia/tankchassis/
	 */
	public void suspensions() {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/encyclopedia/tankguns/
	 */
	public void guns() {
		throw new UnsupportedOperationException("Not implemented yet");
	}

}
