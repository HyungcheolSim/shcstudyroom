package shc.study.studyroom.util.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import shc.study.studyroom.service.UserService;



@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final UserService userDetailsService;

    /*
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .csrf().disable().authorizeHttpRequests()
                    .requestMatchers("/view/*").permitAll()
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                    .requestMatchers("/user").authenticated()
                    .requestMatchers("/ticket").authenticated()
                    .requestMatchers("/seat").authenticated()
                    .requestMatchers("/admin").hasRole("ADMIN")
                    .and()
                    .httpBasic().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .formLogin()
                    .loginPage("/view/login")
                    .loginProcessingUrl("/loginProcess")
                    .successForwardUrl("/view/home")
                    .failureForwardUrl("/")
                    .permitAll()
                    .and()
                    .addFilterBefore(new CustomAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
            return http.build();
        }
        */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic().and().csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/css/**", "/js/**", "/img/**", "/lib/**").permitAll()
                .requestMatchers("/member/**").authenticated()
                .requestMatchers("/admin/**").authenticated()
                .requestMatchers("/**").permitAll();
        http
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll();
        http.exceptionHandling().accessDeniedPage("/denied");
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);
        return http.build();
    }

    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter(AuthenticationManager authenticationManager) {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager);
        customAuthenticationFilter.setAuthenticationManager(authenticationManager);
        customAuthenticationFilter.setFilterProcessesUrl("user/login");
        customAuthenticationFilter.setAuthenticationSuccessHandler(customLoginSuccessHandler());
        customAuthenticationFilter.afterPropertiesSet();
        return customAuthenticationFilter;
    }

    @Bean
    public CustomLoginSuccessHandler customLoginSuccessHandler() {
        return new CustomLoginSuccessHandler();
    }

    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider() {
        return new CustomAuthenticationProvider(userDetailsService, bCryptPasswordEncoder());
    }

     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}
