package OOP;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class KhachHang extends ConNguoi {
	private int status; 
	private String idKhachHang;
	private String hoTen;
	private String ngaySinh;
	private String diaChi;
	private String soDienThoai;
	private double tongChiTieu;
	private int diemTichLuy;
	private double mucGiamGia;

	public KhachHang() {
	}

	public KhachHang(int status, String id, String hoTen, String ngaySinh, String diaChi, String soDienThoai,
			double tongChiTieu) {
		super(hoTen, ngaySinh, diaChi, soDienThoai);
		this.status = status;
		this.idKhachHang = id;
		this.diaChi = diaChi;
		this.tongChiTieu = tongChiTieu;
		capNhatUuDai();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(String idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public int getDiemTichLuy() {
		return diemTichLuy;
	}

	public void setDiemTichLuy(int diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}

	public double getMucGiamGia() {
		return mucGiamGia;
	}

	public void setMucGiamGia(double mucGiamGia) {
		this.mucGiamGia = mucGiamGia;
	}

	public double getTongChiTieu() {
		return tongChiTieu;
	}

	public void setTongChiTieu(double tongChiTieu) {
		this.tongChiTieu = tongChiTieu;
		capNhatUuDai();
	}

	public void capNhatUuDai() {
		if (status == 1) { // Khách hàng thường
			this.diemTichLuy = (int) (tongChiTieu / 10000);
		} else if (status == 2) { // Khách hàng VIP
			this.diemTichLuy = (int) ((tongChiTieu / 10000) * 2); // VIP nhân đôi
		}
		this.mucGiamGia = diemTichLuy / 100.0;
		if (mucGiamGia > 15)
			mucGiamGia = 15; // giới hạn tối đa 15%
	}

	// ===== Đọc file =====
	public static KhachHang[] docFile() {
		KhachHang[] ds = new KhachHang[0];
		try (BufferedReader br = new BufferedReader(new FileReader("kh.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.trim().isEmpty())
					continue;
				String[] st = line.split(";");
				int status = Integer.parseInt(st[0]);
				double tongChiTieu = Double.parseDouble(st[6]);
				KhachHang kh = new KhachHang(status, st[1], st[2], st[3], st[4], st[5], tongChiTieu);
				ds = Arrays.copyOf(ds, ds.length + 1);
				ds[ds.length - 1] = kh;
			}
		} catch (IOException e) {
			System.out.println("❌ Lỗi đọc file: " + e.getMessage());
		}
		return ds;
	}
    public static void ghiFile(KhachHang[] ds) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("kh.txt"))) {
            for (KhachHang kh : ds) {
                pw.printf("%d;%s;%s;%s;%s;%s;%.0f%n", kh.getStatus(), kh.getIdKhachHang(), kh.getHoTen(),
                        kh.getNgaySinh(), kh.getDiaChi(), kh.getSoDienThoai(), kh.getTongChiTieu());
            }
        } catch (IOException e) {
            System.out.println("❌ Lỗi ghi file: " + e.getMessage());
        }
    }

	public static void xuat() {
		KhachHang[] ds = docFile();

		System.out.println(
				"===============================================================================================================================");
		System.out.printf("%-10s | %-20s | %-12s | %-15s | %-12s | %-8s | %-18s | %-10s | %-10s\n", "ID KH", "Họ Tên",
				"Ngày Sinh", "Địa Chỉ", "SĐT", "Loại", "Tổng Chi Tiêu (VND)", "Điểm TL", "Giảm giá (%)");
		System.out.println(
				"===============================================================================================================================");

		for (KhachHang kh : ds) {
			String loai = (kh.getStatus() == 1) ? "Thường" : "VIP";
			System.out.printf("%-10s | %-20s | %-12s | %-15s | %-12s | %-8s | %,18.0f | %-10d | %-10.2f\n",
					kh.getIdKhachHang(), kh.getHoTen(), kh.getNgaySinh(), kh.getDiaChi(), kh.getSoDienThoai(), loai,
					kh.getTongChiTieu(), kh.getDiemTichLuy(), kh.getMucGiamGia());
		}

		System.out.println(
				"===============================================================================================================================");
	}
	   // ===== Thêm khách hàng =====
    public static void them() {
        Scanner sc = new Scanner(System.in);
        KhachHang[] ds = docFile();
        System.out.print("Nhập ID khách hàng: ");
        String id = sc.nextLine();
        for (KhachHang kh : ds) {
            if (kh.getIdKhachHang().equalsIgnoreCase(id)) {
                System.out.println("⚠️ ID đã tồn tại!");
                return;
            }
        }
        System.out.print("Họ tên: "); String ten = sc.nextLine();
        System.out.print("Ngày sinh: "); String ns = sc.nextLine();
        System.out.print("Địa chỉ: "); String dc = sc.nextLine();
        System.out.print("Số điện thoại: "); String sdt = sc.nextLine();
        System.out.print("Trạng thái (1: Thường, 2: VIP): "); int st = Integer.parseInt(sc.nextLine());
        System.out.print("Tổng chi tiêu: "); double tong = Double.parseDouble(sc.nextLine());
        KhachHang khMoi = new KhachHang(st, id, ten, ns, dc, sdt, tong);
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = khMoi;
        ghiFile(ds);
        System.out.println("✅ Đã thêm khách hàng mới!");
    }

    // ===== Sửa khách hàng =====
    public static void sua() {
        Scanner sc = new Scanner(System.in);
        KhachHang[] ds = docFile();
        System.out.print("Nhập ID khách hàng cần sửa: ");
        String id = sc.nextLine();
        boolean found = false;
        for (KhachHang kh : ds) {
            if (kh.getIdKhachHang().equalsIgnoreCase(id)) {
                found = true;
                System.out.println("Nhập thông tin mới (bỏ trống nếu không thay đổi):");
                System.out.print("Họ tên: "); String ten = sc.nextLine();
                if (!ten.isEmpty()) kh.setHoTen(ten);
                System.out.print("Ngày sinh: "); String ns = sc.nextLine();
                if (!ns.isEmpty()) kh.setNgaySinh(ns);
                System.out.print("Địa chỉ: "); String dc = sc.nextLine();
                if (!dc.isEmpty()) kh.setDiaChi(dc);
                System.out.print("Số điện thoại: "); String sdt = sc.nextLine();
                if (!sdt.isEmpty()) kh.setSoDienThoai(sdt);
                System.out.print("Trạng thái (1: Thường, 2: VIP): "); String st = sc.nextLine();
                if (!st.isEmpty()) kh.setStatus(Integer.parseInt(st));
                System.out.print("Tổng chi tiêu: "); String tong = sc.nextLine();
                if (!tong.isEmpty()) kh.setTongChiTieu(Double.parseDouble(tong));
                kh.capNhatUuDai();
                break;
            }
        }
        if (found) {
            ghiFile(ds);
            System.out.println("✅ Đã sửa thông tin khách hàng!");
        } else {
            System.out.println("❌ Không tìm thấy khách hàng!");
        }
    }

    // ===== Xóa khách hàng =====
    public static void xoa() {
        Scanner sc = new Scanner(System.in);
        KhachHang[] ds = docFile();
        System.out.print("Nhập ID khách hàng cần xóa: ");
        String id = sc.nextLine();
        boolean found = false;
        KhachHang[] dsMoi = new KhachHang[0];
        for (KhachHang kh : ds) {
            if (kh.getIdKhachHang().equalsIgnoreCase(id)) { found = true; continue; }
            dsMoi = Arrays.copyOf(dsMoi, dsMoi.length + 1);
            dsMoi[dsMoi.length - 1] = kh;
        }
        if (found) {
            ghiFile(dsMoi);
            System.out.println("✅ Đã xóa khách hàng!");
        } else System.out.println("❌ Không tìm thấy khách hàng!");
    }

    // ===== Tìm kiếm khách hàng =====
    public static void timKiem() {
        Scanner sc = new Scanner(System.in);
        KhachHang[] ds = docFile();
        System.out.print("Nhập từ khóa (ID hoặc họ tên): ");
        String key = sc.nextLine().toLowerCase();
        boolean found = false;
        for (KhachHang kh : ds) {
            if (kh.getIdKhachHang().toLowerCase().contains(key) || kh.getHoTen().toLowerCase().contains(key)) {
                found = true;
                String loai = (kh.getStatus() == 1) ? "Thường" : "VIP";
                System.out.printf("👉 %s | %s | %s | %s | %s | %s | %,10.0f | %d | %.2f%%%n",
                        kh.getIdKhachHang(), kh.getHoTen(), kh.getNgaySinh(), kh.getDiaChi(),
                        kh.getSoDienThoai(), loai, kh.getTongChiTieu(),
                        kh.getDiemTichLuy(), kh.getMucGiamGia());
            }
        }
        if (!found) System.out.println("❌ Không tìm thấy khách hàng!");
    }
    public static void Menu () {
		Scanner sc = new Scanner(System.in);
		int chon;
		do {
			System.out.println("\n========= MENU QUẢN LÝ KHÁCH HÀNG =========");
			System.out.println("1. Xem danh sách khách hàng");
			System.out.println("2. Thêm khách hàng");
			System.out.println("3. Sửa thông tin khách hàng");
			System.out.println("4. Xóa khách hàng");
			System.out.println("5. Tìm kiếm khách hàng");
			System.out.println("0. Thoát");
			System.out.print("➡ Nhập lựa chọn: ");
			chon = Integer.parseInt(sc.nextLine());

			switch (chon) {
				case 1:
					xuat();
					break;
				case 2:
					them();
					break;
				case 3:
					sua();
					break;
				case 4:
					xoa();
					break;
				case 5:
					timKiem();
					break;
				case 0:
					System.out.println("👋 Thoát chương trình!");
					break;
				default:
					System.out.println("❌ Lựa chọn không hợp lệ!");
			}
		} while (chon != 0);
	}
	public static void main(String[] args) {
		Menu();
	}
}

