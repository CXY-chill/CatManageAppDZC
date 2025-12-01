public class Cat {
    private int id;
    private String name;
    private int age;
    private String breeds;
    private int price;
    private String description;
    private int state;
    public Cat(int id, String name,int age, String breeds,int price, String description, int state){
        this.id = id;
        this.name = name;
        this.age = age;
        this.breeds = breeds;
        this.price = price;
        this.description = description;
        this.state = state;
    }
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreeds() {
        return breeds;
    }

    public void setBreeds(String breeds) {
        this.breeds = breeds;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public String toString(){
        return "Cat["+ "id="+id +",name="+ name+ ",age=" + age +",breeds=" + breeds +",price=" + price +",description=" + description + "]";
    }
}