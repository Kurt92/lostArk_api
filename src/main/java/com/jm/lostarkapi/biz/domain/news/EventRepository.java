package com.jm.lostarkapi.biz.domain.news;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {


    Boolean existsByTitle(String title);

    @Query("SELECT e.title FROM Event e")
    List<String> findAllTitles();
}
