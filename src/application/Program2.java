package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public class Program2 {

    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("\n=== TEST 1: department insert ===");
        Department newDepartment = new Department(null, "Food");
        departmentDao.insert(newDepartment);
        System.out.println("Insert completed! Id: " + newDepartment.getId());

        System.out.println("\n=== TEST 2: department update ===");
        Department dep = departmentDao.findById(8);
        dep.setName("Games");
        departmentDao.update(dep);
        System.out.println("Updated completed!");

        System.out.println("\n=== TEST 3: department delete ===");
        departmentDao.deleteById(9);
        System.out.println("Delete completed!");

        System.out.println("=== TEST 4: department findById ===");
        Department dep2 = departmentDao.findById(6);
        System.out.println(dep2);

        System.out.println("=== TEST 5: department findAll ===");
        List<Department> list = departmentDao.findAll();
        for(Department d : list){
            System.out.println(d);
        }
    }
}
