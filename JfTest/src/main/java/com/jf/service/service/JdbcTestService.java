package com.jf.service.service;

import com.jf.model.JdbcTest;

/**
 * service - spring jdbc
 * @author jiafengma
 */
public interface JdbcTestService {
	
	public long saveWithId(JdbcTest bean);

	public boolean saveWithoutId(JdbcTest bean);
	
	public boolean update(JdbcTest bean);
	
	public JdbcTest get(long id);
}
