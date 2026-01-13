package library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();


        
        Book book1 = new Book(1, "Война и мир", 
                "Л.Н. Толстой", 1869, "978-5-17-090335-2");
        
        Book book2 = new Book(2, "Мастер и Маргарита", 
                "М.А. Булгаков", 1967, "978-5-17-088818-5");
        
        Book book3 = new Book(3, "1984", 
                "Джордж Оруэлл", 1949, "978-5-17-099018-5");

        // Добавляем книги в библиотеку
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        System.out.println("ВЫПОЛНЕНИЕ ПРОГРАММЫ");
        
        System.out.println("\n1. Выдача книги ID: 1");
        library.borrowBook(1);
        
        System.out.println("\n2. Доступные книги:");
        for (Book book : library.getAvailableBooks()) {
            System.out.println(book.getTitle());
        }
        
        System.out.println("\n3. Возврат книги ID: 1");
        library.returnBook(1);
        
        library.printOperationLog();
    }
}
