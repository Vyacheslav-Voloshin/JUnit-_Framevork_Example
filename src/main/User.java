package main;

import java.util.*;

public class User {

        private int id;
        private String name;
        private int age;
        private Sex sex;
        private static Map<Integer,User> allUsers = new HashMap<>();
        private static int countId = 0;

        public User(String name, int age, Sex sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;

            if (!hasUser()){
                countId++;
                this.id = countId;
                allUsers.put(id, this);
            }
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Sex getSex() {
            return sex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age &&
                    Objects.equals(name, user.name) &&
                    sex == user.sex;
        }

        @Override
        public int hashCode() {

            return Objects.hash(name, age, sex);
        }

        private boolean hasUser(){
            for (User user : allUsers.values()){
                if (user.equals(this) && user.hashCode() == this.hashCode()){
                    return true;
                }
            }
            return false;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", sex=" + sex +
                    '}';
        }
        //‘ормировать список всех пользователей.
        public static List<User> getAllUsers(){
            return new ArrayList<>(allUsers.values());
        }


        //‘ормировать список пользователей по полу(MALE/FEMALE).
        public static List<User> getAllUsers(Sex sex){
            List<User> list = new ArrayList<>();
            for (User user:allUsers.values()) {
                if(user.getSex().equals(sex)){
                    list.add(user);
                }
            }
            return list;
        }

        //¬озвращать количество пользователей в общем списке
        public static int getHowManyUsers(){
            return allUsers.size();
        }

        // посчитать количество по признаку пола пользовател€.
        public static int getHowManyUsers(Sex sex){
            return getAllUsers(sex).size();
        }

        //ѕосчитать общую сумму по возрасту пользователей
        public static int getAllAgeUsers(){
            int count = 0;
            for (User user:allUsers.values()) {
                count +=user.getAge();
            }
            return count;
        }

        //ѕосчитать общую сумму по возрасту пользователей, так же учесть по признаку пола
        public static int getAllAgeUsers(Sex sex){
            int count = 0;

            for (User user:getAllUsers(sex)) {
                count+=user.getAge();
            }
            return count;
        }

        //ѕосчитать средний возраст, как общий так и по признаку пола.
        public  static int getAverageAgeOfAllUsers(){
            return getAllAgeUsers()/getHowManyUsers();
        }

        public static int getAverageAgeOfAllUsers(Sex sex) {
            return getAllAgeUsers(sex)/getHowManyUsers(sex);
        }

        public static void main(String[] args) {
            new User("≈вгений", 35, Sex.MALE);
            new User("ћарина", 34, Sex.FEMALE);
            new User("јлина", 7, Sex.FEMALE);


            System.out.println("¬се пользователи:");
            User.getAllUsers().forEach(System.out::println);
            System.out.println("¬се пользователи: MALE");
            User.getAllUsers(Sex.MALE).forEach(System.out::println);
            System.out.println("¬се пользователи: FEMALE");
            User.getAllUsers(Sex.FEMALE).forEach(System.out::println);
            System.out.println("================================================");
            System.out.println("       всех пользователей: " + User.getHowManyUsers());
            System.out.println("  всех пользователей MALE: " + User.getHowManyUsers(Sex.MALE));
            System.out.println("всех пользователей FEMALE: " + User.getHowManyUsers(Sex.FEMALE));
            System.out.println("================================================");
            System.out.println("       общий возраст всех пользователей: " + User.getAllAgeUsers());
            System.out.println("  общий возраст всех пользователей MALE: " + User.getAllAgeUsers(Sex.MALE));
            System.out.println("общий возраст всех пользователей FEMALE: " + User.getAllAgeUsers(Sex.FEMALE));
            System.out.println("================================================");
            System.out.println("       средний возраст всех пользователей: " + User.getAverageAgeOfAllUsers());
            System.out.println("  средний возраст всех пользователей MALE: " + User.getAverageAgeOfAllUsers(Sex.MALE));
            System.out.println("средний возраст всех пользователей FEMALE: " + User.getAverageAgeOfAllUsers(Sex.FEMALE));
            System.out.println("================================================");
        }


}
