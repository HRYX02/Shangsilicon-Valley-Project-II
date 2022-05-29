package Project_Development_team_personnel_scheduling.domain;
/**@apiNote 程序员*/
import Project_Development_team_personnel_scheduling.service.Status;

public class Programmer extends Employee {
    private int memberld;//记录成员加入开发团队后在团队中的ID
    private Status status = Status.FREE;
    private Equipment equipment;//表示成员领用的设备

    public Programmer() {

    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id,name,age,salary);
        this.equipment = equipment;
    }

    public int getMemberld() {
        return memberld;
    }
    public void setMemberld(int memberld) {
        this.memberld = memberld;
    }
    public Equipment getEquipment() {
        return equipment;
    }
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return describe() + "\t程序员\t" + getStatus() +"\t\t" + getEquipment().getDescription();
    }
    public String getTeamBaseDetails(){
        return memberld + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary();
    }
    public String getDetailsForTeam(){
        return getTeamBaseDetails() + "\t程序员";
    }
}
