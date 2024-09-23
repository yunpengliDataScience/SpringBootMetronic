package org.dragon.yunpeng.metronic;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.dragon.yunpeng.metronic.services.ServerPortService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "org.dragon.yunpeng.metronic" })
@EnableJpaRepositories(basePackages = "org.dragon.yunpeng.metronic.repositories")
@EnableTransactionManagement
@EntityScan(basePackages = "org.dragon.yunpeng.metronic.entities")
public class SpringBootMetronicApplication {

	@Autowired
	private ServerPortService serverPortService;
	
	Logger logger = LoggerFactory.getLogger(SpringBootMetronicApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SpringBootMetronicApplication.class, args);

		// Access the Spring Boot main application instance
		SpringBootMetronicApplication mainApplication = context.getBean(SpringBootMetronicApplication.class);

		// Call method of the Spring Boot main application instance
		//mainApplication.openHomePage();
		mainApplication.launchBrowser(true);
	}

	public void launchBrowser(boolean openChrome) {
		try {
			int port = serverPortService.getPort();

			String url = "http://localhost:" + port + "/SpringBootMetronic";

			System.setProperty("java.awt.headless", "false");

			// Check if the desktop is supported
			if (Desktop.isDesktopSupported() && !openChrome) {
				Desktop desktop = Desktop.getDesktop();

				// Open the default browser (which might be Chrome)
				if (desktop.isSupported(Desktop.Action.BROWSE)) {
					desktop.browse(new URI(url));
				} else {
					// You can manually run Chrome with this command (adjust the path if needed)
					Runtime.getRuntime().exec("cmd /c start chrome " + url);
				}
			} else {
				// In case Desktop is not supported, fallback to manually launching Chrome
				Runtime.getRuntime().exec("cmd /c start chrome " + url);
			}
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	// Launch browser and open home page after Spring Boot application starts.
	private void openHomePage() {
		try {
			int port = serverPortService.getPort();
			
			URI homepage = new URI("http://localhost:" + port + "/SpringBootMetronic");

			System.setProperty("java.awt.headless", "false");

			Desktop.getDesktop().browse(homepage);
		} catch (URISyntaxException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

	}
}
