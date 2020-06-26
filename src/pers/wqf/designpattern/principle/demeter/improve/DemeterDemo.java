package pers.wqf.designpattern.principle.demeter.improve;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qifeng Wen
 * @date 2020-06-26 下午9:31
 */
public class DemeterDemo {
    public static void main(String[] args) {
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployee(new CollegeManager());
    }
}


// 学校总部员工类
class Employee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

// 学院员工类
class CollegeEmployee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}


// 学院员工管理类
class CollegeManager {
    // 返回学院所有员工
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CollegeEmployee collegeEmployee = new CollegeEmployee();
            collegeEmployee.setId("学院员工id=" + i);
            list.add(collegeEmployee);
        }
        return list;
    }

    // 输出学院员工的信息
    public void printEmployee() {
        List<CollegeEmployee> allEmployee = getAllEmployee();
        System.out.println("--------学院员工---------");
        allEmployee.stream().map(emp -> emp.getId()).forEach(System.out::println);
    }
}

// 学校总部员工管理类
class SchoolManager {
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setId("学校总部id=" + i);
            list.add(employee);
        }
        return list;
    }

    // 输出学校总部和学院员工信息id
    void printAllEmployee(CollegeManager collegeManager) {
        collegeManager.printEmployee();

        System.out.println("-------学校总部员工-------");
        List<Employee> allEmployee1 = getAllEmployee();
        allEmployee1.stream().map(emp -> emp.getId()).forEach(System.out::println);
    }


}