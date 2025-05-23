module com.utils {
    exports com.utils;
}
package com.utils;
public class StringUtils {
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }
}
module com.greetings {
    requires com.utils;
}
package com.greetings;
import com.utils.StringUtils;
public class Greeter {
    public static String getFormalGreeting(String name) {
        return "Dear " + StringUtils.capitalize(name) + ",";
    }
    public static String getFunGreeting(String name) {
        return "Hey " + StringUtils.reverse(name) + "!";
    }
}
package com.greetings;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  
        System.out.println("Welcome to the Greeter Module!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();        
        System.out.println("\nChoose greeting style:");
        System.out.println("1. Formal");
        System.out.println("2. Fun");
        System.out.print("Enter your choice (1-2): ");        
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            choice = 1; // default to formal
        }        
        String greeting;
        if (choice == 2) {
            greeting = Greeter.getFunGreeting(name);
        } else {
            greeting = Greeter.getFormalGreeting(name);
        }        
        System.out.println("\nYour greeting:");
        System.out.println(greeting);
        System.out.println("Have a nice day!");        
        scanner.close();
    }
}
javac -d com.utils/bin/com.utils src/com.utils/module-info.java src/com.utils/com/utils/StringUtils.java
javac --module-path com.utils/bin -d com.greetings/bin/com.greetings src/com.greetings/module-info.java src/com.greetings/com/greetings/*.java
jar --create --file=lib/com.utils.jar -C com.utils/bin/com.utils .
jar --create --file=lib/com.greetings.jar --main-class=com.greetings.Main -C com.greetings/bin/com.greetings .
java --module-path lib -m com.greetings
