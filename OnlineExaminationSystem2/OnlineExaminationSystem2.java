import java.util.*;

public class OnlineExaminationSystem2 {
    static Scanner sc = new Scanner(System.in);
    static Map<String, String> users = new HashMap<>();
    static boolean isLoggedIn = false;
    static int score = 0;

    public static void main(String[] args) {
        // Student login credentials
        users.put("student1", "12345");
        users.put("admin", "admin");

        System.out.println("*** Welcome to the Online Examination System ***");

        if (login()) {
            showMenu();
        } else {
            System.out.println("Invalid login. Exiting...");
        }
    }

    // Login Method
    static boolean login() {
        System.out.print("Enter your name: ");
        String uname = sc.nextLine();
        System.out.print("Enter your password: ");
        String pass = sc.nextLine();

        if (users.containsKey(uname) && users.get(uname).equals(pass)) {
            isLoggedIn = true;
            System.out.println("Login successful!\n");
            return true;
        } else {
            return false;
        }
    }

    // Menu Method
    static void showMenu() {
        int choice;
        do {
            System.out.println("\n===== Main Menu =====");
            System.out.println("1. Start Exam");
            System.out.println("2. View Score");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (choice) {
                    case 1:
                        startExam();
                        break;
                    case 2:
                        System.out.println("Your current score: " + score);
                        break;
                    case 3:
                        System.out.println("Logged out successfully!");
                        isLoggedIn = false;
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // clear invalid input
                choice = -1;
            }
        } while (isLoggedIn);
    }

    // Exam Method
    static void startExam() {
        System.out.println("\n*** Exam Started ***");
        score = 0;

        // Question1
        System.out.println("Question1. What is the capital of India?");
        System.out.println("(a) Mumbai\n(b) Delhi\n(c) Kolkata\n(d) Chennai");
        System.out.print("Answer: ");
        String answer1 = sc.nextLine();
        if (answer1.equalsIgnoreCase("b")) score++;

        // Question2
        System.out.println("Question2. Which language runs on JVM?");
        System.out.println("(a) Python\n(b) C++\n(c) Java\n(d) Kotlin");
        System.out.print("Answer: ");
        String answer2 = sc.nextLine();
        if (answer2.equalsIgnoreCase("c")) score++;

        // Question3
        System.out.println("Question3. 2 + 2 = ?");
        System.out.println("(a) 3\n(b) 4\n(c) 5\n(d) 6");
        System.out.print("Answer: ");
        String answer3 = sc.nextLine();
        if (answer3.equalsIgnoreCase("b")) score++;

        System.out.println("\nExam finished. Your score is: " + score + "/3");
    }
}
