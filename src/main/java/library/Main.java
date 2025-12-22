package library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book(1, "Война и мир", 
                "Л.Н. Толстой", 1869, "978-5-17-090335-2"));
        library.addBook(new Book(2, "Преступление и наказание", 
                "Ф.М. Достоевский", 1866, "978-5-17-090336-9"));
        library.addBook(new Book(3, "Анна Каренина", 
                "Л.Н. Толстой", 1877, "978-5-17-090337-6"));

        System.out.println("=== ДЕМОНСТРАЦИЯ ===");
        
        System.out.println("\n1. Выдача книги ID: 1");
        library.borrowBook(1);
        
        System.out.println("\n2. Доступные книги:");
        library.getAvailableBooks().forEach(b -> System.out.println(b.getTitle()));
        
        System.out.println("\n3. Возврат книги ID: 1");
        library.returnBook(1);
        
        library.printOperationLog();
    }
}
