import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class CP {

    static FastIO io = new FastIO();
    static long mod = 1000000007;
    static BufferedReader br;
    static StringTokenizer st;
    static BufferedWriter out;

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

    // String utils -----------------------

    /**
     * Checks if the pattern {@code p} is present in the string {@code s} using the
     * {@code Z-algorithm}.
     *
     * The Z-algorithm is used to find occurrences of a pattern within a text
     * efficiently.
     * This method concatenates the pattern {@code p}, a delimiter, and the string
     * {@code s} to
     * form a new string {@code temp}.
     * It then computes the Z-array for {@code temp}, which stores the length of the
     * longest substring starting
     * from each position that matches the prefix of {@code temp}.
     *
     * @param s         The string in which to search for the pattern.
     * @param p         The pattern to search for within the string {@code s}.
     * @param delimiter A delimiter character to separate the pattern {@code p} and
     *                  the
     *                  string {@code s} in the concatenated string {@code temp}.
     * @return The number of times the pattern {@code p} occurs in the string
     *         {@code s}.
     */
    static List<Integer> matchPatterZ(String s, String p, String delimiter) {
        String temp = p + delimiter + s;
        int l = 0, r = 0, n = temp.length(), z[] = new int[n];
        for (int i = 1; i < n; i++) {
            if (i < r)
                z[i] = Math.min(z[i - l], r - i + 1);
            while (i + z[i] < n && temp.charAt(z[i]) == temp.charAt(i + z[i])) {
                z[i]++;
            }
            if (r < (z[i] + i - 1)) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        List<Integer> occurrence = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (z[i] == p.length()) {
                occurrence.add(i - p.length());
            }
        }

        return occurrence;
    }

    static void rabinKarp(String s) {
        // change p to 31 if s has only lower case or upper case, if s has both upper
        // and lower p=53.
        int n = s.length();
        long powArr[] = new long[n], hashArr[] = new long[n], p = 31;

        hashArr[0] = s.charAt(0) - 'a' + 1;
        powArr[0] = 1;

        for (int i = 1; i < n; i++) {
            powArr[i] = (powArr[i - 1] * p) % mod;
            hashArr[i] = (hashArr[i - 1] + (s.charAt(i) - 'a' + 1) * powArr[i]) % mod;
        }
    }

    // Pair class -------------------------------

    class Pair {
        int i, j, time;

        Pair(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    // Math functions ---------------------------

    static class CMath {

        static long gcd(long a, long b) {
            if (b == 0)
                return a;
            return gcd(b, a % b);
        }

        static boolean isPrime(long n) {
            if (n <= 1)
                return false;
            long count = 0;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    count++;
                    if (i != n / i)
                        count++;
                }
            }
            return count == 0;
        }

        static long pow(long a, long b) {
            long res = 1;
            while (b > 0) {
                if ((b & 1) == 1)
                    res *= a;
                a *= a;
                b >>= 1;
            }
            return res;
        }

        static long pow(long a, long b, long mod) {
            long res = 1;
            while (b > 0) {
                if ((b & 1) == 1)
                    res = (res * a) % mod;
                a = (a * a) % mod;
                b >>= 1;
            }
            return res;
        }
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

        void println(int[] arr) {
            for (int i : arr)
                print(i + " ");
            println();
        }

        void println(long[] arr) {
            for (long i : arr)
                print(i + " ");
            println();
        }

        void println(char[] arr) {
            for (char c : arr)
                print(c + " ");
            println();
        }

        void println(String[] arr) {
            for (String s : arr)
                print(s + " ");
            println();
        }

        void println(List<Object> arr) {
            for (Object i : arr)
                print(i + " ");
            println();
        }

        void println(Object[] arr) {
            for (Object obj : arr) {
                print(obj.toString() + " ");
            }
            println();
        }

    }

    // Array methods ----------------------------

    static void reverseArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }

    static void reverseArray(long[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            long temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }

    static long sum(int[] arr) {
        long sum = 0;
        for (int i : arr)
            sum += i;
        return sum;
    }

}