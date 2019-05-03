public class Human {
    //thuoc tinh
    String name;//null
    int age;//=0
    String gender;//null

    //ham tao
    public Human(){
        name="new person";
        age=20;
        gender="male";
    }
    //ham tao day du
    public Human(String name, int age, String gender){
        this.name=name;
        this.age=age;
        this.gender=gender;
    }
    //phuong thuc
    public void eat(){
        System.out.println(name+"eating..");

    }
    public void sleep(){
        System.out.println(name+"sleeping..");
    }
}

//Ctrl shift z >< Ctrl z
//Alt Enter: sua loi code
//(fn +) shift +F6: doi ten
// Ctrl+D: duplicate
