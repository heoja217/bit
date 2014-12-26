package java63.web03.service;

import java.util.HashMap;
import java.util.List;

import java63.web03.dao.ProductDao;
import java63.web03.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/* Service 컴포넌트의 역할 
 => 비즈니스 로직 수행
 => 트랜잭션 관리
*/
@Service
public class ProductService {
	@Autowired
	ProductDao productDao;
	
	public List<?> getList(int pageNo, int pageSize){
	  
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", ((pageNo - 1) * pageSize));
    paramMap.put("pageSize", pageSize);
    
    return productDao.selectList(paramMap);
	}
	
  public int getMaxPageNo(int pageSize) {
    int totalSize = productDao.totalSize();
    int maxPageNo = totalSize / pageSize;
    if ((totalSize % pageSize) > 0) maxPageNo++;
    
  	return maxPageNo;
  }
  
  /* Transaction
   => 여러 개의 작업을 하나로 묶은 것
   												ㄴ여러 개의 작업 중 하나라도 
   												오류가 발생하면 전체 작업을 취소.= rollback
   												=>모든 작업이 성공하면 결과를 확정 = commit
  
  * @Transactioanl 선언
 => 메서드 안의 입력/변경/삭제(manipulation) 작업을 하나의 작업으로 묶는다.
 => 모든 작업이 성공했을때만 서버에 반영한다.
  */
  @Transactional(
  		rollbackFor=Exception.class, 
  		propagation=Propagation.REQUIRED)
  public void add(Product product) {
    productDao.insert(product);
    if (product.getPhoto() != null) {
    	productDao.insertPhoto(product);
    }
  }
  
  @Transactional(
  		rollbackFor=Exception.class, 
  		propagation=Propagation.REQUIRED)
  public void update(Product product) {
    productDao.update(product);
  }
  
  @Transactional(
  		rollbackFor=Exception.class, 
  		propagation=Propagation.REQUIRED)
  public void delete(int productNo) {
    productDao.deletePhoto(productNo);
    productDao.delete(productNo);
  }
  
  public Product get(int productNo) {
  	Product product = productDao.selectOne(productNo);
  	product.setPhotoList(productDao.selectPhoto(productNo));
  	return product;
  }
  
}

/* Transaction 관리 정책
 1) Requird
  호출자 | 	m1()
------------------
   Tx1	 |  Tx1
    X		 |	Tx1
 
 2) Required-New
  호출자 | 	m1()
------------------
   Tx1	 |  Tx2
    X		 |  Tx1
    
 3) Supports
  호출자 | 	m1()
------------------
   Tx1	 |  Tx1
    X		 |   X
 
 4) Not Supported
  호출자 | 	m1()
------------------
   Tx1	 |	 X    suspend (지원하지 않음)
    X		 |   X 
    
 5) Mandatory
  호출자 | 	m1()
------------------
   Tx1	 | 	Tx1
    X		 | error

 6) Never
  호출자 | 	m1()
------------------
   Tx1	 | error
    X		 |   X 
   
*/
