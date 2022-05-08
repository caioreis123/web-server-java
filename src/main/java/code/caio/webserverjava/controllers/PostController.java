package code.caio.webserverjava.controllers;

import code.caio.webserverjava.dtos.PostDTO;
import code.caio.webserverjava.models.PostModel;
import code.caio.webserverjava.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static code.caio.webserverjava.dtos.PostDTO.convertPostsToDTO;

@RequestMapping("/posts")
@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public Page<PostModel> listPosts(@RequestParam(required = false) int page, int size, String content){
//        1 iteration:
//        PostModel exemple = new PostModel();
//        exemple.setTitle("Some title");
//        return exemple;

//        2 iteration:
//        return postRepository.findAll();

//        3 iteration:

        Pageable pageable = PageRequest.of(page, size);
        if (content != null) {
            return postRepository.findByContentContaining(content, pageable);
        }
        Page<PostModel> posts = postRepository.findAll(pageable);
        return posts;
    }
}
