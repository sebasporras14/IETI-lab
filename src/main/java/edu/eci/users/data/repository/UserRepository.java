package edu.eci.users.data.repository;

import edu.eci.users.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    // Additional custom query methods (if needed)
}
