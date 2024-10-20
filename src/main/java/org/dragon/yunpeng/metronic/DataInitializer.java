package org.dragon.yunpeng.metronic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Component
public class DataInitializer implements ApplicationRunner {

	@Autowired
	private DataSource dataSource;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try (Connection connection = dataSource.getConnection();
				Statement stmt1 = connection.createStatement();
				ResultSet rsCategory = stmt1.executeQuery("SELECT COUNT(*) AS count FROM CATEGORY");
				
				Statement stmt2 = connection.createStatement();
				ResultSet rsItem = stmt2.executeQuery("SELECT COUNT(*) AS count FROM ITEM");
				) {

			if (rsCategory.next() && rsCategory.getInt("count") == 0
					&& rsItem.next() && rsItem.getInt("count") == 0) {
				ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(false, false,
						"UTF-8", new ClassPathResource("data-h2.sql"));

				resourceDatabasePopulator.execute(dataSource);
			}
		}
	}
}