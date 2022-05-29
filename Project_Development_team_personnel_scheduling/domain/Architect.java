package Project_Development_team_personnel_scheduling.domain;
/**@apiNote 架构师*/
public class Architect extends Designer{
    private int stock;//表示公司奖励的股票数量

    public Architect(){

    }
    public Architect(int id,String name,int age,double salary,Equipment equipment,double bonus,int stock){
        super(id,name,age,salary,equipment,bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return describe() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t\t"+ getStock() + "\t\t" + getEquipment().getDescription();
    }
    public String getDetailsForTeam() {
        return getTeamBaseDetails() + "\t架构师\t" + getBonus() + "\t" + getStock();
    }
}