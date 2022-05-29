package Project_Development_team_personnel_scheduling.service;

public class TeamException extends Exception{
    static final long serialVersionUID = 1001L;
    public TeamException(){

    }
    public TeamException(String message){
        super(message);
    }
}
