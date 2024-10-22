package com.inventory.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.system.model.Supplier;
import com.inventory.system.repository.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	public SupplierService(SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}
	
	//create supplier
	public Supplier createSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

}
