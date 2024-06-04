package test;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StudentGradeManager extends JFrame {
    private JButton addButton, findButton, deleteButton, listButton;
    private JTextField nameField, heightField, weightField;
    private JTextArea textArea;
    private Map<String, Student> students;
    private static final String DESKTOP_PATH = System.getProperty("user.home") + "/Desktop/";
    private static final String CSV_FILE = DESKTOP_PATH + "students_data.csv";

    public StudentGradeManager() {
        super("學生成績管理系統");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new FlowLayout());

        students = new HashMap<>();
        loadCSVData(); // 在應用程式啟動時加載 CSV 檔案中的資料

        nameField = new JTextField(10);
        heightField = new JTextField(10);
        weightField = new JTextField(10);
        add(new JLabel("姓名："));
        add(nameField);
        add(new JLabel("身高（公分）："));
        add(heightField);
        add(new JLabel("體重（公斤）："));
        add(weightField);

        addButton = new JButton("新增/更新資料");
        addButton.addActionListener(this::addOrUpdateData);
        add(addButton);

        findButton = new JButton("查詢資料");
        findButton.addActionListener(this::findData);
        add(findButton);

        deleteButton = new JButton("刪除資料");
        deleteButton.addActionListener(this::deleteData);
        add(deleteButton);

        listButton = new JButton("列出資料");
        listButton.addActionListener(this::listData);
        add(listButton);

        textArea = new JTextArea(15, 50);
        add(new JScrollPane(textArea));

        setVisible(true);
    }

    private void loadCSVData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                if (data.length == 4) {
                    String name = data[0];
                    double height = Double.parseDouble(data[1]);
                    double weight = Double.parseDouble(data[2]);
                    Student student = new Student(name, height, weight);
                    students.put(name, student);
                }
            }
        } catch (IOException | NumberFormatException ex) {
            textArea.setText("讀取 CSV 檔案時發生錯誤：" + ex.getMessage());
        }
    }

    private void addOrUpdateData(ActionEvent e) {
        String name = nameField.getText();
        String height = heightField.getText();
        String weight = weightField.getText();
        try {
            double heightCm = Double.parseDouble(height);
            double weightKg = Double.parseDouble(weight);
            Student student = new Student(name, heightCm, weightKg);
            students.put(name, student);
            textArea.setText("已新增/更新 " + name + " 的資料 - 身高：" + height + " 公分，體重：" + weight + " 公斤，BMI：" + student.calculateBMI());
            saveDataToCSV();
        } catch (NumberFormatException ex) {
            textArea.setText("無效的輸入。請輸入有效的身高和體重數字。");
        } catch (IOException ex) {
            textArea.setText("儲存資料到 CSV 檔案時發生錯誤：" + ex.getMessage());
        }
    }

    private void findData(ActionEvent e) {
        String name = nameField.getText();
        Student student = students.get(name);
        if (student != null) {
            textArea.setText("找到資料：" + student.getName() + " - 身高：" + student.getHeight() + " 公分，體重：" + student.getWeight() + " 公斤，BMI：" + student.calculateBMI());
        } else {
            textArea.setText("找不到 " + name + " 的資料。");
        }
    }

    private void deleteData(ActionEvent e) {
        String name = nameField.getText();
        if (students.remove(name) != null) {
            textArea.setText("已刪除 " + name + " 的資料。");
            saveDataToCSV(); // 刪除後重新儲存 CSV 檔案
        } else {
            textArea.setText("找不到 " + name + " 的資料。");
        }
    }

    private void listData(ActionEvent e) {
        StringBuilder builder = new StringBuilder("所有資料：\n");
        students.values().forEach(student -> {
            builder.append(student.getName()).append(" - 身高：").append(student.getHeight()).append(" 公分，體重：").append(student.getWeight()).append(" 公斤，BMI：").append(student.calculateBMI()).append("\n");
        });
        textArea.setText(builder.toString());
    }

    private void saveDataToCSV() throws IOException {
        try (FileWriter writer = new FileWriter(CSV_FILE)) {
            for (Student student : students.values()) {
                writer.append(student.getName()).append(", ")
                      .append(String.valueOf(student.getHeight())).append(", ")
                      .append(String.valueOf(student.getWeight())).append(", ")
                      .append(String.valueOf(student.calculateBMI())).append("\n");
            }
        }
    }

    public static void main(String[] args) {
        new StudentGradeManager();
    }
}
