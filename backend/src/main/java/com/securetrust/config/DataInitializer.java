package com.securetrust.config;

import com.securetrust.model.Account;
import com.securetrust.model.Customer;
import com.securetrust.repository.AccountRepository;
import com.securetrust.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(CustomerRepository customerRepo, AccountRepository accountRepo) {
        return args -> {
            // Check if data already exists
            if (customerRepo.count() > 0) {
                return;
            }

            // Create customers
            Customer john = new Customer();
            john.setName("John Doe");
            john.setEmail("john@securetrust.com");
            john.setPhone("+1234567890");
            customerRepo.save(john);

            Customer jane = new Customer();
            jane.setName("Jane Smith");
            jane.setEmail("jane@securetrust.com");
            jane.setPhone("+0987654321");
            customerRepo.save(jane);

            // Create accounts
            Account account1 = new Account();
            account1.setCustomer(john);
            account1.setAccountType("SAVINGS");
            account1.setAccountNumber("SB1001");
            account1.setBalance(12500.00);
            accountRepo.save(account1);

            Account account2 = new Account();
            account2.setCustomer(john);
            account2.setAccountType("CHECKING");
            account2.setAccountNumber("CK1001");
            account2.setBalance(8500.50);
            accountRepo.save(account2);

            Account account3 = new Account();
            account3.setCustomer(jane);
            account3.setAccountType("SAVINGS");
            account3.setAccountNumber("SB1002");
            account3.setBalance(34200.75);
            accountRepo.save(account3);

            System.out.println("Initial data loaded successfully!");
        };
    }
}
