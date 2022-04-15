package com.mycompany.myapp.service.dto;

/**
 * A DTO representing a user, with only the public attributes.
 */
public class CustomerDTO {

    private int phone;
    private int id;


    public CustomerDTO() {
        // Empty constructor needed for Jackson.
    }

    public CustomerDTO(Customer customer) {
        this.id = Customer.getId();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    // prettier-ignore
    @Override
    public String toString() {
        return "CustomerDTO{" +
            "id='" + id + '\'' +
            "}";
    }
}
