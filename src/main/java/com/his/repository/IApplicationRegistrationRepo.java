package com.his.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.his.entity.ApplicationRegistration;

public interface IApplicationRegistrationRepo extends JpaRepository<ApplicationRegistration, Long> 
{
    
}
