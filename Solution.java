import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

    static FastIO io = new FastIO();
    static long mod = 1_000_000_007;
    static BufferedReader br;
    static StringTokenizer st;
    static BufferedWriter out;
    static int[][] dp;

    public static void main(String[] args) throws java.lang.Exception {
        // int t = io.nextInt();
        int t = 1;
        for (int tc = 1; tc <= t; tc++) {
            // logic
            solve();
        }
        io.flush();
        io.close();
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

    // input/output class----------------------------

    static class FastIO {

        public FastIO() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
            out = new BufferedWriter(new OutputStreamWriter(System.out));
            st = new StringTokenizer("");
        }

        public void close() {
            try {
                br.close();
                out.close();
            } catch (IOException e) {
                throw new RuntimeException("Error closing FastIO", e);
            }
        }

        void flush() {
            try {
                out.flush();
            } catch (IOException e) {
                throw new RuntimeException("Error flushing FastIO", e);
            }
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
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void print(String s) {

            try {
                out.write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void println(int n) {

            try {
                out.write(n + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void print(int n) {

            try {
                out.write(n);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void println(long n) {

            try {
                out.write(n + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void print(long n) {

            try {
                out.write(n + "");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void println(float n) {

            try {
                out.write(n + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void print(float n) {

            try {
                out.write(n + "");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void println(double n) {

            try {
                out.write(n + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void print(double n) {

            try {
                out.write(n + "");

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        void println(StringBuilder sb) {
            try {
                out.write(sb.toString() + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void print(StringBuilder sb) {
            try {
                out.write(sb.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void println(char c) {
            try {
                out.write(c + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void println() {
            try {
                out.write("\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void print(char c) {
            try {
                out.write(c);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void printIntArr(int[] arr) {
            for (int i : arr)
                print(i + " ");
            println();
        }

        void printCharArr(char[] arr) {
            for (char c : arr)
                print(c + " ");
            println();
        }

        void printStringArr(String[] arr) {
            for (String s : arr)
                print(s + " ");
            println();
        }

        void printList(List<Object> arr) {
            for (Object i : arr)
                print(i + " ");
            println();
        }

        void printArray(Object[] arr) {
            for (Object obj : arr) {
                print(obj.toString() + " ");
            }
            println();
        }

    }

}