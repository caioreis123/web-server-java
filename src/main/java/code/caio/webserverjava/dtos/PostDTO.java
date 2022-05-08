package code.caio.webserverjava.dtos;

import code.caio.webserverjava.models.PostModel;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private String authorName;

    public PostDTO(PostModel post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.authorName = post.getAuthor().getLogin();
    }

    public static List<PostDTO> convertPostsToDTO(List<PostModel> posts) {
        return posts.stream().map(PostDTO::new).collect(toList());
    }
}
