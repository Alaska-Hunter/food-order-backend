package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.User;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the {@link User} entity.
 */
@Repository
public interface CustomerRepository extends JpaRepository<User, Long> {
    Optional<Customer> findOneByActivationKey(String activationKey);

    List<Customer> findAllByActivatedIsFalseAndActivationKeyIsNotNullAndCreatedDateBefore(Instant dateTime);

    Optional<Customer> findOneByResetKey(String resetKey);

    Optional<Customer> findOneByEmailIgnoreCase(String phone);



    @EntityGraph(attributePaths = "authorities")
    Optional<Customer> findOneWithAuthoritiesByLogin(String login);

    @EntityGraph(attributePaths = "authorities")
    Optional<Customer> findOneWithAuthoritiesByEmailIgnoreCase(String phone);

    Page<Customer> findAllByIdNotNullAndActivatedIsTrue(Pageable pageable);
}
