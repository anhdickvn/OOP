package OOP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class KhachHang {
	private int status; // 1 = Thường, 2 = VIP
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

	public KhachHang(int status, String id, String hoTen, String ngaySinh, String diaChi, String sdt,
			double tongChiTieu) {
		this.status = status;
		this.idKhachHang = id;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.soDienThoai = sdt;
		this.tongChiTieu = tongChiTieu;
		capNhatUuDai();
	}

	// ===== Getter/Setter =====
	public int getStatus() {
		return status;
	}

	public String getIdKhachHang() {
		return idKhachHang;
	}

	public String getHoTen() {
		return hoTen;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public double getTongChiTieu() {
		return tongChiTieu;
	}

	public int getDiemTichLuy() {
		return diemTichLuy;
	}

	public double getMucGiamGia() {
		return mucGiamGia;
	}

	public void setTongChiTieu(double tongChiTieu) {
		this.tongChiTieu = tongChiTieu;
		capNhatUuDai();
	}

	// ===== Cập nhật ưu đãi =====
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

	// ===== Xuất bảng =====
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
}
