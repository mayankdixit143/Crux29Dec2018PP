package L22_March30;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Mar-2019
 *
 */

public class DP {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		int n = 3;
		// System.out.println(fibonacci(n));
		// System.out.println(fibonacciTD(n, new int[n + 1]));
		// System.out.println(FibonaaciBU(n));
		// System.out.println(FibonacciBUSE(n));

		// System.out.println(boardPath(0, n));
		// System.out.println(boardPathTD(0, n, new int[n]));
		// System.out.println(boardPathBU(n));
		// System.out.println(boardPathBUSE(n));

		System.out.println(mazePathTD(0, 0, n, n, new int[n + 1][n + 1]));
		System.out.println(mazePathBU(n, n));

		long end = System.currentTimeMillis();

		System.out.println(end - start);
	}

	public static int fibonacci(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		int fnm1 = fibonacci(n - 1);
		int fnm2 = fibonacci(n - 2);

		int fn = fnm1 + fnm2;

		return fn;

	}

	public static int fibonacciTD(int n, int[] strg) {

		if (n == 0 || n == 1) {
			return n;
		}

		// use
		if (strg[n] != 0) {
			return strg[n];
		}

		int fnm1 = fibonacciTD(n - 1, strg);
		int fnm2 = fibonacciTD(n - 2, strg);

		int fn = fnm1 + fnm2;

		// ans store
		strg[n] = fn;

		return fn;

	}

	public static int FibonaaciBU(int n) {

		int[] strg = new int[n + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i < strg.length; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];
	}

	public static int FibonacciBUSE(int n) {

		int[] strg = new int[2];

		strg[0] = 0;
		strg[1] = 1;

		for (int slide = 1; slide <= n - 1; slide++) {

			int sum = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = sum;

		}

		return strg[1];

	}

	public static int boardPath(int curr, int end) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int sum = 0;

		for (int dice = 1; dice <= 6; dice++) {
			sum += boardPath(curr + dice, end);
		}

		return sum;
	}

	public static int boardPathTD(int curr, int end, int[] strg) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		if (strg[curr] != 0) {
			return strg[curr];
		}

		int sum = 0;

		for (int dice = 1; dice <= 6; dice++) {
			sum += boardPathTD(curr + dice, end, strg);
		}

		strg[curr] = sum;

		return sum;
	}

	public static int boardPathBU(int n) {

		int[] strg = new int[n + 6];

		strg[n] = 1;

		for (int i = n - 1; i >= 0; i--) {

			strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3] + strg[i + 4] + strg[i + 5] + strg[i + 6];

		}

		return strg[0];

	}

	public static int boardPathBUSE(int n) {

		int[] strg = new int[6];

		strg[0] = 1;

		for (int slide = 1; slide <= n; slide++) {

			int sum = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];

			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];

			strg[0] = sum;
		}

		return strg[0];
	}

	public static int mazePathTD(int cr, int cc, int er, int ec, int[][] strg) {

		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int ch = mazePathTD(cr, cc + 1, er, ec, strg);
		int cv = mazePathTD(cr + 1, cc, er, ec, strg);

		strg[cr][cc] = ch + cv;

		return ch + cv;
	}

	public static int mazePathBU(int er, int ec) {

		int[][] strg = new int[er + 2][ec + 2];

		for (int row = er; row >= 0; row--) {

			for (int col = ec; col >= 0; col--) {

				if (row == er && col == ec) {
					strg[row][col] = 1;
				} else {
					strg[row][col] = strg[row + 1][col] + strg[row][col + 1];
				}
			}
		}

		return strg[0][0];

	}

}