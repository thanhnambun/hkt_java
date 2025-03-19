package business;

import entity.Student;
import presentation.StudentApplication;

import java.util.Scanner;

public class StudentBusiness {
    public static void showStudent(Scanner scanner) {
        if (StudentApplication.sudentIndex == 0) {
            System.out.println("Danh sách sinh viên trống.");
            return;
        }

        System.out.println("----- DANH SÁCH SINH VIÊN -----");
        for (int i = 0; i < StudentApplication.sudentIndex; i++) {
            StudentApplication.studentList[i].displayData();
        }
    }
    public static void addStudent(Scanner scanner) {
        for (int i =0 ; i< StudentApplication.sudentIndex;i++){
            StudentApplication.studentList[StudentApplication.sudentIndex]= new Student();
            StudentApplication.studentList[StudentApplication.sudentIndex].displayData();
            StudentApplication.sudentIndex++;
        }
    }
    public static void updateStudent(Scanner scanner) {

    }
    public static int findStudent(String studentId) {

        for (int i =0 ; i< StudentApplication.sudentIndex;i++){
            if (StudentApplication.studentList[i].getStudentId().equals(studentId)) {
                return i;
            }
        }
        return -1;
    }
    public static void deleteStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String studentId = scanner.nextLine().trim();
        int index = findStudent(studentId);

        if (index == -1) {
            System.err.println("Không tìm thấy sinh viên có mã: " + studentId);
            return;
        }

        System.out.println("Thông tin sinh viên cần xóa:");
        StudentApplication.studentList[index].displayData();
        System.out.print("Bạn có chắc muốn xóa sinh viên này không? (Y/N): ");
        String confirm = scanner.nextLine().trim();

        if (confirm.equalsIgnoreCase("Y")) {
            for (int i = index; i < StudentApplication.sudentIndex - 1; i++) {
                StudentApplication.studentList[i] = StudentApplication.studentList[i + 1];
            }
            StudentApplication.studentList[--StudentApplication.sudentIndex] = null;
            System.out.println("Xóa sinh viên thành công.");
        } else {
            System.out.println("Hủy thao tác xóa.");
        }
    }
    public static
}
