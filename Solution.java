import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

    static FastIO io = new FastIO();
    static long mod = 1_000_000_007;

    public static void main(String[] args) throws java.lang.Exception {
        int t = io.nextInt();
        // int t = 1;
        for (int tc = 1; tc <= t; tc++) {
            // logic
            solve();
        }
    }

    static void solve() {
    }

    // Miscellaneous ---------------------------

    static void yes() {
        io.println("YES");
    }

    static void no() {
        io.println("NO");
    }

    public static boolean isPower(int x, int y) {
        if (x <= 0 || y <= 1) {
            return false;
        }

        double logResult = Math.log(x) / Math.log(y);
        return Math.abs(logResult - Math.round(logResult)) < 1e-10;
    }
    // input/output class----------------------------

    static class FastIO {
        BufferedReader br;
        StringTokenizer st;
        BufferedWriter out;

        public FastIO() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
            out = new BufferedWriter(new OutputStreamWriter(System.out));
            st = new StringTokenizer("");
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int binaryToInt(String s) {
            return Integer.parseInt(s, 2);
        }

        int nextBinaryToInt() {
            return binaryToInt(io.nextLine());
        }

        int[] nextIntArr(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        int[] nextLineToIntArr() {
            return Arrays.stream(nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        long[] nextLineToLongArr() {
            return Arrays.stream(nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        }

        double[] nextLineToDoubleArr() {
            return Arrays.stream(nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        }

        String[] nextLineToStringArr() {
            return nextLine().split(" ");
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        long[] nextLongArr(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        double[] nextDoubleArr(int n) {
            double[] arr = new double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextDouble();
            }
            return arr;
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        String[] nextLineArr(int n) {
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLine();
            }
            return arr;
        }

        void println(String s) {

            try {
                out.write(s + "\n");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void print(String s) {

            try {
                out.write(s);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void println(int n) {

            try {
                out.write(n + "\n");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void print(int n) {

            try {
                out.write(n);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void println(long n) {

            try {
                out.write(n + "\n");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void print(long n) {

            try {
                out.write(n + "");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void println(float n) {

            try {
                out.write(n + "\n");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void print(float n) {

            try {
                out.write(n + "");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void println(double n) {

            try {
                out.write(n + "\n");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void print(double n) {

            try {
                out.write(n + "");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void println(StringBuilder sb) {
            try {
                out.write(sb.toString() + "\n");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void print(StringBuilder sb) {
            try {
                out.write(sb.toString());
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void println(char c) {
            try {
                out.write(c + "\n");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void print(char c) {
            try {
                out.write(c);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void printArr(int[] arr) {
            for (int i : arr)
                System.out.print(i + " ");
            System.out.println();
        }

        void printArr(long[] arr) {
            for (long i : arr)
                System.out.print(i + " ");
            System.out.println();
        }

        void printArr(char[] arr) {
            for (char c : arr)
                System.out.print(c + " ");
            System.out.println();
        }

        void printArr(String[] arr) {
            for (String s : arr)
                System.out.print(s + " ");
            System.out.println();
        }

        void printList(List<Integer> arr) {
            for (Integer i : arr)
                System.out.print(i + " ");
            System.out.println();
        }

    }

}