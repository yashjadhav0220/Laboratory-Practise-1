import java.net.*;
import java.io.*;
public class Server{
    public static void main(String[] args)throws SocketException,IOException {
        ServerSocket ss =new ServerSocket(1000);
        Socket S = ss.accept();
        System.out.println("Connection Established");
        DataInputStream dis=new DataInputStream(S.getInputStream());
        DataOutputStream dou=new DataOutputStream(S.getOutputStream());
        int a[]={10,20,30,40,50,60,70,80,90,100};
        dou.write(a.length);
        dou.flush();
        for (int i = 0; i < a.length; i++) {
            dou.write(a[i]);
            dou.flush();
        }
        int n =dis.read();
        System.out.println("Frame number to be resent "+n);
        dou.write(a[n]);
        dou.flush();

    }
}