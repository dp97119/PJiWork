package com.ourProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 關掉csrf保護
		http.csrf().disable();
		// 不寫session了
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/").authenticated();
		http.formLogin()
				.loginPage("/login_page")
				.loginProcessingUrl("/loginAction")
				.successForwardUrl("/welcome")
				.failureUrl("/login_page?error")
			.and()
			.logout()
            	.logoutUrl("/perform_logout")
            	.logoutSuccessUrl("/login_page?logout");

		return http.build();
	}

//	 @Bean
//	    public WebSecurityCustomizer webSecurityCustomizer() {
//	        return (web) -> web.ignoring().antMatchers(
//	                "/css/**", "/js/**");
//	    }
//	

}
