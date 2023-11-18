class Student {
    private String id,name;
    private double midScore,finalScore,quizScore,prjScore,collabScore;
    public Student(String idS, String nameS, double midS, double finalS, double quizS, double prjS, double collabS ){
        id = idS;
        name = nameS;
        midScore = midS;
        finalScore = finalS;
        quizScore =quizS;
        prjScore = prjS;
        collabScore =collabS;
    }
    public void setStudent(String idS,String nameS,double midS,double finalS,double quizS,double prjS,double collabS){
        id = idS;
        name = nameS;
        midScore = midS;
        finalScore = finalS;
        quizScore =quizS;
        prjScore = prjS;
        collabScore =collabS;
    }
    public Student getStudent(){
        return this;
    }

    public double getTotalScore() {
        return (this.midScore + this.finalScore + this.quizScore + this.prjScore + this.collabScore);
    }

    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public  double getMidScore(){
        return this.midScore;
    }
    public double getFinalScore(){
        return this.finalScore;
    }
    public double getPrjScore() {
        return this.prjScore;
    }
    public double getCollabScore(){
        return this.collabScore;
    }
    public  Double getQuizScore(){
        return this.quizScore;
    }
}
