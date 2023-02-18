package main;

import beans.Student;
import config.Config;
import java.util.Scanner;
import util.InputUtil;
import util.StudentUtil;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int menu = InputUtil.requireNumber("What do you want to do?"
                    + "\n1.Registration"
                    + "\n2.Show All Students"
                    + "\n3.Find Students"
                    + "\n4.Update Students"
                    + "\n5.Exit");

            if (menu == 1) {
                StudentUtil.registerStudent();
            } else if (menu == 2) {
                StudentUtil.printAllStudents();
            } else if (menu == 3) {
                StudentUtil.findStudents();
            } else if (menu == 4) {
                StudentUtil.updateStudents();
            } else if (menu == 5) {
                System.exit(0);
            }
        }
    }
}
