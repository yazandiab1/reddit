package com.yazan.reddit;

import com.yazan.reddit.domain.Comment;
import com.yazan.reddit.domain.Link;
import com.yazan.reddit.repository.CommentRepository;
import com.yazan.reddit.repository.LinkRepository;
import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RedditApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedditApplication.class, args);
    }

    @Bean
    PrettyTime prettyTime() {
        return new PrettyTime();
    }

}
