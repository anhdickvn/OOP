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
		if (status == 1) {
			this.diemTichLuy = (int) (tongChiTieu / 10000);
		} else if (status == 2) {
			this.diemTichLuy = (int) ((tongChiTieu / 10000) * 2);
		}
		this.mucGiamGia = diemTichLuy / 100.0;
		if (mucGiamGia > 15)
			mucGiamGia = 15;
	}

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
			System.out.println("Lỗi đọc file: " + e.getMessage());
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

	public static void them() {
		Scanner sc = new Scanner(System.in);
		KhachHang[] ds = docFile();
		System.out.print("Nhập ID khách hàng: ");
		String id = sc.nextLine();
		for (KhachHang kh : ds) {
			if (kh.getIdKhachHang().equalsIgnoreCase(id)) {
				System.out.println("ID đã tồn tại!");
				return;
			}
		}
		System.out.print("Họ tên: ");
		String ten = sc.nextLine();
		System.out.print("Ngày sinh: ");
		String ns = sc.nextLine();
		System.out.print("Địa chỉ: ");
		String dc = sc.nextLine();
		System.out.print("Số điện thoại: ");
		String sdt = sc.nextLine();
		System.out.print("Trạng thái (1: Thường, 2: VIP): ");
		int st = Integer.parseInt(sc.nextLine());
		System.out.print("Tổng chi tiêu: ");
		double tong = Double.parseDouble(sc.nextLine());
		KhachHang khMoi = new KhachHang(st, id, ten, ns, dc, sdt, tong);
		ds = Arrays.copyOf(ds, ds.length + 1);
		ds[ds.length - 1] = khMoi;
		ghiFile(ds);
		System.out.println("Đã thêm khách hàng mới!");
	}

	public static void suaTheoID(String idSua) {
		Scanner sc = new Scanner(System.in);
		KhachHang[] ds = docFile();

		for (KhachHang kh : ds) {
			if (kh.getIdKhachHang().equalsIgnoreCase(idSua)) {
				while (true) {
					System.out.println("\n===== CHỈNH SỬA THÔNG TIN KHÁCH HÀNG =====");
					System.out.println("1. Họ tên       (Hiện tại: " + kh.getHoTen() + ")");
					System.out.println("2. Ngày sinh    (Hiện tại: " + kh.getNgaySinh() + ")");
					System.out.println("3. Địa chỉ      (Hiện tại: " + kh.getDiaChi() + ")");
					System.out.println("4. Số điện thoại(Hiện tại: " + kh.getSoDienThoai() + ")");
					System.out.println("5. Loại  (Hiện tại: " + (kh.getStatus() == 1 ? "Thường" : "VIP") + ")");
					System.out.println("6. Tổng chi tiêu(Hiện tại: " + kh.getTongChiTieu() + ")");
					System.out.println("0. 💾 Lưu và thoát");
					System.out.print("👉 Chọn mục bạn muốn sửa (0–6): ");

					String chon = sc.nextLine();

					switch (chon) {
					case "1" -> {
						System.out.print("Nhập họ tên mới: ");
						kh.setHoTen(sc.nextLine());
					}
					case "2" -> {
						System.out.print("Nhập ngày sinh mới: ");
						kh.setNgaySinh(sc.nextLine());
					}
					case "3" -> {
						System.out.print("Nhập địa chỉ mới: ");
						kh.setDiaChi(sc.nextLine());
					}
					case "4" -> {
						System.out.print("Nhập số điện thoại mới: ");
						kh.setSoDienThoai(sc.nextLine());
					}
					case "5" -> {
						System.out.print("Nhập trạng thái mới (1: Thường, 2: VIP): ");
						kh.setStatus(Integer.parseInt(sc.nextLine()));
					}
					case "6" -> {
						System.out.print("Nhập tổng chi tiêu mới: ");
						kh.setTongChiTieu(Double.parseDouble(sc.nextLine()));
					}
					case "0" -> {
						System.out.println("💾 Đang lưu dữ liệu...");
						kh.capNhatUuDai();
						ghiFile(ds);
						System.out.println("✅ Đã cập nhật thông tin khách hàng!");
						return; // Thoát toàn hàm, không in ❌
					}
					default -> System.out.println("❌ Lựa chọn không hợp lệ!");
					}
				}
			}
		}

		System.out.println("❌ Không tìm thấy khách hàng có ID: " + idSua);
	}

	

	public static void ThemKhachHang() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số lượng khách hàng muốn thêm: ");
		int n = Integer.parseInt(sc.nextLine());

		try (FileWriter fw = new FileWriter("kh.txt", true); PrintWriter pw = new PrintWriter(fw)) {

			for (int i = 0; i < n; i++) {
				System.out.println("\n--- Nhập khách hàng thứ " + (i + 1) + " ---");
				System.out.print("ID khách hàng: ");
				String id = sc.nextLine();
				System.out.print("Họ tên: ");
				String hoTen = sc.nextLine();
				System.out.print("Ngày sinh: ");
				String ngaySinh = sc.nextLine();
				System.out.print("Địa chỉ: ");
				String diaChi = sc.nextLine();
				System.out.print("Số điện thoại: ");
				String soDT = sc.nextLine();
				System.out.print("Trạng thái (1: Thường, 2: VIP): ");
				int status = Integer.parseInt(sc.nextLine());
				System.out.print("Tổng chi tiêu: ");
				double tongChiTieu = Double.parseDouble(sc.nextLine());

				// Ghi dòng mới vào file theo định dạng sẵn
				pw.printf("%d;%s;%s;%s;%s;%s;%.0f%n", status, id, hoTen, ngaySinh, diaChi, soDT, tongChiTieu);
			}

			System.out.println("✅ Ghi file thành công vào kh.txt");
		} catch (IOException e) {
			System.out.println("❌ Lỗi khi ghi file: " + e.getMessage());
		}
	}

	public static void ThemKhachHang() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số lượng khách hàng muốn thêm: ");
		int n = Integer.parseInt(sc.nextLine());

		try (FileWriter fw = new FileWriter("kh.txt", true); PrintWriter pw = new PrintWriter(fw)) {

			for (int i = 0; i < n; i++) {
				System.out.println("\n--- Nhập khách hàng thứ " + (i + 1) + " ---");
				System.out.print("ID khách hàng: ");
				String id = sc.nextLine();
				System.out.print("Họ tên: ");
				String hoTen = sc.nextLine();
				System.out.print("Ngày sinh: ");
				String ngaySinh = sc.nextLine();
				System.out.print("Địa chỉ: ");
				String diaChi = sc.nextLine();
				System.out.print("Số điện thoại: ");
				String soDT = sc.nextLine();
				System.out.print("Trạng thái (1: Thường, 2: VIP): ");
				int status = Integer.parseInt(sc.nextLine());
				System.out.print("Tổng chi tiêu: ");
				double tongChiTieu = Double.parseDouble(sc.nextLine());

				// Ghi dòng mới vào file theo định dạng sẵn
				pw.printf("%d;%s;%s;%s;%s;%s;%.0f%n", status, id, hoTen, ngaySinh, diaChi, soDT, tongChiTieu);
			}

			System.out.println("✅ Ghi file thành công vào kh.txt");
		} catch (IOException e) {
			System.out.println("❌ Lỗi khi ghi file: " + e.getMessage());
		}
	}

	public static void xoaTheoID(String id) {
		KhachHang[] ds = docFile(); // đọc danh sách khách hàng
		boolean found = false;
		KhachHang[] dsMoi = new KhachHang[0];

		for (KhachHang kh : ds) {
			if (kh.getIdKhachHang().equalsIgnoreCase(id)) {
				found = true;
				System.out.println("✅ Đã xóa khách hàng: " + kh.getHoTen());
				continue; // bỏ qua khách hàng này
			}
			dsMoi = Arrays.copyOf(dsMoi, dsMoi.length + 1);
			dsMoi[dsMoi.length - 1] = kh;
		}

		if (found) {
			ghiFile(dsMoi); // ghi lại file sau khi xóa
		} else {
			System.out.println("❌ Không tìm thấy khách hàng có ID: " + id);
		}
	}

	public static void timKiem() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập thông tin muốn tìm (ID / Họ tên / SĐT / Địa chỉ / Loại KH): ");
		String tuKhoa = sc.nextLine().toLowerCase();
		KhachHang[] ds = docFile();

		boolean timThay = false;

		for (KhachHang kh : ds) {
			String loai = (kh.getStatus() == 1) ? "Thường" : "VIP";

			boolean timTheoID = kh.getIdKhachHang().equalsIgnoreCase(tuKhoa);
			boolean timTheoTen = kh.getHoTen().toLowerCase().contains(tuKhoa);
			boolean timTheoSdt = kh.getSoDienThoai().toLowerCase().contains(tuKhoa);
			boolean timTheoDiaChi = kh.getDiaChi().toLowerCase().contains(tuKhoa);
			boolean timTheoLoai = loai.toLowerCase().contains(tuKhoa);

			if (timTheoID || timTheoTen || timTheoSdt || timTheoDiaChi || timTheoLoai) {
				timThay = true;
				System.out.println("──────────────────────────────────────────────────────────────");
				System.out.println("🧾 ID Khách hàng: " + kh.getIdKhachHang());
				System.out.println("👤 Họ tên: " + kh.getHoTen());
				System.out.println("📅 Ngày sinh: " + kh.getNgaySinh());
				System.out.println("🏠 Địa chỉ: " + kh.getDiaChi());
				System.out.println("📞 Số điện thoại: " + kh.getSoDienThoai());
				System.out.println("💳 Loại khách hàng: " + loai);
				System.out.printf("💰 Tổng chi tiêu: %, .0f VND\n", kh.getTongChiTieu());
				System.out.println("⭐ Điểm tích lũy: " + kh.getDiemTichLuy());
				System.out.printf("🏷️ Mức giảm giá: %.2f%%\n", kh.getMucGiamGia());
				System.out.println("──────────────────────────────────────────────────────────────");
			}
		}

		if (!timThay) {
			System.out.println("❌ Không tìm thấy khách hàng phù hợp với từ khóa: " + tuKhoa);
		}
	}
	public static void xuatHoaDonTheoID(String idKhachHang) {
    	try (BufferedReader br = new BufferedReader(new FileReader("HoaDon.txt"))) {
       		String line;
        	

        	while ((line = br.readLine()) != null) {
            	line = line.trim();
            	if (line.isEmpty()) continue; // bỏ qua dòng trống

            	String[] parts = line.split(";");
            	if (parts.length < 12) continue; // tránh lỗi nếu thiếu dữ liệu

            
            	String khachHang = parts[0].trim();
           	 	String maHoaDon = parts[1].trim();
            	String ngayIn = parts[2].trim();
            	String loaiKH = parts[3].trim();
            	String sach = parts[4].trim();
            	String soLuong = parts[5].trim();
            	String donGia = parts[6].trim();
            	String tong = parts[7].trim();
            	String ctkm = parts[8].trim();
            	String giamGia = parts[9].trim();
            	String sauGiam = parts[10].trim();
            	String vat = parts[11].trim();

            	if (khachHang.equals(idKhachHang)) {
                	
                	System.out.println("=========================================");
                	System.out.println("KHÁCH HÀNG: " + khachHang);
                	System.out.println("MÃ HÓA ĐƠN: " + maHoaDon);
                	System.out.println("NGÀY IN: " + ngayIn);
                	System.out.println("LOẠI KHÁCH HÀNG: " + loaiKH);
                	System.out.println("SÁCH: " + sach);
                	System.out.println("SỐ LƯỢNG: " + soLuong);
                	System.out.println("ĐƠN GIÁ: " + donGia + " VND");
                	System.out.println("TỔNG: " + tong + " VND");
                	System.out.println("CTKM: " + ctkm);
                	System.out.println("GIẢM GIÁ: " + giamGia + " VND");
                	System.out.println("SAU GIẢM: " + sauGiam + " VND");
                	System.out.println("VAT: " + vat);
                	System.out.println("=========================================");
                	return; 
           		}
        	}

            	System.out.println("❌ Không tìm thấy hóa đơn của khách hàng: " + idKhachHang);
        		

    		}catch (IOException e) {
        		System.out.println("❌ Lỗi đọc file hoadon.txt: " + e.getMessage());
    		}
	}

}


    

