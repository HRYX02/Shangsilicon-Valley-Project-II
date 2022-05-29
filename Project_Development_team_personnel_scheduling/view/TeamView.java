package Project_Development_team_personnel_scheduling.view;

import Project_Development_team_personnel_scheduling.domain.Employee;
import Project_Development_team_personnel_scheduling.domain.Programmer;
import Project_Development_team_personnel_scheduling.service.NameListService;
import Project_Development_team_personnel_scheduling.service.TeamException;
import Project_Development_team_personnel_scheduling.service.TeamService;

public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu() {
        boolean loopFlag = true;
        char menu = '0';
        while (loopFlag) {
            if (menu != '1') {
                listAllEmployees();
            }
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
            menu = TSUtility.readMenuSelection();
                switch (menu) {
                    case '1':
                        getTeam();
                        break;
                    case '2':
                        addMember();
                        break;
                    case '3':
                        deleteMember();
                        break;
                    case '4':
                        System.out.println("确认是否退出(Y/N)：");
                        char isExist = TSUtility.readConfirmSelection();
                        if (isExist == 'Y') {
                            loopFlag = false;
                        } else {
                            loopFlag = true;
                        }
                        break;
                }
            }
        }

        /**
         * @apiNote 显示所以的员工信息
         * @author XinXiShi
         */
        private void listAllEmployees () {
            System.out.println("--------------------------------开发团队调度软件----------------------------------");
            Employee[] employees = listSvc.getAllEmployees();
            if (employees == null || employees.length == 0) {
                System.out.println("公司中没有任何员工信息！");
            } else {
                System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
                for (int i = 0; i < employees.length; i++) {
                    System.out.println(employees[i]);
                }
            }
            System.out.println("-------------------------------------------------------------------------------");
        }

        /**
         * @apiNote 查看开发团队情况
         */
        private void getTeam () {
            System.out.println("--------------------团队成员列表---------------------");
            Programmer[] team = teamSvc.getTeam();
            if (team == null || team.length == 0) {
                System.out.println("公司中没有任何员工信息！");
            } else {
                System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\n");
                for (int i = 0; i < team.length; i++) {
                    System.out.println(team[i].getDetailsForTeam());
                }
            }
        }

        private void addMember () {
            System.out.println("---------------------添加成员---------------------");
            System.out.print("请输入要添加的员工ID：");
            int id = TSUtility.readInt();
            try {
                Employee employee = listSvc.getEmployee(id);
                teamSvc.addMember(employee);
                System.out.println("添加成功");
            } catch (TeamException e) {
                System.out.println(e.getMessage());
            }
            TSUtility.readReturn();
        }

        private void deleteMember () {
            System.out.println("---------------------添加成员---------------------");
            System.out.print("请输入要删除的员工TID：");
            int memberId = TSUtility.readInt();
            System.out.print("确认是否删除(Y/N)：");
            char isDelete = TSUtility.readConfirmSelection();
            if (isDelete == 'N') {
                return;
            }
            try {
                teamSvc.removeMember(memberId);
                System.out.println("删除成功");
            } catch (TeamException e) {
                System.out.println(e.getMessage());
            }

            TSUtility.readReturn();
        }

        public static void main (String[]args){
            TeamView teamView = new TeamView();
            teamView.enterMainMenu();
        }
    }