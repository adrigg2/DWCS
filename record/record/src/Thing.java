public record Thing(int a, int b) {
    static int bDefault = 0;

    public Thing(int a) {
        this(a, bDefault);
        bDefault++;
    }
}
