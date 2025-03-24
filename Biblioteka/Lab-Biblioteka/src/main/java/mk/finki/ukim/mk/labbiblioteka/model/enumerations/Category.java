package mk.finki.ukim.mk.labbiblioteka.model.enumerations;

public enum Category {
    NOVEL,
    THRILER,
    HISTORY,
    FANTASY,
    BIOGRAPHY,
    CLASSICS,
    DRAMA
}

//public enum Category {
//    NOVEL(1),
//    THRILER(2),
//    HISTORY(3),
//    FANTASY(4),
//    BIOGRAPHY(5),
//    CLASSICS(6),
//    DRAMA(7);
//
//    private final int id;
//
//    Category(int id) {
//        this.id = id;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    // Convert Long ID to Category enum
//    public static Category fromId(Long id) {
//        for (Category category : values()) {
//            if (category.id == id) {
//                return category;
//            }
//        }
//        throw new IllegalArgumentException("Unknown category id: " + id);  // Handle invalid IDs
//    }
//}
