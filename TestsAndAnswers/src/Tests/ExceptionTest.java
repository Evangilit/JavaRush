package Tests;

public class ExceptionTest {
    public static void main(String[] args) {
        String s = "";
        try {
            s = s.substring(s.indexOf("\t")+1, s.lastIndexOf("\t"));
        } catch (RuntimeException e){
            System.out.println(e.getCause().toString());
        }
    }
}
