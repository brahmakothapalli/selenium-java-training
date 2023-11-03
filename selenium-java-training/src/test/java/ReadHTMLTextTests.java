import org.jsoup.Jsoup;
import org.testng.annotations.Test;

public class ReadHTMLTextTests {

    @Test
    public void testHtml(){
        String htmlText = "'<html>A signed TMHCC application (<a href= \\\"https://www.nasinsurance.com/var/documents/NGPNBA-12022.pdf\\\" target=\\\"_blank\\\" rel=\\\"noopener noreferrer\\\">NGPNBA-12022</a>) <b>Required to backdate within 7 days of the effective date:</b> the application must be signed within one business day of the date you placed the order or thereafter. By uploading the application you are confirming it is meets the aforementioned requirements. If the application does not meet the requirements, do not submit it; obtain a resigned application.</html>', '1', '2429403'";
        String htmlText1 = "'<html>A completed D1 Disclosure Notice (<a href=\\\"http://www.nasinsurance.com/var/documents/D-1.pdf\\\" target=\\\"_blank\\\" rel=\\\"noopener noreferrer\\\">D-1 Form</a>).</html>', '0', '2429403'";
        String htmlText2 = "'<html>Receipt of a State of California Producer License copy from the Broker working directly with the Insured.</html>', '0', '2429403'";
        String textOnly = Jsoup.parse(htmlText).text();
        String textOnly1 = Jsoup.parse(htmlText1).text();
        String textOnly2 = Jsoup.parse(htmlText2).text();
//        System.out.println(textOnly.split("'")[0]);
        System.out.println(textOnly.split("'")[1]);
        System.out.println(textOnly1.split("'")[1]);
        System.out.println(textOnly2.split("'")[1]);
    }
}
