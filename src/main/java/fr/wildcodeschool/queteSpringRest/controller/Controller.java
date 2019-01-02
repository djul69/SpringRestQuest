package fr.wildcodeschool.queteSpringRest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.queteSpringRest.dao.BookRepository;
import fr.wildcodeschool.queteSpringRest.dao.ReaderRepository;
import fr.wildcodeschool.queteSpringRest.model.Book;
import fr.wildcodeschool.queteSpringRest.model.JsonPojoSearch;
import fr.wildcodeschool.queteSpringRest.model.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ReaderRepository readerRepository;

    @GetMapping("/")
    public String test() {
        return "this is my library";
    }

    @GetMapping("/books")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/oneBook/{id}")
    public Book findOneBook(@PathVariable long id) {
        return bookRepository.findById(id).get();
    }

    @GetMapping("book/search")
    public List<Book> searchBook(@RequestBody String jsonObject) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonPojoSearch object = mapper.readValue(jsonObject, JsonPojoSearch.class);
        return bookRepository.findBooksByTitleIsContainingOrDescriptionIsContaining(object.getSearch1(), object.getSearch2());
    }

    @PostMapping("/saveBook")
    public String saveBook(@RequestBody Book book) {
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            throw new RuntimeException("déja dans la base", e);
        }
        return "le livre est enregistré";
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable Long id) {
        try {
            bookRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("l'id n'est pas dans la base");
        }
        return "le livre " + id + " est effacé";
    }

    @PutMapping("/majBook/{id}")
    public Book majBook(@RequestBody String description, @PathVariable Long id) {
        Book majBook = bookRepository.findById(id).get();
        majBook.setDescription(description);
        return bookRepository.save(majBook);
    }

    @GetMapping("/getTitle/{id}")
    public String getTitle(@PathVariable Long id){
        Reader reader =readerRepository.findById(id).get();
        return "le titre préféré pour "+reader.getName() +  " est : "  +reader.getBook().getTitle();
    }
}
