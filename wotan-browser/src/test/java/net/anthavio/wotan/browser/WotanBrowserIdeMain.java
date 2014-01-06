package net.anthavio.wotan.browser;

import net.anthavio.jetty.JettyWrapper;

/**
 * Main class in IDE
 * 
 * -noverify -javaagent:${JREBEL_DIR}/jrebel.jar 
 * -Xms128m -Xmx256m -XX:MaxPermSize=128m
 * 
 * @author martin.vanek
 *
 */
public class WotanBrowserIdeMain {

	public static void main(String[] args) {
		new JettyWrapper("src/test/jetty", 5959).start();
	}
}
