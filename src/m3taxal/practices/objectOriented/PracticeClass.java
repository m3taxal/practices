package m3taxal.practices.objectOriented;

public class Person {
    private String name;
    private int age;

    public Person(String initialName) {
        this.age = 0;
        this.name = initialName;
    }

    public void printPerson() {
        System.out.println(this.name + ", age " + this.age + " years");
    }

    public void growOlder(){
        this.age += 1;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
