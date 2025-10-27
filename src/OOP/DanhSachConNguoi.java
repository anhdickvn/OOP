import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class DanhSachConNguoi {

    
    public static void ghiFileNhanVien(NhanVien[] danhSach) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("NhanVien.txt"))) {
        for (NhanVien nv : danhSach) {
            String line = nv.getHoTen() + ";" + nv.getNgaySinh() + ";" + nv.getDiaChi() + ";" + nv.getSoDienThoai() + ";" +
                          nv.getIdNhanVien() + ";" + nv.getLuong() + ";" + nv.getChucVu() + ";" + nv.getCa() + ";" + nv.getDoanhThu();
            bw.write(line);
            bw.newLine();
        }
    } catch (Exception e) {
        System.out.println(" Lỗi khi ghi file: " + e.getMessage());
    }
}

 public static void ghiFileQuanLy(QuanLy[] danhSach) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("QuanLy.txt"))) {
        for (QuanLy ql : danhSach) {
            String line = ql.getHoTen() + ";" + ql.getNgaySinh() + ";" + ql.getDiaChi() + ";" + ql.getSoDienThoai() + ";" +
                          ql.getIdQuanLy() + ";" + ql.getLuong() + ";" + ql.getKhuLamViec();
            bw.write(line);
            bw.newLine();
        }
    } catch (Exception e) {
        System.out.println(" Lỗi khi ghi file: " + e.getMessage());
    }
}
    
    public static void timKiemNhanVien() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Tìm kiếm thông tin nhân viên:");
    System.out.print("Nhập từ khóa (ID NV / Tên / Chức vụ / Ca): ");
    String tuKhoa = sc.nextLine().toLowerCase();

    NhanVien[] ds = NhanVien.dsNV;
    boolean timThay = false;

    System.out.println("=============== KẾT QUẢ TÌM KIẾM NHÂN VIÊN ===============");
    System.out.printf("%-20s| %-12s| %-15s| %-12s| %-10s| %-10s| %-8s| %-12s\n",
        "Họ Tên", "Ngày Sinh", "Địa Chỉ", "SĐT",
        "ID NV", "Chức vụ", "Ca", "Doanh Thu");
    System.out.println("-----------------------------------------------------------------------------------------------------------------------");

    for (NhanVien nv : ds) {
        boolean timTheoID = nv.getIdNhanVien().equalsIgnoreCase(tuKhoa);
        boolean timTheoTen = nv.getHoTen().equalsIgnoreCase(tuKhoa);
        boolean timTheoChucVu = nv.getChucVu().equalsIgnoreCase(tuKhoa);
        boolean timTheoCa = nv.getCa().equalsIgnoreCase(tuKhoa);

        if (timTheoID || timTheoTen || timTheoChucVu || timTheoCa) {
            timThay = true;
           System.out.printf("%-20s| %-12s| %-15s| %-12s| %-10s| %-10s| %-8s| %-12.0f\n",
                nv.getHoTen(), nv.getNgaySinh(), nv.getDiaChi(), nv.getSoDienThoai(),
                nv.getIdNhanVien(), nv.getChucVu(), nv.getCa(), nv.getDoanhThu());
        }
    }

    if (!timThay) {
        System.out.println("Không tìm thấy Nhân Viên phù hợp với từ khóa: " + tuKhoa);
    }
}


    public static void timKiemQuanLy() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tìm kiếm thông tin quản lý:");
        System.out.print("Nhập từ khóa (ID QL / Tên / Khu làm việc): ");
        String tuKhoa = sc.nextLine().toLowerCase();

        QuanLy[] ds = QuanLy.dsQL;
        boolean timThay = false;

        if (ds == null || ds.length == 0) {
            System.out.println("Danh sách quản lý trống!");
            return;
        }

        System.out.println("=============== KẾT QUẢ TÌM KIẾM QUẢN LÝ ===============");
        System.out.printf("%-20s| %-12s| %-15s| %-12s| %-10s| %-15s\n",
                "Họ Tên", "Ngày Sinh", "Địa Chỉ", "SĐT", "ID QL", "Khu làm việc");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");

        for (QuanLy ql : ds) {
            if (ql == null) continue;

            boolean timTheoID = ql.getIdQuanLy().equalsIgnoreCase(tuKhoa);
            boolean timTheoTen = ql.getHoTen().equalsIgnoreCase(tuKhoa);
            boolean timTheoKhu = ql.getKhuLamViec().equalsIgnoreCase(tuKhoa);

            if (timTheoID || timTheoTen || timTheoKhu) {
                timThay = true;
                System.out.printf("%-20s| %-12s| %-15s| %-12s| %-10s| %-15s\n",
                        ql.getHoTen(), ql.getNgaySinh(), ql.getDiaChi(), ql.getSoDienThoai(),
                        ql.getIdQuanLy(), ql.getKhuLamViec());
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy Quản Lý phù hợp với từ khóa: " + tuKhoa);
        }
    }


    public static void chinhSuaNhanVien() {
    Scanner sc = new Scanner(System.in);
    System.out.print("🔎 Nhập ID nhân viên cần chỉnh sửa: ");
    String id = sc.nextLine();

    NhanVien [] dsNV = NhanVien.dsNV;
    boolean timThay = false;
    for (NhanVien nv : dsNV ) {
        if (nv.getIdNhanVien().equalsIgnoreCase(id)) {
            timThay = true;
            int choice;
            do {
                System.out.println("\n===== CHỈNH SỬA THÔNG TIN NHÂN VIÊN =====");
                System.out.println("1. Họ tên       (Hiện tại: " + nv.getHoTen() + ")");
                System.out.println("2. Ngày sinh    (Hiện tại: " + nv.getNgaySinh() + ")");
                System.out.println("3. Địa chỉ      (Hiện tại: " + nv.getDiaChi() + ")");
                System.out.println("4. Số điện thoại(Hiện tại: " + nv.getSoDienThoai() + ")");
                System.out.println("5. Lương        (Hiện tại: " + nv.getLuong() + ")");
                System.out.println("6. Chức vụ      (Hiện tại: " + nv.getChucVu() + ")");
                System.out.println("7. Ca làm       (Hiện tại: " + nv.getCa() + ")");
                System.out.println("8. Doanh thu    (Hiện tại: " + nv.getDoanhThu() + ")");
                System.out.println("0. Lưu và thoát");
                System.out.print("👉 Chọn mục bạn muốn sửa: ");
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Nhập họ tên mới: ");
                        nv.setHoTen(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Nhập ngày sinh mới: ");
                        nv.setNgaySinh(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Nhập địa chỉ mới: ");
                        nv.setDiaChi(sc.nextLine());
                        break;
                    case 4:
                        System.out.print("Nhập số điện thoại mới: ");
                        nv.setSoDienThoai(sc.nextLine());
                        break;
                    case 5:
                        System.out.print("Nhập lương mới: ");
                        nv.setLuong(Double.parseDouble(sc.nextLine()));
                        break;
                    case 6:
                        System.out.print("Nhập chức vụ mới: ");
                        nv.setChucVu(sc.nextLine());
                        break;
                    case 7:
                        System.out.print("Nhập ca làm mới: ");
                        nv.setCa(sc.nextLine());
                        break;
                    case 8:
                        System.out.print("Nhập doanh thu mới: ");
                        nv.setDoanhThu(Double.parseDouble(sc.nextLine()));
                        break;
                    case 0:
                        System.out.println(" Đang lưu dữ liệu...");
                        ghiFileNhanVien(dsNV);
                        System.out.println(" Cập nhật thành công!");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
                }
            } while (choice != 0);
            break;
        }
    }

    if (!timThay) {
        System.out.println(" Không tìm thấy nhân viên có ID: " + id);
    }
}

public static void ChinhSuaQuanLy() {
    Scanner sc = new Scanner(System.in);
    System.out.print("🔎 Nhập ID quản lý cần chỉnh sửa: ");
    String id = sc.nextLine();

    QuanLy [] dsQL = QuanLy.dsQL;
    boolean timThay = false;
    for (QuanLy ql : dsQL ) {
        if (ql.getIdQuanLy().equalsIgnoreCase(id)) {
            timThay = true;
            int choice;
            do {
                System.out.println("\n===== CHỈNH SỬA THÔNG TIN QUẢN LÝ =====");
                System.out.println("1. Họ tên       (Hiện tại: " + ql.getHoTen() + ")");
                System.out.println("2. Ngày sinh    (Hiện tại: " + ql.getNgaySinh() + ")");
                System.out.println("3. Địa chỉ      (Hiện tại: " + ql.getDiaChi() + ")");
                System.out.println("4. Số điện thoại(Hiện tại: " + ql.getSoDienThoai() + ")");
                System.out.println("5. Lương        (Hiện tại: " + ql.getLuong() + ")");
                System.out.println("6. Khu làm việc      (Hiện tại: " + ql.getKhuLamViec() + ")");
                System.out.println("0. Lưu và thoát");
                System.out.print(" Chọn mục bạn muốn sửa: ");
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Nhập họ tên mới: ");
                        ql.setHoTen(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Nhập ngày sinh mới: ");
                        ql.setNgaySinh(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Nhập địa chỉ mới: ");
                        ql.setDiaChi(sc.nextLine());
                        break;
                    case 4:
                        System.out.print("Nhập số điện thoại mới: ");
                        ql.setSoDienThoai(sc.nextLine());
                        break;
                    case 5:
                        System.out.print("Nhập lương mới: ");
                        ql.setLuong(Double.parseDouble(sc.nextLine()));
                        break;
                    case 6:
                        System.out.print("Nhập khu vực làm việc mới: ");
                        ql.setKhuLamViec(sc.nextLine());
                        break;
                    case 0:
                        System.out.println(" Đang lưu dữ liệu...");
                        ghiFileQuanLy(dsQL);
                        System.out.println(" Cập nhật thành công!");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
                }
            } while (choice != 0);
            break;
        }
    }

    if (!timThay) {
        System.out.println(" Không tìm thấy nhân viên có ID: " + id);
    }
}

public static void ChucNangNhanVien(){
     Scanner sc = new Scanner(System.in);
    int choice;
            do {
                System.out.println("\n===== CHỌN CHỨC NĂNG =====");
                System.out.println("1. Thêm Nhân Viên Mới");
                System.out.println("2. Chỉnh sửa thông tin Nhân Viên");
                System.out.println("0. Lưu và thoát");
                System.out.print(" Chọn mục bạn muốn sửa: ");
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        NhanVien.NhapNhanVien();
                        break;
                    case 2:
                        chinhSuaNhanVien();
                        break;
                    case 0:
                        System.out.println(" Đang lưu dữ liệu...");
                        System.out.println(" Cập nhật thành công!");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
                }
            } while (choice != 0);
}
    public static void ChucNangQuanLy(){
     Scanner sc = new Scanner(System.in);
    int choice;
            do {
                System.out.println("\n===== CHỌN CHỨC NĂNG =====");
                System.out.println("1. Thêm Quản Lý Mới");
                System.out.println("2. Chỉnh sửa thông tin Quản Lý");
                System.out.println("0. Lưu và thoát");
                System.out.print(" Chọn mục bạn muốn sửa: ");
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        QuanLy.NhapQuanLy();;
                        break;
                    case 2:
                        ChinhSuaQuanLy();
                        break;
                    case 0:
                        System.out.println(" Đang lưu dữ liệu...");
                        System.out.println(" Cập nhật thành công!");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
                }
            } while (choice != 0);
}
   
}






