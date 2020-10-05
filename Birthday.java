
public class Birthday {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] rep = new int[n + 2];

        for (int t = 0; t < trials; t++) {
            boolean share = false;
            int[] bd = new int[n + 2];


            while (!share) {
                for (int i = 0; i < n + 2; i++) {
                    if (share) break;
                    int r = (int) (Math.random() * n);
                    bd[i] = r;
                    for (int j = 0; j < i; j++) {
                        if (bd[i] == bd[j]) {
                            rep[i]++;
                            share = true;
                            break;
                        }

                    }
                }
            }
        }

        double[] sum = new double[n + 2];

        for (int i = 1; i < n + 2; i++) {
            if (i == 1) sum[i] = 0;
            else sum[i] = sum[i - 1] + ((double) rep[i - 1] / trials);
            System.out.println(i + "\t" + rep[i - 1] + "\t" + sum[i]);
            if (sum[i] >= 0.5) break;
        }
    }
}
