package three;

import edu.princeton.cs.algs4.Stack;
import java.util.Vector;
import static java.lang.Math.*;
import edu.princeton.cs.algs4.IndexMultiwayMinPQ;
public class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
//    private IndexMinPQ<Double> pq;
    private IndexMultiwayMinPQ<Double> pq;
    private Vector<Point> points;//优化需要用上
    private int destination;

    public DijkstraSP(EdgeWeightedDigraph G, int s, int w, Vector<Point> p) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
//        pq = new IndexMinPQ<Double>(G.V());
        pq = new IndexMultiwayMinPQ<Double>(G.V(),2);
        points = new Vector<Point>(p);

        destination = w;

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            if (v == w) {
                break;//优化1
            }
            for (DirectedEdge e : G.adj(v)) {
                relax1(e);//优化2
            }
        }
    }

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
//        pq = new IndexMinPQ<Double>(G.V());
        pq = new IndexMultiwayMinPQ<Double>(G.V(),2);
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            for (DirectedEdge e : G.adj(v)) {
                relax(e);
            }
        }
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)) {
                pq.decreaseKey(w, distTo[w]);
            } else {
                pq.insert(w, distTo[w]);
            }
        }
    }

    public static double Odistance(Point from, Point to) {
        return sqrt(pow(from.X() - to.X(), 2) + pow(from.Y() - to.Y(), 2));
    }

    private void relax1(DirectedEdge e) {//优化2
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight() + Odistance(points.elementAt(w), points.elementAt(destination)) - Odistance(points.elementAt(v), points.elementAt(destination))) {
            distTo[w] = distTo[v] + e.weight() + Odistance(points.elementAt(w), points.elementAt(destination)) - Odistance(points.elementAt(v), points.elementAt(destination));
            edgeTo[w] = e;
            if (pq.contains(w)) {
                pq.decreaseKey(w, distTo[w]);
            } else {
                pq.insert(w, distTo[w]);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }
}


