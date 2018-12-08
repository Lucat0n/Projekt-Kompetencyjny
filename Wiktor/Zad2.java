package Zad2;

public class Main {

    static{
        Student.getFieldsByAnnotation();
    }

    public static void main(String[] args) throws Exception{
        Student s = new Student(555555, "Alfred", "Nobel" , 3.0);
        Student s2 = new Student(123456, "Alfredzik", "Nobel" , 5.0);
        Student s3 = new Student(123456, "Alfred", "Nobel" , 5.0);

        if(s.equals(s2)) System.out.println("Podani studenci mają takie same dane");
        else System.out.println("Porównywane dane studentów różnią się od siebie");
        if(s.equals(s3)) System.out.println("Podani studenci mają takie same dane");
        else System.out.println("Porównywane dane studentów różnią się od siebie");

    }
}
