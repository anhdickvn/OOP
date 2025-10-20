package OOP;

public class ChuongTrinhKM implements IGiamGia {
	private String idSach;
	private String idCTKM;
	private double phanTramKhuyenMai;
	private String ngayBatDau;
	private String ngayKetThuc;

	public ChuongTrinhKM() {
	}

	public ChuongTrinhKM(String idSach, String idCTKM, double phanTramKhuyenMai, String ngayBatDau,
			String ngayKetThuc) {
		this.idSach = idSach;
		this.idCTKM = idCTKM;
		this.phanTramKhuyenMai = phanTramKhuyenMai;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}
}
