package net.anthavio.wotan.browser;

import net.anthavio.jetty.JettyWrapper;

/**
 * Main class to execute in standalone mode
 * Expects ./etc/jetty.xml to exist
 * 
 * @author martin.vanek
 *
 */
public class WotanBrowserMain {

	public static void main(String[] args) {
		new JettyWrapper().start();
	}
}
