package cn.fenqing168.springboot.dao;

import cn.fenqing168.springboot.entitites.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fenqing
 */
@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departmentMap = null;

    static{
        departmentMap = new HashMap<>();
        departmentMap.put(101, new Department(101, "D-AA"));
        departmentMap.put(102,  new Department(102, "D-BB"));
        departmentMap.put(103, new Department(103, "D-CC"));
        departmentMap.put(104,new Department(104, "D-EE"));
        departmentMap.put(105, new Department(105, "D-EE"));
    }

    public static Department getDepartmentStatic(Integer id){
        return departmentMap.get(id);
    }

    public DepartmentDao(){

    }

    /**
     *
     * @param id
     * @return
     */
    public Department getDepartment(Integer id) {
        return departmentMap.get(id);
    }

    public Collection<Department> getDepartments() {
        return departmentMap.values();
    }
}
