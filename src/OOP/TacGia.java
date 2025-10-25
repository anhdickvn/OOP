package OOP;

public class TacGia {
	private String idTacGia;
	private String tenTacGia;

	public String getIdTacGia() {
		return this.idTacGia;
	}

	public void setIdTacGia(String idTacGia) {
		this.idTacGia = idTacGia;
	}

	public String getTenTacGia() {
		return this.tenTacGia;
	}

	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}

	public TacGia() {
	}

	public TacGia(String idTacGia, String tenTacGia) {
		this.idTacGia = idTacGia;
		this.tenTacGia = tenTacGia;
	}

	public String toString() {
		return idTacGia + " - " + tenTacGia;
	}
}
