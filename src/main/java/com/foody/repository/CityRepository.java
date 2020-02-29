package com.foody.repository;

import com.foody.entity.City;
import com.foody.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    @Query(value="SELECT * from city c where c.state_id=?1", nativeQuery = true)
    List<City> getCityByState(int stateId);

}
