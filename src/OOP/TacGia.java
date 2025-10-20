package OOP;

import java.util.Scanner;

public class TacGia {
	private String idTacGia;
	private String tenTacGia;
	private String ngaySinh;

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

	public String getNgaySinh() {
		return this.ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public TacGia() {
	}

	public TacGia(String idTacGia, String tenTacGia, String ngaySinh) {
		this.idTacGia = idTacGia;
		this.tenTacGia = tenTacGia;
		this.ngaySinh = ngaySinh;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ID tac gia: ");
		idTacGia = sc.nextLine();
		System.out.print("Ten tac gia: ");
		tenTacGia = sc.nextLine();
		System.out.println("Ngay sinh: ");
		ngaySinh = sc.nextLine();
	}

	public void xuat() {
		System.out.printf("%-15s %-25s %-15s %-20s\n", "ID Tác Giả", "Tên Tác Giả", "Ngày Sinh");
		System.out.println("--------------------------------------------------------------------------");
		System.out.printf("%-15s %-25s %-15s %-20s\n", idTacGia, tenTacGia, ngaySinh);
	}
}