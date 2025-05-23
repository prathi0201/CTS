public class PatternMatchingSwitch {
    public static void main(String[] args) {
        Object[] objects = {42, "Hello", 3.14, true, 'A', null};
        for (Object obj : objects) {
            printTypeInfo(obj);
        }
    }
    public static void printTypeInfo(Object obj) {
        String message = switch (obj) {
            case Integer i -> "It's an Integer with value: " + i;
            case String s -> "It's a String with value: \"" + s + "\"";
            case Double d -> "It's a Double with value: " + d;
            case Boolean b -> "It's a Boolean with value: " + b;
            case Character c -> "It's a Character with value: '" + c + "'";
            case null -> "It's a null reference";
            default -> "It's an unknown type: " + obj.getClass().getSimpleName();
        };
        System.out.println(message);
    }
}
