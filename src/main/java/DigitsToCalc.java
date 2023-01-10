enum DigitsToCalc {
    arabicOne(1, "1", true),
    arabicTwo(2, "2", true),
    arabicThree(3, "3", true),
    arabicFour(4, "4", true),
    arabicFive(5, "5", true),
    arabicSix(6, "6", true),
    arabicSeven(7, "7", true),
    arabicEight(8, "8", true),
    arabicNine(9, "9", true),
    arabicTen(10, "10", true),
    romanOne(1, "I", false),
    romanTwo(2, "II", false),
    romanThree(3, "III", false),
    romanFour(4, "IV", false),
    romanFive(5, "V", false),
    romanSix(6, "VI", false),
    romanSeven(7, "VII", false),
    romanEight(8, "VIII", false),
    romanNine(9, "IX", false),
    romanTen(10, "X", false);

    private final int value;
    private final String label;
    private final boolean isArabic;

    DigitsToCalc(int value, String label, boolean isArabic) {
        this.value = value;
        this.label = label;
        this.isArabic = isArabic;
    }

    public int getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public boolean isArabic() {
        return isArabic;
    }
}


