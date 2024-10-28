package StudentManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGUI extends JFrame implements ActionListener {
    private StudentManagement sms; 
    private JTextField nameField, rollField, gradeField;
    private JTextArea displayArea;
    private JButton addButton, removeButton, searchButton, displayButton;

    public StudentGUI() {
        sms = new StudentManagement(); 

      
        setTitle("Student Management System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); 

       
        nameField = new JTextField(15);
        rollField = new JTextField(15);
        gradeField = new JTextField(15);

        addButton = new JButton("Add Student");
        removeButton = new JButton("Remove Student");
        searchButton = new JButton("Search Student");
        displayButton = new JButton("Display All Students");

        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);

       
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        add(nameField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Roll Number:"), gbc);
        gbc.gridx = 1;
        add(rollField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Grade:"), gbc);
        gbc.gridx = 1;
        add(gradeField, gbc);

        // Add buttons in a new row
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(addButton, gbc);
        gbc.gridx = 1;
        add(removeButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(searchButton, gbc);
        gbc.gridx = 1;
        add(displayButton, gbc);

        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2; 
        add(new JScrollPane(displayArea), gbc);

        // Add action listeners
        addButton.addActionListener(this);
        removeButton.addActionListener(this);
        searchButton.addActionListener(this);
        displayButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String name = nameField.getText();
        String rollNumber = rollField.getText();
        String grade = gradeField.getText();

        switch (command) {
            case "Add Student":
                if (name.isEmpty() || rollNumber.isEmpty() || grade.isEmpty()) {
                    displayArea.setText("All fields are required to add a student.");
                } else {
                    sms.addStudent(new Student(name, rollNumber, grade));
                    displayArea.setText("Student added successfully.");
                    clearFields();
                }
                break;

            case "Remove Student":
                if (rollNumber.isEmpty()) {
                    displayArea.setText("Roll Number is required to remove a student.");
                } else {
                    if (sms.removeStudent(rollNumber)) {
                        displayArea.setText("Student removed successfully.");
                    } else {
                        displayArea.setText("Student not found.");
                    }
                    clearFields();
                }
                break;

            case "Search Student":
                if (rollNumber.isEmpty()) {
                    displayArea.setText("Roll Number is required to search a student.");
                } else {
                    Student foundStudent = sms.searchStudent(rollNumber);
                    if (foundStudent != null) {
                        displayArea.setText(foundStudent.toString());
                    } else {
                        displayArea.setText("Student not found.");
                    }
                    clearFields();
                }
                break;

            case "Display All Students":
                if (sms.getAllStudents().isEmpty()) {
                    displayArea.setText("No students to display.");
                } else {
                    StringBuilder displayText = new StringBuilder();
                    for (Student student : sms.getAllStudents()) {
                        displayText.append(student.toString()).append("\n");
                    }
                    displayArea.setText(displayText.toString());
                }
                break;

            default:
                break;
        }
    }

    private void clearFields() {
        nameField.setText("");
        rollField.setText("");
        gradeField.setText("");
    }

  
    public static void main(String[] args) {
        StudentGUI gui = new StudentGUI();
        gui.setVisible(true);
    }
}
