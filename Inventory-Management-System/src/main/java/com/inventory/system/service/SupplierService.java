package com.inventory.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.system.dto.SupplierRequest;
import com.inventory.system.dto.SupplierResponse;
import com.inventory.system.model.Supplier;
import com.inventory.system.repository.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	public SupplierService(SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}
	
	public SupplierResponse mapToSupplierResponse(Supplier supplier) {
	return SupplierResponse.builder()
			.supplier_id(supplier.getSupplier_id())
			.name(supplier.getName())
			.email(supplier.getEmail())
			.build();
	}
	
	
	//create supplier
	public SupplierResponse createSupplier(SupplierRequest supplierRequest) {
		Supplier supplier = Supplier.builder()
				.name(supplierRequest.getName())
				.email(supplierRequest.getEmail())
				.build();
		Supplier sup = supplierRepository.save(supplier);
		return mapToSupplierResponse(sup);
 	}
	
	//get supplier by id
	public SupplierResponse getSupplierById(Long Supplier_id) {
		Supplier supplier = supplierRepository.getById(Supplier_id);
		return mapToSupplierResponse(supplier);
	}
	
	//get all suppliers
	public List<SupplierResponse> getAllSuppliers(){
		List<Supplier> suppliers = supplierRepository.findAll();
		return suppliers.stream()
				.map(this::mapToSupplierResponse)
				.toList();
	}
	
	//update supplier
	public SupplierResponse updateSupplier(SupplierRequest supplierRequest, Long supplier_id) {
		Supplier existingSupplier = supplierRepository.getById(supplier_id);
		existingSupplier.setName(supplierRequest.getName());
		existingSupplier.setEmail(supplierRequest.getEmail());
		Supplier supplier = supplierRepository.save(existingSupplier);
		return mapToSupplierResponse(supplier);
	}

	//delete supplier
	public boolean deleteSupplier(Long supplier_id) {
		Supplier supplier = supplierRepository.getById(supplier_id);
		supplierRepository.delete(supplier);
		return true;
	}
}
