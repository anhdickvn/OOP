package OOP;

public abstract class ConNguoi {
	private String hoTen;
	private String ngaySinh;
	private String diaChi;
	private String soDienThoai;

	public ConNguoi() {
	}

	public ConNguoi(String hoTen, String ngaySinh, String diaChi, String soDienThoai) {
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	@Override
	public String toString() {
		return hoTen + " | " + ngaySinh + " | " + diaChi + " | " + soDienThoai;
	}
}
