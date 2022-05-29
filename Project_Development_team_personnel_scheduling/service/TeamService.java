package Project_Development_team_personnel_scheduling.service;
/**
 * @apiNote 关于开发团队成员的管理：添加、删除等。
 */

import Project_Development_team_personnel_scheduling.domain.Architect;
import Project_Development_team_personnel_scheduling.domain.Designer;
import Project_Development_team_personnel_scheduling.domain.Employee;
import Project_Development_team_personnel_scheduling.domain.Programmer;

public class TeamService {
    private int count = 1;//用来为开发团队新增成员自动生成团队中的唯一ID，即memberId。（提示：应使用增1的方式）
    private final int MAX_MEMBER = 5;//表示开发团队最大成员数
    private Programmer[] team = new Programmer[MAX_MEMBER];//用来保存当前团队中的各成员对象
    private int total;//记录团队成员的实际人数

    public TeamService(){
        super();
    }
    /**
     * @apiNote 返回当前团队的所有对象返回：包含所有成员对象的数组，数组大小与成员人数一致
     */
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * 向团队中添加成员参数：待添加成员的对象
     * 异常：添加失败， TeamException中包含了失败原因
     */
    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        if (isExist(e)) {
            throw new TeamException("该员工已在本开发团队中");
        }
        Programmer p = (Programmer) e;
        if (p.getStatus().getNAME().equals("BUSY")) {
            throw new TeamException("该员工已是某团队成员");
        }
        if (p.getStatus().getNAME().equals("VOCATION")) {
            throw new TeamException("该员正在休假，无法添加");
        }
        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Programmer) {
                numOfPro++;
            } else if (team[i] instanceof Designer) {
                numOfDes++;
            } else if (team[i] instanceof Architect) {
                numOfArch++;
            }
        }
        if (e instanceof Programmer) {
            if (numOfPro >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        } else if (e instanceof Designer) {
            if (numOfPro >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else if (e instanceof Architect) {
            if (numOfPro >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        }
        p.setStatus(Status.BUSY);
        p.setMemberld(count++);
        team[total++] = p;
    }

    public boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (e.getId() == team[i].getId()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * 从团队中删除成员
     * 参数：待删除成员的memberId
     * 异常：找不到指定memberId的员工，删除失败
     */
    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        for (;i < total;i++){
            if (team[i].getMemberld() == memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if (i == total){
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }
        for (int j = i + 1;j < total;j++){
            team[j] = team[j + 1];
        }
        team[total - 1] = null;
        total--;
    }
}