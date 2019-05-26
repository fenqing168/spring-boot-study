package cn.fenqing168.springboot.controller;

import cn.fenqing168.springboot.dao.DepartmentDao;
import cn.fenqing168.springboot.dao.EmployeeDao;
import cn.fenqing168.springboot.entitites.Department;
import cn.fenqing168.springboot.entitites.EmpLoyee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @author fenqing
 */
@Controller
public class EmpController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 查询所有员工返回列表页面
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model){

        Collection<EmpLoyee> empLoyees = employeeDao.getAll();

        model.addAttribute("emps", empLoyees);

        // thymeleaf默认就会拼接字符串
        // classpath:/templaes/.html
        return "emp/list";
    }

    /**
     * 来到员工添加页面
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

}
