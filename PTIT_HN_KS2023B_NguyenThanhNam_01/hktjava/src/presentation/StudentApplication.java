package presentation;

import business.StudentBusiness;
import entity.Student;

import java.util.Scanner;

public class StudentApplication {
    public static final Student[] studentList = new Student[100];
    public static int sudentIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("student menu ");
            System.out.println("1. hiển thij danh sách  sinh viên");
            System.out.println("2 . thêm mới sinh viên ");
            System.out.println("3. sửa sinh viên ");
            System.out.println("4. xóa sinh viên ");
            System.out.println("5. tìm kiếm sinh viên ");
            System.out.println("6 . sắp xếp ");
            System.out.println("7. thoát ");
            System.out.println("vui lòng lựa chọn ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    StudentBusiness.showStudent(scanner);
                    break;
                case 2:
                    StudentBusiness.addStudent(scanner);
                    break;
                case 3:

                    break;
                case 4:
                    StudentBusiness.deleteStudent(scanner);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("đã thoát chương trình ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("vui lòng lựa chọn đúng từ 1-7");
                    break;
            }
        } while (true);
    }
}
