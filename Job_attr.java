import java.util.*;

class Job{
    public int priority; // job priority
    public int duration_time; // job duration time
    public String name; // job name
    public int remaining_time; // duration time remaining


    // initialize the attributes of Job
    public Job(int priority, int duration_time, String name){
        this.priority = priority;
        this.duration_time = duration_time;
        this.name = name;
        this.remaining_time = duration_time;
    }

    public static void main(String[] args){
        // Create a list of Job objects with different priorities and duration times
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(1, 0, "Job 1 is running"));
        jobs.add(new Job(2, 0, "Job 2 is running"));
        jobs.add(new Job(10, 5, "Job 3 is running"));
        jobs.add(new Job(5, 3, "Job 4 is running"));
        jobs.add(new Job(3, 2, "Job 5 is running"));

        // Initialize variables for the simulation
        int time = 0;
        int completed_jobs = 0;
        List<String> FCFS_output = new ArrayList<>();
        List<String> HPF_output = new ArrayList<>();
        List<String> SRTF_Output = new ArrayList<>();

        // Loop until all jobs are completed
        while (completed_jobs < jobs.size()){
            // First Come First Served
            if (!jobs.isEmpty()){
                // Select the first job in the list
                Job current_job = jobs.get(0);
                // Add the job name and system time to the FCFS output list
                FCFS_output.add("System Time " + time + " " + current_job.name);
                // Decrement the remaining duration time of the job
                current_job.remaining_time--;

                // Check if the job has completed
                if (current_job.remaining_time == 0){
                    // Remove the job from the list
                    jobs.remove(current_job);
                    // Increment the number of completed jobs
                    completed_jobs++;
                }
            }

            // Highest priority
            if (!jobs.isEmpty()){
                // Select the job with the highest priority
                Job current_job = jobs.stream().max(Comparator.comparingInt(job -> job.priority)).get();
                // Add the job name and system time to the HPF output list
                HPF_output.add("System Time " + time + "  " + current_job.name);
                // Decrement the remaining duration time of the job
                current_job.remaining_time--;

                // Check if the job has completed
                if (current_job.remaining_time == 0){
                    // Remove the job from the list
                    jobs.remove(current_job);
                    // Increment the number of completed jobs
                    completed_jobs++;
                }
            }

            // Shortest Remaining Time First
            if (!jobs.isEmpty()){
                // Select the job with the shortest remaining time
                Job current_job = jobs.stream().min(Comparator.comparingInt(job -> job.remaining_time)).get();
                // Add the job name and system time to the SRTF output list
                SRTF_Output.add("System Time " + time + " " + current_job.name);
                // Decrement the remaining duration time of the job
                current_job.remaining_time--;

                // Check if the job has completed
                if (current_job.remaining_time == 0){
                    // Remove the job from the list
                    jobs.remove(current_job);
                    // Increment the number of completed jobs
                    completed_jobs++;
                }
            }

            // Increment the system time
            time++;
        }

        // Print the output lists for each scheduling policy
        System.out.println("First Come First Served:");
        FCFS_output.forEach(System.out::println);

        System.out.println("\nHighest Priority First:");
        HPF_output.forEach(System.out::println);

        System.out.println("\nShortest Remaining Time First:");
        SRTF_Output.forEach(System.out::println);
    }
}