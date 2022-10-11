package ObserverModel;

public class Main {
    public static void main(String[] args) {
        //��������
        KWICSubject kwicSubject = new KWICSubject();
        //�����۲���
        Input input = new Input("src/input.txt");
        Shift shift = new Shift(input.getLineTxt());
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        Output output = new Output(alphabetizer.getKwicList(), "src/output.txt");

        // ���۲��߼�������
        kwicSubject.addObserver(input);
        kwicSubject.addObserver(shift);
        kwicSubject.addObserver(alphabetizer);
        kwicSubject.addObserver(output);
        // �𲽵��ø����۲���
        kwicSubject.startKWIC();
    }
}
