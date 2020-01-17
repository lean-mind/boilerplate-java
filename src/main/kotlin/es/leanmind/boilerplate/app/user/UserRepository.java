package es.leanmind.boilerplate.app.user;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Optional<User> getByEmail(String username);

    Optional<User> findByIdAndDeletedIsFalse(Long id);

    Optional<User> getByEmailAndDeletedFalse(String username);
}
