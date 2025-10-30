package OOP;

import java.util.Scanner;

public class OOP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] usernames = { "admin", "nhanvien", "khachhang" };
		String[] passwords = { "123", "123", "123" };
		String[] roles = { "quanly", "nhanvien", "khachhang" };

		String role = "";
		String user, pass;

		do {
			System.out.print("Nhập tài khoản: ");
			user = sc.nextLine();

			System.out.print("Nhập mật khẩu: ");
			pass = sc.nextLine();

			role = "";
			for (int i = 0; i < usernames.length; i++) {
				if (user.equals(usernames[i]) && pass.equals(passwords[i])) {
					role = roles[i];
					break;
				}
			}

			if (role.equals("")) {
				System.out.println("❌ Sai tài khoản hoặc mật khẩu! Vui lòng thử lại.\n");
			}

		} while (role.equals(""));
		System.out.println("\n✅ Đăng nhập thành công với vai trò: " + role.toUpperCase());
		boolean running = true;

		while (running) {
			switch (role) {
			case "quanly":
				int chonQL;
				do {
					System.out.println("===== MENU QUẢN LÝ =====");
					System.out.println("1. Quản lý nhân viên");
					System.out.println("2. Quản lý sách");
					System.out.println("3. Xem doanh thu");
					
					System.out.println("0. Quay lại (Đăng xuất)");
					System.out.print("Chọn: ");
					chonQL = sc.nextInt();
					sc.nextLine();
					System.out.println();

					switch (chonQL) {
					case 1:
						System.out.println("→ Bạn đã chọn: Quản lý nhân viên");
						break;
					case 2:
						System.out.println("→ Bạn đã chọn: Quản lý sách");
						break;
					case 3:
						System.out.println("→ Bạn đã chọn: Xem doanh thu");
						break;
					case 0:
						System.out.println("→ Quay lại màn hình đăng nhập...");
						break;
					default:
						System.out.println("Lựa chọn không hợp lệ!");
						break;
					}

					System.out.println();
				} while (chonQL != 0);
				break;

			case "nhanvien":
				System.out.println("1. Bán sách");
				System.out.println("2. Xem danh sách sách");
				System.out.println("3. Lập hóa đơn");
				System.out.println("0. Đăng xuất");
				break;

			case "khachhang":
				System.out.print("Nhập ID khách hàng: ");
				String IDKH = sc.nextLine();
				int chonKH;
				do {
					System.out.println("\n===== MENU KHÁCH HÀNG =====");
					System.out.println("1. Xem sách");
					System.out.println("2. Đặt Hàng");
					System.out.println("3. Xem hóa đơn của tôi");
					System.out.println("4. Thay đổi thông tin cá nhân");
					System.out.println("0. Quay lại (Đăng xuất)");
					System.out.print("Chọn: ");
					chonKH = sc.nextInt();
					sc.nextLine(); 

					switch (chonKH) {
					case 1:
						Sach.xuatKho();
						break;

					case 2:
						Sach.menuTimKiem();
						break;

					case 3:
						System.out.println("→ Chức năng xem hóa đơn cá nhân (đọc từ file hoadon.txt)");
						break;

					case 4:
						System.out.println("4. Thay đổi thông tin cá nhân");
						KhachHang.suaTheoID(IDKH);	
							
					case 0:
						System.out.println("→ Quay lại màn hình đăng nhập...");
						break;

					default:
						System.out.println("❌ Lựa chọn không hợp lệ!");
						break;
					}

				} while (chonKH != 0);
				break;
			}

			System.out.print("Chọn: ");
			int chon = sc.nextInt();
			sc.nextLine();

			if (chon == 0) {
				System.out.println("Đăng xuất thành công!");
				running = false;
			} else {
				System.out.println("→ Bạn đã chọn chức năng " + chon);
			}
		}

		sc.close();
	}
}
