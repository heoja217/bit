package carrot.control.json;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import carrot.domain.Order;
import carrot.service.OrderService;

@Controller("json.orderControl")
@RequestMapping("/json/order")
public class OrderControl {
  static Logger log = Logger.getLogger(OrderControl.class);
  static final int PAGE_DEFAULT_SIZE = 10;
  
  @Autowired OrderService     	orderService;
  @Autowired ServletContext 		servletContext;
 
  @RequestMapping(value="/add", method=RequestMethod.POST)
  public Object add(Order order) throws Exception {  
    
    orderService.add(order);
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    
    return resultMap;
  }

  @RequestMapping("/delete")
  public Object delete(int no) throws Exception {
    orderService.delete(no);
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    
    return resultMap;
  }
  
  @RequestMapping("/list")
  public Object list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="10") int pageSize, int supplierNo) throws Exception {
    
    if (pageSize <= 0)
      pageSize = PAGE_DEFAULT_SIZE;
    
    int maxPageNo = orderService.getMaxPageNo(pageSize, supplierNo);
    
    if (pageNo <= 0) pageNo = 1;
    if (pageNo > maxPageNo) pageNo = maxPageNo;
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("currPageNo", pageNo);
    resultMap.put("maxPageNo", maxPageNo);
    resultMap.put("orders", 
        orderService.getList(pageNo, pageSize, supplierNo));
    
    return resultMap;
  }
  
  @RequestMapping("/update")
  public Object update(Order order) throws Exception {
    orderService.update(order);
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    return resultMap;
  }
  
  @RequestMapping("/view")
  public Object view(int no, Model model) throws Exception {
    Order order = orderService.get(no);
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("order", order);
    return resultMap;
  }
}












