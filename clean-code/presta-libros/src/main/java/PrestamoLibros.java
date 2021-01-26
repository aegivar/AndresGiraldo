import java.util.Date;

public class PrestamoLibros {
    private String IdLend;
    private Libro book;
    private Date endDate;

    public PrestamoLibros(String idLend, Libro book, Date endDate) {
        IdLend = idLend;
        this.book = book;
        this.endDate = endDate;
    }

    public String getIdLend() {
        return IdLend;
    }

    public void setIdLend(String idLend) {
        IdLend = idLend;
    }

    public Libro getBook() {
        return book;
    }

    public void setBook(Libro book) {
        this.book = book;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int timeElapsed(){
        int elapsedDays = 3;
        return elapsedDays;
    }

    public int remainingDays() {
        int remainingDays = 10;
        return remainingDays;
    }


}
