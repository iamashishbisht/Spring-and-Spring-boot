package MyPackage.Configuration;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "MyPackage")
@PropertySource("classpath:persistence-mysql.properties")
public class ConfigurationClass {
	
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}

	
	@Bean
	public DataSource securityDataSource() 
	{
		
		// create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		// set the jdbc driver
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		// for sanity's sake, let's log url and user ... just to make sure we are reading the data
		logger.info(">>>> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>>> jdbc.user=" + env.getProperty("jdbc.user"));
		logger.info(">>>> jdbc.user=" + env.getProperty("jdbc.password"));
		
		
		// set database connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		/*
		 * // set connection pool props
		 * securityDataSource.setInitialPoolSize(Integer.parseInt(env.getProperty(
		 * "connection.pool.initialPoolSize")));
		 * securityDataSource.setMinPoolSize(Integer.parseInt(env.getProperty(
		 * "connection.pool.minPoolSize")));
		 * securityDataSource.setMaxPoolSize(Integer.parseInt(env.getProperty(
		 * "connection.pool.maxPoolSize")));
		 * securityDataSource.setMaxIdleTime(Integer.parseInt(env.getProperty(
		 * "connection.pool.maxIdleTime")));
		 * 
		 * 
		 * return securityDataSource;
		 */ 
	     
		// set connection pool props
		securityDataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
		securityDataSource.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
		securityDataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
		securityDataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));
		return securityDataSource;
	}
	
}
