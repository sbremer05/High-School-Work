import java.util.*;

public class Teacher {
    ArrayList<Double> hours = new ArrayList<Double>();
    double totalHours;
    double payRate;
    double check;
    String id;
    String name;

    Teacher(){
        totalHours = 0;
        payRate = 0;
        check = 0;
        id = "";
        name = "";
    }

    public void calculateValues(String[] values) {
        for(int i = 3; i < values.length; i++) {
            hours.add(Double.parseDouble(values[i]));
            totalHours += hours.get(i - 3);
        }
        payRate = Double.parseDouble(values[2]);
        id = values[0];
        name = values[1];
    }

    public double getTotalHours() {
        return totalHours;
    }

    public double[] getHours() {
        double[] temp = new double[hours.size()];
        for(int i = 0; i < temp.length; i++) {
            temp[i] = hours.get(i);
        }
        return temp;
    }

    public double getPayrate() {
        return payRate;
    }

    public double getCheck() {
        check = payRate * totalHours * 100;
        check = Math.round(check) / 100.0;
        return check;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}