package com.jcs.leetcode;

/**
 * Follow up for N-Queens problem.
 *
 * Now, instead outputting board configurations, return the total number of
 * distinct solutions.
 *
 * @author rob
 */
public class Prob0052NQueens2 {

    public static void main(String[] args) {
        Prob0052NQueens2 q = new Prob0052NQueens2();
        Integer res = q.totalNQueens(4);

        System.out.println(res.toString());
    }

    public int totalNQueens(int n) {
        Point[] points = new Point[n];
        return solveNQueens(n, 0, points, 0);
    }

    public int solveNQueens(int size, int row, Point[] points, int solutions) {
        if (row == size) {
            return solutions + 1;
        }
        Point p = new Point();
        p.y = row;
        points[row] = p;
        for (int i = 0; i < size; i++) {
            p.x = i;
            if (pointOk(points, row, p)) {
                solutions = solveNQueens(size, row + 1, points, solutions);
            }
        }
        return solutions;
    }

    private boolean pointOk(Point[] points, int row, Point p) {
        for (int i = 0; i < row; i++) {
            Point o = points[i];
            if (o.x == p.x
                    || o.y == p.y
                    || ((o.x - o.y) == (p.x - p.y))
                    || ((o.x + o.y) == (p.x + p.y))) {
                return false;
            }
        }
        return true;
    }

    public static class Point {

        //decided to make mutable to avoid new point construction during iteration
        int x;
        int y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
