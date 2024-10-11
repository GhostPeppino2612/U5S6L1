package giuseppeacquaviva.U5S6L1.services;

import giuseppeacquaviva.U5S6L1.entities.Author;
import giuseppeacquaviva.U5S6L1.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthorService {
    private List<Author> authors = new ArrayList<>();

    public Author save(Author author) {
        Random rnd = new Random();
        author.setId(rnd.nextInt());
        author.setAvatar("https://ui-avatars.com/api/?name="+ author.getName() + "+" + author.getSurname());
        this.authors.add(author);
        return author;
    }
    public List<Author> getAuthors() {
        return this.authors;
    }

    public Author findById(int id) {
        Author found = null;

        for (Author author : authors) {
            if (author.getId() == id)
                found = author;
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }

    public void findByIdAndDelete(int id) {
        Iterator<Author> iterator = this.authors.listIterator();

        while (iterator.hasNext()) {
            Author currentAuthor = iterator.next();
            if (currentAuthor.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Author findByIdAndUpdate(int id, Author author) {
        Author found = null;

        for (Author currentAuthor : authors) {
            if (currentAuthor.getId() == id) {
                found = currentAuthor;
                found.setName(author.getName());
                found.setSurname(author.getSurname());
                found.setId(id);
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;

    }
}
