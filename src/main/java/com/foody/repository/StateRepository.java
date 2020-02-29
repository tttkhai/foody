package com.foody.repository;

import com.foody.entity.City;
import com.foody.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

    @Query(value="SELECT * from state s where s.country_id=?1", nativeQuery = true)
    List<State> getStateByCountry(int countryId);
}
