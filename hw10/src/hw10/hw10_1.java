package hw10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hw10_1 {
    private static final String FILE_PATH = "C:\\Users\\User\\Desktop\\Stds.csv"; // �ɮ׸��|

    public static void main(String[] args) {
        Map<String, Integer> grades = new HashMap<>();
        
    
        File file = new File(FILE_PATH);
        if (file.exists()) {
           
            loadFromFile(grades, file);
            System.out.println("�w�q�ɮפ�Ū���ǥͦ��Z�C");
        } else {
        
            try {
                file.createNewFile();
                System.out.println("�w�إ߷s�ɮ� " + FILE_PATH);
            } catch (IOException e) {
                System.out.println("�إ߷s�ɮ׮ɵo�Ϳ��~�G" + e.getMessage());
            }
        }

        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("�п�ܾާ@:");
            System.out.println("1.�s�W�ǥͦ��Z 2.�d�߾ǥͦ��Z 3.�ק�ǥͦ��Z 4.�R���ǥͦ��Z 5.�C�X�Ҧ��ǥͦ��Z 6.�h�X");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStudentGrade(grades, scanner);
                    break;
                case 2:
                    queryStudentGrade(grades, scanner);
                    break;
                case 3:
                    updateStudentGrade(grades, scanner);
                    break;
                case 4:
                    removeStudentGrade(grades, scanner);
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

        
        saveToFile(grades, file);
        System.out.println("�ǥͦ��Z�w�g�J�ɮ� " + FILE_PATH);
    }

   
    private static void loadFromFile(Map<String, Integer> grades, File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String name = parts[0];
                int score = Integer.parseInt(parts[1]);
                grades.put(name, score);
            }
        } catch (IOException e) {
            System.out.println("Ū���ɮ׮ɵo�Ϳ��~�G" + e.getMessage());
        }
    }

   
    private static void addStudentGrade(Map<String, Integer> grades, Scanner scanner) {
        System.out.println("�п�J�ǥͦW�r:");
        String name = scanner.nextLine();
        System.out.println("�п�J�ǥͦ��Z:");
        int score = scanner.nextInt();
        scanner.nextLine(); 
        grades.put(name, score);
        System.out.println("�ǥͦ��Z�w�s�W�C");
    }

    
    private static void queryStudentGrade(Map<String, Integer> grades, Scanner scanner) {
        System.out.println("�п�J�ǥͦW�r:");
        String name = scanner.nextLine();
        Integer score = grades.get(name);
        if (score != null) {
            System.out.println(name + "�����Z�O: " + score);
        } else {
            System.out.println("�䤣��ǥ� " + name + " �����Z�C");
        }
    }

  
    private static void updateStudentGrade(Map<String, Integer> grades, Scanner scanner) {
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

    
    private static void removeStudentGrade(Map<String, Integer> grades, Scanner scanner) {
        System.out.println("�п�J�n�R�����Z���ǥͦW�r:");
        String name = scanner.nextLine();
        if (grades.containsKey(name)) {
            grades.remove(name);
            System.out.println(name + "�����Z�w�R���C");
        } else {
            System.out.println("�䤣��ǥ� " + name + " �����Z�A�L�k�R���C");
        }
    }

    
    private static void listAllStudentGrades(Map<String, Integer> grades) {
        System.out.println("�Ҧ��ǥͦ��Z�C��:");
        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    
    private static void saveToFile(Map<String, Integer> grades, File file) {
        try (FileWriter writer = new FileWriter(file)) {
            for (Map.Entry<String, Integer> entry : grades.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.out.println("�g�J�ɮ׮ɵo�Ϳ��~�G" + e.getMessage());
        }
    }
}