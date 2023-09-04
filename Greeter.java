import java.util.Locale;
import java.util.ResourceBundle;

public class Greeter {
  private Locale locale;
  private String name;

  public Greeter(String language, String country, String name) {
    this.locale = new Locale(language, country);
    this.name = name;
  }

  public String sayHello() {
    ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
    String greeting = messages.getString("greeting");
    return greeting + ", " + ""+name.toUpperCase()+"";
  }

  public static void main(String[] args) {
    if (args.length < 3) {
      System.out.println("The number of command line arguments is invalid.");
      return;
    }

    String language = args[0];
    String country = args[1];
    String name = String.join(" ", Arrays.copyOfRange(args, 2, args.length));

    Greeter greeter = new Greeter(language, country, name);
    System.out.println(greeter.sayHello());
  }
}
