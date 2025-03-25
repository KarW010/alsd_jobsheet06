import java.util.Scanner;

public class DosenDemo09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataDosen09 listDosen = new DataDosen09();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Data Dosen");
            System.out.println("2. Tampilkan Data Dosen");
            System.out.println("3. Sorting Usia ASC (Bubble Sort)");
            System.out.println("4. Sorting Usia DSC (Selection Sort atau Insertion Sort)");
            System.out.println("5. Pencarian Nama (Sequential Search)");
            System.out.println("6. Pencarian Usia (Binary Search)");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Kode Dosen: ");
                    String kode = sc.nextLine();
                    System.out.print("Nama Dosen: ");
                    String nama = sc.nextLine();
                    System.out.print("Jenis Kelamin (L/P): ");
                    char jk = sc.next().charAt(0);
                    boolean jenisKelamin = (jk == 'L' || jk == 'l');
                    System.out.print("Usia: ");
                    int usia = sc.nextInt();
                    sc.nextLine();

                    Dosen09 dsn = new Dosen09(kode, nama, jenisKelamin, usia);
                    listDosen.tambah(dsn);
                    break;

                case 2:
                    System.out.println("\nData Dosen:");
                    listDosen.tampil();
                    break;

                case 3:
                    listDosen.sortingASC();
                    System.out.println("\nData Dosen Setelah Sorting ASC:");
                    listDosen.tampil();
                    break;

                case 4:
                    System.out.println("Pilih metode sorting DSC:");
                    System.out.println("1. Selection Sort");
                    System.out.println("2. Insertion Sort");
                    System.out.print("Pilihan: ");
                    int sortPilihan = sc.nextInt();

                    if (sortPilihan == 1) {
                        listDosen.sortingDSC();
                    } else {
                        listDosen.insertionSort();
                    }

                    System.out.println("\nData Dosen Setelah Sorting DSC:");
                    listDosen.tampil();
                    break;

                case 5:
                    System.out.print("Masukkan nama dosen yang dicari: ");
                    String cariNama = sc.nextLine();
                    System.out.println("\nHasil Pencarian:");
                    listDosen.pencarianDataSequential(cariNama);
                    break;

                case 6:
                    listDosen.sortingASC();
                    System.out.print("Masukkan usia dosen yang dicari: ");
                    int cariUsia = sc.nextInt();
                    System.out.println("\nHasil Pencarian:");
                    listDosen.pencarianDataBinary(cariUsia, 0, listDosen.idx - 1);
                    break;

                case 7:
                    System.out.println("Berhasil keluar dari program.");
                    sc.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }
}
