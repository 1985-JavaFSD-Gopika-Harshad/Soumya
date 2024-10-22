package com.inventory.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.system.model.Supplier;
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
	public Supplier createSupplier(@RequestBody Supplier supplier) {
		return supplierService.createSupplier(supplier);
	}


}
