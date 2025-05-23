public class MyClass {
    public int add(int a, int b) {
        int sum = a + b;
        System.out.println("Sum is: " + sum);
        return sum;
    }
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        int result = obj.add(10, 20);
        System.out.println("Result from main: " + result);
    }
}
