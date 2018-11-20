package com.spillz.genstore.models.data;


import com.spillz.genstore.models.Invoice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;




@Repository
@Transactional
public interface InvoicesDao extends CrudRepository<Invoice, Integer>


 {
}
