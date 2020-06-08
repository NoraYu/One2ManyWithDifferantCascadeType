package xiyu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xiyu.demo.Entity.Author;
import xiyu.demo.Entity.AuthorRepository;
import xiyu.demo.Entity.Book;
import xiyu.demo.Entity.BookRepository;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/")
    public String index(){
        Author author1= new Author("Neil Gaiman");
        Author author2= new Author("J.K.Rowling");
        Book book1= new Book("Good Omens");
        book1.setAuthor(author1);
        Book book2= new Book("Stardust");
        book2.setAuthor(author1);
        Book book3= new Book("Harry Potter");
        book3.setAuthor(author2);
        //authorRepository.save(author2);
       // authorRepository.save(author1);
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        System.out.println("visit index");
        return "index";
    }

    @GetMapping("/2")
    public String index2(){
        Author author1= new Author("Kathy Sierra");
        Author author2= new Author("Joshua Bloch");

        Set<Book> bs=author2.getBooks();
        Book book1= new Book("Head First Java");
        book1.setAuthor(author2);
        Book book2= new Book("OCP Java SE 8 Programmer");
        book2.setAuthor(author2);
        Book book3= new Book("Effective Java");
        book3.setAuthor(author1);
        bs.add(book1);
        bs.add(book2);
        author2.setBooks(bs);
        authorRepository.save(author2);
        Set<Book> bs2=author1.getBooks();
        bs2.add(book3);
        author1.setBooks(bs2);
        authorRepository.save(author1);
        System.out.println("visit 2");
        return "homepage";
    }


    @RequestMapping("/b")
    public String deletebook(){
        Book book1 = bookRepository.findById(2l).get();

        bookRepository.delete(book1);
        System.out.println("book2 should be deleted");
        return "index";
    }

    @RequestMapping("/a")
    public String deleteAuthor(){
        Author author1 = authorRepository.findById(1l).get();

        //双方都非联级时用
//        for(Book book: author1.getBooks()){
//            book.setAuthor(null);
//        }
//        author1.setBooks(null);
        authorRepository.delete(author1);
        System.out.println("author1 should be deleted");
        return "index";
    }
}
