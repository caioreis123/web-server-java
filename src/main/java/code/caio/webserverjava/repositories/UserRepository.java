package code.caio.webserverjava.repositories;

import code.caio.webserverjava.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findById(long id);
}
