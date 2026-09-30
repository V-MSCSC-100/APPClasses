//Question 1
class EmergencyAlert extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " | Priority: " + getPriority() + " | Critical patient alert");
        }
    }
}

class VitalMonitor extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " | Priority: " + getPriority() + " | Monitoring vital signs");
        }
    }
}

class ReportGenerator extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " | Priority: " + getPriority() + " | Generating routine report");
        }
    }
}

public class HospitalMonitoring {
    public static void main(String[] args) {
        EmergencyAlert emergency = new EmergencyAlert();
        VitalMonitor vital = new VitalMonitor();
        ReportGenerator report = new ReportGenerator();

        emergency.setName("EmergencyAlert");
        vital.setName("VitalMonitor");
        report.setName("ReportGenerator");

        emergency.setPriority(Thread.MAX_PRIORITY);
        vital.setPriority(Thread.NORM_PRIORITY);
        report.setPriority(Thread.MIN_PRIORITY);

        emergency.start();
        vital.start();
        report.start();
    }

//Question 2

class OrderProcessing extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " | Priority: " + getPriority() + " | Processing customer order");
        }
    }
}

class DeliveryTracking extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " | Priority: " + getPriority() + " | Tracking delivery location");
        }
    }
}

class Notification extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " | Priority: " + getPriority() + " | Sending order notification");
        }
    }
}

public class FoodDelivery {
    public static void main(String[] args) {
        OrderProcessing order = new OrderProcessing();
        DeliveryTracking delivery = new DeliveryTracking();
        Notification notification = new Notification();

        order.setName("OrderProcessing");
        delivery.setName("DeliveryTracking");
        notification.setName("Notification");

        order.setPriority(10);
        delivery.setPriority(5);
        notification.setPriority(1);

        order.start();
        delivery.start();
        notification.start();
    }
}

//Question 3

import javax.swing.*;
import java.awt.*;

public class StudentRegistration extends JFrame {
    JTextField nameField, regField;
    JRadioButton male, female, other;
    JComboBox<String> department;

    StudentRegistration() {
        setTitle("Student Registration");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Student Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Register Number:"));
        regField = new JTextField();
        add(regField);

        add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        group.add(other);

        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(other);
        add(genderPanel);

        add(new JLabel("Department:"));
        department = new JComboBox<>(new String[]{"CSE", "AIML", "ECE", "EEE", "MECH"});
        add(department);

        JButton submit = new JButton("Submit");
        add(new JLabel(""));
        add(submit);

        submit.addActionListener(e -> {
            String gender = male.isSelected() ? "Male" :
                            female.isSelected() ? "Female" : "Other";

            JOptionPane.showMessageDialog(this,
                    "Name: " + nameField.getText() +
                    "\nRegister Number: " + regField.getText() +
                    "\nGender: " + gender +
                    "\nDepartment: " + department.getSelectedItem());
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}

//Question 4

import javax.swing.*;
import java.awt.*;

public class UserLogin extends JFrame {
    JTextField username;
    JPasswordField password;
    JCheckBox remember, notifications;

    UserLogin() {
        setTitle("User Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Username:"));
        username = new JTextField();
        add(username);

        add(new JLabel("Password:"));
        password = new JPasswordField();
        add(password);

        remember = new JCheckBox("Remember Me");
        notifications = new JCheckBox("Receive Notifications");

        add(remember);
        add(notifications);

        JButton login = new JButton("Login");
        add(new JLabel(""));
        add(login);

        login.addActionListener(e -> {
            String user = username.getText();
            String pass = new String(password.getPassword());

            if (user.equals("admin") && pass.equals("1234")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new UserLogin();
    }
}

//Question 5

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CourseManagement extends JFrame {
    JList<String> courseList;
    JTable table;
    DefaultTableModel model;

    CourseManagement() {
        setTitle("Student Course Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        String[] courses = {"Java", "Python", "Data Structures", "Machine Learning", "Database Systems"};

        courseList = new JList<>(courses);
        JScrollPane listScroll = new JScrollPane(courseList);

        model = new DefaultTableModel(
                new String[]{"Student Name", "Selected Course", "Enrollment Status"}, 0);

        table = new JTable(model);
        JScrollPane tableScroll = new JScrollPane(table);

        JPanel buttons = new JPanel();

        JButton add = new JButton("Add");
        JButton remove = new JButton("Remove");

        buttons.add(add);
        buttons.add(remove);

        add.addActionListener(e -> {
            String course = courseList.getSelectedValue();

            if (course != null) {
                model.addRow(new Object[]{"Student", course, "Enrolled"});
            }
        });

        remove.addActionListener(e -> {
            int row = table.getSelectedRow();

            if (row != -1) {
                model.removeRow(row);
            }
        });

        add(listScroll, BorderLayout.WEST);
        add(tableScroll, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CourseManagement();
    }
}
