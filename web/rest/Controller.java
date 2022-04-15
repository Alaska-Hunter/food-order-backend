package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.security.SecurityUtils;
import com.mycompany.myapp.service.CourseService;
import com.mycompany.myapp.service.dto.CourseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class Controller {
    private Service Service;

    /**
     * 1. Requirements: 顾客点餐
     * 2. Http Method: POST (create)
     * 3. URL: /foodlist/{foodName}
     * 4. HTTP status code: 201
     * 5. Request body: path variable - {foodName}
     * 6. Response body: None (void)
     * 7. Request Header: JWT Token
     */
    @PostMapping(path = "/foodlist/{foodName}")
    @ResponseStatus(HttpStatus.CREATED)
    public void orderFood(@PathVariable String foodName) {
        String customerName = getcustomerName();
        Service.orderFood(customerName, foodName);
    }

    /**
     * 1. Requirements: 列出菜单
     * 2. Http Method: GET
     * 3. URL: /foodlist
     * 4. HTTP status code: 200
     * 5. Request body: None
     * 6. Response body: List<CourseDTO>
     * 7. Request Header: JWT Token
     */
    @GetMapping(path = "/food-list")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<foodlistDTO> getfoodList() {
        return Service.getfoodList();
    }

    /**
     * 1. Requirements: 列出顾客所有订菜
     * 2. Http Method: GET
     * 3. URL: /customer/foodlist
     * 4. HTTP status code: 200
     * 5. Request body: None
     * 6. Response body: List<CourseDTO>
     * 7. Request Header: JWT Token
     */
    @GetMapping(path = "/customer/foodlist")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<CourseDTO> getcustomerFoodList() {
        String customerName = getcustomerName();
        return Service.getcustomerfoodList(customerName);
    }

    /**
     * Extract username from JWT token
     * @return
     */
    private String getUserName() {
        return SecurityUtils.getCurrentUserLogin().orElseThrow(() -> {
            throw new UsernameNotFoundException("Username not found");
        });
    }

}

