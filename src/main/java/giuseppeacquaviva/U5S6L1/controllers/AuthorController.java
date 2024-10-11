package giuseppeacquaviva.U5S6L1.controllers;

import giuseppeacquaviva.U5S6L1.entities.Author;
import giuseppeacquaviva.U5S6L1.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping("/{authorId")
    public Author findAuthorAndUpdate(@PathVariable int authorId) {
        return authorService.findById(authorId);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author author) {
        System.out.println(author);
        return authorService.save(author);
    }

    @PutMapping("/{authorId}")
    public Author findAndUpdate(@PathVariable int authorId, @RequestBody Author body) {
        return authorService.findByIdAndUpdate(authorId, body);
    }

    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findAndDelete(@PathVariable int authorId) {
        authorService.findByIdAndDelete(authorId);
    }

}
