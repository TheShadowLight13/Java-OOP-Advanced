package pr04;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(Arrays.asList(authors));
    }

    public String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return Collections.unmodifiableList(this.authors);
    }

    private void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public int compareTo(Book o) {
        if (this.getTitle().compareTo(o.getTitle()) == 0) {
            if (this.getYear() > o.getYear()) {
                return 1;
            } else if (this.getYear() < o.getYear()) {
                return -1;
            } else {
                return 0;
            }
        }
        return this.getTitle().compareTo(o.getTitle());
    }

    @Override
    public String toString() {
        return this.getTitle() + " " + this.getYear();
    }
}
