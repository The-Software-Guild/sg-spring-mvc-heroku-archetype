package ${package};

import java.util.Map;
import ${package}.dao.*;
import ${package}.model.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
        
    private RecordDao dao;

    @Autowired
    public MainController(RecordDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayIndexMain(Map<String, Object> model) {
        model.put("active", "index");
        model.put("recordsList", dao.getAllRecords());
        return "index";
    }
    
    @RequestMapping(value = "/addForm", method = RequestMethod.GET)
    public String addFormDisplay(Map<String, Object> model) {
        model.put("active", "addform");
        return "new_record";
    }
    
    @RequestMapping(value = "/addForm", method = RequestMethod.POST)
    public String addFormProcess(HttpServletRequest req) {
        String recordInfo = req.getParameter("recordInfo");
        if(recordInfo!= null && !recordInfo.isEmpty()){
            this.dao.addRecord(new Record(0, recordInfo));
            return "redirect:/";
        }else{
            return "redirect:/addForm?error=true";
        }   
    }
}
