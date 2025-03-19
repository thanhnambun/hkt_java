package validate;

import presentation.StudentApplication;

import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {

    private static final String VIETNAM_PHONE_REGEX ="^(0|\\+84)[0-9]{7}$";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";

    public static String validateProductId(Scanner scanner, String message, String regex) {
        System.out.println(message);
        do {
            String inputString = scanner.nextLine();
            if (Pattern.matches(regex, inputString)) {
                return inputString;
            }
            System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại");
        } while (true);
    }

    public static String validateStudent(Scanner scanner, String message ) {
        String name;
        do {
            System.out.print(message);
            name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            }
            System.err.println("Không được để trống.");
        } while (true);
    }


    public static String validateBirthday(Scanner scanner, String message) {
        String birthday;
        do {
            System.out.print(message);
            birthday = scanner.nextLine().trim();
            if (birthday.isEmpty()) {
                System.err.println("Ngày sinh không được để trống.");
                continue;
            }
            if (Pattern.matches("w{2}/{2}/{4}", birthday)) {
                return birthday;
            }
            System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại");

        } while (true);
    }

    public static String validatePhoneNumber(Scanner scanner, String message) {
        String phone;
        do {
            System.out.print(message);
            phone = scanner.nextLine().trim();
            if (phone.isEmpty()) {
                System.err.println("Số điện thoại không được để trống.");
                continue;
            }
            if (Pattern.matches(VIETNAM_PHONE_REGEX, phone)) {
                return phone;
            } else {
                System.err.println("Số điện thoại không đúng định dạng Việt Nam.");
            }
        } while (true);
    }

    public static String validateEmail(Scanner scanner, String message) {
        String email;
        do {
            System.out.print(message);
            email = scanner.nextLine().trim();
            if (email.isEmpty()) {
                System.err.println("Email không được để trống.");
                continue;
            }
            if (Pattern.matches(EMAIL_REGEX, email)) {
                return email;
            } else {
                System.err.println("Email không đúng định dạng (phải là địa chỉ gmail).");
            }
        } while (true);
    }

    public static boolean validateSex(Scanner scanner, String message) {
        String input;
        do {
            System.out.print(message + " (true - Nam / false - Nữ): ");
            input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                return Boolean.parseBoolean(input);
            }
            System.err.println("Giới tính chỉ nhận true (Nam) hoặc false (Nữ).");
        } while (true);
    }

    public static float validateGPA(Scanner scanner, String message) {
        float gpa;
        do {
            System.out.print(message);
            try {
                gpa = Float.parseFloat(scanner.nextLine());
                if (gpa >= 0) {
                    return gpa;
                } else {
                    System.err.println("GPA phải >= 0.");
                }
            } catch (NumberFormatException e) {
                System.err.println("GPA phải là số thực hợp lệ.");
            }
        } while (true);
    }

    public static byte validateStatus(Scanner scanner, String message) {
        byte status;
        do {
            System.out.print(message + " (1-Đang học / 2-Bảo lưu / 3-Đã nghỉ học): ");
            try {
                status = Byte.parseByte(scanner.nextLine());
                if (status >= 1 && status <= 3) {
                    return status;
                } else {
                    System.err.println("Trạng thái chỉ nhận giá trị 1, 2 hoặc 3.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Trạng thái phải là số nguyên.");
            }
        } while (true);
    }

    public static String isStudentExist(Scanner scanner, String value, String type) {
        do {
            boolean isExist = false;
            switch (type) {
                case "studentId":
                    for (int i = 0; i < StudentApplication.sudentIndex; i++) {
                        if (StudentApplication.studentList[i].getStudentId().equals(value)) {
                            isExist = true;
                            break;
                        }
                    }
                    break;
                case "email":
                    for (int i = 0 ; i < StudentApplication.sudentIndex; i++) {
                        if (StudentApplication.studentList[i].getEmail().equals(value)) {
                            isExist = true;
                            break;
                        }
                    }
                    break;
            }
            if (!isExist) {
                return value;
            }
            System.err.println("Dữ liệu bị trùng lặp, vui lòng nhập lại");
            value = scanner.nextLine();
        } while (true);

    }
}



