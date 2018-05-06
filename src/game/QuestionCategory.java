package game;

public enum QuestionCategory {
    RANDOM(1, "Random"),
    GEO(2, "Geography"),
    HIST(3, "History"),
    TECH(4, "Technology"),
	SPORTS(5, "Sports"),
	BONUS(6, "Bonus");

    //http://ceving.blogspot.bg/2012/10/enum-in-java-with-array-of-string-values.html
    private static final String[] array;
    private final String textRepresentation;
    private final int categoryKey;

    QuestionCategory(int categoryKey, String textRepresentation) {
        this.categoryKey = categoryKey;
        this.textRepresentation = textRepresentation;
    }

    static {
        array = new String[QuestionCategory.values().length];
        for (QuestionCategory value : QuestionCategory.values())
            array[value.ordinal()] = value.toString();
    }

    public static String[] toArray() {
        return array;
    }

    public static QuestionCategory getCategoryByKey(int categoryKey){
        for (QuestionCategory questionCategory : QuestionCategory.values()) {
            if(questionCategory.categoryKey == categoryKey){
                return questionCategory;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return textRepresentation;
    }
}
