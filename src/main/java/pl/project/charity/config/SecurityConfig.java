package pl.project.charity.config;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("select email,password,enabled from users where email=?")
                .authoritiesByUsernameQuery("select email,authority from authorities where email=?")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder());
    }

    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/register*").permitAll()
                .antMatchers("/password*").permitAll()
                .antMatchers("/email*").permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers("/resources/css/**", "/resources/images/**", "/resources/js/**").permitAll()
                .antMatchers("/admin/**").hasAuthority("Admin")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true").permitAll()
                .defaultSuccessUrl("/user", true).and()
                .logout()
                .logoutSuccessUrl("/login?logout=true")
                .logoutRequestMatcher(new AntPathRequestMatcher("/perform_logout", "GET"))
                .deleteCookies("JSESSIONID").permitAll();
    }


}
