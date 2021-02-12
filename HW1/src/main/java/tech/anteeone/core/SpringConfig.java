package tech.anteeone.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.anteeone.beans.AdditonOperator;
import tech.anteeone.beans.DividingOperator;
import tech.anteeone.beans.MultiplicationOperator;
import tech.anteeone.beans.SubstractionOperator;

@Configuration
public class SpringConfig {

    @Bean
    public AdditonOperator additonOperator(){
        return new AdditonOperator();
    }

    @Bean
    public SubstractionOperator substractionOperator(){
        return new SubstractionOperator();
    }

    @Bean
    public MultiplicationOperator multiplicationOperator(){
        return new MultiplicationOperator();
    }

    @Bean
    public DividingOperator dividingOperator(){
        return new DividingOperator();
    }
}
