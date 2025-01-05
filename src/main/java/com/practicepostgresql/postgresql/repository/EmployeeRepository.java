package com.practicepostgresql.postgresql.repository;

import com.practicepostgresql.postgresql.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
