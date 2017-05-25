/**
 * Created by Ольга on 11.03.2017.
 */

import org.apache.axis.client.Service;
import org.apache.axis.client.Call;
import javax.xml.rpc.ServiceException;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class educationApp {
    public static void main(String[] args) throws ServiceException, MalformedURLException {
        String endpoint = "http://localhost:8080/axis/education.jws";
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new URL(endpoint));
        System.out.println("1 - введите средний балл студента");
        System.out.println("2 - введите фамилию студента");
        System.out.println("3 - выход");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            line = in.readLine();
            while(!line.equals("3")){
                if (line.equals("3")) break;
                if (line.equals("1")) {
                    String gpa = in.readLine();
                    Object[] param1 = new Object[]{gpa};
                    String response = (String) call.invoke("gpa_name", param1);
                    System.out.println("Средний балл=" + gpa + "\n" + "Фамилия=" + response);
                }

                if (line.equals("2")){
                    String name = in.readLine();
                    Object[] param2 = new Object[]{name};
                    String response = (String) call.invoke("name_gpa", param2);
                    System.out.println("Фамилия="+name+ "\n"+"Средний балл="+response);
                }
                System.out.println("1 - введите средний балл студента");
                System.out.println("2 - введите фамилию студента");
                System.out.println("3 - выход");
                line = in.readLine();
            } }catch (IOException e) {e.printStackTrace();}

}
}
