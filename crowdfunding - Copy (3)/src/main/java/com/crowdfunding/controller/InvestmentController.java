package com.crowdfunding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crowdfunding.dto.InvestmentDTO;

import Service.InvestmentService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "https://localhost:3000/")
@RequestMapping("/api/investments")
public class InvestmentController {
	
    @Autowired
    private InvestmentService investmentService;


    @GetMapping("/{id}")
    public ResponseEntity<InvestmentDTO> getInvestmentById(@PathVariable Long investmentId){
    return new ResponseEntity<>(investmentService.getInvestmentById(investmentId), HttpStatus.OK);
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<List<InvestmentDTO>> getInvestmentsByProjectId(@PathVariable Long projectId){
        List<InvestmentDTO> investments = investmentService.getInvestmentsByProjectId(projectId);
        return new ResponseEntity<>(investments, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<InvestmentDTO> createInvestment(@Valid @RequestBody InvestmentDTO investmentDTO){
        return new ResponseEntity<>(investmentService.makeInvestment(investmentDTO), HttpStatus.CREATED);
        }
   @PutMapping("/{id}")
    public ResponseEntity<InvestmentDTO> updateInvestment(@PathVariable Long investmentId,@Valid @RequestBody InvestmentDTO investmentDTO){
    return new ResponseEntity<>(investmentService.updateInvestment(investmentId,investmentDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InvestmentDTO> deleteInvestment(@PathVariable Long investmentId){
    investmentService.deleteInvestment(investmentId);
    return new ResponseEntity<>( HttpStatus.OK);
    }
    @GetMapping("/investor/{investorName}")
    public ResponseEntity<List<InvestmentDTO>> getInvestmentsByInvestorName(@PathVariable String investorName){
        List<InvestmentDTO> investments = investmentService.getInvestmentsByInvestorName(investorName);
        return new ResponseEntity<>(investments, HttpStatus.OK);
    }
}// write your logic here

