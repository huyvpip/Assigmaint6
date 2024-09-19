package Student.v5;

import java.util.Date;

public abstract class Person {
    private String id;
    private String fullName;
    private Date dateOfBirth;
    private Date bookBorrowDate;
    private Date bookReturnDate;

    public Person(String id, String fullName, Date dateOfBirth, Date bookBorrowDate, Date bookReturnDate) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.bookBorrowDate = bookBorrowDate;
        this.bookReturnDate = bookReturnDate;
    }

    // Getters and Setters for all attributes
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public Date getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public Date getBookBorrowDate() { return bookBorrowDate; }
    public void setBookBorrowDate(Date bookBorrowDate) { this.bookBorrowDate = bookBorrowDate; }

    public Date getBookReturnDate() { return bookReturnDate; }
    public void setBookReturnDate(Date bookReturnDate) { this.bookReturnDate = bookReturnDate; }

    public boolean isBookOverdue() {
        long diff = bookReturnDate.getTime() - bookBorrowDate.getTime();
        long daysDiff = diff / (1000 * 60 * 60 * 24);  // convert to days
        return daysDiff >= 30;
    }

    // Abstract methods
    public abstract void addPerson();
    public abstract void updatePerson(String id);
    public abstract void displayInfo();
}