public class Assessment {
    String name;
    double grade;

    public Assessment(String tempname, double tempgrade) {
        name = tempname;
        grade = tempgrade;
    }
    // Used to access assessment's name
    public String getName() {
        return name;
    }
    // Used to edit name
    public void editName(String newName) {
        name = newName;
    }
    // Used to access assessment's grade
    public double getGrade() {
        return grade;
    }
    // Used to edit grade
    public void editGrade(double newGrade) {
        grade = newGrade;
    }
}