import java.net.*;
import java.io.*;
public class Client{
    public static void main(String[] args) throws SocketException,IOException{
        int v[]=new int[10];
        int sent=0;
        Socket s = new Socket("localhost",1000);
        DataInputStream dis= new DataInputStream(s.getInputStream());
        DataOutputStream dou= new DataOutputStream(s.getOutputStream());
        int p = dis.read();
        for (int i = 0; i < p; i++) {
            v[i]=dis.read();
        }
        v[5]=-1;
        for (int i = 0; i < v.length; i++) {
            System.out.println("Received frame "+v[i]);
            if (v[i]==-1){
                sent=i;
            }
        }
        dou.write(sent);
        dou.flush();

        int received=dis.read();
        v[sent]=received;
        System.out.println("Received after rectification "+v[sent]);
    }
}