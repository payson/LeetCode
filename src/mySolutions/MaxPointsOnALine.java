package mySolutions;

import dataStructures.Point;

import javax.print.attribute.IntegerSyntax;
import java.util.HashMap;

/**
 * Created by Payson Wu on 20/03/14.
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points.length < 2) {
            return points.length;
        }
        int result = 0;
        for (int i = 0; i < points.length - 1; i++) {
            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
            int duplicates = 1; // itself
            int vertical = 0; // same x, should compute separately since cannot divide 0
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x) {
                    if (points[i].y == points[j].y) {
                        duplicates++;
                    } else {
                        vertical++;
                    }
                    continue;
                }
                double k = points[i].y == points[j].y ? 0.0 : 1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);
                if (hm.containsKey(k)) {
                    hm.put(k, hm.get(k) + 1);
                } else {
                    hm.put(k, 1);
                }
            }
            for (int iter : hm.values()) {
                if (iter + duplicates > result ) {
                    result = iter + duplicates;
                }
            }
            result = Math.max(result, vertical + duplicates);
        }
        return result;
    }
}
