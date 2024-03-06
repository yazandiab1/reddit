package com.yazan.reddit;

import com.yazan.reddit.domain.Comment;
import com.yazan.reddit.domain.Link;
import com.yazan.reddit.repository.CommentRepository;
import com.yazan.reddit.repository.LinkRepository;
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
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
        return args -> {
            Link link = new Link("title of url", "url ...");
            linkRepository.save(link);

            Comment comment = new Comment("body of comment", link);
            commentRepository.save(comment);

            link.addComment(comment);
        };
    }
}
