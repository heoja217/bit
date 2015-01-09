package carrot.dao;

import java.util.Map;

import carrot.domain.Company;


public interface CompanyDao {
	
	void insert(Company company);
	Company existUser(Map<String,String> params);
	Company selectOne(int sid);
}