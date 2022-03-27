package car_dealer.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "car_dealer")
@EnableTransactionManagement
@PropertySource(value = "car_dealer.properties")
public class Config {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
