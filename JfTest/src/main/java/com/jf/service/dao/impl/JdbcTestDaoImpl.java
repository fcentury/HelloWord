package com.jf.service.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jf.model.JdbcTest;
import com.jf.service.dao.JdbcTestDao;

/**
 * jdbcTestdaoimpl-spring jdbc
 * @author jiafengma
 */
@Repository
public class JdbcTestDaoImpl implements JdbcTestDao {
	
	@Autowired
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbctemplate;
	@Autowired
	@Qualifier("jdbcTemplate2")
	private JdbcTemplate jdbctemplate2;
	
	/**
     * <p>
     * 定义PreparedStatementCreator的实现类
     * </p>
     * @author jiafengma
     * @date Jul 31, 2013
     */
    protected class PSCreator implements PreparedStatementCreator {
    	JdbcTest bean;

        public PSCreator(JdbcTest bean) {
            this.bean = bean;
        }

        @Override
        public java.sql.PreparedStatement createPreparedStatement(
                java.sql.Connection con) throws SQLException {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into jdbc_test (name,status) values (?,?)",Statement.RETURN_GENERATED_KEYS);
            int parameterIndex = 1;
            ps.setString(parameterIndex++, bean.getName());
            ps.setInt(parameterIndex++, bean.getStatus());
            return ps;
        }
    }
    
    /**
     * <p>
     * 定义RowMapper的实现类
     * </p>
     * @author jiafengma
     */
    protected class ItemMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        	JdbcTest item = new JdbcTest();
            item.setId(rs.getLong("id"));
            item.setName(rs.getString("name"));
            item.setStatus(rs.getInt("status"));
            return item;
        }
    }

	@Override
	public long saveWithId(JdbcTest bean) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbctemplate.update(new PSCreator(bean), keyHolder);
        Long id = (Long) keyHolder.getKey();
		return id;
	}
	
	@Override
	public boolean saveWithoutId(JdbcTest bean){
		System.out.println("##---savewithoutid-" + bean.getId());
		/**
		 * id为0,jdbc忽略id，使用id自增，如果id>0则会使用设置的id插入
		 */
//		final String sql = "insert into jdbc_test (id,name,status) values (?,?,?)";
//		Object[] params = new Object[]{bean.getId(),bean.getName(),bean.getStatus()};
		boolean flag = swTest(bean);
		return flag;
	}

	@Override
	public boolean update(JdbcTest bean) {
		return false;
	}

	@Override
	public JdbcTest get(long id) {
		final String sql = "select * from jdbc_test where id=?";
		Object[] params = new Object[]{id};
		List<JdbcTest> items = jdbctemplate.query(sql, params,new ItemMapper());
		if(items.isEmpty()){
			return null;
		}
		return items.get(0);
	}
	
//	@Transactional 此注解应用在@service注解的类中
	public boolean swTest(JdbcTest bean){
		final String sql = "insert into jdbc_test (name,status) values (?,?)";
		final String sql2 = "insert into jdbc_test2 (name,status) values (?,?)";
		Object[] params = new Object[]{bean.getName(),bean.getStatus()};
		jdbctemplate2.update(sql,params);
		jdbctemplate2.update(sql2,params);
		int flag = jdbctemplate.update(sql,params);
//		jdbctemplate.execute("insert into jdbc_test (name,status) values ('jk',1)");
//		jdbctemplate.execute("insert into jdbc_test2 (name,status) values ('kl',1)");
		jdbctemplate.update(sql2,params);
		int j = 1/0;
//		if(flag > 0) return true;
		return false;
	}

}
