package com.hex.trs.service;

import org.springframework.stereotype.Service;

import com.hex.trs.dto.TicketReqDto;
import com.hex.trs.enums.Status;
import com.hex.trs.mapper.TicketMapper;
import com.hex.trs.model.Ticket;
import com.hex.trs.repository.TicketRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketService {

	
	private TicketMapper ticketMapper;
	private TicketRepository ticketRepository;
	
	public Ticket add(TicketReqDto ticketReqDto) {
		
		//convert Dto to Entity using Mapper
		
		Ticket ticket = ticketMapper.toEntity(ticketReqDto);
		ticket.setStatus(Status.OPEN);
		
		return ticketRepository.save(ticket);
	}

}
