package scheper.mateus.api.repository;

import org.springframework.stereotype.Repository;
import scheper.mateus.api.entity.User;

import java.util.Optional;

@Repository
@SuppressWarnings("unchecked")
public class UserRepository extends BaseRepository {

    public Optional<User> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(entityManager.find(User.class, id));
    }
}
