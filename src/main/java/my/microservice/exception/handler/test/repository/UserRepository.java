package my.microservice.exception.handler.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import my.microservice.exception.handler.test.domain.User;

@Component
public interface UserRepository extends JpaRepository<User,Long>{

}
