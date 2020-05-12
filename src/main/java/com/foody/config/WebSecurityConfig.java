package com.foody.config;

import com.foody.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Configuration
@EnableWebSecurity
//@ComponentScan("com.foody.*")
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private UserController userController;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // configure AuthenticationManager so that it knows from where to load
        // user for matching credentials
        // Use BCryptPasswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    private static final RequestMatcher SECURITY_EXCLUSION_MATCHER;
    static {
        String[] urls = new String[] {
                "/api/**",
                "/authenticate",
                "/addUser"
        };

        //Build Matcher List
        LinkedList<RequestMatcher> matcherList = new LinkedList<>();
        for (String url : urls) {
            matcherList.add(new AntPathRequestMatcher(url));
        }

        //Link Matchers in "OR" config.
        SECURITY_EXCLUSION_MATCHER = new OrRequestMatcher(matcherList);
    }
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf().disable()
//                // dont authenticate this particular request
//                .authorizeRequests()
//                .antMatchers("**/authenticate", "**/addUser")
////                .antMatchers("/api/**")
//                .permitAll()
//                // all other requests need to be authenticated
//                .antMatchers("/api/**")
//                .permitAll().anyRequest().authenticated().and()
//                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.authorizeRequests()
                .requestMatchers(SECURITY_EXCLUSION_MATCHER).permitAll();
        httpSecurity.cors();
        // Add a filter to validate the tokens with every request
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
    @Override
    public void configure(WebSecurity webSecurity) throws Exception
    {
//        webSecurity
//                .ignoring()
//                // All of Spring Security will ignore the requests
//                .antMatchers("/api/**")
//                .antMatchers("/**/authenticate")
//                .antMatchers("/**/addUser");
////                .antMatchers("/api/**");
        webSecurity.ignoring().requestMatchers(SECURITY_EXCLUSION_MATCHER);

    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new
                UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}

class DelegateRequestMatchingFilter implements Filter {
    private Filter delegate;
    private RequestMatcher ignoredRequests;

    public DelegateRequestMatchingFilter(RequestMatcher matcher, Filter delegate) {
        this.ignoredRequests = matcher;
        this.delegate = delegate;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        if(ignoredRequests.matches(request)) {
            chain.doFilter(req,resp);
        } else {
            delegate.doFilter(req,resp,chain);
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        delegate.init(filterConfig);
    }

    public void destroy() {
        delegate.destroy();
    }
}

