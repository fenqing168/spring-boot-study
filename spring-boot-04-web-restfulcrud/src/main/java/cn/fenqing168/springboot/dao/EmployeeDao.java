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
                new EmpLoyee(1001, "E-AA", "aa@163.com", 1, new Department(101, "D-AA"), new Date()));
        empLoyees.put(1002,
                new EmpLoyee(1001, "E-BB", "bb@163.com", 1, new Department(102, "D-BB"), new Date()));
        empLoyees.put(1003,
                new EmpLoyee(1001, "E-CC", "cc@163.com", 0, new Department(103, "D-CVC"), new Date()));
        empLoyees.put(1004,
                new EmpLoyee(1001, "E-DD", "dd@163.com", 0, new Department(104, "D-EE"), new Date()));
        empLoyees.put(1005,
                new EmpLoyee(1001, "E-EE", "ee@163.com", 1, new Department(105, "D-EE"), new Date()));
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
