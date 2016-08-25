package dpa

class HelperTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    def page_title = {attrs ->
      out << splitCamelCase(attrs.str)
    }



    static String splitCamelCase(String s) {
     return s.replaceAll(
        String.format("%s|%s|%s",
           "(?<=[A-Z])(?=[A-Z][a-z])",
           "(?<=[^A-Z])(?=[A-Z])",
           "(?<=[A-Za-z])(?=[^A-Za-z])"
        ),
        " "
     );
    }
}
