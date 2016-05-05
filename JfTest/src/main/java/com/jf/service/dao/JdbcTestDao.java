package com.jf.service.dao;

import com.jf.model.JdbcTest;

/**
 * jdbcTestdao-spring jdbc
 * @author jiafengma
 */
public interface JdbcTestDao {
	
	public long saveWithId(JdbcTest bean);

	public boolean saveWithoutId(JdbcTest bean);
	
	public boolean update(JdbcTest bean);
	
	public JdbcTest get(long id);
}
