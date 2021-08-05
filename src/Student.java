public class Student {
    private String name;
    private String grades;
    Student(String name,String grades){
        this.name=name;
        this.grades=grades;
    }
    Student(){

    }

    public String getName() {
        return name;
    }

    public String getGrades() {
        return grades;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }


    @Override
    public String toString(){
        return "Student Name: "+name+"\nGrades: "+grades;
    }
}
