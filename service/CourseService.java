package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Course;
import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.domain.UserCourse;
import com.mycompany.myapp.repository.CourseRepository;
import com.mycompany.myapp.repository.UserCourseRepository;
import com.mycompany.myapp.repository.UserRepository;
import com.mycompany.myapp.service.dto.CourseDTO;
import com.mycompany.myapp.service.mapper.CourseMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor //lombok - generate all args constructor
public class FoodService {
    private CustomerRepository CustomerRepository;
    private FoodRepository FoodRepository;
    private CustomerFoodListRepository CustomerFoodListRepository;
    private FoodMapper FoodMapper;

    public void orderFood(String Customer, String foodName) {
        CustomerFood customerFood = getCustomerFood(customerName, FoodName);

        Optional<customerFood> optionalcustomerFood = customerFoodRepository.findOneBycustomerFood(customerFood.getCustomer(), customerFood.getFoodList());
        optionalcustomerFood.ifPresent(existingcustomerFood -> {
            throw new IllegalArgumentException("customerFood already exist: " + existingcustomerFood.toString());
        });

        customerFoodRepository.save(customerFood);
    }

    public List<CourseDTO> getFoodList() {
        List<Course> foodList = CustomerFoodListRepository.findAll();

        return foodList.stream().map(course -> foodMapper.convert(food)).collect(Collectors.toList());
    }

    public List<FoodListDTO> getcustomerFood(String customerName) {

        Custumer custumer = getCustomerbycustomerName(customer);

        List<customerFood> customerFoodList = customerFoodRepository.findAllByCustomer(cutomer);

        return customerFoodList.stream()
            .map(customerFood -> customerFood.getfoodList())
            .map(food -> foodListMapper.convert(food))
            .collect(Collectors.toList());
    }


    private customerFood getcustomerFood(String customerName, String foodName) {

        Customer customer = getCustomerbyCustomerName(customer);

        Food food = getFoodByFoodName(FoodName);

        return new customerFood(customer, food);
    }

    private Customer getCustomerbyCustomerName(String customer) {
        Optional<customer> optionalcustomer = customerRepository.findOneByLogin(customerName);
        return optionalCustomer.orElseThrow(() -> new UCustomernameNotFoundException("No such customer: " + customerName));
    }

    private Food getFoodByFoodNameByCourseName(String foodName) {
        Optional<Food> optionalFood = FoodRepository.findOneByFoodName(FoodName);
        return optionalFood.orElseThrow(() -> new IllegalArgumentException("No such Food: " + FoodName));
    }
}
