package ma.enset.devmicroservicetp1.repositories;

import ma.enset.devmicroservicetp1.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
