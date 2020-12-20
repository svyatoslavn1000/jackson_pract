import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        readTree();
        pointer();
        simpleSerialisation();
    }

    private static void simpleDeserialisation() throws IOException {

    }

    private static void simpleSerialisation() throws IOException {
        Category category = new Category();
        category.setId(123);
        category.setName("Science");
        category.setCountBook(3);

        Book book = new Book();
        book.setName("Book");
        book.setCategory(category);
        List<Book> books = new ArrayList<Book>();
        books.add(book);
        category.setBooks(books);

        String categoryJson = objectMapper.writerWithDefaultPrettyPrinter()
 //               .withView(CategoryViews.IdView.class)
                .writeValueAsString(category);

        System.out.println(categoryJson);
    }

    private static void pointer() throws IOException {
        URL resource = Main.class.getResource("/category.json");
        Category category = objectMapper.readValue(resource, Category.class);
        System.out.println(category.toString());
    }

//    private static void readArray() throws IOException {
//        URL resource = Main.class.getResource("/array.json");
//        ArrayNode arrayNode = (ArrayNode) objectMapper.readTree(resource);
//        for (JsonNode jsonNode : arrayNode) {
//            if (jsonNode instanceof ObjectNode) {
//
//                for (Iterator<String> it = jsonNode.fieldNames(): it.hasNext(); ){
//                    String nameField = it.next();
//                    jsonNode.get(nameField);
//                }
//            }else if(jsonNode instanceof BooleanNode){
//
//            }
//        }
//    }

    private static void readTree() throws IOException {
        URL resource = Main.class.getResource("/simple.json");
        JsonNode jsonNode = objectMapper.readTree(resource);
        System.out.println(jsonNode.get("first_name").asText());
        System.out.println(jsonNode.get("websites").get(0).get("description").asText());
    }
}
