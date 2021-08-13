package heap;

import stack.Queue;

import java.util.Comparator;
import java.util.PriorityQueue;

class Element implements Comparable<Element>{
    int row,col,val;

    public Element(int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }

    @Override
    public int compareTo(Element e){
        return this.val - e.val;
    }
}

public class KthSmallest2 {
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Element> q = new PriorityQueue<Element>();

        //add first row into the priority queue
        for(int i=0;i<matrix[0].length;i++)
            q.add(new Element(0,i, matrix[0][i]));

        for(int i=0;i<k-1;i++){
            Element e = q.poll();
            if (e.row+1 < matrix.length)
                q.add(new Element(e.row+1, e.col, matrix[e.row+1][e.col]));
        }

        return q.peek().val;

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};

        System.out.println(kthSmallest(matrix, 8));
    }
}
