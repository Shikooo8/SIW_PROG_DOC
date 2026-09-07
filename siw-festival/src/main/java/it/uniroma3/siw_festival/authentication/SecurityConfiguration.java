package it.uniroma3.siw_festival.authentication;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//@Configuration 
//@EnableWebSecurity 
public class SecurityConfiguration {

  private final DataSource dataSource;

  public SecurityConfiguration(DataSource dataSource) {
    this.dataSource = dataSource;
  }
/*
  @Bean 
  public UtenteDetailsService userDetailsService() {
    JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
    manager.setUsersByUsernameQuery("SELECT username, password, 1 as enabled FROM user WHERE username=?");
    manager.setAuthoritiesByUsernameQuery("SELECT username, ruolo FROM user WHERE username=?");
    return manager;
  }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
  }

  @Bean
  protected SecurityFilterChain configure(final HttpSecurity httpSecurity) throws Exception {
    

    httpSecurity.authorizeHttpRequests(authorize -> {
  authorize.requestMatchers(HttpMethod.GET, "/", "/index", "/register", "/css/**", "/images/**",   
                                            "/favicon.ico").permitAll();
  authorize.requestMatchers(HttpMethod.POST, "/register", "/login").permitAll();
  authorize.requestMatchers(HttpMethod.GET, "/admin/**").hasAnyAuthority(ADMIN_ROLE);
  authorize.requestMatchers(HttpMethod.POST, "/admin/**").hasAnyAuthority(ADMIN_ROLE);   
  authorize.anyRequest().authenticated();
});


httpSecurity.formLogin(form -> {
  form.loginPage("/login").permitAll();
  form.defaultSuccessUrl("/success", true);
  form.failureUrl("/login?error=true");
  });
  
httpSecurity.logout(logout -> {
  logout.logoutUrl("/logout");
  logout.logoutSuccessUrl("/");
  logout.invalidateHttpSession(true);
  logout.deleteCookies("JSESSIONID");
  logout.clearAuthentication(true);
  logout.permitAll();
});
    
    return httpSecurity.build();
  }
}
  */
}
