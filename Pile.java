class Pile {
    private int pileAmount;
    private String pileName;

    public Pile(int pA, String pN) {
        pileAmount = pA;
        pileName = pN;
    }

    public String getPileName() {
        return pileName;
    }

    public void setPileAmount(int newAmount) {
        pileAmount = newAmount;
    }

    public int getPileAmount() {
        return pileAmount;
    }
}