import java.util.Scanner;

public class CatManageApp {
    //array of saving cats
    private static Cat[] cats = new Cat[100];
    //private:method can only be accessed in the current class
    //static:it is static method.It can be called directly by the class name without
    //creating an instance object.
    //maintain the current maximum index
    private static int maxIndex = -1;
    //maxIndex:the largest number of the index
    static void main(String[] args) {
        //void:do not need to return any value
        System.out.println("Welcome to use simple cat manage system");
        Scanner sc = new Scanner(System.in);
        //"Scanner": a input scanning class provided by java
        //"sc":parameter name
        //"new":crate an object
        //"Systen.in":represent for input
       int select = 0;
        while (true) {
            System.out.println("---------------00------------------------00-----------------------");
            System.out.println("-------------00--00--------------------00--00---------------------");
            System.out.println("------------00----00---000000000000---00----00--------------------");
            System.out.println("-----------00---------000--------000----------00------------------");
            System.out.println("---------00------------------------------------00-----------------");
            System.out.println("-------000--------------------------------------000---------------");
            System.out.println("-------000--------------------------------------000---------------");
            System.out.println("-1Save  2Delete  3Modify  4Query  5PrintAll 6ShowStatistics 0Exit-");
            System.out.println("-------000---------------------------------------00---------------");
            System.out.println("-------000-----------------00000000-------------000---------------");
            System.out.println("--------000-----------------000000-------------000----------------");
            System.out.println("---------000------------------00--------------000-----------------");
            System.out.println("-----------000-------------------------------000------------------");
            System.out.println("--------------000--------------------------000--------------------");
            System.out.println("------------------000000000000000000000000------------------------");
            System.out.println("-------Please enter the business you want to select---------------");
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
                case 6:
                    showStatistics();
                    break;
                default:
                    System.out.println("Your choice is wrong.Please choose again.");
            }
        }

    }

    // add cats
    //user can in put and save the information of cats one by one
    private static void save() {
        System.out.println("---------------Save cats--------------");
        maxIndex ++;//the max index add 1
        Scanner sc = new Scanner(System.in);
        int id = createNo();
        //createNo:generate number
        System.out.println("Name");
        String name = sc.next();
        //next():a method included in scanner,used to read the next string
        System.out.println("Age");
        int age = sc.nextInt();
        while (age < 0) {
            System.out.println("Age cannot be negative, please enter again:");
            age = sc.nextInt();
        }
        //nextInt():a method included in scanner,used to read the next integer
        //next() and nextInt()is different
        System.out.println("Breeds");
        String breeds = sc.next();
        System.out.println("Price");
        int price = sc.nextInt();
        System.out.println("Description");
        String description = sc.next();
        Cat a = new Cat(id,name,age,breeds,price,description,1);
        //combine the object
        //Cat:variable declaration
        cats[maxIndex] = a;
        //save information into array
        //a is a place where we store the information temporarily
        System.out.println("Add a cat succesfully!");
        System.out.println("This cat's ID is " + maxIndex+".");
    }

    //delete a cat
    private static void delete() {
        System.out.println("---------------Delete cats--------------");
        System.out.println("Please enter the cat ID you want to delete:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        int index = findIndex(id);
        if (index == -1) {
            System.out.println("Cat not found!");
            return;
        }
        if(cats[index].getState() ==0){
            System.out.println("This cat is deleted.");
            return;
        }
        printCat(index);
        System.out.println("Are you sure you want to delete the cat? 1Yes 2No");
        int answer = sc.nextInt();
        if (answer == 1){
            cats[index].setState(0);
            //change cat's state into 0 to delete it
            System.out.println("Delete successfully!");
        }
    }

    //modify a cat
    private static void modify() {
        System.out.println("----------------Modify cats--------------");
        System.out.println("Please enter the cat ID you want to modify:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        int index = findIndex(id);
        if(cats[index].getState() == 0){
            System.out.println("This cat is deleted.");
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

    //query cats
    private static void query() {
        System.out.println("----------------Query cats--------------");
        System.out.println("-------1name  2age  3breeds--------");
        //basis for queries
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();
        //int select:variable declaration
        //sc:object variable
        //nextInt:method name
        if (select == 1) {
            //query base on name
            System.out.println("Please enter cats' name:");
            String name = sc.next();
            for (int i = 0; i <= maxIndex; i++) {
                if (cats[i].getName().contains(name) && cats[i].getState() == 1) {
                   //cat[i]:the cat with index i
                    //get.name:get cat name by using get.name method
                    //contains(name):check whether cat's name contain name string
                    //get.State:get the cats' status
                    //==1:make sure it is not deleted
                    System.out.println(cats[i]);
                }
            }

        } else if (select == 2) {
            //query based on age
            System.out.println("Please enter cats' age:");
            int age = sc.nextInt();
            for (int i = 0; i <= maxIndex; i++) {
                if (cats[i].getAge() == age) {
                    System.out.println(cats[i]);

                }
            }
        } else if (select == 3) {
            //query base on breeds
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
    //print all the cats
        private static void printAll () {
            System.out.println("--------All information of cats--------");
            for (int i = 0; i <= maxIndex; i++) { //use for loop to print all cats
                //maxIndex means the max number of the cats' index
                if (cats[i] != null && cats[i].getState() == 1) {
                    //this "if" is to judge whether the cat is deleted or not.
                    //We only need to print the one is not deleted.
                    //"getState"is a method included in "product",which
                    //is used to return product status value
                    System.out.println(cats[i]);
                }
            }
        }
    private static void showStatistics() {
        System.out.println("------------show statistics-------------");
        int totalCats = 0;
        int activeCats = 0;
        int deletedCats = 0;
        int totalValue = 0;

        for (int i = 0; i <= maxIndex; i++) {
            if (cats[i] != null) {
                totalCats++;
                if (cats[i].getState() == 1) {
                    activeCats++;
                    totalValue += cats[i].getPrice();
                } else {
                    deletedCats++;
                }
            }
        }

        System.out.println("The total number of cats is: " + totalCats);
        System.out.println("The number of active cats is: " + activeCats);
        System.out.println("The number of deleted cats is: " + deletedCats);
        System.out.println("The total value of all cats is: " + totalValue);
        if (activeCats > 0) {
            System.out.println("The average value of each active cat is: " + (totalValue / activeCats));
        }
    }
        //automatically generate numbers
        public static int createNo () {
            if (maxIndex == 0){
                return 1;
            } else {
                //last cat's index add 1
                return cats[maxIndex-1].getId() +1;
            }
        }

        //search index based on cat's number
        public static int findIndex (int id){
            int index = -1;//if we don't find the relative index
            //if statement won't conduct,return index whose value is -1
            //search a number in its array
            for (int i = 0; i <= maxIndex; i++) { //search through all the cats
                //in the array
                if (id == cats[i].getId()) { //find the cat which has the index
                    index = i; //assign the value of i to the index
                    break;//find the index and then stop the loop
                }
            }
            return index;
        }

        //print cats under the specified index
        public static void printCat ( int index){
            System.out.println(cats[index]);
            //simplify the print operation by using "toString" method above
        }


    }
