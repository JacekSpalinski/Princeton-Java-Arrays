
public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        int[] thue = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) thue[i] = 0;
            if (i % 2 == 0) thue[i] = thue[i / 2];
            else thue[i] = 1 - thue[i - 1];
        }

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = thue[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i] == a[j]) System.out.print("+  ");
                else System.out.print("-  ");
            }
            System.out.println();
        }
    }
}




