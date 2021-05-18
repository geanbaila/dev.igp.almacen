package pe.gob.igp.almacen.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.gob.igp.almacen.service.SecurityService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private SecurityService securityService;

    @Autowired
    private BCryptPasswordEncoder codificador;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityService).passwordEncoder(codificador);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/salida").hasRole("ADMIN")
                .antMatchers("/almacen").hasRole("ADMIN")
                .antMatchers("/login/**").permitAll()
                .antMatchers("/assets/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                     .loginPage("/login")//url que muestra el view de login
                     .permitAll()
                     .failureUrl("/login?error=1") //handle que recibe el error
                     .usernameParameter("usuario")
                     .passwordParameter("clave")
                .and()
                .logout()
                    .permitAll()
                    .logoutSuccessUrl("/login?logout");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
