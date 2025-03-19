package entity;

import validate.Validator;

import java.util.Scanner;

public class Student implements IApp {
    private String studentId;
    private String studentName;
    private String birthday;
    private String phoneNumber;
    private boolean sex;
    private String email;
    private String major;
    private String className;
    private float gpa;
    private byte status = 1;

    public Student() {

    }

    public Student(String studentId, String studentName, String phoneNumber, String birthday, boolean sex, String email, String major, String className, float gpa, byte status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.sex = sex;
        this.email = email;
        this.major = major;
        this.className = className;
        this.gpa = gpa;
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.studentId =inputStudentId(scanner);
        this.studentName =inputStudentName(scanner);
        this.birthday =inputBirthday(scanner);
        this.email =inputEmail(scanner);
        this.major =inputMajor(scanner);
        this.className =inputClassName(scanner);
        this.gpa =inputGpa(scanner);
        this.status =inputStatus(scanner);
        this.phoneNumber = inputPhone(scanner);
        this.sex = inputSex(scanner);
    }

    @Override
    public void displayData() {
        System.out.println("mã sinh viên :%s" + studentId+ ",tên sinh viên " +studentName +" ngày sinh " + birthday);
        System.out.println(" giới tính sinh viên " +sex +  "số điện thoại " +phoneNumber + "email " + email) ;
        System.out.println(" ngành học " + major + " lớp học"  + className + "ddiemr " + gpa);
        System.out.println("trạng thái " + status);

    }

    public String inputStudentId(Scanner scanner) {
        String studentId = Validator.validateProductId(scanner, "vui lòng nhập id", "(SV)\\w{5}");
        return Validator.isStudentExist(scanner, studentId, "studentId");
    }

    public String inputStudentName(Scanner scanner) {
        return Validator.validateStudent(scanner, "vui lòng nhập tên sinh viên ");
    }

    public String inputBirthday(Scanner scanner) {
        return Validator.validateBirthday(scanner, "vui lòng nhập ngày tháng năm sinh ");
    }

    public String inputPhone(Scanner scanner) {
        return Validator.validatePhoneNumber(scanner,"vui lòng nhập số điện thoại");
    }
    public String inputEmail(Scanner scanner) {
        String email = Validator.validateEmail(scanner,"vui lòng nhập email");
        return Validator.isStudentExist(scanner,email,"email");
    }
    public Boolean inputSex(Scanner scanner) {
        return Validator.validateSex(scanner,"vui lòng nhập giới tính ");
    }
    public String inputMajor(Scanner scanner) {
        return Validator.validateStudent(scanner,"vui lòng nhập tên ngành học ");
    }

    public String inputClassName(Scanner scanner) {
        return Validator.validateStudent(scanner,"vui lòng nhập tên lớp học ");
    }

    public float inputGpa(Scanner scanner) {
        return Validator.validateGPA(scanner,"vui lòng nhập ddierm của sinh viên ");
    }

    public Byte inputStatus(Scanner scanner) {
        return Validator.validateStatus(scanner,"vui lòng nhập trạng thái");
    }
}
