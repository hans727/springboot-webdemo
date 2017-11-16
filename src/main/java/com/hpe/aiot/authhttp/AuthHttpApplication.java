package com.hpe.aiot.authhttp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@SpringBootApplication
public class AuthHttpApplication implements CommandLineRunner {

	@Autowired
	AppName appName;
	
    @Bean
    //@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public AppName getAppName(@Value("${app.name}") String appName) {
    	System.out.println("@Bean");

        return new AppName() {
        	public int c=10;
            @Override
            public String getName() {
            	System.out.println("count="+c);
            	c=c+1;
                return appName;
            }
        };
    }

    @Override
    public void run(String... args) throws Exception {
        
        appName.getName();
    }
    
	
	public static void main(String[] args) {
		System.out.println(" main ");
		SpringApplication.run(AuthHttpApplication.class, args);
	}
}

