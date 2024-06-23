# ObjectUtils
Java library to implement functions which are already available in other languages but not in java!!

  1. dataTypeOf() -> to find the datatype of the input or already initialized variable
  2. getObjectSizeOf() -> to find the size of every data-type
  3. isInstanceOf() -> tells whether the declared or pre existing variable belongs to the defined class or not
  4. apply() -> works as a lambda function for the language (building a functionality in one line)
  5. toUnsignedInt() -> converts the integer type data type value to unsigned Integer


## Table of Contents
1. Instrumentation Setup
2. Data Type Identification
3. Object Size Calculation
4. Instance Type Checking
5. Lambda Function Application
6. Integer to Unsigned Integer Conversion
7. Usage Examples


## Instrumentation Setup
To enable object size calculation, Java instrumentation must be set up. This is done using the premain method, which is called before the main method of the application.
```
public static void premain(String args, Instrumentation instrumentation) {
    ObjectUtils.instrumentation = instrumentation;
}
```


## Data Type Identification
The dataTypeOf method takes an object as input and returns a string indicating the data type of the object.
```
public static String dataTypeOf(Object input) {
    if (input instanceof String) {
        return "string";
    } else if (input instanceof Integer) {
        return "integer";
    } else if (input instanceof Double) {
        return "double";
    } else if (input instanceof Float) {
        return "floating-point";
    } else if (input instanceof Boolean) {
        return "boolean";
    } else if (input instanceof Long) {
        return "long";
    } else if (input instanceof Character) {
        return "character";
    } else if (input instanceof Short) {
        return "short";
    } else if (input instanceof Byte) {
        return "byte";
    } else {
        return "Unknown";
    }
}
```


## Object Size Calculation
The getObjectSizeOf method returns the size of the given object in bytes. This method requires that the Java agent is initialized.
```
public static long getObjectSizeOf(Object input) {
    if (instrumentation == null) {
        throw new IllegalStateException("Agent not initialized");
    }
    return instrumentation.getObjectSize(input);
}
```


## Instance Type Checking
The isInstanceOf method checks if an object is an instance of a specified class.
```
public static boolean isInstanceOf(Object obj, Class<?> clazz) {
    return clazz.isInstance(obj);
}
```


## Lambda Function Application
The apply method allows the application of a lambda function to a given input. It uses a user-defined interface Function.
```
public interface Function<T, R> {
    R apply(T type);
}

public static <T, R> R apply(T type, Function<T, R> function) {
    return function.apply(type);
}
```


## Integer to Unsigned Integer Conversion
The toUnsignedInt method converts a signed integer to its unsigned equivalent.
```
public static long toUnsignedInt(int input) {
    return input & 0xFFFFFFFFL;
}
```


## Usage Examples
### Data Type Identification
```
boolean bool = true;
System.out.println(ObjectUtils.dataTypeOf(bool)); // Output: boolean
```

### Object Size Calculation
```
double d = 3.14;
System.out.println(ObjectUtils.getObjectSizeOf(d)); // Output: 24
```

### Instance Type Checking
```
String str = "Hello World!";
boolean isString = ObjectUtils.isInstanceOf(str, String.class);
System.out.println("isString: " + isString); // Output: isString: true
```

### Lambda Function Application
```Function<Integer, Integer> square = x -> x * x;
int result = ObjectUtils.apply(5, square);
System.out.println("Result: " + result); // Output: Result: 25
```

### Integer to Unsigned Integer Conversion
```
int signedInt = -10;
long unsignedInt = ObjectUtils.toUnsignedInt(signedInt);
System.out.println("Unsigned int value: " + unsignedInt); // Output: Unsigned int value: 4294967286
```
