import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class PasswordChecker implements ActionListener {
    private static JLabel PageName;
    private static JLabel userName;
    private static JTextField userNameField;
    private static JLabel password;
    private static JPasswordField passwordField;
    private static JButton loginButton;
    private static JLabel checker;
    Student Araf=new Student("Araf","80%");
    Student John=new Student("John","85%");
    Student Drake=new Student("Drake","77%");
    Student Jamey=new Student("Jamey","78%");
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        frame.setSize(700,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel=new JPanel();
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.orange);

        PageName=new JLabel("Login Page");
        PageName.setBounds(100,10,100,100);
        PageName.setForeground(Color.blue);
        Font font = new Font("Courier", Font.BOLD,15);
        PageName.setFont(font);
        panel.add(PageName);

        userName=new JLabel("User Name: ");
        userName.setBounds(50, 100, 150, 25);
        panel.add(userName);

        userNameField=new JTextField();
        userNameField.setBounds(135,100,100,25);
        panel.add(userNameField);

        password=new JLabel("Password: ");
        password.setBounds(50,150,100,25);
        panel.add(password);

        passwordField=new JPasswordField();
        passwordField.setBounds(135,150,100,25);
        panel.add(passwordField);

        loginButton=new JButton("Login");
        loginButton.setBounds(50,200,80,25);
        panel.add(loginButton);

        checker =new JLabel("");
        checker.setBounds(50,250,500,25);
        loginButton.addActionListener(new PasswordChecker());
        panel.add(checker);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ArrayList<Student> ListofStudents=new ArrayList<Student>();
        ListofStudents.add(Araf);
        ListofStudents.add(John);
        ListofStudents.add(Drake);
        ListofStudents.add(Jamey);
        StudentList school=new StudentList(ListofStudents);

        String user=userNameField.getText();
        String password=passwordField.getText();

        boolean NameCheck=false;
        for (Student s: ListofStudents){
            if (user.equals(s.getName()) && isValid(password)){
                NameCheck=true;
                checker.setText("Overall Average: "+s.getGrades()+ ". Email at syedarafimam27@gmail.com if any query");
            }
        }
        if (NameCheck==false){
            checker.setText("Incorrect Name or password");
        }



    }
    // Student password Format: LLLNNNN
    public static boolean isValid(String name){
        boolean good=true;
        int i=0;
        if (name.length()!=7){
            good=false;
        }
        while (good && i<3){
            if (!Character.isLetter(name.charAt(i))){
                good=false;
            }
            i++;
        }
        while (good && i<7){
            if (!Character.isDigit(name.charAt(i))){
                good=false;
            }
            i++;
        }
        return good;
    }
}
