package com.hex.trs.repository;

import com.hex.trs.model.CustomerPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerPlanRepository extends JpaRepository<CustomerPlan, Long> {
	

}

