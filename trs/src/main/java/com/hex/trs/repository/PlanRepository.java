package com.hex.trs.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.hex.trs.dto.PlanDto;
import com.hex.trs.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    @Query("SELECT new com.hex.trs.dto.PlanDto(p.id, p.name, p.price, COUNT(cp.customer.id)) " +
           "FROM Plan p LEFT JOIN CustomerPlan cp ON p.id = cp.plan.id " +
           "GROUP BY p.id, p.name, p.price")
    List<PlanDto> getAllPlansWithCustomerCount();
}


//@Query("""
//        select new com.hex.trs.dto.PlanDto(p.id,p.name,p.price,count(c.id))
//        from Plan p LEFT JOIN CustomerPlan cp ON p.id = cp.plan.id
//        LEFT JOIN Customer c ON cp.customer = c
//        group by p.id
//        """)
//List<PlanDto> getPlanDetailsWithCustomerCount();



/*
* select p.id,p.name,p.price,count(c.id) as num_customers
    -> from customers c RIGHT join customer_plan cp ON c.id = cp.customer_id
    -> RIGHT JOIN plan p ON cp.plan_id = p.id
    -> group by p.id,p.name,p.price;
* */