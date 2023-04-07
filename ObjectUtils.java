package ObjectUtils;


import java.lang.instrument.Instrumentation;

public class ObjectUtils
{
    private static Instrumentation instrumentation;
    
    // method to create the 
    public static void premain(String args, Instrumentation instrumentation){
        ObjectUtils.instrumentation = instrumentation;
    }
    
    // taking the user declared data as input and comparing it with every data-type to check it
    public static String dataTypeOf(Object input){ 
        if(input instanceof String){
            return "string";
        }
        
        else if(input instanceof Integer){
            return "integer";
        }
        
        else if(input instanceof Double){
            return "double";
        }
        
        else if(input instanceof Float){
            return "floating-point";
        }
        
        else if(input instanceof Boolean){
            return "boolean";
        }
        
        else if(input instanceof Long){
            return "long";
        }
        
        else if(input instanceof Character){
            return "character";
        }
        
        else if(input instanceof Short){
            return "short";
        }
        
        else if(input instanceof Byte){
            return "byte";
        }
        
        else{
            return "Unknown";
        }
    }
    /* Example of working -->
        boolean bool = true;
        System.out.println(JavaUtils.dataTypeOf(bool)); //Output: boolean
    */
    

    // taking the user declared data as input and finding size of every data-type
    public static long getObjectSizeOf(Object input) {
        if (instrumentation == null) {
            throw new IllegalStateException("Agent not initialized");
        }

        return instrumentation.getObjectSize(input);
    }
    /* Example of working -->
       double d = 3.14;
       System.out.println(JavaUtils.getObjectSizeOf(d)); //Output: 24
    */
    
    
    // taking the user declared data as input and checking if the input belongs to the desired class or not
    public static boolean isInstanceOf(Object obj, Class<?> clazz) {
        return clazz.isInstance(obj);
    }
    /*Example of working -->
      String str = "Hello World!";
      boolean isString = JavaUtils.isInstanceOf(str, String.class);
      System.out.println("isString: " + isString); // Output: isString: true
    */
    
    
    // interface to initiate the user defined Function using lambda function as like in c++
    public interface Function<T, R> {
        R apply(T type);
    }
    // to directly create a desired one liner lambda function for the desired variable
    public static <T, R> R apply(T type, Function<T, R> function) {
        return function.apply(type);
    }
    /*Example of working -->
      Function<Integer, Integer> square = x -> x * x;
      int result = ObjectUtils.apply(5, square);
      System.out.println("Result: " + result); // Output: Result: 25
    */
    
    
    // to convert integer to unsigned int 
    public static long toUnsignedInt(int input) {
        return input & 0xFFFFFFFFL;
    }
    /* Example of working -->
       //int signedInt = -10;
       long unsignedInt = JavaUtils.toUnsignedInt(-10);
       System.out.println("Unsigned int value: " + unsignedInt); // Output: Unsigned int value: 4294967286
    */
}
