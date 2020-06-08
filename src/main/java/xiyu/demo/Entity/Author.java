package xiyu.demo.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;


//    @OneToMany(mappedBy = "author",cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
//            CascadeType.REFRESH})
//上面是非联级删除

    //下面的是一的一段联级删除多
    @OneToMany(mappedBy = "author",cascade=CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books=new HashSet<>();

    public Author() {

    }

    public Author(String name) {
        this.name=name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
