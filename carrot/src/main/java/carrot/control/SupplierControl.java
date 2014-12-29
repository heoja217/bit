package carrot.control;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import carrot.domain.Supplier;
import carrot.service.SupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierControl {
  static Logger log = Logger.getLogger(SupplierControl.class);
  static final int PAGE_DEFAULT_SIZE = 5;
  
  @Autowired SupplierService     supplierService;
  
  @Autowired ServletContext servletContext;

  @RequestMapping(value="/add", method=RequestMethod.GET)
  public ModelAndView form() throws Exception {
    ModelAndView mv = new ModelAndView();
    mv.addObject("suppliers", supplierService.getList());
    mv.setViewName("supplier/SupplierForm");
    return mv;
  }
 
  @RequestMapping(value="/add", method=RequestMethod.POST)
  public String add(Supplier supplier) throws Exception {  
 
    supplierService.add(supplier);
    
    return "redirect:list.do";
  }

  @RequestMapping("/delete")
  public String delete(int no) throws Exception {
    supplierService.delete(no);
    return "redirect:list.do";
  }
  
  @RequestMapping("/list")
  public String list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="5") int pageSize,
      Model model) throws Exception {
    
    if (pageSize <= 0)
      pageSize = PAGE_DEFAULT_SIZE;
    
    int maxPageNo = supplierService.getMaxPageNo(pageSize);
    
    if (pageNo <= 0) pageNo = 1;
    if (pageNo > maxPageNo) pageNo = maxPageNo;
    
    model.addAttribute("suppliers", 
        supplierService.getList(pageNo, pageSize));
    
    model.addAttribute("currPageNo", pageNo);
    
    if (pageNo > 1) {
      model.addAttribute("prevPageNo", (pageNo - 1));
    }
    
    if (pageNo < maxPageNo) {
      model.addAttribute("nextPageNo", (pageNo + 1));
    }
    
    return "supplier/SupplierList";
  }
  
  @RequestMapping("/update")
  public String update(Supplier supplier) throws Exception {
    supplierService.update(supplier);
    return "redirect:list.do";
  }
  
  @RequestMapping("/view")
  public String view(int no, Model model) throws Exception {
    Supplier supplier = supplierService.get(no);
    model.addAttribute("supplier", supplier);
    model.addAttribute("suppliers", supplierService.getList());
    return "supplier/SupplierView";
  }
}

