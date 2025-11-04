package com.hex.trs.model;

import com.hex.trs.enums.JobTitle;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "executives")
@Getter
@Setter
@NoArgsConstructor
public class Executive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private JobTitle jobTitle;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public JobTitle getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}
    
    
	


}