package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Course;
import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.domain.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerCourseRepository extends JpaRepository<UserCourse, Long> {
    Optional<CustomerFood> findOneByUserAndCourse(Customer customer, Food food);
    List<CustomerFood> findAllByUser(Customer customer);

    @Transactional //增删改：必须要加
    void deleteByUserAndCourse(Customer customer, Food food);
}
