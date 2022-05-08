public class PracticeClass {
    private String name;
    private int age;

    public PracticeClass(String initialName) {
        this.age = 0;
        this.name = initialName;
    }

    public void printPerson() {
        System.out.println(this.name + ", age " + this.age + " years");
    }

    public void growOlder(PracticeClass test1){
        if(this.age < test1.age)
            this.age += 1;
    }

}
