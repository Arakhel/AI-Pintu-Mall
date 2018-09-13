import java.util.concurrent.TimeUnit;

public class PintuMall {
    private String orang[][];
    private int baris = 1;
    private int kolom = 10;

    public PintuMall(){
        orang = new String[baris][kolom];

        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                orang[i][j]=" ";
            }
        }

        orang[0][0]="y";
        orang[0][1]="y";
        orang[0][3]="y";
        orang[0][4]="y";
        orang[0][7]="y";
        orang[0][9]="y";
    }

    void Move() throws InterruptedException {
        System.out.println(toString());
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom-1; j++) {
                if (orang[i][j].equals("y")) {
                    System.out.println("Ada orang dalam jarak 3 m\n");
                    buka();
                    if(orang[i][j+1].equals("y")){
                        System.out.println("Ada orang lagi dalam jarak 3 m, tunggu 3 detik lagi\n");
                        TimeUnit.SECONDS.sleep(3);
                        j+=1;
                    }
                    System.out.println("Tutup Pintu, orangnya sudah lewat\n");
                } else {
                    tutup();
                }
            }
        }
    }

    public String toString() {
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < baris; i++) {

            for (int j = 0; j < kolom; j++) {
                r.append("[").append(orang[i][j]).append("]");
            }
            r.append("\n");
        }
        return r.toString();
    }

    private void buka() throws InterruptedException {
        try {
            System.out.println("Buka Pintu\n");
            System.out.println("Tunggu 3 detik\n");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void tutup() {
        try {
            System.out.println("Tidak terbuka, baru tidak ada orang\n");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
