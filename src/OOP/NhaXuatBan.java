package OOP;

public class NhaXuatBan {
	private String idNhaXuatBan;
	private String tenNhaXuatBan;
	private String diaChi;

	public NhaXuatBan() {
	}

	public NhaXuatBan(String idNhaXuatBan, String tenNhaXuatBan, String diaChi) {
		this.idNhaXuatBan = idNhaXuatBan;
		this.tenNhaXuatBan = tenNhaXuatBan;
		this.diaChi = diaChi;
	}

	public String getIdNhaXuatBan() {
		return idNhaXuatBan;
	}

	public void setIdNhaXuatBan(String idNhaXuatBan) {
		this.idNhaXuatBan = idNhaXuatBan;
	}

	public String getTenNhaXuatBan() {
		return tenNhaXuatBan;
	}

	public void setTenNhaXuatBan(String tenNhaXuatBan) {
		this.tenNhaXuatBan = tenNhaXuatBan;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String toString() {
		return idNhaXuatBan + " - " + tenNhaXuatBan + " - " + diaChi;
	}
}
