
import java.util.ArrayList;
import java.util.List;

import static de.interaapps.web.javahtmldsl.JavaHTMLDSL.*;

public class test {
    public static void main(String[] args) {
        List<String> example = new ArrayList<>();
        example.add("Hee");
        example.add("Yoo");

        String html = html( $->$.attr("lang", "de-DE"),
                head(
                        title("Hello world")
                ),
                body(
                        div(
                            h1($->$.css("color", "#F00"), "Hello world"),
                            br,
                            element("h6", $->$.text("Custom Element"))
                        ),
                        img("https://cdn.interaapps.de/icon/interaapps/pastefy.png"),
                        img($->$.width(10).height(30), "https://cdn.interaapps.de/icon/interaapps/pastefy.png"),
                        p("Hello\nWorld"),
                        ul(
                                // Foreaches the list and sets the text of the element to the entry
                                li($->$.forList(example, (item, $e)->$e.text(item)))
                        )
                )
        );

        System.out.println(html);
    }
}
