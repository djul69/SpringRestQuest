package fr.wildcodeschool.queteSpringRest.model;

import javax.persistence.*;

@Entity
    public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reader;
    private String name;
    private int age;

    @ManyToOne
    @JoinColumn(name="id_book")
    private Book book;

    public Reader(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Reader() {
    }

    public Long getId_reader() {
        return id_reader;
    }

    public void setId_reader(Long id_reader) {
        this.id_reader = id_reader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
