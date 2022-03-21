package Entity;

public class User {
    private String name;
    private int passCode;
    private int budget;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassCode() {
        return passCode;
    }

    public void setPassCode(int passCode) {
        this.passCode = passCode;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public User() {
    }

    public User(String name, int passCode, int budget) {
        this.name = name;
        this.passCode = passCode;
        this.budget = budget;
    }
}
