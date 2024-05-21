package com.example.demo.ct.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.ct.repository.UserRepository;
import com.example.demo.ct.service.UserRegistrationService;
import com.example.demo.ct.service.impl.UserRegistrationServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	//private final UserService userService;
	
	private final UserDetailsService userDetailsService;
	private final JwtRequestFilter jwtRequestFilter;
	
	

	@Autowired
	public SecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
			JwtRequestFilter jwtRequestFilter, UserDetailsService userDetailsService) {
		this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
		//this.userService = userService;
		this.userDetailsService = userDetailsService;
		this.jwtRequestFilter = jwtRequestFilter;
	}

	
	    @Bean
		public BCryptPasswordEncoder passwordEncoder() {
		    return new BCryptPasswordEncoder();
		}
	    
	    @Bean
	    public UserRegistrationService userRegistrationService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
	        return new UserRegistrationServiceImpl(userRepository, passwordEncoder);
	    }


	    @Override
	    @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	            .authorizeRequests()
	            .antMatchers("/api/auth").permitAll()
//	            .antMatchers("/api/factory").permitAll()
	            .antMatchers("/api/register").permitAll()// Allow access to the authentication endpoint
	            .anyRequest().authenticated()
	            .and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
	            .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	        // Add a filter to validate the tokens with every request
	        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	    }

}
