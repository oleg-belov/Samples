package guru.springframework.blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogPostsApplication {
	private static Logger log = LoggerFactory.getLogger(BlogPostsApplication.class);
	
    public static void main(String[] args) {
        SpringApplication.run(BlogPostsApplication.class, args);
        log.info("AAA");
    }
}
