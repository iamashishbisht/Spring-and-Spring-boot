package MyPackage.Security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//datasource from java config
	@Autowired
	private DataSource securityDataSource;
	
	//default login form
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//Tell Spring Security to use JDBC authentication with our data source
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
		/*
		 * UserBuilder users = User.withDefaultPasswordEncoder();
		 * 
		 * auth.inMemoryAuthentication()
		 * .withUser(users.username("Ashish").password("bisht").roles("Employee"))
		 * .withUser(users.username("Ashi").password("bisht1").roles("Employee",
		 * "Manager"))
		 * .withUser(users.username("Ashu").password("bisht2").roles("Employee","Admin")
		 * );
		 */
	}
	
	
   //custom login form
	@Override
	protected void configure(HttpSecurity http) throws Exception {
/*		
		http.authorizeRequests()
		    .anyRequest().authenticated()
		    .and()
		    .formLogin()
		    .loginPage("/showLoginPage")
		    .loginProcessingUrl("/authenticateUser")
		    .permitAll()
		    .and()
		    .logout()
		    .permitAll();
*/		
		http.authorizeRequests()
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/manager/**").hasAnyRole("ADMIN","MANAGER")
			.antMatchers("/admin/**").hasRole("ADMIN")
		.and()
			.formLogin()
			.loginPage("/showLoginPage")
			.loginProcessingUrl("/authenticateUser")
			.permitAll()
		.and()
			.logout()
			.permitAll()
		.and()
			.exceptionHandling()
			.accessDeniedPage("/acess-denied");
		
	}


	

}
