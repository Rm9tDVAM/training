package DesignPattern.Itarator;

public abstract class Teacher {
    protected StudentList studentList;

    public abstract void createStudentList();
    public abstract void callStudents();
}