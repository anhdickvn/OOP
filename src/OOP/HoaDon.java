package OOP;

import java.util.Scanner;

public class HoaDon {

	private String idHoaDon;
	private String idKhachHang;
	private String idCTKM;
	private String ngayInPhieu;
	private int soLuong;
	private double tongTien;
	private Sach[] dsSach;
	private int[] dsSoLuong;

	public HoaDon() {
	}

	public HoaDon(String idHoaDon, String idKhachHang, String idCTKM, String ngayInPhieu, int soLuong, double tongTien,
			Sach[] dsSach, int[] dsSoLuong) {
		this.idHoaDon = idHoaDon;
		this.idKhachHang = idKhachHang;
		this.idCTKM = idCTKM;
		this.ngayInPhieu = ngayInPhieu;
		this.soLuong = soLuong;
		this.tongTien = tongTien;
		this.dsSach = dsSach;
		this.dsSoLuong = dsSoLuong;
	}

	public String getIdHoaDon() {
		return idHoaDon;
	}

	public void setIdHoaDon(String idHoaDon) {
		this.idHoaDon = idHoaDon;
	}

	public String getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(String idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public String getIdCTKM() {
		return idCTKM;
	}

	public void setIdCTKM(String idCTKM) {
		this.idCTKM = idCTKM;
	}

	public String getNgayInPhieu() {
		return ngayInPhieu;
	}

	public void setNgayInPhieu(String ngayInPhieu) {
		this.ngayInPhieu = ngayInPhieu;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public Sach[] getDsSach() {
		return dsSach;
	}

	public void setDsSach(Sach[] dsSach) {
		this.dsSach = dsSach;
	}

	public int[] getDsSoLuong() {
		return dsSoLuong;
	}

	public void setDsSoLuong(int[] dsSoLuong) {
		this.dsSoLuong = dsSoLuong;
	}

	public void nhapHoaDon(KhoSach kho) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập mã hóa đơn: ");
		idHoaDon = sc.nextLine();

		System.out.print("Nhập mã khách hàng: ");
		idKhachHang = sc.nextLine();

		System.out.print("Nhập mã chương trình khuyến mãi (nếu có): ");
		idCTKM = sc.nextLine();

		System.out.print("Khách mua bao nhiêu loại sách? ");
		int n = Integer.parseInt(sc.nextLine());

		dsSach = new Sach[n];
		dsSoLuong = new int[n];
		tongTien = 0;
		soLuong = 0;
		Sach[] dsKho = kho.getDs();
		for (int i = 0; i < n; i++) {
			System.out.println("Nhập sách thứ " + (i + 1));
			System.out.print("Nhập ID sách: ");
			String idSach = sc.nextLine();

			Sach sachChon = null;

			for (int j = 0; j < kho.getSoLuongSachKho(); j++) {
				if (dsKho[j].getIdSach().equalsIgnoreCase(idSach)) {
					sachChon = dsKho[j];
					break;
				}
			}

			if (sachChon == null) {
				System.out.println("Không tìm thấy sách có mã " + idSach);
				i--;
				continue;
			}

			System.out.print("Nhập số lượng muốn mua: ");
			int soLuongMua = sc.nextInt();
			sc.nextLine();

			if (soLuongMua > sachChon.getSoLuong()) {
				System.out.println("Sách chỉ còn " + sachChon.getSoLuong() + " cuốn trong kho!");
				i--;
				continue;
			}

			dsSach[i] = sachChon;
			dsSoLuong[i] = soLuongMua;

			sachChon.setSoLuong(sachChon.getSoLuong() - soLuongMua);

			soLuong += soLuongMua;
			tongTien += sachChon.getGia() * soLuongMua;

			System.out.println("Đã thêm " + soLuongMua + " quyển \"" + sachChon.getTenSach() + "\"");
			ngayInPhieu = java.time.LocalDate.now().toString();
		}
	}

	public void xuatHoaDon() {
		System.out.println("\n=== THÔNG TIN HÓA ĐƠN ===");
		System.out.println("Mã hóa đơn: " + idHoaDon);
		System.out.println("Mã khách hàng: " + idKhachHang);
		System.out.println("Mã CTKM: " + idCTKM);
		System.out.println("Ngày in phiếu: " + ngayInPhieu);
		System.out.println("Tổng số lượng: " + soLuong);
		System.out.println("Tổng tiền: " + tongTien);
	}
}
