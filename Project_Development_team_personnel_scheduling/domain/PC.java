package Project_Development_team_personnel_scheduling.domain;

public class PC implements Equipment{
    private String model;
    private String display;//显示器名称

    public PC() {

    }
    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model + display;
    }
}
