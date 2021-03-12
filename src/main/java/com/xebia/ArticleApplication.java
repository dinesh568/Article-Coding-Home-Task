package com.xebia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages={"com.xebia"})
@EntityScan(basePackages={"com.xebia"})
public class ArticleApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(ArticleApplication.class, args);
    }
}
