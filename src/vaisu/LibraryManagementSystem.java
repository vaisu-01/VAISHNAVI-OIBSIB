package vaisu;


    import java.util.Scanner;

    public class LibraryManagementSystem {
        public static void main(String[] args) {
            loginAdmin();
        }
        private static void loginAdmin() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Admin Login:");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            if (validateAdmin(username, password)) {
                System.out.println("Login successful!");
                boolean exit = false;
                while (!exit) {
                    System.out.println(" select an option:");
                    System.out.println("1. Add a book");
                    System.out.println("2. Update a book");
                    System.out.println("3. Delete a book");
                    System.out.println("4. Add a member");
                    System.out.println("5. Update a member");
                    System.out.println("6. Delete a member");
                    System.out.println("7. Exit");
                    System.out.print("Enter your choice: ");
                    int select = scanner.nextInt();
                    switch (select) {
                        case 1:
                            addBook();
                            break;
                        case 2:
                            updateBook();
                            break;
                        case 3:
                            deleteBook();
                            break;
                        case 4:
                            addMember();
                            break;
                        case 5:
                            updateMember();
                            break;
                        case 6:
                            deleteMember();
                            break;
                        case 7:
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                }
            } else {
                System.out.println("Invalid login credentials. Please try again.");
            }
        }

        private static boolean validateAdmin(String username, String password)
        {
            return true;
        }
        private static void addBook() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Add Book:");
            System.out.println("Book  has been added successfully!");
        }
        private static void updateBook() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Update Book:");
            System.out.println("Book has been updated successfully!");
        }
        private static void deleteBook() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Delete a Book:");
            System.out.println("Book  has been deleted successfully!");
        }

        private static void addMember() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Add Member:");
            System.out.println("Member has been added successfully!");
        }
        private static void updateMember() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Update a Member:");
            System.out.println("Member has been updated successfully!");
        }
        private static void deleteMember() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Delete a Member:");
            System.out.println("Member has been deleted successfully!");
        }
    }

