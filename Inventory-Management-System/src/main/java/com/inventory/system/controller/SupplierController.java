package com.inventory.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.system.dto.SupplierRequest;
import com.inventory.system.dto.SupplierResponse;
 import com.inventory.system.service.SupplierService;

@RestController
@RequestMapping("/supplier/")
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	public SupplierController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	
	@PostMapping
	public SupplierResponse createSupplier(@RequestBody SupplierRequest supplierRequest) {
		return supplierService.createSupplier(supplierRequest);
 	}

	@GetMapping("{supplier_id}")
	public SupplierResponse getSupplierById(@PathVariable Long supplier_id) {
		return supplierService.getSupplierById(supplier_id);
	}
	
	@GetMapping("all")
	public List<SupplierResponse> getAllSuppliers(){
		return supplierService.getAllSuppliers();
	}

	@PutMapping("update/{supplier_id}")
	public SupplierResponse updateSupplier(@RequestBody SupplierRequest supplierRequest,@PathVariable Long supplier_id) {
		return supplierService.updateSupplier(supplierRequest, supplier_id);
	}
	
	@DeleteMapping("{supplier_id}")
	public boolean deleteSupplier(@PathVariable Long supplier_id) {
		return supplierService.deleteSupplier(supplier_id);
	}




}
