import java.util.Scanner;

public class CatManageApp {
    private static Cat[] cats = new Cat[100];
    private static int maxIndex = -1;
    static void main(String[] args) {
        System.out.println("Welcome to use simple cat manage system");
        Scanner sc = new Scanner(System.in);
       int select = 0;
        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println("------1Save  2Delete  3Modify  4Query  5PrintAll--------");
            System.out.println("--------------------------------------------------------");
            System.out.println("Please enter the business you want to select");
            select = sc.nextInt();
            switch (select) {
                case 1:
                    save();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    modify();
                    break;
                case 4:
                    query();
                    break;
                case 5:
                    printAll();
                    break;
                default:
                    System.out.println("Your choice is wrong.Please choose again.");
            }
        }

    }

    private static void save() {
        System.out.println("---------------Save cats--------------");
        maxIndex ++;
        Scanner sc = new Scanner(System.in);
        int id = createNo();
        System.out.println("Name");
        String name = sc.next();
        System.out.println("Age");
        int age = sc.nextInt();
        System.out.println("Breeds");
        String breeds = sc.next();
        System.out.println("Price");
        int price = sc.nextInt();
        System.out.println("Description");
        String description = sc.next();
        Cat a = new Cat(id,name,age,breeds,price,description,1);
        cats[maxIndex] = a;
    }
    private static void delete() {
        System.out.println("---------------Delete cats--------------");
        System.out.println("Please enter the cat ID you want to delete:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        int index = findIndex(id);
        if(cats[index].getState() ==0){
            System.out.println("This cat is deleted.");
            return;
        }
        printCat(index);
        System.out.println("Are you sure you want to delete the cat? 1Yes 2No");
        int answer = sc.nextInt();
        if (answer == 1){
            cats[index].setState(0);
            System.out.println("Delete successfully!");
        }
    }
    private static void modify() {
        System.out.println("----------------Modify cats--------------");
        System.out.println("Please enter the cat ID you want to modify:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        int index = findIndex(id);
        if(cats[index].getState() == 0){
            System.out.println("This cat is modified.");
            return;
        }
        printCat(index);
        System.out.println("Please enter new cat' information:");
        System.out.println("Name");
        String name = sc.next();
        System.out.println("Age");
        int age = sc.nextInt();
        System.out.println("Breeds");
        String breeds = sc.next();
        System.out.println("Price");
        int price = sc.nextInt();
        System.out.println("Description");
        String description = sc.next();
        cats[index].setName(name);
        cats[index].setAge(age);
        cats[index].setBreeds(breeds);
        cats[index].setPrice(price);
        cats[index].setDescription(description);
        System.out.println("Modify successfully!");
    }
    private static void query() {
        System.out.println("----------------Query cats--------------");
        System.out.println("-------1name  2age  3breeds--------");
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();
        if (select == 1) {
            System.out.println("Please enter cats' name:");
            String name = sc.next();
            for (int i = 0; i <= maxIndex; i++) {
                if (cats[i].getName().contains(name) && cats[i].getState() == 1) {
                    System.out.println(cats[i]);
                }
            }

        } else if (select == 2) {
            System.out.println("Please enter cats' age:");
            int age = sc.nextInt();
            for (int i = 0; i <= maxIndex; i++) {
                if (cats[i].getAge() == age) {
                    System.out.println(cats[i]);

                }
            }
        } else if (select == 3) {
            System.out.println("Please enter cats' breeds: ");
            String breeds = sc.next();
            for (int i = 0; i <= maxIndex; i++) {
                if (cats[i].getBreeds().equals(breeds) && cats[i].getState() == 1) {
                    System.out.println(cats[i]);

                }
            }

        }else{
            System.out.println("Your choice is wrong.");
        }


    }
        private static void printAll () {
            System.out.println("--------All information of cats--------");
            for (int i = 0; i <= maxIndex; i++) {
                if (cats[i] != null && cats[i].getState() == 1) {
                    System.out.println(cats[i]);
                }
            }
        }
        public static int createNo () {
            if (maxIndex == 0){
                return 1;
            } else {
                return cats[maxIndex-1].getId() +1;
            }
        }
        public static int findIndex (int id){
            int index = -1;
            for (int i = 0; i <= maxIndex; i++) {
                if (id == cats[i].getId()) {
                    index = i;
                    break;
                }
            }
            return index;
        }
        public static void printCat ( int index){
            System.out.println(cats[index]);
        }


    }
