package com.outer_shopping.project.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.outer_shopping.project.dao.OuterDao;
import com.outer_shopping.project.vo.OuterVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
@Transactional
public class OuterDaoImpl implements OuterDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
    private JpaTransactionManager transactionManager;
	
	/**
	 * 아웃터 등록
	 */
	@Override
	public void insertOuter(OuterVo outer) {
		
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
	    
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = transactionManager.getTransaction(def);
		
		try {
			
			entityManager.merge(outer);
			
			transactionManager.commit(status);
			
		}catch (Exception e) {
			transactionManager.rollback(status); // Spring transaction rollback
			e.getStackTrace();
			
			System.out.println("insertOuter(dao) : ");
			e.printStackTrace();
		}
		
		
	}
	
}
