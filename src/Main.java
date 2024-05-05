import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<User> users = new ArrayList<>();
    private static User currentUser;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1. Đăng nhập ");
            System.out.println("2. Đăng kí");
            System.out.println("3. Quên mật khẩu");
            System.out.println("4. Thoát");
            System.out.println(" Nhập lựa chọn của bạn");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    login(scanner);
                    break;
                case 2:
                    register(scanner);
                    break;
                case 3:
                    forgotPassword(scanner);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }

        }

    }
    private static void login(Scanner scanner){
        System.out.println("Nhap mail:");
        String email = scanner.nextLine();
        System.out.println(" Nhap password:");
        String password = scanner.nextLine();
        for (User user: users){
            if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                currentUser = user;
                System.out.println(" Dang nhap thanh cong.");
                System.out.println(" chao mung" + currentUser + "ban co the thuc hien cong viec sau:");
            }
            System.out.println(" tai khoan hoac mat khau khong xac dinh");
        }

    }
    private static void register( Scanner scanner){
        System.out.println(" nhap ten nguoi dung");
        String username = scanner.nextLine();
        System.out.println(" nhap email:");
        String email = scanner.nextLine();
        System.out.println(" Nhap mat khau:");
        String password = scanner.nextLine();
        users.add(new User(username, email, password));
        System.out.println("Đăng ký thành công.");
    }
    private static void forgotPassword(Scanner scanner) {
        System.out.print("Nhập email: ");
        String email = scanner.nextLine();
        System.out.print("Nhập mật khẩu mới: ");
        String newPassword = scanner.nextLine();
        System.out.println("Đổi mật khẩu thành công.");
        login(scanner);
    }
    // thầy ơi phần này em đã code xong phần gia diện đăng nhập nhưng qua đến phần sau đăng nhập thành công
    // thì lại k hiện để lựa chọn. em đang k biết sửa thế nào ạ
    private static void loggedInMenu(Scanner scanner) {
        while (true) {
            System.out.println("1. Thay đổi tên đăng nhập");
            System.out.println("2. Thay đổi email");
            System.out.println("3. Thay đổi mật khẩu");
            System.out.println("4. Đăng xuất");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    changeUsername(scanner);
                    break;
                case 2:
                    changeEmail(scanner);
                    break;
                case 3:
                    changePassword(scanner);
                    break;
                case 4:
                    currentUser = null;
                    System.out.println("Đăng xuất thành công.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
    private static void changeUsername(Scanner scanner) {
        System.out.print("Nhập tên người dùng mới: ");
        String newUsername = scanner.nextLine();
        currentUser.setUsername(newUsername);
        System.out.println("Thay đổi tên người dùng thành công.");
    }
    private static void changeEmail(Scanner scanner) {
        System.out.print("Nhập email mới: ");
        String newEmail = scanner.nextLine();
        for (User user : users) {
            if (user.getEmail().equals(newEmail)) {
                System.out.println("Email đã tồn tại.");
                return;
            }
        }
        currentUser.setEmail(newEmail);
        System.out.println("Thay đổi email thành công.");
    }
    private static void changePassword(Scanner scanner) {
        System.out.print("Nhập mật khẩu mới: ");
        String newPassword = scanner.nextLine();
        System.out.println("Thay đổi mật khẩu thành công.");
    }
}
