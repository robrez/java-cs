package com.jcs.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 *
 * For example, There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 * [".Q..", // Solution 1 "...Q", "Q...", "..Q."],
 *
 * ["..Q.", // Solution 2 "Q...", "...Q", ".Q.."] ]
 *
 *
 * @author rob
 */
public class Prob0051NQueens {

    public static void main(String[] args) {
        Prob0051NQueens q = new Prob0051NQueens();
        List<List<String>> res = q.solveNQueens(4);

        System.out.println(res.toString());
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> l = new ArrayList<>();
        Point[] points = new Point[n];
        solveNQueens(n, 0, points, l);
        return l;
    }

    public void solveNQueens(int size, int row, Point[] points, List<List<String>> l) {
        if (row == size) {
            List<String> items = new ArrayList<String>();
            for (int i = 0; i < size; i++) {
                items.add(pointToString(size, points[i]));
            }
            l.add(items);
            return;
        }
        Point p = new Point();
        p.y = row;
        points[row] = p;
        for (int i = 0; i < size; i++) {
            p.x = i;
            if (pointOk(points, row, p)) {
                solveNQueens(size, row + 1, points, l);
            }
        }
    }

    private String pointToString(int size, Point p) {
        char[] chars = new char[size];
        for (int i = 0; i < size; i++) {
            if (i == p.x) {
                chars[i] = 'Q';
            } else {
                chars[i] = '.';
            }
        }
        return new String(chars);
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
