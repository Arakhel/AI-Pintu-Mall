import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PintuMall {
    private String orang[][];
    private int baris = 1;
    private int kolom = 10;

    Scanner sc = new Scanner(System.in);

    public PintuMall() throws InterruptedException {
        orang = new String[baris][kolom];
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                System.out.println("Apakah ada orang dalam jarak 10 m? (y/t)");
                orang[i][j] = sc.next();
                if (orang[i][j].equals("y")) {
                    buka();
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
            System.out.println("Buka Pintu ada orang");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void tutup() {
        System.out.println("Tutup Pintu baru gak ada orang");
    }
}
