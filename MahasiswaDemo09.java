import java.util.Scanner;
public class MahasiswaDemo09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumMhs = sc.nextInt();
        sc.nextLine();
        MahasiswaBerprestasi09 list = new MahasiswaBerprestasi09(jumMhs);

        for (int i = 0; i < jumMhs; i++) {
            System.out.println("Masukkan Data Mahasiswa ke-" + (i + 1));
            System.out.print("NIM   : ");
            String nim = sc.nextLine();
            System.out.print("Nama  : ");
            String nama = sc.nextLine();
            System.out.print("Kelas : ");
            String kelas = sc.nextLine();
            System.out.print("IPK   : ");
            double ipk = sc.nextDouble();
            sc.nextLine();
            System.out.println("--------------------------------");

            list.tambah(new Mahasiswa09(nim, nama, kelas, ipk));
        }
        list.tampil();
        System.out.println("----------------------------------------------------");
        System.out.println("Pencarian data menggunakan Sequential Search");
        System.out.println("----------------------------------------------------");
        System.out.print("Masukkan IPK mahasiswa yang dicari: ");
        double cari = sc.nextDouble();

        int posisi = list.sequentialSearching(cari);
        list.tampilPosisi(cari, posisi);
        list.tampilDataSearch(cari, posisi);

        System.out.println("----------------------------------------------------");
        System.out.println("Pencarian data menggunakan Binary Search");
        System.out.println("----------------------------------------------------");
        System.out.print("Masukkan IPK mahasiswa yang dicari: ");
        cari = sc.nextDouble();

        int posisi2 = list.findBinarySearch(cari, 0, jumMhs - 1);
        list.tampilPosisi(cari, posisi2);
        list.tampilDataSearch(cari, posisi2);
    }
}
