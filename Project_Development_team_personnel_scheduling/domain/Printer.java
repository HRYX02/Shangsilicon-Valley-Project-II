package Project_Development_team_personnel_scheduling.domain;

public class Printer implements Equipment{
    private String name;
    private String type;//机器的类型

    public Printer(){

    }
    public Printer(String name,String  type){
        this.name = name;
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name + type;
    }
}