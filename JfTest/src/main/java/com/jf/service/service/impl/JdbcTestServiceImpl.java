package com.jf.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jf.model.JdbcTest;
import com.jf.service.dao.JdbcTestDao;
import com.jf.service.service.JdbcTestService;

/**
 * serviceimpl - spring jdbc
 * @author jiafengma
 */
@Service
public class JdbcTestServiceImpl implements JdbcTestService {
	
	@Autowired
	private JdbcTestDao dao;

	@Override
	public long saveWithId(JdbcTest bean) {
		System.out.println(bean);
		return dao.saveWithId(bean);
	}

	/**
	 * 事务测试
	 */
	@Override
	@Transactional
	public boolean saveWithoutId(JdbcTest bean) {
		System.out.println(bean);
		return dao.saveWithoutId(bean);
	}

	@Override
	public boolean update(JdbcTest bean) {
		return false;
	}

	@Override
	public JdbcTest get(long id) {
		return dao.get(id);
	}

}
