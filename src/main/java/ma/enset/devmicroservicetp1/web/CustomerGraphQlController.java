package ma.enset.devmicroservicetp1.web;

import lombok.AllArgsConstructor;
import ma.enset.devmicroservicetp1.entities.Customer;
import ma.enset.devmicroservicetp1.repositories.CustomerRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerGraphQlController {
    private CustomerRepository customerRepository;


    @QueryMapping
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }
}