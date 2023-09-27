class Course {
    Teacher courseTeacher;
    String name;
    String code;
    String prefix;
    int examNote; // Sınav notu
    int oralNote; // Sözlü notu
    double examWeight; // Sınav notunun etkisi yüzdesi
    double oralWeight; // Sözlü notunun etkisi yüzdesi

    public Course(String name, String code, String prefix, double examWeight, double oralWeight) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        this.examNote = 0;
        this.oralNote = 0;
        this.examWeight = examWeight;
        this.oralWeight = oralWeight;
    }

    public void addTeacher(Teacher t) {
        if (this.prefix.equals(t.branch)) {
            this.courseTeacher = t;
            System.out.println("İşlem başarılı");
        } else {
            System.out.println(t.name + " Akademisyeni bu dersi veremez.");
        }
    }

    public void setExamNote(int note) {
        if (note >= 0 && note <= 100) {
            this.examNote = note;
        }
    }

    public void setOralNote(int note) {
        if (note >= 0 && note <= 100) {
            this.oralNote = note;
        }
    }

    public void printTeacher() {
        if (courseTeacher != null) {
            System.out.println(this.name + " dersinin Akademisyeni : " + courseTeacher.name);
        } else {
            System.out.println(this.name + " dersine Akademisyen atanmamıştır.");
        }
    }
}