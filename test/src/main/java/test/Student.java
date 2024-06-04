package test;

public class Student {
    private String name;
    private double height;
    private double weight;

    public Student(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double calculateBMI() {
        double heightInMeters = height / 100; // convert height from cm to meters
        double bmi = weight / (heightInMeters * heightInMeters);
        return Math.round(bmi * 100.0) / 100.0; // round to 2 decimal places
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Height: " + height + " cm, Weight: " + weight + " kg, BMI: " + calculateBMI();
    }
}
