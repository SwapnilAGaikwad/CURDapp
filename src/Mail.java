import javax.xml.transform.Result;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;
public class Mail {
    static Scanner scanner =new Scanner(System.in);
    public static void main(String[]args){
    insertStudent();
    selectStudent();
    updateStudent();
    deleteStudent();
    }

    static void deleteStudent(){
        int rollNo = scanner.nextInt();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai", "root", "");
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from student where rollno = ‘"+rollNo+"’");
            if (count>0){
                System.out.println("Student is Deleted from DB");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    static void updateStudent(){
        Student student = new Student();
        student.setRollNo(scanner.nextInt());
        student.setName(scanner.next());
        student.setEmail(scanner.next());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai", "root", "");
            Statement st = con.createStatement();
            st.executeUpdate("Update student set name = ‘" + student.getName() + "’ email ‘" + student.getEmail() + "' where rollNo ='" + student.getRollNo() + "')");
            selectStudent(student.getRollNo());
        }
             catch (Exception e){
                System.out.println(e);
            }

    }

    static void selectStudent(){
        Student student = new Student();
        int rollNo = scanner.nextInt();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from where rollNo = '"+rollNo+"'");
            while (rs.next()) {
                student.setRollNo(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
            }
            }
             catch (Exception e){
                System.out.println(e);
            }
        }
    static void selectStudent(int rollNo){
        Student student = new Student();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from where rollNo = '"+rollNo+"'");
            while (rs.next()) {
                student.setRollNo(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    }
    static void insertStudent(){

            Student student =new Student();
            student.setRollNo(scanner.nextInt());
            student.setName(scanner.next());
            student.setEmail(scanner.next());
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai","root","");
                Statement st = con.createStatement();
                st.execute("insert into student values ('"+student.getRollNo()+"','"+student.getName()+"','"+student.getEmail()+"')");
            }
            catch (Exception e){
                System.out.println(e);
            }
}

