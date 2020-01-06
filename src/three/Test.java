package three;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Test extends JFrame {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("F:/usa.txt"));
        int V = sc.nextInt();
        int E = sc.nextInt();
        int v, w;
        double weight;
        int i = 0, j = 0;
        DirectedEdge e;
        DrawMap map = new DrawMap(1500, 900, "USA");

        EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);
        Vector<Point> points = new Vector<Point>(V);
        while (i < V) {
            int point, x, y;
            point = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
            points.add(new Point(point, x, y));
            i++;
        }
        while (j < E) {
            v = sc.nextInt();
            w = sc.nextInt();
            weight = DijkstraSP.Odistance(points.elementAt(v), points.elementAt(w));
            e = new DirectedEdge(v, w, weight);
            G.addEdge(e);
            G.addEdge(new DirectedEdge(w, v, weight));
            map.addMapLine(points.elementAt(v).X(), points.elementAt(v).Y(), points.elementAt(w).X(), points.elementAt(w).Y());
            j++;
        }
        map.repaintMap();

        Scanner in = new Scanner(System.in);
        int s = in.nextInt(), temps = in.nextInt();
        long startime, endtime;
        startime = System.nanoTime();
        DijkstraSP SP = new DijkstraSP(G, s);
        endtime = System.nanoTime();
        System.out.println("未优化的时间:" + (endtime - startime) + "ns");

        startime = System.nanoTime();
        DijkstraSP SP1 = new DijkstraSP(G, s, temps, points);
        endtime = System.nanoTime();
        System.out.println("优化1、2、3的时间:" + (endtime - startime) + "ns");

        Iterator<DirectedEdge> iter;
        if (SP.hasPathTo(temps)) {
            iter = SP.pathTo(temps).iterator();
            e = iter.next();
            map.addPathLine(points.elementAt(e.from()).X(), points.elementAt(e.from()).Y(), points.elementAt(e.to()).X(), points.elementAt(e.to()).Y());
            System.out.printf("%d -> %d ", e.from(), e.to());
            while (iter.hasNext()) {
                e = iter.next();
                map.addPathLine(points.elementAt(e.from()).X(), points.elementAt(e.from()).Y(), points.elementAt(e.to()).X(), points.elementAt(e.to()).Y());
                System.out.printf(" -> %d", e.to());
            }
            map.repaintMap();
            System.out.printf("\n the length of shortest path is : %f", SP.distTo(temps));
        } else {
            System.out.println("no path,please input another x,y");
        }
        return;
    }

}

