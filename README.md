# Java HTML DSL
> Test Project!
 
This is a Test Project, which allows you to create HTML from Java Code.
```java
import java.util.ArrayList;
import java.util.List;

import static de.interaapps.web.javahtmldsl.JavaHTMLDSL.*;

public class test {
    public static void main(String[] args) {
        List<String> example = new ArrayList<>();
        example.add("This is the first entry");
        example.add("This is the second entry");

        String html = html(
            head(
                title("Hello world")
            ),
            body(
            div(
                h1($->$.css("color", "#F00"), "Hello world"),
                br,
                element("h6", $->$.text("Custom Element"))),
                p("Hello\nWorld"),
                ul(
                    // Foreaches the list and sets the text of the element to the entry
                    li($->$.forList(example, (item, $e)->$e.text(item)))
                ),
                div( $->$.attr("data-test", "just another attribute"),
                    h2("Nice one")        
                )
            )
        );

        System.out.println(html);
    }
}

```
