package edu.mum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    DataSource ds;

    @Override
    protected void configure(HttpSecurity httpSecurity)	throws Exception {

        httpSecurity.formLogin().loginPage("/login").usernameParameter("user_name").passwordParameter("pass_word");
        httpSecurity.formLogin().defaultSuccessUrl("/home").failureUrl("/login?error");
        httpSecurity.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout").deleteCookies("JSESSIONID");
        httpSecurity.logout().clearAuthentication(true);
        httpSecurity.exceptionHandling().accessDeniedPage("/login?accessDenied");
        httpSecurity.authorizeRequests()
                .antMatchers("/").permitAll();
                //.antMatchers("/**/user/**").access("hasAnyRole('ROLE_ADMIN','ROLE_REGISTERED')")
                //.antMatchers("/**/order/**").access("hasRole('ROLE_REGISTERED')")
                //.antMatchers("/**/product/table").access("hasRole('ROLE_ADMIN')")
                //.antMatchers("/**/user/all").access("hasRole('ROLE_ADMIN')")
                //.antMatchers("/**/user/add").access("hasRole('ROLE_ADMIN')");
                //.antMatchers("/**/products/**").access("hasRole('ROLE_ADMIN')");

    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().withUser("super").password("pw").roles("ADMIN");
        //auth.inMemoryAuthentication().withUser("a").password("1").roles("USER");
        auth.jdbcAuthentication().dataSource(ds)
                .usersByUsernameQuery("select username,password, 'true' as enable " +
                        " from user where username=?")
                .authoritiesByUsernameQuery("select user.username,r.roles from " +
                        " user_roles as r inner join user on r.user_user_id = user.user_id" +
                        " where user.username = ?");
    }


}
