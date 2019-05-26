package cn.fenqing168.springboot.controller;

import cn.fenqing168.springboot.dao.DepartmentDao;
import cn.fenqing168.springboot.dao.EmployeeDao;
import cn.fenqing168.springboot.entitites.Department;
import cn.fenqing168.springboot.entitites.EmpLoyee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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

    /**
     * 员工添加
     * @param empLoyeep SpringMvc 自动将请求参数和入参对象的属性进行一一绑定；
     *                  请求参数的名字和javaBean入参的对象里面属性名一一对应
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(EmpLoyee empLoyeep){
        System.out.println(empLoyeep);
        employeeDao.save(empLoyeep);
        //来到员工列表
        // redirect: 表示重定向一个地址 /代表当前项目下资源目录
        // forward: 表示转发到一个页面
        return "redirect:/emps";
    }

    /**
     * 查出员工页面回显
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        EmpLoyee empLoyee = employeeDao.get(id);
        model.addAttribute("emp", empLoyee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //修改添加二合一
        return "emp/add";
    }

    /**
     * 修改需要提交员工ID
     * @param empLoyee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmployee(EmpLoyee empLoyee){
        System.out.println(empLoyee);
        employeeDao.save(empLoyee);
        return "redirect:/emps";
    }

}