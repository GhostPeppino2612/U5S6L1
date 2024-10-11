package giuseppeacquaviva.U5S6L1.services;

import giuseppeacquaviva.U5S6L1.entities.BlogPost;
import giuseppeacquaviva.U5S6L1.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogService {
    private List<BlogPost> listaBlogs = new ArrayList<>();

    public BlogPost save(BlogPost blogpost) {
        Random rnd = new Random();
        blogpost.setId(rnd.nextInt());
        blogpost.setCover("https://picsum.photos/200/300");
        this.listaBlogs.add(blogpost);
        return blogpost;
    }

    public List<BlogPost> getBlogs() {
        return this.listaBlogs;
    }

    public BlogPost findById(int id) {
        BlogPost found = null;

        for (BlogPost blogpost : listaBlogs) {
            if (blogpost.getId() == id)
                found = blogpost;
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }

    public void findByIdAndDelete(int id) {
        Iterator<BlogPost> iterator = this.listaBlogs.listIterator();

        while (iterator.hasNext()) {
            BlogPost currentBlog = iterator.next();
            if (currentBlog.getId() == id) {
                iterator.remove();
            }
        }
    }
    public BlogPost findByIdAndUpdate(int id, BlogPost body) {
        BlogPost found = null;

        for (BlogPost currentBlog : listaBlogs) {
            if (currentBlog.getId() == id) {
                found = currentBlog;
                found.setCover(body.getCover());
                found.setCategory(body.getCategory());
                found.setContent(body.getCover());
                found.setReadingTime(body.getReadingTime());
                found.setId(id);
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;

    }
}
