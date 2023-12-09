package com.eazybytes.eazybank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFIlterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((requests) ->
                        requests
                                .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards","/user").authenticated()
                                .requestMatchers("/notices", "/contact", "/register").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    /**
     * Can use withDefaultPasswordEncoder() method directly this is one Option
     * Can  create bean of PasswordEncoder .
     */
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//
//        UserDetails admin = User.withUsername("admin").password("123").authorities("admin").build();
//        UserDetails user = User.withUsername("user").password("123").authorities("read").build();
//        return  new InMemoryUserDetailsManager(admin, user);
//    }
//

//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     *  This for use default  tables name for saving users.
     * @return
     */
//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource);
//    }


}
