package de.interaapps.web.javahtmldsl;

public class JavaHTMLDSL {
    public static String br = "<br>";
    public static String hr = "<hr>";

    public static String element(String name, DomElementEditor elementEditor){
        return elementEditor.edit(new DomElement(name)).build();
    }

    public static String element(String name, DomElementEditor elementEditor, String ...contents){
        return elementEditor.edit(new DomElement(name)).html(contents).build();
    }

    public static String element(String name){
        return new DomElement(name).build();
    }

    public static String element(String name, String ...contents){
        return new DomElement(name).html(contents).build();
    }

    public static String html(DomElementEditor elementEditor, String ...contents){
        return "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\">"+elementEditor.edit(new DomElement("html").html(contents)).build();
    }
    public static String html(String ...contents){
        return html($->$, contents);
    }


    public static String body(DomElementEditor elementEditor, String ...contents){
        return elementEditor.edit(new DomElement("body").html(contents)).build();
    }
    public static String body(String ...contents){
        return body($->$, contents);
    }

    public static String head(DomElementEditor elementEditor, String ...contents){
        return elementEditor.edit(new DomElement("head").html(contents)).build();
    }
    public static String head(String ...contents){
        return head($->$, contents);
    }
    public static String title(String contents){
        return new DomElement("title").html(contents).build();
    }

    //section Headings
    public static String h1(DomElementEditor elementEditor, String ...contents){
        return elementEditor.edit(new DomElement("h1").html(contents)).build();
    }
    public static String h1(String ...contents){
        return h1($->$, contents);
    }
    public static String h2(DomElementEditor elementEditor, String ...contents){
        return elementEditor.edit(new DomElement("h2").html(contents)).build();
    }
    public static String h2(String ...contents){
        return h2($->$, contents);
    }
    public static String h3(DomElementEditor elementEditor, String ...contents){
        return elementEditor.edit(new DomElement("h3").html(contents)).build();
    }
    public static String h3(String ...contents){
        return h3($->$, contents);
    }
    public static String h4(DomElementEditor elementEditor, String ...contents){
        return elementEditor.edit(new DomElement("h4").html(contents)).build();
    }
    public static String h4(String ...contents){
        return h4($->$, contents);
    }
    public static String h5(DomElementEditor elementEditor, String ...contents){
        return elementEditor.edit(new DomElement("h5").html(contents)).build();
    }
    public static String h5(String ...contents){
        return h5($->$, contents);
    }
    //endsection



    public static String p(DomElementEditor elementEditor, String ...contents){
        return elementEditor.edit(new DomElement("p").html(contents)).build();
    }
    public static String p(String ...contents){
        return p($->$, contents);
    }


    public static String img(DomElementEditor elementEditor, String src){
        return elementEditor.edit(new DomElement("img").src(src)).build();
    }
    public static String img(String src){
        return img($->$, src);
    }


    public static String div(DomElementEditor elementEditor, String ...contents){
        return elementEditor.edit(new DomElement("div").html(contents)).build();
    }
    public static String div(String ...contents){
        return div($->$, contents);
    }



    public static String ul(DomElementEditor elementEditor, String ...contents){
        return elementEditor.edit(new DomElement("ul").html(contents)).build();
    }
    public static String ul(String ...contents){
        return ul($->$, contents);
    }

    public static String ol(DomElementEditor elementEditor, String ...contents){
        return elementEditor.edit(new DomElement("ol").html(contents)).build();
    }
    public static String ol(String ...contents){
        return ol($->$, contents);
    }

    public static String li(DomElementEditor elementEditor, String ...contents){
        return elementEditor.edit(new DomElement("li").html(contents)).build();
    }
    public static String li(String ...contents){
        return li($->$, contents);
    }


    public interface DomElementEditor {
        DomElement edit(DomElement $);
    }

    public static String escape(String str){
        return DomElement.addSlashes(str);
    }
}
