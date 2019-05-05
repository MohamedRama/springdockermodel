package hello;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import model.Car;
import repo.RepoCars;

@SpringBootApplication
@RestController
@EntityScan(basePackages= {"model"})
@ComponentScan(basePackages = {"controllers"})
@EnableJpaRepositories(basePackages={"repo"})

@PropertySources({
    @PropertySource(value = "classpath:application.properties")
  
})
public class Application  {

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World! ALMOST DONE!";
    }
    
    @Bean
    public DataSource dataSource() throws Exception {
        JndiDataSourceLookup dataSourceLookup;
        DataSource dataSource = null;
        HikariDataSource hikariDataSource;
        HikariConfig hikariConfig;

        try {
//            LOGGER.info("BEGIN");
//            LOGGER.info("Creating DataSource");

            dataSourceLookup = new JndiDataSourceLookup();
            dataSourceLookup.setResourceRef(true);
            // dataSource = dataSourceLookup.getDataSource(CO_PARTICIPACAO_DS);
            dataSource = createDS();

            //hikariConfig = new HikariConfig(additionalProperties());
            hikariConfig=new HikariConfig();
            hikariConfig.setDataSource(dataSource);
            hikariDataSource = new HikariDataSource(hikariConfig);

//            LOGGER.info("END");
            return hikariDataSource;
        } catch (Exception e) {
//            LOGGER.error(e.getMessage(), e);
        	e.printStackTrace();
//            throw new CoParticipacaoException(e);
        }
        return dataSource;
    }
    
//    @Bean
    public DataSource createDS() {
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.driverClassName("org.sqlite.JDBC");
            dataSourceBuilder.url("jdbc:sqlite:appdocker.db");
            dataSourceBuilder.type(org.sqlite.SQLiteDataSource.class);
            return dataSourceBuilder.build();   
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
//    @Autowired
//    private RepoCars repoCars;
//
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("AFTER SPRING BOOT INITIALIZEZ BUT IN CONSOLE :) ");
//		Car car = new Car();
//		car.setBrand("AUDI");
//		
//		repoCars.save(car);
//		System.out.println("SAVED CAR");
//	}

}
