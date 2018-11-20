package com.spillz.genstore.models.data;

import com.spillz.genstore.models.Inventory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.CrudRepository;


@Repository
@Transactional
public interface InventoryDao extends CrudRepository<Inventory, Integer> {




}
