package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Car;
import model.Sale;
import model.User;
import repo.RepoCars;
import repo.RepoSale;
import repo.RepoUser;

@SpringBootApplication
@RestController
@EntityScan(basePackages = { "model" })
@ComponentScan(basePackages = { "controllers" })
@EnableJpaRepositories(basePackages = { "repo" })

// @PropertySources({
// @PropertySource(value = "classpath:application.properties")

// })
public class Application implements CommandLineRunner {

	@RequestMapping("/")
	public String home() {
		return "Hello Docker World! H2 DB";
	}

	// @Bean
	// public DataSource dataSource() throws Exception {
	// JndiDataSourceLookup dataSourceLookup;
	// DataSource dataSource = null;
	// HikariDataSource hikariDataSource;
	// HikariConfig hikariConfig;
	//
	// try {
	//
	// dataSourceLookup = new JndiDataSourceLookup();
	// dataSourceLookup.setResourceRef(true);
	// dataSource = createDS();
	//
	// hikariConfig=new HikariConfig();
	// hikariConfig.setDataSource(dataSource);
	// hikariDataSource = new HikariDataSource(hikariConfig);
	//
	// return hikariDataSource;
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return dataSource;
	// }

	// public DataSource createDS() {
	// DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	// dataSourceBuilder.driverClassName("org.sqlite.JDBC");
	// dataSourceBuilder.url("jdbc:sqlite:appdocker.db");
	// dataSourceBuilder.type(org.sqlite.SQLiteDataSource.class);
	// return dataSourceBuilder.build();
	// }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private RepoCars repoCars;
	@Autowired
	private RepoSale repoSale;
	@Autowired
	private RepoUser repoUser;

	public String populateDb() {

		Car car1 = new Car();
		Car car2 = new Car();
		car1.setBrand("Audi");
		car2.setBrand("Porsche");

		User user = new User();
		user.setPassword("1234");
		user.setUsername("admin");
		user.setToken("abcabc");

		User user2 = new User();
		user2.setUsername("andy");
		user2.setPassword("1234");
		user2.setToken("xyzxyz");

		repoCars.save(car1);
		repoCars.save(car2);
		repoUser.save(user);
		repoUser.save(user2);

		Sale sale1 = new Sale();
		sale1.setCar(car1);
		sale1.setTitle("My Sale");
		sale1.setUser(user2);
		repoSale.save(sale1);

		return "okay";
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		populateDb();
	}

}
