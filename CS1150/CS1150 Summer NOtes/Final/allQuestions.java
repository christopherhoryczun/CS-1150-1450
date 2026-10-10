import java.util.Scanner;

public class AllQuestions {

    public static void main(String[] args) {
        // Uncomment the method call below to run that question's program:

        // question1();
        // question2();
        // question3();
        // question4();
        // question5();
        // question6();
        // question7();
        // question8();
        // question9();
    }

    // Question 1
    public static void question1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = scanner.nextInt();

        if (num > 0) {
            double result = Math.pow(2, num);
            System.out.println("2 raised to the power " + num + " is: " + (long) result);
        } else {
            System.out.println("The number is not positive.");
        }
        scanner.close();
    }

    // Question 2
    public static void question2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a double: ");
        double input = scanner.nextDouble();

        double sqrt = Math.sqrt(input);
        System.out.printf("Square root (4 significant figures): %.2f\n", sqrt);

        scanner.close();
    }

    // Question 3
    public static void question3() {
        boolean A = true;
        boolean B = false;

        System.out.println("1.) A && B = " + (A && B));              // false
        System.out.println("2.) !(A && B) = " + !(A && B));          // true
        System.out.println("3.) A || !B = " + (A || !B));            // true
        System.out.println("4.) A && (B || !A) = " + (A && (B || !A))); // false
        // Fixed typo from "B||B!" to "B || !B"
        System.out.println("5.) B || !B = " + (B || !B));            // true
    }

    // Question 4
    public static void question4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        if (isPrime(num)) {
            System.out.println(num + " is prime.");
        } else if (num % 2 == 0) {
            System.out.println(num + " is even.");
        } else {
            System.out.println(num + " is odd.");
        }
        scanner.close();
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Question 5
    public static void question5() {
        Scanner scanner = new Scanner(System.in);
        String password = "Test1234!@#$";
        String input;

        do {
            System.out.print("Enter the password: ");
            input = scanner.nextLine();

            if (input.equals(password)) {
                System.out.println("Correct password. Program ending.");
                break;
            } else {
                System.out.println("Incorrect password. Try again.");
            }
        } while (true);

        scanner.close();
    }

    // Question 6
    public static void question6() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int wordCount = countWords(input);
        System.out.println("Number of words: " + wordCount);

        scanner.close();
    }

    private static int countWords(String str) {
        if (str == null || str.isEmpty()) return 0;
        String[] words = str.trim().split("\\s+");
        return words.length;
    }

    // Question 7
    public static void question7() {
        char[] chars = new char[20];

        // Fill half of the array with letters a-j
        for (int i = 0; i < 10; i++) {
            chars[i] = (char) ('a' + i);
        }

        // Print chars if not default '\u0000'
        for (char c : chars) {
            if (c != '\u0000') {
                System.out.print(c + " ");
            }
        }
        System.out.println();
    }

    // Question 8
    public static void question8() {
        Person defaultPerson = new Person();
        Person student = new Person("Student", 20);

        System.out.println("Default Person: Name = " + defaultPerson.getName() + ", Age = " + defaultPerson.getAge());
        System.out.println("Student: Name = " + student.getName() + ", Age = " + student.getAge());
    }

    // Question 9
    public static void question9() {
        Animal animal = new Animal();
        Lion lion = new Lion();

        animal.display();
        lion.display();
    }
}

// Supporting classes for questions 8 and 9:

class Person {
    private String name;
    private int age;

    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
}

class Animal {
    public void display() {
        System.out.println("This is an animal");
    }
}

class Lion extends Animal {
    @Override
    public void display() {
        System.out.println("This is a tiger");
    }
}
