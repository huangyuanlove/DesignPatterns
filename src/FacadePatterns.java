import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

/**
 * 外观模式
 */
public class FacadePatterns {

    public static void main(String[] args) {
        PageMaker.makeWelcomePage("xuan@huangyuanlove.com","welcome.html");
    }
}

class DataBase {
    private DataBase() {
    }

    public static Properties getProperties(String dbName) {
        String fileName = dbName + ".txt";
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}

class HtmlWriter {
    private Writer writer;

    public HtmlWriter(Writer writer) {
        this.writer = writer;
    }

    public void title(String title) throws IOException {
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>" + title + "</title>");
        writer.write("</head>");
        writer.write("<body>\n");
        writer.write("<h1>" + title + "</h1>\n");
    }

    public void paragraph(String msg) throws IOException {
        writer.write("<p>" + msg + "</p>\n");
    }

    public void link(String href, String caption) throws IOException {
        writer.write("<a href=\"" + href + "\">" + caption + "</a>");
    }

    public void mailto(String mailAddr, String userName) throws IOException {
        link("mailto:" + mailAddr, userName);
    }

    public void close() throws IOException {
        writer.write("</body>");
        writer.write("</html>");
        writer.close();
    }
}

class PageMaker {
    private PageMaker() {
    }

    public static void makeWelcomePage(String mailAddr, String fileName) {
        try {
            Properties mailPro = DataBase.getProperties("maildata");
            String userName = mailPro.getProperty(mailAddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(fileName));
            writer.title("Welcome to " + userName + "'s page");
            writer.paragraph(userName + "欢迎来到" + userName + "的主页");
            writer.paragraph("等着你的邮件");
            writer.mailto(mailAddr, userName);
            writer.close();
            System.out.println(fileName + " is create for " + mailAddr + "(" + userName + ")");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

