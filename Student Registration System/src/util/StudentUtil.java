/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import beans.Student;
import config.Config;

/**
 *
 * @author User
 */
public class StudentUtil {

    public static Student fillStudent() {
        String name = InputUtil.requireText("enter name");
        String surname = InputUtil.requireText("enter surname");
        int age = InputUtil.requireNumber("enter age");
        String group = InputUtil.requireText("enter group");
        return new Student(name, surname, age, group);
    }

    public static void registerStudent() {
        int count = InputUtil.requireNumber("How many students do you enroll?");
        Config.students = new Student[count];
        for (int i = 0; i < Config.students.length; i++) {
            System.out.println(i + 1 + ".Register");
            Config.students[i] = StudentUtil.fillStudent();
        }
    }

    public static void printAllStudents() {
        for (int i = 0; i < Config.students.length; i++) {
            System.out.println(i + 1 + "." + Config.students[i]);
        }
    }

    public static void findStudents() {
        String text = InputUtil.requireText("enter name | surname | group | age");
        for (int i = 0; i < Config.students.length; i++) {
            if (Config.students[i].getName().contains(text) || Config.students[i].getSurname().contains(text) || Config.students[i].getGroup().contains(text) || (Config.students[i].getAge() + "").contains(text)) {
                System.out.println(Config.students[i]);
            }
        }
    }

    public static void updateStudents() {
        StudentUtil.printAllStudents();
        int i = InputUtil.requireNumber("Which do you want to change");
        Student st = Config.students[i - 1];
        String params = InputUtil.requireText("change params: 'name' | 'surname' | group | age");
        if (params.contains("'name'")) {
            st.setName(InputUtil.requireText("enter new name"));
        }
        if (params.contains("'surname'")) {
            st.setSurname(InputUtil.requireText("enter new surname"));
        }
        if (params.contains("group")) {
            st.setGroup(InputUtil.requireText("enter new group"));
        }
        if (params.contains("age")) {
            st.setAge(InputUtil.requireNumber("enter new age"));
        }
    }
}
