package com.projects.RestApiMssql.repository;

import com.projects.RestApiMssql.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
