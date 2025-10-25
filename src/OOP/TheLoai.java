package OOP;

public class TheLoai {
	private String idTheLoai;
	private String tenTheLoai;

	public String getIdTheLoai() {
		return this.idTheLoai;
	}

	public void setIdTheLoai(String idTheLoai) {
		this.idTheLoai = idTheLoai;
	}

	public String getTenTheLoai() {
		return this.tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

	public TheLoai() {
	}

	public TheLoai(String idTheLoai, String tenTheLoai) {
		this.idTheLoai = idTheLoai;
		this.tenTheLoai = tenTheLoai;
	}

	public String toString() {
		return idTheLoai + " - " + tenTheLoai;
	}
}
