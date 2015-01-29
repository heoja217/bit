package carrot.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import carrot.dao.CompanyDao;
import carrot.domain.Company;

/* Service 컴포넌트의 역할
 * => 비즈니스 로직 수행
 * => 트랜잭션 관리
 */

@Service
public class CompanyService {
	@Autowired
	CompanyDao companyDao;

public Company validate(String sid, String spwd) {
		HashMap<String, String> params = new HashMap<>();
		params.put("sid", sid);
		params.put("spwd", spwd);
		return companyDao.existUser(params);
	}

	/*
	 * @Transactional 선언 => 메서드 안의 입력/변경/삭제(manipluation) 작업을 하나의 작업을 묶는다. => 모든
	 * 작업이 성공했을 때만 서버에 반영한다.
	 */
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void add(Company company) {
		companyDao.insert(company);

	}
	
	public List<Company> getList(HashMap<String,Object> paramMap) {
		return companyDao.selectNameList(paramMap);
	}
	
	public Company selectOne(int sid) {
		System.out.println(sid);
		return companyDao.selectOne(sid);
	}
}
