package com.test.SpringBootApi.respository;

import com.test.SpringBootApi.domain.Beverage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeverageRepository extends JpaRepository<Beverage, Long> {

    List<Beverage> findBeverageByCarbonatedTrue();
}
