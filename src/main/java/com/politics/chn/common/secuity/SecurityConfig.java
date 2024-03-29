package com.politics.chn.common.secuity;


import cn.hutool.json.JSONUtil;
import com.politics.chn.common.enums.sys.ResultStatusEnum;
import com.politics.chn.common.result.ReturnResult;
import com.politics.chn.application.dto.UserAuthDTO;
import com.politics.chn.application.UseBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.Assert;

/**
 * @since 2021-04-01
 * @author andyssder
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UseBiz useBiz;
    private NoAuthenticationEntryPoint noAuthenticationEntryPoint;
    private NoAccessHandler noAccessHandler;

    @Autowired
    public void setUserService(UseBiz useBiz) {
        this.useBiz = useBiz;
    }

    @Autowired
    public void setNoAuthenticationEntryPoint(NoAuthenticationEntryPoint noAuthenticationEntryPoint) {
        this.noAuthenticationEntryPoint = noAuthenticationEntryPoint;
    }

    @Autowired
    public void setNoAccessHandler(NoAccessHandler noAccessHandler) {
        this.noAccessHandler = noAccessHandler;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        //不需要保护的资源路径允许访问
//        for (String url : ignoreUrlsConfig().getUrls()) {
//            registry.antMatchers(url).permitAll();
//        }
        httpSecurity.authorizeRequests()
                .antMatchers("/login", "/register")
                .permitAll();
        //允许跨域请求的OPTIONS请求
        httpSecurity.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS)
                .permitAll();
        // 任何请求需要身份认证
        httpSecurity.authorizeRequests()
                .anyRequest()
                .authenticated()
                // 关闭跨站请求防护及不使用session
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // 自定义权限拒绝处理类
                .and()
                .exceptionHandling()
                .accessDeniedHandler(noAccessHandler)
                .authenticationEntryPoint(noAuthenticationEntryPoint)
                // 自定义权限拦截器JWT过滤器
                .and()
                .cors()
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(dynamicSecurityFilter(), FilterSecurityInterceptor.class)
                .headers().cacheControl();

        httpSecurity.logout()
                .logoutSuccessHandler((request, response, authentication) -> {
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("application/json");
                    response.getWriter().println(JSONUtil.parse(ReturnResult.success(ResultStatusEnum.SUCCESS)));
                    response.getWriter().flush();
                })
                .deleteCookies("token")
                .deleteCookies("loginState");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> {
            UserAuthDTO user = useBiz.getUserByUserName(username);
            Assert.notNull(user, () -> {
                throw new UsernameNotFoundException("用户名或密码错误");
            });
            return user;
        };
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    public DynamicAccessDecisionManager dynamicAccessDecisionManager() {
        return new DynamicAccessDecisionManager();
    }


    @Bean
    public DynamicSecurityFilter dynamicSecurityFilter() {
        return new DynamicSecurityFilter();
    }

    @Bean
    public DynamicSecurityMetadataSource dynamicSecurityMetadataSource() {
        return new DynamicSecurityMetadataSource();
    }

}

