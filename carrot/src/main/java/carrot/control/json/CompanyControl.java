package carrot.control.json;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import carrot.domain.Company;
import carrot.service.CompanyService;

@Controller("json.companyControl")
@RequestMapping("/json/company")
public class CompanyControl {
  static Logger log = Logger.getLogger(CompanyControl.class);
  static final int PAGE_DEFAULT_SIZE = 5;
  
  @Autowired CompanyService     companyService;
  @Autowired ServletContext servletContext;
 
  @RequestMapping(value="/add", method=RequestMethod.POST)
  public Object add(Company company) throws Exception {  
    
    companyService.add(company);
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    
    return resultMap;
  }
}












