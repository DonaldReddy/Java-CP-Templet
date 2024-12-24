import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class CP {

    static FastIO io = new FastIO();
    static long mod = 1000000007;

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

    // Binary Search Tree Class -----------------------

    static class Node {
        int val, idx;
        Node left = null, right = null;

        Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }

        Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
            this.left = this.right = null;
        }

        static Node insert(Node root, int val) {

            if (root == null)
                return new Node(val);
            if (val > root.val)
                root.right = insert(root.right, val);
            else if (val < root.val)
                root.left = insert(root.left, val);
            return root;
        }

        static Node insert_With_Idx(Node root, int val, int idx) {

            if (root == null)
                return new Node(val, idx);
            if (val > root.val)
                root.right = insert_With_Idx(root.right, val, idx);
            else if (val < root.val)
                root.left = insert_With_Idx(root.left, val, idx);
            return root;
        }

        static Node delete(Node root, int x) {
            if (root == null)
                return null;
            if (root.val == x) {
                if (root.left == null)
                    return root.right;
                else if (root.right == null)
                    return root.left;
                root.val = getMin(root.right);
                root.right = delete(root.right, root.val);
            } else if (x > root.val)
                root.right = delete(root.right, x);
            else if (x < root.val)
                root.left = delete(root.left, x);
            return root;
        }

        static int getMin(Node root) {
            while (root.left != null)
                root = root.left;
            return root.val;
        }

        static boolean search(Node root, int x) {
            if (root == null)
                return false;
            if (root.val == x)
                return true;
            if (x > root.val)
                return search(root.right, x);
            return search(root.left, x);
        }

        static void preorder(Node root) {
            if (root == null)
                return;
            System.out.print(root.val + " ");
            preorder(root.left);
            preorder(root.right);
        }

        static void inorder(Node root) {
            if (root == null)
                return;
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }

        static void postorder(Node root) {
            if (root == null)
                return;
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.val + " ");
        }

        static boolean checkFBT(Node root) {
            if (root == null)
                return false;
            if (root.left == null && root.right == null)
                return true;
            if (root.left != null && root.right != null)
                return checkFBT(root.left) && checkFBT(root.right);
            return false;
        }

        static boolean checkCBST(Node root) {
            if (root == null)
                return true;
            Queue<Node> q = new LinkedList<Node>();
            boolean missing = false;
            q.offer(root);
            while (!q.isEmpty()) {
                Node t = q.poll();
                if (t.left != null) {
                    if (missing)
                        return false;
                    q.offer(t.left);
                } else
                    missing = true;

                if (t.right != null) {
                    if (missing)
                        return false;
                    q.offer(t.right);
                } else
                    missing = true;
            }
            return true;
        }

        static int height(Node root) {
            if (root == null)
                return 0;
            int l = 0, r = 0;
            if (root.left != null)
                l = 1 + height(root.left);
            if (root.right != null)
                r = 1 + height(root.right);
            return Math.max(l, r);
        }

        static void depth(Node root, LinkedHashMap<Integer, Integer> hm) {
            if (root == null)
                return;
            Deque<Pair> q = new LinkedList<>();
            q.offer(new Pair(root, 0));
            while (!q.isEmpty()) {
                Pair temp = q.poll();
                hm.put(temp.node.val, temp.hd);
                if (temp.node.left != null)
                    q.offer(new Pair(temp.node.left, temp.hd + 1));
                if (temp.node.right != null)
                    q.offer(new Pair(temp.node.right, temp.hd + 1));
            }
            for (Map.Entry<Integer, Integer> i : hm.entrySet()) {
                System.out.print(i.getValue() + " ");
            }
            System.out.println();
        }

        static void levelOrder(Node root) {
            if (root == null)
                return;
            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            q.offer(null);
            while (!q.isEmpty()) {
                Node t = q.poll();
                if (t == null) {
                    if (q.isEmpty()) {
                        System.out.println();
                        return;
                    }
                    System.out.println();
                    q.offer(null);
                } else {
                    System.out.print(t.val + " ");
                    if (t.left != null)
                        q.offer(t.left);
                    if (t.right != null)
                        q.offer(t.right);
                }
            }
        }

        static void zigzagLevelOrder(Node root) {
            if (root == null)
                return;
            Queue<Node> q = new LinkedList<>();
            boolean rev = true;
            q.offer(root);
            q.offer(null);
            ArrayList<Integer> lev = new ArrayList<>();
            while (!q.isEmpty()) {
                Node t = q.poll();
                if (t == null) {
                    if (rev)
                        Collections.reverse(lev);
                    for (int i : lev)
                        System.out.print(i + " ");
                    lev.clear();
                    if (q.isEmpty()) {
                        System.out.println();
                        return;
                    }
                    q.offer(null);
                    rev ^= true;
                } else {
                    lev.add(t.val);
                    if (t.left != null)
                        q.offer(t.left);
                    if (t.right != null)
                        q.offer(t.right);
                }
            }
        }

        static void bottomUpLevelOrder(Node root) {
            if (root == null)
                return;
            Queue<Node> q = new LinkedList<>();
            Stack<ArrayList<Integer>> stk = new Stack<>();
            ArrayList<Integer> lev = new ArrayList<>();
            q.offer(root);
            q.offer(null);

            while (!q.isEmpty()) {
                Node t = q.poll();
                if (t == null) {
                    stk.push(new ArrayList<>(lev));
                    lev.clear();
                    if (q.isEmpty())
                        break;
                    q.offer(null);
                } else {
                    lev.add(t.val);
                    if (t.left != null)
                        q.offer(t.left);
                    if (t.right != null)
                        q.offer(t.right);
                }
            }

            while (!stk.isEmpty()) {
                for (int i : stk.pop())
                    System.out.print(i + " ");
                System.out.println();
            }
            System.out.println();
        }

        static void zigzagBottomUpLevelOrder(Node root) {
            if (root == null)
                return;
            Queue<Node> q = new LinkedList<>();
            Stack<ArrayList<Integer>> stk = new Stack<>();
            boolean rev = true;
            ArrayList<Integer> lev = new ArrayList<>();
            q.offer(root);
            q.offer(null);

            while (!q.isEmpty()) {
                Node t = q.poll();
                if (t == null) {
                    if (rev)
                        Collections.reverse(lev);
                    stk.push(new ArrayList<>(lev));
                    lev.clear();
                    if (q.isEmpty())
                        break;
                    q.offer(null);
                    rev ^= true;
                } else {
                    lev.add(t.val);
                    if (t.left != null)
                        q.offer(t.left);
                    if (t.right != null)
                        q.offer(t.right);
                }
            }

            while (!stk.isEmpty()) {
                for (int i : stk.pop())
                    System.out.print(i + " ");
            }
            System.out.println();
        }

        static boolean isBalanced(Node root) {
            int res = isBalance(root);
            return res == -1 ? false : true;
        }

        private static int isBalance(Node root) {
            if (root == null)
                return 0;
            int l = isBalance(root.left);
            if (l == -1)
                return -1;
            int r = isBalance(root.right);
            if (r == -1)
                return -1;
            if (Math.abs(l - r) > 1)
                return -1;
            return Math.max(l, r) + 1;
        }

        static int sumOfNumberFromRootToLeaf(Node root) {
            if (root == null)
                return 0;
            return sumOfNumberFromRootToLeaf(root, 0);
        }

        private static int sumOfNumberFromRootToLeaf(Node root, int n) {
            if (root == null)
                return 0;
            if (root.left == null && root.right == null)
                return n * size(root.val) + root.val;
            int l = 0, r = 0;
            if (root.left != null)
                l = sumOfNumberFromRootToLeaf(root.left, n * size(root.val) + root.val);
            if (root.right != null)
                r = sumOfNumberFromRootToLeaf(root.right, n * size(root.val) + root.val);
            return (l + r) % ((int) Math.pow(10, 9) + 7);
        }

        private static int size(int n) {
            int c = 0;
            while (n > 0) {
                c++;
                n /= 10;
            }
            return (int) Math.pow(10, c);
        }

        static boolean isBST(int[] arr) {
            return checkBST(arr, Integer.MIN_VALUE, Integer.MAX_VALUE, 1);
        }

        private static boolean checkBST(int[] tree, int low, int high, int i) {
            if (i - 1 >= tree.length)
                return true;
            if (tree[i - 1] > high)
                return false;
            if (tree[i - 1] < low)
                return false;

            boolean l = checkBST(tree, low, tree[i - 1] - 1, 2 * i), r = false;
            if (l)
                r = checkBST(tree, tree[i - 1] + 1, high, 2 * i + 1);
            return l && r;
        }

        static void leftView(Node root, Set<Integer> lev, int d) {
            if (root == null)
                return;
            if (!lev.contains(d))
                System.out.print(root.val + " ");
            lev.add(d);
            leftView(root.left, lev, d + 1);
            leftView(root.right, lev, d + 1);
        }

        static void rightView(Node root) {
            LinkedHashMap<Integer, Integer> lev = new LinkedHashMap<Integer, Integer>();
            rightView(root, lev, 0);
            for (int i : lev.values())
                System.out.print(i + " ");
            System.out.println();
        }

        private static void rightView(Node root, LinkedHashMap<Integer, Integer> lev,
                int d) {
            if (root == null)
                return;
            lev.put(d, root.val);
            rightView(root.left, lev, d + 1);
            rightView(root.right, lev, d + 1);
        }

        static Node ceil(Node root, int x) {
            if (root == null || root.val == x)
                return root;
            if (root.val < x)
                return ceil(root.right, x);
            return root;
        }

        static Node LCA(Node root, int u, int v) {
            if (root == null)
                return null;
            if (u > root.val && v > root.val)
                return LCA(root.right, u, v);
            if (u < root.val && v < root.val)
                return LCA(root.left, u, v);
            return root;
        }

        static void vertical_Order(Node root) {
            if (root == null)
                return;

            Deque<Pair> q = new LinkedList<Pair>();
            TreeMap<Integer, ArrayList<Integer>> hm = new TreeMap<>();
            q.offer(new Pair(root, 0));
            while (!q.isEmpty()) {
                Pair temp = q.poll();
                if (hm.containsKey(temp.hd))
                    hm.get(temp.hd).add(temp.node.val);
                else
                    hm.put(temp.hd, new ArrayList<Integer>() {
                        {
                            add(temp.node.val);
                        }
                    });
                if (temp.node.left != null)
                    q.offer(new Pair(temp.node.left, temp.hd - 1));
                if (temp.node.right != null)
                    q.offer(new Pair(temp.node.right, temp.hd + 1));
            }
            for (Map.Entry<Integer, ArrayList<Integer>> ver : hm.entrySet()) {
                Collections.sort(ver.getValue());
                for (int i : ver.getValue())
                    System.out.print(i + " ");
                System.out.println();
            }
        }

        static void top_View(Node root) {
            if (root == null)
                return;

            Deque<Pair> q = new LinkedList<Pair>();
            TreeMap<Integer, Integer> hm = new TreeMap<>();
            q.offer(new Pair(root, 0));
            while (!q.isEmpty()) {
                Pair temp = q.poll();
                if (!hm.containsKey(temp.hd))
                    hm.put(temp.hd, temp.node.val);
                if (temp.node.left != null)
                    q.offer(new Pair(temp.node.left, temp.hd - 1));
                if (temp.node.right != null)
                    q.offer(new Pair(temp.node.right, temp.hd + 1));
            }
            for (Map.Entry<Integer, Integer> ver : hm.entrySet())
                System.out.print(ver.getValue() + " ");
        }

        static int tree_Width(Node root) {

            if (root == null)
                return 0;
            int ans = 0;
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(root, 1));
            while (!q.isEmpty()) {
                int start = q.peek().hd;
                int len = q.size();
                int end = 0;
                for (int i = 0; i < len; i++) {
                    Pair cur = q.poll();
                    int idx = cur.hd;
                    Node node = cur.node;
                    end = cur.hd;
                    if (node.left != null)
                        q.offer(new Pair(node.left, 2 * idx));
                    if (node.right != null)
                        q.offer(new Pair(node.right, 2 * idx + 1));
                }
                ans = Math.max(ans, end - start + 1);
            }
            return ans;

        }

        static class Pair {
            Node node = null;
            int hd, idx;

            Pair(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
    }

    // Array methods ----------------------------

    static void reverseArray(Object[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            Object temp = arr[i];
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