public class DataDosen09 {
    Dosen09[] dataDosen = new Dosen09[10];
    int idx = 0;

    public void tambah(Dosen09 dsn) {
        if (idx < dataDosen.length) {
            dataDosen[idx] = dsn;
            idx++;
        } else {
            System.out.println("Data dosen sudah penuh!");
        }
    }

    public void tampil() {
        for (int i = 0; i < idx; i++) {
            dataDosen[i].tampil();
        }
    }

    public void pencarianDataSequential(String nama) {
        boolean ditemukan = false;
        int jumlahHasil = 0;
        for (int i = 0; i < idx; i++) {
            if (dataDosen[i].nama.equalsIgnoreCase(nama)) {
                dataDosen[i].tampil();
                ditemukan = true;
                jumlahHasil++;
            }
        }
        if (!ditemukan) {
            System.out.println("Dosen dengan nama '" + nama + "' tidak ditemukan.");
        }
        cekHasilPencarian(jumlahHasil);
    }

    public void sortingASC() {
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 1; j < idx - i; j++) {
                if (dataDosen[j].usia < dataDosen[j - 1].usia) {
                    Dosen09 temp = dataDosen[j];
                    dataDosen[j] = dataDosen[j - 1];
                    dataDosen[j - 1] = temp;
                }
            }
        }
    }

    public void pencarianDataBinary(int usia, int left, int right) {
        if (left > right) {
            System.out.println("Dosen dengan usia " + usia + " tidak ditemukan.");
            return;
        }
        int mid = left + (right - left) / 2;
        if (dataDosen[mid].usia == usia) {
            int jumlahHasil = 1;
            dataDosen[mid].tampil();

            int i = mid - 1;
            while (i >= left && dataDosen[i].usia == usia) {
                dataDosen[i].tampil();
                jumlahHasil++;
                i--;
            }
            i = mid + 1;
            while (i <= right && dataDosen[i].usia == usia) {
                dataDosen[i].tampil();
                jumlahHasil++;
                i++;
            }
            cekHasilPencarian(jumlahHasil);
            return;
        }
        if (dataDosen[mid].usia > usia) {
            pencarianDataBinary(usia, left, mid - 1);
        } else {
            pencarianDataBinary(usia, mid + 1, right);
        }
    }

    public void sortingDSC() {
        for (int i = 0; i < idx - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < idx; j++) {
                if (dataDosen[j].usia > dataDosen[maxIdx].usia) {
                    maxIdx = j;
                }
            }
            Dosen09 temp = dataDosen[maxIdx];
            dataDosen[maxIdx] = dataDosen[i];
            dataDosen[i] = temp;
        }
    }

    public void insertionSort() {
        for (int i = 1; i < idx; i++) {
            Dosen09 temp = dataDosen[i];
            int j = i;
            while (j > 0 && dataDosen[j - 1].usia < temp.usia) {
                dataDosen[j] = dataDosen[j - 1];
                j--;
            }
            dataDosen[j] = temp;
        }
    }

    public void cekHasilPencarian(int jumlah) {
        if (jumlah > 1) {
            System.out.println("Peringatan! Ditemukan lebih dari satu hasil dengan kriteria yang sama!");
        }
    }
}
