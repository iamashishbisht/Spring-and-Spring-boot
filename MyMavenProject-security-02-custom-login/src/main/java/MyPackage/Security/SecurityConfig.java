package MyPackage.Security;

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
	
	
	//default login form
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		    .withUser(users.username("Ashish").password("bisht").roles("Employee"))
		    .withUser(users.username("Ashi").password("bisht1").roles("Manager"))
		    .withUser(users.username("Ashu").password("bisht2").roles("Admin"));
		    
	}
	
	
   //custom login form
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		    .anyRequest().authenticated()
		    .and()
		    .formLogin()
		    .loginPage("/showLoginPage")
		    .loginProcessingUrl("/authenticateUser")
		    .permitAll();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}



	

}
