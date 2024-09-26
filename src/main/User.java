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
        //����������� ������ ���� �������������.
        public static List<User> getAllUsers(){
            return new ArrayList<>(allUsers.values());
        }


        //����������� ������ ������������� �� ����(MALE/FEMALE).
        public static List<User> getAllUsers(Sex sex){
            List<User> list = new ArrayList<>();
            for (User user:allUsers.values()) {
                if(user.getSex().equals(sex)){
                    list.add(user);
                }
            }
            return list;
        }

        //���������� ���������� ������������� � ����� ������
        public static int getHowManyUsers(){
            return allUsers.size();
        }

        // ��������� ���������� �� �������� ���� ������������.
        public static int getHowManyUsers(Sex sex){
            return getAllUsers(sex).size();
        }

        //��������� ����� ����� �� �������� �������������
        public static int getAllAgeUsers(){
            int count = 0;
            for (User user:allUsers.values()) {
                count +=user.getAge();
            }
            return count;
        }

        //��������� ����� ����� �� �������� �������������, ��� �� ������ �� �������� ����
        public static int getAllAgeUsers(Sex sex){
            int count = 0;

            for (User user:getAllUsers(sex)) {
                count+=user.getAge();
            }
            return count;
        }

        //��������� ������� �������, ��� ����� ��� � �� �������� ����.
        public  static int getAverageAgeOfAllUsers(){
            return getAllAgeUsers()/getHowManyUsers();
        }

        public static int getAverageAgeOfAllUsers(Sex sex) {
            return getAllAgeUsers(sex)/getHowManyUsers(sex);
        }

        public static void main(String[] args) {
            new User("�������", 35, Sex.MALE);
            new User("������", 34, Sex.FEMALE);
            new User("�����", 7, Sex.FEMALE);


            System.out.println("��� ������������:");
            User.getAllUsers().forEach(System.out::println);
            System.out.println("��� ������������: MALE");
            User.getAllUsers(Sex.MALE).forEach(System.out::println);
            System.out.println("��� ������������: FEMALE");
            User.getAllUsers(Sex.FEMALE).forEach(System.out::println);
            System.out.println("================================================");
            System.out.println("       ���� �������������: " + User.getHowManyUsers());
            System.out.println("  ���� ������������� MALE: " + User.getHowManyUsers(Sex.MALE));
            System.out.println("���� ������������� FEMALE: " + User.getHowManyUsers(Sex.FEMALE));
            System.out.println("================================================");
            System.out.println("       ����� ������� ���� �������������: " + User.getAllAgeUsers());
            System.out.println("  ����� ������� ���� ������������� MALE: " + User.getAllAgeUsers(Sex.MALE));
            System.out.println("����� ������� ���� ������������� FEMALE: " + User.getAllAgeUsers(Sex.FEMALE));
            System.out.println("================================================");
            System.out.println("       ������� ������� ���� �������������: " + User.getAverageAgeOfAllUsers());
            System.out.println("  ������� ������� ���� ������������� MALE: " + User.getAverageAgeOfAllUsers(Sex.MALE));
            System.out.println("������� ������� ���� ������������� FEMALE: " + User.getAverageAgeOfAllUsers(Sex.FEMALE));
            System.out.println("================================================");
        }


}
