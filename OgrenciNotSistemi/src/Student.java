class Student {
    String name, stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double average;
    boolean isPass;

    Student(String name, int classes, String stuNo, Course mat, Course fizik, Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAverage();
        this.isPass = false;
    }

    public void addBulkExamNote(int matExam, int fizikExam, int kimyaExam, int matOral, int fizikOral, int kimyaOral) {
        mat.setExamNote(matExam);
        mat.setOralNote(matOral);
        fizik.setExamNote(fizikExam);
        fizik.setOralNote(fizikOral);
        kimya.setExamNote(kimyaExam);
        kimya.setOralNote(kimyaOral);
    }

    public void isPass() {
        if (mat.examNote == 0 || fizik.examNote == 0 || kimya.examNote == 0 || mat.oralNote == 0 || fizik.oralNote == 0 || kimya.oralNote == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.average);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAverage() {
        double matWeightedAverage = (mat.examNote * mat.examWeight) + (mat.oralNote * mat.oralWeight);
        double fizikWeightedAverage = (fizik.examNote * fizik.examWeight) + (fizik.oralNote * fizik.oralWeight);
        double kimyaWeightedAverage = (kimya.examNote * kimya.examWeight) + (kimya.oralNote * kimya.oralWeight);

        this.average = (matWeightedAverage + fizikWeightedAverage + kimyaWeightedAverage) / 3.0;
    }

    public boolean isCheckPass() {
        calcAverage();
        return this.average > 55;
    }

    public void printNote() {
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu (Sınav): " + mat.examNote + ", Notu (Sözlü): " + mat.oralNote);
        System.out.println("Fizik Notu (Sınav): " + fizik.examNote + ", Notu (Sözlü): " + fizik.oralNote);
        System.out.println("Kimya Notu (Sınav): " + kimya.examNote + ", Notu (Sözlü): " + kimya.oralNote);
    }
}
