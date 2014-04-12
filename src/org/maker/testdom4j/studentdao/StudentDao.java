package org.maker.testdom4j.studentdao;

import org.dom4j.*;
import org.maker.testdom4j.bean.Student;
import org.maker.testdom4j.utils.XmlUtils;

/**
 * Created by DELL on 2014/4/12.
 */
public class StudentDao {
    public void add(Student student) {
        Document document = XmlUtils.getDocument();
        Element stuElement = DocumentHelper.createElement("student");
        Attribute examid = DocumentHelper.createAttribute(stuElement, "examid", student.getExamid());
        Attribute idcard = DocumentHelper.createAttribute(stuElement, "idcard", student.getIdcard());

        Element name = DocumentHelper.createElement("name");
        Element loaction = DocumentHelper.createElement("location");
        Element grade = DocumentHelper.createElement("grade");

        name.setText(student.getName());
        loaction.setText(student.getLocation());
        grade.setText(String.valueOf(student.getGrade()));

        stuElement.add(examid);
        stuElement.add(idcard);
        stuElement.add(name);
        stuElement.add(loaction);
        stuElement.add(grade);
        document.getRootElement().add(stuElement);

        XmlUtils.write2xml(document);

    }

    public Student find(String examid) {
        Document document = XmlUtils.getDocument();
        Element stuElement = (Element) document.selectSingleNode("//student[@examid='" + examid + "'][1]");
        Student student = new Student();
        if (stuElement != null) {
            student.setExamid(stuElement.attributeValue("examid"));
            student.setIdcard(stuElement.attributeValue("idcard"));
            student.setName(stuElement.element("name").getText());
            student.setLocation(stuElement.element("location").getText());
            student.setGrade(Double.valueOf(stuElement.element("grade").getText()));
            return student;
        }

        return null;
    }

    public void delete(String name) {
        Document document = XmlUtils.getDocument();
        Node stuElement = document.selectSingleNode("//student[name='" + name + "'][1]");
        if (stuElement != null){
            stuElement.getParent().remove(stuElement);
        } else {
            throw new NullPointerException();
        }
        XmlUtils.write2xml(document);

    }
}
