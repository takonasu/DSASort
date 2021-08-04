public class Bucket {
    int number;
    Bucket NextHop;

    public Bucket() {
        this.number = -1;
        this.NextHop = null;
    }

    public void add(int addNumber) {
        if (this.NextHop == null) {
            this.number = addNumber;
            this.NextHop = new Bucket();
        } else {
            NextHop.add(addNumber);
        }
    }
}