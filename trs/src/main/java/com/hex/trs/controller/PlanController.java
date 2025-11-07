package com.hex.trs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hex.trs.dto.PlanDto;
import com.hex.trs.service.PlanService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/plan")
@AllArgsConstructor
public class PlanController {
	
	
	private final PlanService planService ;
	// write a get api to fetch all plan information along with the number of customer subscribing for each plan
    
    @GetMapping("customer/plansubscribing")
    public List<PlanDto> getAllPlansWithCustomerCount() {
    	return planService.getAllPlansWithCustomerCount();
    }
	
	
	

}
