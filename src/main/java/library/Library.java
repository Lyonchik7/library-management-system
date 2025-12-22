package library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private OperationLog operationLog;

    public static class OperationLog {
        public class LogEntry {
            private OperationType type;
            private String description;
            // конструктор и методы будут позже
        }
        
        public enum OperationType {
            ADD_BOOK, BORROW, RETURN
        }
        
        private List<LogEntry> entries;
        // методы будут позже
    }

    public Library() {
        books = new ArrayList<>();
        operationLog = new OperationLog();
    }
    
    // методы будут добавлены позже
}
