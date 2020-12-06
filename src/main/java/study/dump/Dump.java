package study.dump;

public class Dump {
    public final static int OUTOFMEMORY = 900000000;

    private String oom;

    private int length;

    StringBuffer tempOOM = new StringBuffer();

    public Dump(int leng) {
        this.length = leng;

        int i = 0;
        while (i < leng) {
            i++;
            try {
                tempOOM.append("a");
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                break;
            }
        }
        this.oom = tempOOM.toString();

    }

    public String getOom() {
        return oom;
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        Dump javaHeapTest = new Dump(OUTOFMEMORY);
        System.out.println(javaHeapTest.getOom().length());
    }
}

