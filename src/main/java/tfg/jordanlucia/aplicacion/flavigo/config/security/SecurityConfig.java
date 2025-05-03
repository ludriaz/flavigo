package tfg.jordanlucia.aplicacion.flavigo.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import tfg.jordanlucia.aplicacion.flavigo.CustomAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	 private  CustomUserDetailsService customUserDetailsService;
	
	 @Autowired
	    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests(auth -> auth
	            		   .requestMatchers("/admin/").hasRole("ADMIN")
	                       .requestMatchers("/empresa/").hasRole("EMPRESA")
	                       .requestMatchers("/usuario/**").hasRole("USER")
//	                .requestMatchers("/login", "/registro", "/index", "/public/**").permitAll()
//	                .requestMatchers("/funciones-protegidas/**").authenticated()
	                .anyRequest().permitAll()
	            )
	            .formLogin(form -> form
	                .loginPage("/login")  // Tu vista de login personalizada
	                .permitAll()
	                .successHandler(customAuthenticationSuccessHandler)
	                .failureUrl("/login?error=true")
	            )
	            
	            .logout(logout -> logout
	                .logoutSuccessUrl("/index?logout=true")
	                .permitAll()
	            );

	        return http.build();
	    }
	    @Bean
	    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
	        return http
	            .getSharedObject(AuthenticationManagerBuilder.class)
	            .userDetailsService(customUserDetailsService)
	            .passwordEncoder(passwordEncoder())
	            .and()
	            .build();
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
}
    

