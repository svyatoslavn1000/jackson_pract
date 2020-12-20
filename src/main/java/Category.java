import com.fasterxml.jackson.annotation.*;

import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "CATEGORY_ID")
public class Category {

    @JsonView(CategoryViews.IdView.class)
    private long id;
    @JsonView(CategoryViews.NameView.class)
    private String name;

    @JsonView(CategoryViews.FullView.class)
    private int countBook;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    private List<Book> books;

    public int getCountBook() {
        return countBook;
    }

    public void setCountBook(int countBook) {
        this.countBook = countBook;
    }

    @JsonIgnore
    public String getLogin(){
        return "login";
    }

   // @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("CATEGORY_ID")
    public void setId(long id) {
        this.id = id;
    }
  //  @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("CATEGORY_NAME")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countBook=" + countBook +
                ", books=" + books +
                '}';
    }
}
