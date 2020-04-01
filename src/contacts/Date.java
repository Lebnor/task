package contacts;

import java.time.LocalDateTime;

public class Date {

    private LocalDateTime creationDate;
    private LocalDateTime lastEdited;

    public Date() {
        this.creationDate = LocalDateTime.now();
        this.lastEdited = LocalDateTime.now();
    }

    public void edited() {
        this.lastEdited = LocalDateTime.now();
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getLastEdited() {
        return lastEdited;
    }
}
