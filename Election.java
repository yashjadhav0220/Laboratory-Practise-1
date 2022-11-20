
import java.util.Scanner;

class Ring {
    public int[] status;
    public int[] process;
    public int n;
    public int[] elearr;

    public Ring() {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of processes");
        n = s.nextInt();
        status = new int[n];
        process = new int[n];
        elearr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Process no: ");
            process[i] = s.nextInt();
            System.out.println("Status of Process " + (i + 1));
            status[i] = s.nextInt();

        }
        System.out.println("Enter your choice \n1.Crash \n2.Election ");
        int choice = s.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter process no to crash");
                int x = s.nextInt();
                crash(x);
                break;
            case 2:
                election();
                break;
        }
    }

    public void crash(int x) {
        status[x - 1] = 0;
        if (status[n-1]==0){
            election();
        }
        if (status[n - 1] == 1) {
            System.out.println("No Need of election");
        }
    }
    

    void election() {

        if (status[n - 1] == 0) {
            int ele;
            System.out.println("Enter the process number from whome you will start election ");
            Scanner s = new Scanner(System.in);
            ele = s.nextInt();
            for (int i = 0; i < n - 1; i++) {
                if(status[i]==1){
                    elearr[i] = process[i];
                }
                System.out.println(elearr[i]);
                
            }
            int max = elearr[0];
            for (int i = 0; i < elearr.length; i++) {
                if (elearr[i] > max) {
                    max = elearr[i];
                }

            }
            System.out.println("New Coordinator is " + max);
        }
        else{
            System.out.println("No Need of election");
        }

    }

}

class Bully {
    public int ele, co, n;
    public int[] prio;
    public int[] status;

    public Bully() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of processes");
        n = s.nextInt();
        System.out.println("Enter the process priority and status");
        prio = new int[n];
        status = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Status of Process " + (i + 1));
            status[i] = s.nextInt();
            System.out.println("Priority for Process " + (i + 1));
            prio[i] = s.nextInt();
        }

        System.out.println("Enter the process who will start election");
        ele = s.nextInt();
        election(ele);
        System.out.println("Final coordinator is " + co);

    }

    public void election(int ele) {
        ele = ele - 1;
        co = ele + 1;
        for (int i = 0; i < n; i++) {
            if (prio[ele] < prio[i]) {
                System.out.println("Message sent from " + (ele + 1) + " to " + (i + 1));
                if (status[i] == 1) {
                    election(i + 1);
                }
            }
        }
    }
}

public class Election {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int ch;
        System.out.println("Enter your choice \n1.Ring \n2.Bully");
        ch = s.nextInt();
        switch (ch) {
            case 1:
                Ring r = new Ring();
                break;
            case 2:
                Bully b = new Bully();
        }

    }
}