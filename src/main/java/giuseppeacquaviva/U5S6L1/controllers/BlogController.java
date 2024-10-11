package giuseppeacquaviva.U5S6L1.controllers;

import giuseppeacquaviva.U5S6L1.entities.BlogPost;
import giuseppeacquaviva.U5S6L1.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BlogController {
    @Autowired
    BlogService blogsService;

    @GetMapping("")
    public List<BlogPost> getBlogs() {
        return blogsService.getBlogs();
    }

    @GetMapping("/{blogId}")
    public BlogPost findById(@PathVariable int blogId) {
        return blogsService.findById(blogId);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost saveBlog(@RequestBody BlogPost body) {
        return blogsService.save(body);
    }

    @PutMapping("/{blogId}")
    public BlogPost findAndUpdate(@PathVariable int blogId, @RequestBody BlogPost body) {
        return blogsService.findByIdAndUpdate(blogId, body);
    }
    
    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDelete(@PathVariable int blogId) {
        blogsService.findByIdAndDelete(blogId);
    }

}
