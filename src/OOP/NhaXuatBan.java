package OOP;

public class NhaXuatBan {
	private String idNhaXuatBan;
	private String tenNhaXuatBan;

	public NhaXuatBan() {
	}

	public NhaXuatBan(String idNhaXuatBan, String tenNhaXuatBan, String diaChi) {
		this.idNhaXuatBan = idNhaXuatBan;
		this.tenNhaXuatBan = tenNhaXuatBan;
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

	public String toString() {
		return idNhaXuatBan + " - " + tenNhaXuatBan;
	}
}
