package oshai;

public class JavaService {

    public static void main(String[] args) {
        System.out.println("hello java");
        System.out.println(new KotlinService("hi").getName());
        System.out.println(new ScalaService("hi").name());
        System.out.println(new KotlinDataService("hi"));
        System.out.println(KotlinDataService.class);
        System.out.println(new ScalaCaseService("hi"));
        System.out.println(ScalaCaseService.apply("bb"));
        System.out.println(SingleS$.MODULE$);
        System.out.println(SingleK.INSTANCE);
    }
}
