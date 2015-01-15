package carrot.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import carrot.dao.OrderDao;
import carrot.domain.Order;

/* Service 컴포넌트의 역할
 * => 비즈니스 로직 수행
 * => 트랜잭션 관리
 */

@Service
public class OrderService {
  @Autowired
  OrderDao orderDao;
  
  public List<?> getList(int pageNo, int pageSize, int supplierNo) {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", ((pageNo - 1) * pageSize));
    paramMap.put("pageSize", pageSize);
    paramMap.put("supplierNo", supplierNo);
    return orderDao.selectList(paramMap);
  }
  
  public int getMaxPageNo(int pageSize, int supplierNo) {
    int totalSize = orderDao.totalSize(supplierNo);
    int maxPageNo = totalSize / pageSize;
    if ((totalSize % pageSize) > 0) maxPageNo++;
    
    return maxPageNo;
  }
  
  /* @Transactional 선언
   * => 메서드 안의 입력/변경/삭제(manipluation) 작업을 하나의 작업을 묶는다.
   * => 모든 작업이 성공했을 때만 서버에 반영한다. 
   */
  @Transactional(
      rollbackFor=Exception.class, 
      propagation=Propagation.REQUIRED)
  public void add(Order order) {
    orderDao.insert(order);
  }
  
  @Transactional(
      rollbackFor=Exception.class, 
      propagation=Propagation.REQUIRED)
  public void update(Order order) {
    orderDao.update(order);
  }
  
  @Transactional(
      rollbackFor=Exception.class, 
      propagation=Propagation.REQUIRED)
  public void delete(int orderNo) {
    orderDao.delete(orderNo);
  }
  
  public Order get(int orderNo) {
    Order order = orderDao.selectOne(orderNo);
    return order;
  }
}
















