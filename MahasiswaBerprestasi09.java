public class MahasiswaBerprestasi09 {
    Mahasiswa09 []listMhs = new Mahasiswa09[5];
    int idx;

    void tambah (Mahasiswa09 mhs){
        if (idx<listMhs.length){
            listMhs[idx]=mhs;
            idx++;
        }else {
            System.out.println("data sudah penuh");
        }
    }

    void tampil (){
        for (Mahasiswa09 mhs:listMhs){
            if (mhs != null){
                mhs.tampilInformasi();
                System.out.println("----------------------------");
            }
        }
    }

    int sequentialSearching(double cari){
        int posisi = -1;
        for (int j=0; j<listMhs.length; j++){
            if (listMhs[j].ipk==cari){
                posisi=j;
                break;
            }
        }
        return posisi;
    }

    void tampilPosisi(double x, int pos){
        if (pos!=-1){
            System.out.println("data mahasiswa dengan IPK :" +x+ " ditemukan pada indeks " +pos);
        }
        else {
            System.out.println("data " +x+ "tidak ditemukan");
        }
    }

    void tampilDataSearch(double x, int pos){
        if (pos !=-1){
            System.out.println("nim\t : "+listMhs[pos].nim);
            System.out.println("nama\t : "+listMhs[pos].nama);
            System.out.println("kelas\t : "+listMhs[pos].kelas);
            System.out.println("ipk\t : "+x);
        }
        else{
            System.out.println("Data mahasiswa dengan IPK " +x+ " tidak ditemukan");
        }
    }

    int findBinarySearch(double cari, int left, int right){
        int mid;
        if (right>=left){
            mid = (left+right)/2;
            if (cari == listMhs[mid].ipk){
                return (mid);
            }
            else if (listMhs[mid].ipk>cari){
                return findBinarySearch(cari, left, mid-1);
            }
            else {
                return findBinarySearch(cari, mid+1, right);
            }
        }
        return -1;
    }
}