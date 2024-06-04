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
        super("�ǥͦ��Z�޲z�t��");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new FlowLayout());

        students = new HashMap<>();
        loadCSVData(); // �b���ε{���Ұʮɥ[�� CSV �ɮפ������

        nameField = new JTextField(10);
        heightField = new JTextField(10);
        weightField = new JTextField(10);
        add(new JLabel("�m�W�G"));
        add(nameField);
        add(new JLabel("�����]�����^�G"));
        add(heightField);
        add(new JLabel("�魫�]����^�G"));
        add(weightField);

        addButton = new JButton("�s�W/��s���");
        addButton.addActionListener(this::addOrUpdateData);
        add(addButton);

        findButton = new JButton("�d�߸��");
        findButton.addActionListener(this::findData);
        add(findButton);

        deleteButton = new JButton("�R�����");
        deleteButton.addActionListener(this::deleteData);
        add(deleteButton);

        listButton = new JButton("�C�X���");
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
            textArea.setText("Ū�� CSV �ɮ׮ɵo�Ϳ��~�G" + ex.getMessage());
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
            textArea.setText("�w�s�W/��s " + name + " ����� - �����G" + height + " �����A�魫�G" + weight + " ����ABMI�G" + student.calculateBMI());
            saveDataToCSV();
        } catch (NumberFormatException ex) {
            textArea.setText("�L�Ī���J�C�п�J���Ī������M�魫�Ʀr�C");
        } catch (IOException ex) {
            textArea.setText("�x�s��ƨ� CSV �ɮ׮ɵo�Ϳ��~�G" + ex.getMessage());
        }
    }

    private void findData(ActionEvent e) {
        String name = nameField.getText();
        Student student = students.get(name);
        if (student != null) {
            textArea.setText("����ơG" + student.getName() + " - �����G" + student.getHeight() + " �����A�魫�G" + student.getWeight() + " ����ABMI�G" + student.calculateBMI());
        } else {
            textArea.setText("�䤣�� " + name + " ����ơC");
        }
    }

    private void deleteData(ActionEvent e) {
        String name = nameField.getText();
        if (students.remove(name) != null) {
            textArea.setText("�w�R�� " + name + " ����ơC");
            saveDataToCSV(); // �R���᭫�s�x�s CSV �ɮ�
        } else {
            textArea.setText("�䤣�� " + name + " ����ơC");
        }
    }

    private void listData(ActionEvent e) {
        StringBuilder builder = new StringBuilder("�Ҧ���ơG\n");
        students.values().forEach(student -> {
            builder.append(student.getName()).append(" - �����G").append(student.getHeight()).append(" �����A�魫�G").append(student.getWeight()).append(" ����ABMI�G").append(student.calculateBMI()).append("\n");
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
