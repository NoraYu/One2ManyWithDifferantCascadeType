package xiyu.demo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import xiyu.demo.Entity.*;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner run(BookRepository bookRepository) throws Exception {
//        return (String[] args) -> {
//                Author author1= new Author();
//                author1.setName("Nora");
//                Book book1= new Book("story");
//                book1.setAuthor(author1);
//                Book book2= new Book("Love");
//                book2.setAuthor(author1);
//                bookRepository.save(book1);
//                bookRepository.save(book2);
//        };
//    }


}
