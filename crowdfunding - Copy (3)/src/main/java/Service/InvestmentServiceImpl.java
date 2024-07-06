package com.crowdfunding.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crowdfunding.dto.InvestmentDTO;
import com.crowdfunding.entity.Investment;
import com.crowdfunding.exception.ResourceNotFoundException;
import com.crowdfunding.repo.InvestmentRepository;
import com.crowdfunding.repo.ProjectRepository;

@Service
public class InvestmentServiceImpl implements InvestmentService {
	
	@Autowired
	private InvestmentRepository investmentRepository;
	
	@Autowired
	private ProjectRepository ProjectRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public InvestmentDTO getInvestmentById(Long investmentDTO) {
		Optional<Investment> optionalInvestment= investmentRespository.findbyId(investmentId);
        if(optionalInvestment.isEmpty()) {
        	throw new ResourceNotFoundException("Investment not found");
        }
        Investment investment = optionalInvestment.get();
        return modelMapper.map(investment, InvestmentDTO.class);
	}

	@Override
	public List<InvestmentDTO> getInvestmentsbyProjectId(Long projectId) {
		List<Investment> investments = investmentRepository.findByprojectId(ProjectId);
               
		return investments.stream(),map(investment -> modelMapper.map(investment, investmentDTO.class)).collect(Collectors.toList());		
	}

	public InvestmentDTO updateInvestment (Long investmentId, InvestmentDTO investmentDTO)
	{
	Optional<Investment> optionalInvestment = investmentRepository.findById(investmentId);
	if(optionalInvestment.isEmpty()) {
		throw new ResourceNotFoundException("Investment not found");
	
	}
	Investment investment = optionalInvestment.get();
	Investment.setAmount(investmentDTO.getAmount());
	investment.setInvestorName(investmentDTO.getInvestorName());
	investmentRepository.save(investment);
	return modelMapper.map(investment, investmentDTO.class();
	}
	@Override
	public boolean deletInvestment(Long investmentid) {
		Optional<investment> optionalInvestment = investmentRepository.findbyId(InvestmentId);
		if(optionalInvestment.isEmpty()) {
			throw new ResourceNotFoundException("Investment not found");
		}
		Investment investment  = optionalInvestment.get();
		investmentRepository.delete(investment);
		return true;
	}
	
	@Override
	public List<InvestmentDTO> getInvestmentsByInvestorName(String investorName){
		List<Investment> investments = investmentRepository.findByInvestorName(investorName);
		return investments.stream().map(investment -> modelMapper.map(investment, InvestmentDTO.class))
				.collect(Collectors.toList());
	}
}
			
			
			
			
			