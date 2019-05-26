package cn.fenqing168.springboot.dao;

import cn.fenqing168.springboot.entitites.Department;
import cn.fenqing168.springboot.entitites.EmpLoyee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeDao {

    private static Map<Integer, EmpLoyee> empLoyees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static{
        empLoyees = new HashMap<>();

        empLoyees.put(1001,
                new EmpLoyee(1001, "E-AA", "aa@163.com", 1, DepartmentDao.getDepartmentStatic(101), new Date()));
        empLoyees.put(1002,
                new EmpLoyee(1001, "E-BB", "bb@163.com", 1, DepartmentDao.getDepartmentStatic(102), new Date()));
        empLoyees.put(1003,
                new EmpLoyee(1001, "E-CC", "cc@163.com", 0, DepartmentDao.getDepartmentStatic(103), new Date()));
        empLoyees.put(1004,
                new EmpLoyee(1001, "E-DD", "dd@163.com", 0, DepartmentDao.getDepartmentStatic(104), new Date()));
        empLoyees.put(1005,
                new EmpLoyee(1001, "E-EE", "ee@163.com", 1, DepartmentDao.getDepartmentStatic(105), new Date()));
    }

    private static Integer initId = 1006;

    /**
     *
     * @param empLoyee
     */
    public void save(EmpLoyee empLoyee){

        if(empLoyee.getId() == null){
            empLoyee.setId(initId++);
        }

        empLoyee.setDepartment(departmentDao.getDepartment(empLoyee.getDepartment().getId()));
        empLoyees.put(empLoyee.getId(), empLoyee);

    }

    public Collection<EmpLoyee> getAll() {
        return empLoyees.values();
    }
}
