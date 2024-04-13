package com.MVRGroup.repository;

import com.MVRGroup.entity.RawmaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RawmaterialRepository extends JpaRepository<RawmaterialEntity, Integer>  {
    // You can add custom methods if needed
	  @Query(value = "INSERT INTO raw_material (raw_material_id, date_added, description, expiry_date, name, quantity_available, storage_conditions, supplier_name, unit_price) VALUES (:#{#rawMaterial.rawMaterialID}, :#{#rawMaterial.dateAdded}, :#{#rawMaterial.description}, :#{#rawMaterial.expiryDate}, :#{#rawMaterial.name}, :#{#rawMaterial.quantityAvailable}, :#{#rawMaterial.storageConditions}, :#{#rawMaterial.supplierName}, :#{#rawMaterial.unitPrice})", nativeQuery = true)
	 RawmaterialEntity saveRawMaterial(RawmaterialEntity rawMaterial);
}
