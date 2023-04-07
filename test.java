
import java.lang.instrument.Instrumentation;

public class Test{    
  public static void main(String[] args){
        boolean bool = true;
        System.out.println(ObjectUtils.dataTypeOf(bool)); 
        int i = 3;
        System.out.println(ObjectUtils.getObjectSizeOf(i));
        String str = "Namaste Sabko!";
        boolean isString = ObjectUtils.isInstanceOf(str, String.class);
        System.out.println("isString: " + isString);
        long unsignedInt = ObjectUtils.toUnsignedInt(-10);
        System.out.println("Unsigned int value: " + unsignedInt); 
    }
}
