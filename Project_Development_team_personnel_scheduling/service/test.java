package Project_Development_team_personnel_scheduling.service;

import Project_Development_team_personnel_scheduling.domain.Employee;
import Project_Development_team_personnel_scheduling.domain.Programmer;
import org.junit.Test;

public class test {
    @Test
    public void test1(){
       NameListService nameListService = new NameListService();
       Employee[] employee = nameListService.getAllEmployees();
     for (int i=0;i<employee.length;i++){
         System.out.println(employee[i]);
     }
   }
    @Test
    public void test2(){
        try {
            NameListService nameListService = new NameListService();
            Employee employee = nameListService.getEmployee(20);
            System.out.println(employee);
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }

   }
}
