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

import carrot.dao.SupplierDao;
import carrot.domain.Supplier;

@Controller("json.supplierControl")
@RequestMapping("/json/supplier")
public class SupplierControl {
  static Logger log = Logger.getLogger(SupplierControl.class);
  static final int PAGE_DEFAULT_SIZE = 5;
  
  @Autowired SupplierDao supplierDao;
  @Autowired ServletContext servletContext;
 
  @RequestMapping(value="/add", method=RequestMethod.POST)
  public Object add(Supplier supplier) throws Exception {  
    
    supplierDao.insert(supplier);
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    
    return resultMap;
  }

  @RequestMapping("/delete")
  public Object delete(int no) throws Exception {
    supplierDao.delete(no);
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    
    return resultMap;
  }
  
  @RequestMapping("/list")
  public Object list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="5") int pageSize) throws Exception {
    
    if (pageSize <= 0)
      pageSize = PAGE_DEFAULT_SIZE;
    
    int totalSize = supplierDao.totalSize();
    int maxPageNo = totalSize / pageSize;
    if ((totalSize % pageSize) > 0) maxPageNo++;
    
    if (pageNo <= 0) pageNo = 1;
    if (pageNo > maxPageNo) pageNo = maxPageNo;
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", ((pageNo - 1) * pageSize));
    paramMap.put("pageSize", pageSize);
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("currPageNo", pageNo);
    resultMap.put("maxPageNo", maxPageNo);
    resultMap.put("suppliers", supplierDao.selectList(paramMap));
    
    return resultMap;
  }
  
  @RequestMapping("/update")
  public Object update(Supplier supplier) throws Exception {
    supplierDao.update(supplier);
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    return resultMap;
  }
  
  @RequestMapping("/view")
  public Object view(int no, Model model) throws Exception {
    Supplier supplier = supplierDao.selectOne(no);
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    resultMap.put("supplier", supplier);
    return resultMap;
  }
}












