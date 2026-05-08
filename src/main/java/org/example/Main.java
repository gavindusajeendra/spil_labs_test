package org.example;

import java.io.*;
import java.util.*;

public class Main{

    static class Point implements Comparable<Point> {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            if (this.x == other.x)
                return Double.compare(this.y, other.y);
            return Double.compare(this.x, other.x);
        }
    }

    //cross product
    static double cross(Point O, Point A, Point B) {
        return (A.x - O.x) * (B.y - O.y)
                - (A.y - O.y) * (B.x - O.x);
    }

    static double distance(Point A, Point B) {
        double dx = A.x - B.x;
        double dy = A.y - B.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    static List<Point> convexHull(List<Point> points) {
        Collections.sort(points);

        int n = points.size();
        if (n <= 1) return points;

        List<Point> lower = new ArrayList<>();

        for (Point p : points) {
            while (lower.size() >= 2 &&
                    cross(lower.get(lower.size() - 2),
                            lower.get(lower.size() - 1),
                            p) <= 0) {
                lower.remove(lower.size() - 1);
            }
            lower.add(p);
        }

        List<Point> upper = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            Point p = points.get(i);

            while (upper.size() >= 2 &&
                    cross(upper.get(upper.size() - 2),
                            upper.get(upper.size() - 1),
                            p) <= 0) {
                upper.remove(upper.size() - 1);
            }

            upper.add(p);
        }

        lower.remove(lower.size() - 1);
        upper.remove(upper.size() - 1);

        lower.addAll(upper);

        return lower;
    }

    static double perimeter(List<Point> hull) {
        int n = hull.size();

        if (n == 1) return 0;

        double perim = 0;

        for (int i = 0; i < n; i++) {
            perim += distance(hull.get(i),
                    hull.get((i + 1) % n));
        }

        return perim;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());

            double minX = Math.min(x1, x2);
            double maxX = Math.max(x1, x2);

            double minY = Math.min(y1, y2);
            double maxY = Math.max(y1, y2);

            points.add(new Point(minX, minY));
            points.add(new Point(minX, maxY));
            points.add(new Point(maxX, minY));
            points.add(new Point(maxX, maxY));
        }

        List<Point> hull = convexHull(points);

        double ans = perimeter(hull);

        System.out.printf("%.10f\n", ans);
    }
}