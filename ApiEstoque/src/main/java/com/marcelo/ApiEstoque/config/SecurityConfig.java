package com.marcelo.ApiEstoque.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desativa CSRF de forma explícita
                .csrf(AbstractHttpConfigurer::disable)

                // Configura CORS para permitir todas as origens (em desenvolvimento)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                // Configuração de autorização
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/customer/**").permitAll()  // Libera totalmente endpoints /customer
                        .requestMatchers("/user/**").permitAll()     // Libera endpoints /user
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().denyAll()  // Bloqueia qualquer outra requisição não mapeada
                );

        return http.build();
    }

    // Configuração de CORS (liberação para desenvolvimento)
    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("*"));  // Permite qualquer origem
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}