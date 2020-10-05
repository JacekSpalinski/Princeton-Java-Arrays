
public class DiscreteDistribution {
    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);
        int[] a = new int[args.length - 1];
        int len = args.length - 1;
        for (int i = 0; i < len; i++) {
            a[i] = Integer.parseInt(args[i + 1]);
        }

        int[] s = new int[len + 1];
        s[1] = a[0];
        for (int i = 2; i <= len; i++) {
            s[i] = s[i - 1] + a[i - 1];
        }
        for (int t = 0; t < m; t++) {
            int r = (int) (Math.random() * s[len]);
            for (int i = 1; i <= len; i++) {
                if (r >= s[i - 1] && r < s[i]) System.out.print(i + " ");
            }
        }
        System.out.println();

    }
}
