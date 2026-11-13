package com.example.ems.repository;
import com.example.ems.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
public interface AttendanceRepository extends JpaRepository<Attendance,Long>{
 List<Attendance> findAllByOrderByDateDesc();
 boolean existsByEmployeeIdAndDate(Long employeeId, LocalDate date);
}
