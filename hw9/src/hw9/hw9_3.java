package hw9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hw9_3 {

    public static void main(String[] args) {
        Map<String, Integer> grades = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("[1.�s�W�ǥͦ��Z]�B[2.�d�߾ǥͦ��Z]�B[3.�ק�ǥͦ��Z]�B[4.�R���ǥͦ��Z]�B[5.�C�X�Ҧ��ǥͦ��Z]�B[6.�h�X]");
            int choice = sc.nextInt();
            sc.nextLine();
 
            switch (choice) {
                case 1:
                    addStudentGrade(grades, sc);
                    break;
                case 2:
                    queryStudentGrade(grades, sc);
                    break;
                case 3:
                    updateStudentGrade(grades, sc);
                    break;
                case 4:
                    removeStudentGrade(grades, sc);
                    break;
                case 5:
                    listAllStudentGrades(grades);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("�п�J���Ī��ﶵ�I");
            }
        }
    }
    
    public static void addStudentGrade(Map<String, Integer> grades, Scanner scanner) {
        System.out.println("�п�J�ǥͦW�r:");
        String name = scanner.nextLine();
        System.out.println("�п�J�ǥͦ��Z:");
        int score = scanner.nextInt();
        scanner.nextLine(); 
        grades.put(name, score);
        System.out.println("�ǥͦ��Z�w�s�W�C");
    }
    
    public static void queryStudentGrade(Map<String, Integer> grades, Scanner scanner) {
        System.out.println("�п�J�ǥͦW�r:");
        String name = scanner.nextLine();
        Integer score = grades.get(name);
        if (score != null) {
            System.out.println(name + "�����Z�O: " + score);
        } else {
            System.out.println("�䤣��ǥ� " + name + " �����Z�C");
        }
    }
   
    public static void updateStudentGrade(Map<String, Integer> grades, Scanner scanner) {
        System.out.println("�п�J�n�ק令�Z���ǥͦW�r:");
        String name = scanner.nextLine();
        if (grades.containsKey(name)) {
            System.out.println("�п�J�s�����Z:");
            int newScore = scanner.nextInt();
            scanner.nextLine(); 
            grades.put(name, newScore);
            System.out.println(name + "�����Z�w��s�C");
        } else {
            System.out.println("�䤣��ǥ� " + name + " �����Z�A�L�k��s�C");
        }
    }
   
    public static void removeStudentGrade(Map<String, Integer> grades, Scanner scanner) {
        System.out.println("�п�J�n�R�����Z���ǥͦW�r:");
        String name = scanner.nextLine();
        if (grades.containsKey(name)) {
            grades.remove(name);
            System.out.println(name + "�����Z�w�R���C");
        } else {
            System.out.println("�䤣��ǥ� " + name + " �����Z�A�L�k�R���C");
        }
    }
    
    public static void listAllStudentGrades(Map<String, Integer> grades) {
        System.out.println("�Ҧ��ǥͦ��Z�C��:");
        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}