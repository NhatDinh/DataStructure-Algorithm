package priority_queue;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

public class Jobs {
    // Creating empty priority queue
    PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();


    //fill pQueue with 100 random generated jobs time.
    void fill_pQueue(int size){
        Random rand = new Random();
        for (int i = 0; i < size; i++){
            //random time range 0- 100 time unit
            int time = rand.nextInt(100);
            pQueue.add(time);
        }
    }

    //FIRST IN FIRST OUT APPROACH
    void process_fifo(Jobs jobs){
        Integer turn_around_time = 0, wait_time = 0;
        Iterator itr = jobs.pQueue.iterator();
        System.out.println();
        while (itr.hasNext()){
            Integer process_time = (Integer) itr.next();
            wait_time = turn_around_time;
            System.out.print("\n Wait time: " + wait_time);
            turn_around_time = wait_time + process_time;
            System.out.print("- Turn-around time: " + turn_around_time);
            //remove job
            jobs.pQueue.remove(itr);
            System.out.print("- Removed " + process_time);

        }
        System.out.println("\npQueue after: ");
        show(jobs);
    }

    //SHORTEST JOB FIRST APPROACH
    void process_sjf(Jobs jobs, int wait_time){
        Iterator itr = jobs.pQueue.iterator();
        int turn_around_time = 0;
        //Looking for job with shortest time to finish
        while (itr.hasNext()) {
            Integer shortest = (Integer) itr.next();
            Integer process_time = shortest;
            while (itr.hasNext()){
                Integer current = (Integer) itr.next();
                if(current <= shortest){
                    shortest = current;
                    process_time = shortest;
                }
                process_time = shortest;
            }
            System.out.print("\n Wait time: " + wait_time);
            turn_around_time = wait_time + process_time;
            wait_time = turn_around_time;
            System.out.print("- Turn-around time: " + turn_around_time);
            jobs.pQueue.remove(shortest);
            System.out.print("- Process time: " + shortest);
            //show(jobs);
            process_sjf(jobs,wait_time);//recursively call process_sjf untill all elements are removed
        }
    }

    //ROUND ROBIN APPROACH
    void process_rr(Jobs jobs, int timeout){

        Iterator itr = jobs.pQueue.iterator();
        int turn_around_time = 0, wait_time = 0, process_time = 0;
        //Looking for job with shortest time to finish
        while (itr.hasNext()) {
            if((Integer)itr.next() - timeout > 0){
                System.out.print("\n Wait time: " );
                turn_around_time = wait_time + process_time;
                wait_time = turn_around_time;
                System.out.print("- Turn-around time: " + turn_around_time);
                jobs.pQueue.remove(process_time);
                System.out.print("- Process time: " + process_time);
            }
        }
    }
    //utility method to print pQueue
    static void show(Jobs jobs){
        Iterator itr = jobs.pQueue.iterator();
        System.out.print("\npQueue: ");
        while (itr.hasNext()){
            System.out.print( itr.next() + ", ");
        }
    }

    public static void main(String args[]) {
        Jobs jobs = new Jobs();
        jobs.fill_pQueue(100);
        show(jobs);
        //FIFO APPROACH
        System.out.print("\nFifo approach: ");
        jobs.process_fifo(jobs);

        //SJF APPROACH
        System.out.print("\nSJF approach: ");
        jobs.process_sjf(jobs, 0);

    }
}
