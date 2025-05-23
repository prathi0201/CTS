import j ReflectionDemo.javaava.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Scanner;
public class ReflectionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String className = "MyDynamicClass"; // Our target class
        try {   
            Class<?> targetClass = Class.forName(className);
            System.out.println("\nSuccessfully loaded class: " + targetClass.getName());      
            System.out.println("\n--- Declared Methods of " + targetClass.getName() + " ---");
            Method[] methods = targetClass.getDeclaredMethods();
            for (Method method : methods) {
                System.out.print("  Method Name: " + method.getName() + " (");
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    System.out.print(parameterTypes[i].getSimpleName());
                    if (i < parameterTypes.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println(") - Modifiers: " + Modifier.toString(method.getModifiers()));
            }
          int.class).newInstance("Name", 30);
            Object instance = targetClass.getDeclaredConstructor().newInstance();
            System.out.println("\nInstance of " + className + " created.");          
            System.out.println("\n--- Invoke Methods Dynamically ---");
            while (true) {
                System.out.print("\nEnter method name to invoke (or 'exit' to quit): ");
                String methodName = scanner.nextLine().trim();
                if (methodName.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.print("Enter comma-separated argument types (e.g., int,java.lang.String or leave blank for no args): ");
                String argTypesStr = scanner.nextLine().trim();
                System.out.print("Enter comma-separated arguments (e.g., 10,20 or \"Hello\" or leave blank for no args): ");
                String argsStr = scanner.nextLine().trim();
                try {
                    Class<?>[] paramTypes = new Class<?>[0];
                    if (!argTypesStr.isEmpty()) {
                        String[] typeNames = argTypesStr.split(",");
                        paramTypes = new Class<?>[typeNames.length];
                        for (int i = 0; i < typeNames.length; i++) {
                            // Basic type mapping; for real app, use a more robust converter
                            switch (typeNames[i].trim()) {
                                case "int": paramTypes[i] = int.class; break;
                                case "boolean": paramTypes[i] = boolean.class; break;
                                case "double": paramTypes[i] = double.class; break;
                                case "long": paramTypes[i] = long.class; break;
                                case "float": paramTypes[i] = float.class; break;
                                case "char": paramTypes[i] = char.class; break;
                                case "short": paramTypes[i] = short.class; break;
                                case "byte": paramTypes[i] = byte.class; break;
                                default: paramTypes[i] = Class.forName(typeNames[i].trim()); // For object types like java.lang.String
                            }
                        }
                    }
                    Object[] invokeArgs = null;
                    if (!argsStr.isEmpty()) {
                        String[] argValues = argsStr.split(",");
                        invokeArgs = new Object[argValues.length];
                        for (int i = 0; i < argValues.length; i++) {
                            // Basic argument parsing based on inferred type; more robust parsing needed for real app
                            if (paramTypes.length > i) {
                                if (paramTypes[i] == int.class || paramTypes[i] == Integer.class) {
                                    invokeArgs[i] = Integer.parseInt(argValues[i].trim());
                                } else if (paramTypes[i] == boolean.class || paramTypes[i] == Boolean.class) {
                                    invokeArgs[i] = Boolean.parseBoolean(argValues[i].trim());
                                } else if (paramTypes[i] == double.class || paramTypes[i] == Double.class) {
                                    invokeArgs[i] = Double.parseDouble(argValues[i].trim());
                                } else if (paramTypes[i] == long.class || paramTypes[i] == Long.class) {
                                    invokeArgs[i] = Long.parseLong(argValues[i].trim());
                                } else if (paramTypes[i] == float.class || paramTypes[i] == Float.class) {
                                    invokeArgs[i] = Float.parseFloat(argValues[i].trim());
                                } else if (paramTypes[i] == char.class || paramTypes[i] == Character.class) {
                                    invokeArgs[i] = argValues[i].trim().charAt(0);
                                } else if (paramTypes[i] == short.class || paramTypes[i] == Short.class) {
                                    invokeArgs[i] = Short.parseShort(argValues[i].trim());
                                } else if (paramTypes[i] == byte.class || paramTypes[i] == Byte.class) {
                                    invokeArgs[i] = Byte.parseByte(argValues[i].trim());
                                } else if (paramTypes[i] == String.class) {
                                    invokeArgs[i] = argValues[i].trim().replace("\"", ""); // Remove quotes if present
                                } else {
                                    // For other object types, you'd need more sophisticated parsing/deserialization
                                    invokeArgs[i] = argValues[i].trim();
                                }
                            } else {                              
                                invokeArgs[i] = argValues[i].trim().replace("\"", "");
                            }
                        }
                    }          
                    Method methodToInvoke = targetClass.getDeclaredMethod(methodName, paramTypes);            
                    if (!methodToInvoke.trySetAccessible()) {
                        System.out.println("Warning: Could not make method " + methodName + " accessible. It might be private or protected.");
                    }             
                    System.out.println("\n--- Invoking method '" + methodName + "' ---");
                    Object result = methodToInvoke.invoke(instance, invokeArgs);
                    if (methodToInvoke.getReturnType() != void.class) {
                        System.out.println("Method returned: " + result);
                    }
                } catch (NoSuchMethodException e) {
                    System.err.println("Error: Method not found with the specified name and parameter types. " + e.getMessage());
                    System.err.println("Available methods might include: " + Arrays.stream(targetClass.getDeclaredMethods())
                        .map(m -> m.getName() + "(" + Arrays.toString(m.getParameterTypes()) + ")")
                        .reduce((a, b) -> a + ", " + b)
                        .orElse("No methods found."));
                } catch (InvocationTargetException e) {
                    System.err.println("Error during method invocation (method threw an exception): " + e.getTargetException().getMessage());
                } catch (IllegalAccessException e) {
                    System.err.println("Error: Cannot access method. Ensure it's public or trySetAccessible() worked. " + e.getMessage());
                } catch (InstantiationException e) {
                    System.err.println("Error creating instance: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.err.println("Error: Invalid arguments provided for method. " + e.getMessage());
                } catch (ClassNotFoundException e) {
                    System.err.println("Error: Specified parameter type class not found. " + e.getMessage());
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Class not found: " + className + ". Make sure it's in the classpath.");
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.err.println("Error initializing target class: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
        System.out.println("\nReflection demo finished.");
    }
}
