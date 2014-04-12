package org.maker.testdom4j.view;

import org.maker.testdom4j.bean.Student;
import org.maker.testdom4j.studentdao.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 2014/4/11.
 */
public class Main {
    public static void main(String[] args) {

        Student student = new Student();
        StudentDao studentDao = new StudentDao();
        System.out.println("添加学生 (a)   查找学生 (b)   删除学生 (c)");
        System.out.print("请输入操作的类型: ");


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = bufferedReader.readLine();
            char c = str.charAt(0);
            switch (c) {
                case 'a':
                    System.out.print("请输入学生的姓名: ");
                    student.setName(bufferedReader.readLine());

                    System.out.print("请输入学生的准考证号: ");
                    student.setExamid(bufferedReader.readLine());

                    System.out.print("请输入学生的身份证号: ");
                    student.setIdcard(bufferedReader.readLine());

                    System.out.print("请输入学生的地区: ");
                    student.setLocation(bufferedReader.readLine());

                    System.out.print("请输入学生的成绩: ");
                    student.setGrade(Double.valueOf(bufferedReader.readLine()));
                    try {
                        studentDao.add(student);
                    } catch (Exception e) {
                        System.out.println("数据添加失败!");
                        break;
                    }
                    System.out.println("------数据添加成功------");
                    break;

                case 'b':
                    System.out.print("请输入查询的学生准考证号: ");
                    Student stu = studentDao.find(bufferedReader.readLine());
                    if (stu != null) {
                        System.out.println(stu);
                    } else {
                        System.out.println("查无此人!");
                    }
                    break;

                case 'c':
                    System.out.print("请输入删除的学生姓名: ");
                    String name = bufferedReader.readLine();
                    try {
                        studentDao.delete(name);
                    } catch (NullPointerException e) {
                        System.out.println("不存在该用户!");
                    }
                    break;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

