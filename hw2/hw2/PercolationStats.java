package hw2;


import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final double[] experiments;

    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T, PercolationFactory pf){
        if(N <= 0 || T <= 0)
            throw new IllegalArgumentException();
        experiments = new double[T];

        for(int experiment = 0; experiment < T; experiment++){
            experiments[experiment] = performExperiment(N, pf);
        }
    }
    // sample mean of percolation threshold
    public double mean(){
        return StdStats.mean(experiments);
    }
    // sample standard deviation of percolation threshold
    public double stddev(){
        return StdStats.stddev(experiments);
    }
    // low endpoint of 95% confidence interval
    public double confidenceLow(){
        return mean() - ( (1.96 * stddev()) / (Math.pow(experiments.length, 0.5)) );
    }
    // high endpoint of 95% confidence interval
    public double confidenceHigh(){
        return mean() + ( (1.96 * stddev()) / (Math.pow(experiments.length, 0.5)) );
    }

    // Perform single experiment on NxN grid and return the threshold
    private double performExperiment(int N, PercolationFactory pf){
        Percolation p = pf.make(N);
        int openSites = 0;
        double totalSites = N*N;
        while(!p.percolates()){
            int row = StdRandom.uniform(N);
            int col = StdRandom.uniform(N);
            if(!p.isOpen(row, col)){
                p.open(row, col);
                openSites++;
            }
        }
        return openSites / totalSites;
    }
}
