package OOP;

public class KhachHang extends ConNguoi {
	private String idKhachHang;

	public KhachHang() {
	}

	public KhachHang(String idKhachHang, String hoTen, String ngaySinh, String diaChi, String soDienThoai) {
		super(hoTen, ngaySinh, diaChi, soDienThoai);
		this.idKhachHang = idKhachHang;
	}

	public String getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(String idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	@Override
	public String toString() {
		return idKhachHang + " | " + super.toString();
	}
}
