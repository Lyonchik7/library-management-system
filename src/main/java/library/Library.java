package library;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private OperationLog operationLog;

    // Вложенный класс для журнала операций
    public static class OperationLog {
        private List<String> entries; // Список записей журнала
        
        public OperationLog() {
            entries = new ArrayList<>();
        }
        
        // Метод добавления записи в журнал
        public void addEntry(String operation, String description) {
            String time = LocalDateTime.now().toString();
            entries.add("[" + time + "] " + operation + " - " + description);
        }
        
        // Метод печати журнала
        public void printLog() {
            if (entries.isEmpty()) {
                System.out.println("Журнал операций пуст.");
            } else {
                System.out.println("Журнал операций библиотеки:");
                for (String entry : entries) {
                    System.out.println(entry);
                }
                System.out.println();
            }
        }
    }

    // Конструктор библиотеки
    public Library() {
        books = new ArrayList<>();
        operationLog = new OperationLog();
    }

    // Добавить книгу в библиотеку
    public void addBook(Book book) {
        books.add(book);
        operationLog.addEntry("ADD_BOOK", "Добавлена книга: " + book.getTitle());
    }

    // Найти книгу по ID
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Найти книги по автору
    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // Выдать книгу
    public boolean borrowBook(int id) {
        Book book = findBookById(id);
        if (book == null) {
            System.out.println("Книга с ID " + id + " не найдена");
            return false;
        }
        
        if (!book.isAvailable()) {
            System.out.println("Книга " + book.getTitle() + " уже выдана");
            return false;
        }
        
        book.setAvailable(false);
        operationLog.addEntry("BORROW", "Выдана книга: " + book.getTitle());
        System.out.println("Книга успешно выдана: " + book.getTitle());
        return true;
    }

    // Вернуть книгу
    public boolean returnBook(int id) {
        Book book = findBookById(id);
        if (book == null) {
            System.out.println("Книга с ID " + id + " не найдена");
            return false;
        }
        
        if (book.isAvailable()) {
            System.out.println("Книга " + book.getTitle() + " уже в библиотеке");
            return false;
        }
        
        book.setAvailable(true);
        operationLog.addEntry("RETURN", "Возвращена книга: " + book.getTitle());
        System.out.println("Книга успешно возвращена: " + book.getTitle());
        return true;
    }

    // Получить список доступных книг
    public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                result.add(book);
            }
        }
        return result;
    }

    // Вывести журнал операций
    public void printOperationLog() {
        operationLog.printLog();
    }
    
    // Получить статистику
    public String getStatistics() {
        int total = books.size();
        int available = 0;
        for (Book book : books) {
            if (book.isAvailable()) {
                available++;
            }
        }
        int borrowed = total - available;
        
        return "Статистика библиотеки:\n" +
               "Всего книг: " + total + "\n" +
               "Доступно: " + available + "\n" +
               "Выдано: " + borrowed;
    }
}
