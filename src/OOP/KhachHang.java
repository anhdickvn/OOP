package OOP;

class KhachHang extends ConNguoi {
	private String idKhachHang;

	public KhachHang() {
	}

	public KhachHang(String hoTen, String ngaySinh, String diaChi, String soDienThoai, String idKhachHang) {
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
	public void nhapThongTin() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ID khach hang: ");
		idKhachHang = sc.nextLine();
		super.nhapThongTin();
	}

	@Override
	public void hienThiThongTin() {
		System.out.println("ID khach hang: " + idKhachHang);
		super.hienThiThongTin();
	}
}
