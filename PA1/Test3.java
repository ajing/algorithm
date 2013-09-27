public class Test3
{
    public static void main(String[] args)
    {
        int N = 10;
        int seed = 720640;
        for (N = 1; N <1000; N=N+10){
            Stopwatch stopwatch = new Stopwatch();
            Timing.trial(N, seed);
            double time = stopwatch.elapsedTime();
            System.out.println(Double.toString(time));
        }
    }
}