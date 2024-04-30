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
            System.out.println("[1.新增學生成績]、[2.查詢學生成績]、[3.修改學生成績]、[4.刪除學生成績]、[5.列出所有學生成績]、[6.退出]");
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
                    System.out.println("請輸入有效的選項！");
            }
        }
    }
    
    public static void addStudentGrade(Map<String, Integer> grades, Scanner scanner) {
        System.out.println("請輸入學生名字:");
        String name = scanner.nextLine();
        System.out.println("請輸入學生成績:");
        int score = scanner.nextInt();
        scanner.nextLine(); 
        grades.put(name, score);
        System.out.println("學生成績已新增。");
    }
    
    public static void queryStudentGrade(Map<String, Integer> grades, Scanner scanner) {
        System.out.println("請輸入學生名字:");
        String name = scanner.nextLine();
        Integer score = grades.get(name);
        if (score != null) {
            System.out.println(name + "的成績是: " + score);
        } else {
            System.out.println("找不到學生 " + name + " 的成績。");
        }
    }
   
    public static void updateStudentGrade(Map<String, Integer> grades, Scanner scanner) {
        System.out.println("請輸入要修改成績的學生名字:");
        String name = scanner.nextLine();
        if (grades.containsKey(name)) {
            System.out.println("請輸入新的成績:");
            int newScore = scanner.nextInt();
            scanner.nextLine(); 
            grades.put(name, newScore);
            System.out.println(name + "的成績已更新。");
        } else {
            System.out.println("找不到學生 " + name + " 的成績，無法更新。");
        }
    }
   
    public static void removeStudentGrade(Map<String, Integer> grades, Scanner scanner) {
        System.out.println("請輸入要刪除成績的學生名字:");
        String name = scanner.nextLine();
        if (grades.containsKey(name)) {
            grades.remove(name);
            System.out.println(name + "的成績已刪除。");
        } else {
            System.out.println("找不到學生 " + name + " 的成績，無法刪除。");
        }
    }
    
    public static void listAllStudentGrades(Map<String, Integer> grades) {
        System.out.println("所有學生成績列表:");
        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}