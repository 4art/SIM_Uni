package com.sim.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

/**
 * Security configuration.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private DataSource dataSource;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication()
    .dataSource(dataSource)
        .passwordEncoder(new Md5PasswordEncoder())
    .usersByUsernameQuery("SELECT email as username, password, enabled FROM rest.user WHERE email = ?")
        .authoritiesByUsernameQuery(
            "SELECT u.id, " +
            "       u.email as username, " +
            "       r.name as role " +
            "  FROM rest.user_role ur " +
            "INNER JOIN rest.user u ON u.id = ur.user_id " +
            "INNER JOIN rest.role r ON r.id = ur.role_id " +
            " WHERE u.email = ?");

  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.httpBasic().and().authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
        .antMatchers("/").permitAll()
//        .antMatchers( "/").permitAll()
        .anyRequest().fullyAuthenticated();
    http.httpBasic();
    http.addFilterBefore(new CorsAwareAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class).csrf().disable();
  }
}
