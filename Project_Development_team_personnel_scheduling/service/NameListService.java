package Project_Development_team_personnel_scheduling.service;

import Project_Development_team_personnel_scheduling.domain.*;

import static Project_Development_team_personnel_scheduling.service.Data.*;

public class NameListService {
    private Employee[] employees;
/**
 * @Description根据项目提供的Data类构建相应大小的employees数组
 * 再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，
 * 以及相关联的Equipment子类的对象将对象存于数组中Data类位于com.atguigu.team.service包中
 */
    public NameListService() {
        employees = new Employee[EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++) {
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);

            Equipment equipment;
            double bonus;
            int stock;

            switch (type) {
                case 10:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary,equipment);
                    break;
                case DESIGNER:
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    equipment = createEquipment(i);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case ARCHITECT:
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    equipment = createEquipment(i);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);
            }
        }
    }
    /**
     * @apiNote getEmployee(id : int)方法：获取指定ID的员工对象。参数：指定员工的ID
     * 返回：指定员工对象异常：找不到指定的员工
     */
    public Employee getEmployee(int id) throws TeamException {
        if (id < employees.length) {
            return employees[id - 1];
        } else {
            throw new TeamException("找不到指定成员");
        }
    }
    /**
     *getAllEmployees ()方法：获取当前所有员工。返回：包含所有员工对象的数组
     */
    public Employee[] getAllEmployees(){
        return employees;
    }
    private Equipment createEquipment(int index) {
        int type = Integer.parseInt(EQUIPMENTS[index][0]);
        switch (type) {
            case PC:
                return new PC(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
            case NOTEBOOK:
                double price = Double.parseDouble(EQUIPMENTS[index][2]);
                return new NoteBook(EQUIPMENTS[index][1], price);
            case PRINTER:
                return new Printer(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
        }
        return null;
    }
}
