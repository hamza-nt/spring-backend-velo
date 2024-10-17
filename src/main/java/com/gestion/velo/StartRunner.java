package com.gestion.velo;

import com.gestion.velo.entity.Customer;
import com.gestion.velo.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@AllArgsConstructor
public class StartRunner implements ApplicationRunner {

    private final CustomerRepository customersRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Customer> customers = customersRepo.findAll();
        if(!customers.isEmpty()){
            System.out.println(customers.size() + " customers found");
        }
    }
}
