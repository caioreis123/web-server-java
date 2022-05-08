package code.caio.webserverjava.repositories;

import code.caio.webserverjava.models.PostModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostModel, Long> {
    Page<PostModel> findByContentContaining(String content, Pageable pageable);
}
