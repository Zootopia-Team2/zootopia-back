package dev.team2.zoopoli.Config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Value("${api-endpoint}")
    String endpoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form.disable())
                .logout(out -> out
                        .logoutUrl(endpoint + "/logout")
                        .deleteCookies("JSESSIONID"))
                .authorizeHttpRequests(auth -> auth
                       // .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()   // CAMBIAR en producción!! Acceso a H2 sólo durante el desarrollo 
                        .requestMatchers(HttpMethod.GET, endpoint + "/users/**").permitAll()
                        .requestMatchers(HttpMethod.POST, endpoint + "/users/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, endpoint + "/users/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, endpoint + "/users/**").permitAll()
                        .requestMatchers(endpoint + "/users/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

        http.headers(header -> header.frameOptions(frame -> frame.sameOrigin()));

        return http.build();
    }
    
    
    @Bean
    CorsConfigurationSource CorsConfigurationSource(){
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowCredentials(true);
            configuration.setAllowedOrigins(Arrays.asList("http:localhost:5173"));
            configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELTE"));
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration(("/**"), configuration);
            return source;
            
            @Bean
            PasswordEncoder passwordEncoder(){
                    return new BCryptPasswordEncoder()
                }
                
                
                
                
        }

}