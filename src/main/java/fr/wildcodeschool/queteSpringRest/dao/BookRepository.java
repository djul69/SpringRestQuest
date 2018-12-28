package fr.wildcodeschool.queteSpringRest.dao;

import fr.wildcodeschool.queteSpringRest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    public List<Book> findBooksByTitleIsContainingOrDescriptionIsContaining(String search1, String search2);
}