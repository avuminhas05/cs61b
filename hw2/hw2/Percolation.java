package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import org.junit.Test;
import static org.junit.Assert.*;

public class Percolation {
    private boolean[][] grid;
    private WeightedQuickUnionUF uf;
    private int gridSize;
    private int ufSize;
    private int numOpenSites;

    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N){
        if(N <= 0)
            throw new IllegalArgumentException();
        gridSize = N;
        ufSize = (gridSize * gridSize) + 2;
        grid = new boolean[gridSize][gridSize];
        uf = new WeightedQuickUnionUF(ufSize);
        numOpenSites = 0;

        for(int row = 0; row < gridSize; row++){
            for(int col = 0; col < gridSize; col++){
                grid[row][col] = true;
            }
        }
    }
    // open the site (row, col) if it is not open already
    public void open(int row, int col){
        validateRowCol(row, col);
        if(grid[row][col]){
            grid[row][col] = false;
            numOpenSites++;
            if(row != 0 && isOpen(row - 1, col))
                uf.union(siteNum(row, col), siteNum(row-1, col));
            if(row != (gridSize-1) && isOpen(row+1, col))
                uf.union(siteNum(row, col), siteNum(row+1, col));
            if(col != 0 && isOpen(row, col-1))
                uf.union(siteNum(row, col), siteNum(row, col-1));
            if(col != (gridSize-1) && isOpen(row, col+1))
                uf.union(siteNum(row, col), siteNum(row, col+1));
            if(row == 0)
                uf.union(siteNum(row, col), 0);
            if(row == (gridSize-1))
                uf.union(siteNum(row, col), ufSize-1);

        }
    }
    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        validateRowCol(row, col);
        return (grid[row][col] == false);
    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        validateRowCol(row, col);
        return uf.connected(siteNum(row, col), 0);
    }
    // number of open sites
    public int numberOfOpenSites(){
        return numOpenSites;
    }
    // does the system percolate?
    public boolean percolates(){
        return uf.connected(0, ufSize-1);
    }

    private int siteNum(int row, int col){
        validateRowCol(row, col);
        return (row*gridSize) + col;
    }
    private void validateRowCol(int row, int col){
        if(row < 0 || row >= gridSize || col < 0 || col >= gridSize)
            throw new IllegalArgumentException();
    }

    // use for unit testing (not required)
    public static void main(String[] args){
        Percolation p = new Percolation(4);
        p.open(0, 1);
        System.out.println(p.percolates());
        p.open(1, 1);
        System.out.println(p.percolates());
        p.open(2, 1);
        System.out.println(p.percolates());
        p.open(3, 1);
        System.out.println(p.percolates());
    }
}
