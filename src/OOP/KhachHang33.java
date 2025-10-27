import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class KhachHang33 extends ConNguoi {
	private String idKhachHang;
	private int status; 
	private int soLanMua;
	private double tongChiTieu;
	private double mucGiamGia;
	private int diemTichLuy;
	public KhachHang33() {}

	public KhachHang33(String idKhachHang, String hoTen, String ngaySinh, String diaChi, String soDienThoai, int status,
			int soLanMua, double tongChiTieu) {
		super(hoTen, ngaySinh, diaChi, soDienThoai);
		this.idKhachHang = idKhachHang;
		this.status = status;
		this.soLanMua = soLanMua;
		this.tongChiTieu = tongChiTieu;
		capNhatUuDai();
	}

	public String getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(String idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSoLanMua() {
		return soLanMua;
	}

	public void setSoLanMua(int soLanMua) {
		this.soLanMua = soLanMua;
	}

	public double getTongChiTieu() {
		return tongChiTieu;
	}

	public void setTongChiTieu(double tongChiTieu) {
		this.tongChiTieu = tongChiTieu;
		capNhatUuDai();
	}

	public double getMucGiamGia() {
		return mucGiamGia;
	}

	public int getDiemTichLuy() {
		return diemTichLuy;
	}

	public void capNhatUuDai() {
		if (status == 2) {
			this.diemTichLuy = (int) (tongChiTieu / 1000);
			if (diemTichLuy > 100)
				mucGiamGia = 0.15;
			else if (diemTichLuy > 50)
				mucGiamGia = 0.1;
			else if (diemTichLuy > 0)
				mucGiamGia = 0.05;
		}
	}

	@Override
	public String toString() {
		return idKhachHang + " | " + super.toString();
	}

public static KhachHang33[] docFile() {
		KhachHang33[] dsKH = new KhachHang33[0];
		String fileName = "kh.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] st = line.split(";");
				String loai = st[0];

				if (loai.equalsIgnoreCase("Thuong")) {
					KhachHang33 kh = new KhachHang33(st[1], st[2], st[3], st[4], st[5], 1, Integer.parseInt(st[6]), 0);
					dsKH = Arrays.copyOf(dsKH, dsKH.length + 1);
					dsKH[dsKH.length - 1] = kh;
				} else if (loai.equalsIgnoreCase("VIP")) {
					KhachHang33 kh = new KhachHang33(st[1], st[2], st[3], st[4], st[5], 2, 0, Double.parseDouble(st[6]));
					dsKH = Arrays.copyOf(dsKH, dsKH.length + 1);
					dsKH[dsKH.length - 1] = kh;
				}
			}
		} catch (IOException e) {
			System.out.println("Lỗi đọc file: " + e.getMessage());
		}
		return dsKH;
	}


	public static void ghiFile(KhachHang33[] dsKH) {
		String fileName = "kh.txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
			for (KhachHang33 kh : dsKH) {
				if (kh.getStatus() == 1) {
					bw.write("Thuong;" + kh.getIdKhachHang() + ";" + kh.getHoTen() + ";" + kh.getNgaySinh() + ";" +
						kh.getDiaChi() + ";" + kh.getSoDienThoai() + ";" + kh.getSoLanMua());
				} else {
					bw.write("VIP;" + kh.getIdKhachHang() + ";" + kh.getHoTen() + ";" + kh.getNgaySinh() + ";" +
						kh.getDiaChi() + ";" + kh.getSoDienThoai() + ";" + kh.getTongChiTieu());
				}
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Lỗi ghi file: " + e.getMessage());
		}
	}
   public static void xuatTatCa(KhachHang33[] dsKH) {
		System.out.println("\n===== DANH SÁCH KHÁCH HÀNG THƯỜNG =====");
		xuatDanhSach(dsKH, 1);
		System.out.println("\n===== DANH SÁCH KHÁCH HÀNG VIP =====");
		xuatDanhSach(dsKH, 2);
	}
	public static void xuatDanhSach(KhachHang33[] dsKH, int status) {
		if (status == 1) {
			System.out.printf("%-10s | %-20s | %-12s | %-20s | %-15s | %-12s\n", 
				"ID KH", "Họ Tên", "Ngày Sinh", "Địa Chỉ", "SĐT", "Số lần mua");
			System.out.println("----------------------------------------------------------------------------------------");
			for (KhachHang33 kh : dsKH)
				if (kh.getStatus() == 1)
					System.out.printf("%-10s | %-20s | %-12s | %-20s | %-15s | %-12d\n", 
						kh.getIdKhachHang(), kh.getHoTen(), kh.getNgaySinh(), kh.getDiaChi(),
						kh.getSoDienThoai(), kh.getSoLanMua());
		} else {
			System.out.printf("%-10s | %-20s | %-12s | %-20s | %-15s | %-15s | %-10s | %-10s\n", 
				"ID KH", "Họ Tên", "Ngày Sinh", "Địa Chỉ", "SĐT", "Tổng Chi Tiêu", "Điểm TL", "Giảm giá (%)");
			System.out.println("------------------------------------------------------------------------------------------------------");
			for (KhachHang33 kh : dsKH)
				if (kh.getStatus() == 2)
					System.out.printf("%-10s | %-20s | %-12s | %-20s | %-15s | %-15.0f | %-10d | %-10.2f\n",
						kh.getIdKhachHang(), kh.getHoTen(), kh.getNgaySinh(), kh.getDiaChi(),
						kh.getSoDienThoai(), kh.getTongChiTieu(), kh.getDiemTichLuy(), kh.getMucGiamGia() * 100);
		}
	}


	public static KhachHang33[] themKhachHang(KhachHang33[] dsKH, int status) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập ID KH: ");
		String id = sc.nextLine();
		System.out.print("Nhập họ tên: ");
		String ten = sc.nextLine();
		System.out.print("Nhập ngày sinh: ");
		String ns = sc.nextLine();
		System.out.print("Nhập địa chỉ: ");
		String dc = sc.nextLine();
		System.out.print("Nhập số điện thoại: ");
		String sdt = sc.nextLine();

		if (status == 1) {
			System.out.print("Nhập số lần mua: ");
			int slm = sc.nextInt();
			KhachHang33 kh = new KhachHang33(id, ten, ns, dc, sdt, 1, slm, 0);
			dsKH = Arrays.copyOf(dsKH, dsKH.length + 1);
			dsKH[dsKH.length - 1] = kh;
		} else {
			System.out.print("Nhập tổng chi tiêu: ");
			double tong = sc.nextDouble();
			KhachHang33 kh = new KhachHang33(id, ten, ns, dc, sdt, 2, 0, tong);
			dsKH = Arrays.copyOf(dsKH, dsKH.length + 1);
			dsKH[dsKH.length - 1] = kh;
		}

		ghiFile(dsKH);
		System.out.println("==> Đã thêm khách hàng thành công!");
		return dsKH;
	}

	public static void timKiem(KhachHang33[] dsKH, String id) {
		for (KhachHang33 kh : dsKH) {
			if (kh.getIdKhachHang().equalsIgnoreCase(id)) {
				System.out.println("Tìm thấy: " + kh.getIdKhachHang() + " - " + kh.getHoTen());
				return;
			}
		}
		System.out.println("Không tìm thấy khách hàng có ID này.");
	}

	public static void suaKhachHang(KhachHang33[] dsKH, int status) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập ID KH cần sửa: ");
		String id = sc.nextLine();
		boolean found = false;

		for (KhachHang33 kh : dsKH) {
			if (kh.getIdKhachHang().equalsIgnoreCase(id)) {
				found = true;
				System.out.print("Nhập họ tên mới: ");
				kh.setHoTen(sc.nextLine());
				System.out.print("Nhập địa chỉ mới: ");
				kh.setDiaChi(sc.nextLine());
				System.out.print("Nhập SĐT mới: ");
				kh.setSoDienThoai(sc.nextLine());

				if (status == 1) {
					System.out.print("Nhập số lần mua mới: ");
					kh.setSoLanMua(sc.nextInt());
				} else {
					System.out.print("Nhập tổng chi tiêu mới: ");
					kh.setTongChiTieu(sc.nextDouble());
				}
				break;
			}
		}

		if (found) {
			ghiFile(dsKH);
			System.out.println("==> Đã cập nhật thông tin!");
		} else
			System.out.println("Không tìm thấy khách hàng!");
	}

	public static KhachHang33[] xoaKhachHang(KhachHang33[] dsKH) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập ID KH cần xóa: ");
		String id = sc.nextLine();
		boolean found = false;
		KhachHang33[] moi = new KhachHang33[0];

		for (KhachHang33 kh : dsKH) {
			if (!kh.getIdKhachHang().equalsIgnoreCase(id)) {
				moi = Arrays.copyOf(moi, moi.length + 1);
				moi[moi.length - 1] = kh;
			} else
				found = true;
		}

		if (found) {
			ghiFile(moi);
			System.out.println("==> Đã xóa khách hàng thành công!");
		} else
			System.out.println("Không tìm thấy khách hàng để xóa!");

		return moi;
	}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    KhachHang33[] dsKH = docFile();
    int chon;

    do {
        System.out.println("\n=== MENU QUẢN LÝ KHÁCH HÀNG ===");
        System.out.println("1. Xuất toàn bộ danh sách khách hàng");
        System.out.println("2. Thêm khách hàng");
        System.out.println("3. Sửa thông tin khách hàng");
        System.out.println("4. Xóa khách hàng");
        System.out.println("5. Tìm kiếm khách hàng theo ID");
        System.out.println("0. Thoát");
        System.out.print("Chọn: ");
        chon = sc.nextInt();
        sc.nextLine(); 

        switch (chon) {
            case 1 -> xuatTatCa(dsKH);

            case 2 -> {
                System.out.print("Thêm khách hàng loại nào (1 - Thường, 2 - VIP): ");
                int statusThem = sc.nextInt();
                sc.nextLine();
                dsKH = themKhachHang(dsKH, statusThem);
            }

            case 3 -> {
                System.out.print("Sửa thông tin khách hàng loại nào (1 - Thường, 2 - VIP): ");
                int statusSua = sc.nextInt();
                sc.nextLine();
                suaKhachHang(dsKH, statusSua);
            }

            case 4 -> dsKH = xoaKhachHang(dsKH);

            case 5 -> {
                System.out.print("Nhập ID cần tìm: ");
                String id = sc.nextLine();
                timKiem(dsKH, id);
            }

            case 0 -> System.out.println("==> Thoát chương trình!");
            default -> System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
        }

    } while (chon != 0);
}
}
