package com.example.address_service.repo;

import com.example.address_service.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address,Long> {
    @Query(value = "SELECT a.* " +
            "FROM mydb.employee e " +
            "JOIN mydb.address a ON e.id = a.employee_id " +
            "WHERE e.id = :empId", nativeQuery = true)
    Address findByEmployeeId(@Param("empId") Long empId);

}
