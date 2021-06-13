package de.interaapps.web.javahtmldsl;

import org.apache.commons.text.StringEscapeUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomElement implements Cloneable {
    private String name;
    private String innerHTML = "";
    private List forList;
    private ForDomEditor forDomEditor;
    private boolean ifCond = true;
    private String css;
    private Map<String, String> attributes = new HashMap<>();

    public DomElement(String name) {
        this.name = name;
    }

    public DomElement html(String ...innerHTML){
        this.innerHTML = String.join("",innerHTML);
        return this;
    }

    public DomElement text(String innerText){
        this.innerHTML = StringEscapeUtils.escapeHtml4(innerText).replaceAll("\n", "<br>");
        return this;
    }

    public DomElement append(String innerHTML){
        this.innerHTML = innerHTML;
        return this;
    }

    public DomElement appendText(String innerHTML){
        this.innerHTML += innerHTML;
        return this;
    }

    public DomElement css(String style){
        css = style;
        return this;
    }

    public DomElement appendCss(String style){
        if (css == null) css = "";
        css += style;
        return this;
    }

    public DomElement css(String name, String value){
        appendCss(name+": "+value+";");
        return this;
    }

    public DomElement attr(String name, String value){
        attributes.put(name, value);
        return this;
    }

    public DomElement src(String value){
        attr("src", value);
        return this;
    }

    public DomElement type(String value){
        attr("type", value);
        return this;
    }

    public DomElement href(String value){
        attr("href", value);
        return this;
    }

    public DomElement target(String value){
        attr("target", value);
        return this;
    }

    public DomElement name(String value){
        attr("name", value);
        return this;
    }

    public DomElement content(String value){
        attr("content", value);
        return this;
    }
    public DomElement width(String value){ attr("width", value); return this;  }
    public DomElement height(String value){ attr("height", value); return this;  }

    public DomElement width(int value){ attr("width", value+"px"); return this;  }
    public DomElement height(int value){ attr("height", value+"px"); return this;  }

    public DomElement className(String value){
        attr("class", value);
        return this;
    }

    public DomElement addClass(String value){
        if (!attributes.containsKey("class")) className(value);
        else
            attributes.put("class", attributes.get("class")+" "+value);
        return this;
    }

    public DomElement ifCondition(boolean ifCond) {
        this.ifCond = ifCond;
        return this;
    }

    public <T> DomElement forList(List<T> list, ForDomEditor<T> forDomEditor){
        forList = list;
        this.forDomEditor = forDomEditor;
        return this;
    }

    public String build() {
        if (!ifCond) return "";
        StringBuilder stringBuilder = new StringBuilder();

        if (forList == null) {
            stringBuilder.append("\n<").append(name);
            if (css != null)
                attr("style", css);

            attributes.forEach((key,val) -> {
                stringBuilder
                        .append(' ')
                        .append(key)
                        .append("=")
                        .append('"')
                        .append(addSlashes(val))
                        .append('"');
            });

            stringBuilder.append(">");
            stringBuilder.append(innerHTML);
            stringBuilder.append("</").append(name).append(">\n");
        } else {
            stringBuilder.setLength(0);
            forList.forEach(item -> {
                try {
                    DomElement domElement = (DomElement) clone();
                    domElement.forList = null;
                    domElement.forDomEditor = null;
                    forDomEditor.forEach(item, domElement);
                    stringBuilder.append(domElement.build());
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            });
        }
        return stringBuilder.toString();
    }

    public interface ForDomEditor<T> {
        void forEach(T item, DomElement $);
    }

    public String toString() {
        return build();
    }


    public static String addSlashes(String s) {
        s = s.replaceAll("\\\\", "\\\\\\\\");
        s = s.replaceAll("\\n", "\\\\n");
        s = s.replaceAll("\\r", "\\\\r");
        s = s.replaceAll("\\00", "\\\\0");
        s = s.replaceAll("\"", "\\\\\"");
        return s;
    }

}
