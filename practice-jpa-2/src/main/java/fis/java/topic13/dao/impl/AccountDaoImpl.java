package fis.java.topic13.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import fis.java.topic13.dao.AccountDao;
import fis.java.topic13.entity.Account;

@Service
public class AccountDaoImpl implements AccountDao{
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Account> getByFullname(String fullname) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM training.accounts where fullname like :fullname;";
		Map<String, String> params = new HashMap<>();
		params.put("fullname", "%" + fullname + "%");
		
		return jdbcTemplate.query(sql, params, new RowMapper<Account>() {

			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account account = new Account();
				account.setAccountId(rs.getLong("account_id"));
				account.setAccountNo(rs.getString("account_no"));
				account.setCardNo(rs.getString("card_no"));
				account.setAmount(rs.getDouble("amount"));
				account.setFullname(rs.getString("fullname"));
				account.setIssuedDate(rs.getDate("issued_date"));
				account.setUpdateDate(rs.getDate("update_date"));
				return account;
			}
		});
	}

}
