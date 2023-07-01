package kz.com.SerAya.Repository;

import kz.com.SerAya.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}