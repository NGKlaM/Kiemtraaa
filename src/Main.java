import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<DanhsachSV> ListSV = new ArrayList<DanhsachSV>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        while (true) {
            System.out.println("1.Thêm sv vào danh sách: ");
            System.out.println("2.in ra danh sách sv ra màn hình: ");
            System.out.println("3.Kiểm tra danh sách vó rỗng hay không : ");
            System.out.println("4.Lấy ra số lượng sinh viên trong danh sách: ");
            System.out.println("5.làm rỗng danh sách: ");
            System.out.println("6.Kiêm tra sinh viên có tồn tại trong danh sách hay không dựa trên mã sinh viên: ");
            System.out.println("7.Xóa một sinh viên ra khỏi danh sách dựa trên mã sinh viên: ");
            System.out.println("8.Tìm kiếm tất cả sinh viên dựa trên tên được nhập từ bàn phím: ");
            System.out.println("9.Xuất ra danh sách sinh viên có diểm từ cao xuống thấp: ");
            int so = Integer.parseInt(sc.nextLine());
            switch (so) {
                case 1:
                    Nhapvao();
                    break;
                case 2:
                    inratt();
                    break;
                case 3:
                    KTrong();
                    break;
                case 4:
                    layraSL();
                    break;
                case 5:
                    Lamrong();
                    break;
                case 6:
                    KiemtraSVtrongDS();
                    break;
                case 7:
                    xoaSVtheoMa();
                    break;
                case 8:
                    Timkiemten();
                    break;
                case 9:
                    Sapxep();
            }
        }
    }

    private static void Sapxep() {
        Collections.sort(ListSV, ((o1, o2) -> Float.compare(o2.getDTB(), o1.getDTB())));
        inratt();
    }


    private static void Timkiemten() {
        System.out.println("Nhập tên muốn tìm kiếm: ");
        String Username = sc.nextLine();
        System.out.println("Kết quả là: ");
        for (DanhsachSV SV:ListSV){
            if (SV.getUsername().equals(Username)){
                SV.inttSV();
            }
        }
    }

    private static void xoaSVtheoMa() {
        System.out.println("Moi ban nhap vao ma sinh vien can xoa: ");
        String MaSV = sc.nextLine();
        ListSV.removeIf(sv -> sv.getMaSv().equals(MaSV));
    }

    private static void KiemtraSVtrongDS() {
        System.out.println("Moi ban nhap vao ma sinh vien de kiem tra ton tai: ");
        String maSV = sc.nextLine();
        Boolean check = true;
        for (DanhsachSV sinhvien: ListSV
        ) {
            if (sinhvien.getMaSv().equals(maSV)){
                check = false;
                System.out.println("Sinh vien da co trong he thong");
            }
        }

        if (check){
            System.out.println("Sinh vien ko co trong he thong");
        }
    }

    private static void layraSL() {
        System.out.println("So luong sinh vien la: " + ListSV.size());
    }

    private static void KTrong() {
        if (ListSV.isEmpty()) {
            System.out.println("danh sách rỗng ");
        } else {
            System.out.println("danh sách không có sinh viên: ");
        }
    }

    private static void inratt() {
        System.out.println("in danh sách sv: ");
        for (DanhsachSV sinhvien : ListSV) {
            sinhvien.inttSV();
        }
    }


    private static void Nhapvao() {
        System.out.println("Moi ban nhap so luong SV can nhap: ");
        int so = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < so; i++) {
            System.out.println("nhạp vào mã sinh viên" + (i+1));
            String MaSV = sc.nextLine();
            System.out.println("mời bạn nhập vào họ và tên sinh viên: " + (i + 1));
            String Username = sc.nextLine();
            System.out.println("nhập vào Năm sinh sv: " + (i + 1));
            int year = Integer.parseInt(sc.nextLine());
            System.out.println("Nhập vào điểm TB" + (i + 1));
            float DTB = Float.parseFloat(sc.nextLine());
            DanhsachSV SV = new DanhsachSV(MaSV, Username, year, DTB);
            ListSV.add(SV);
        }
    }


    private static void Lamrong() {
        System.out.println("Ban co chac chan xoa het sinh vien khoi danh sach khong? Neu muon nhap OK");
        String check = sc.nextLine();
        if (check.equals("OK")) {
            ListSV.clear();
        }
    }
}