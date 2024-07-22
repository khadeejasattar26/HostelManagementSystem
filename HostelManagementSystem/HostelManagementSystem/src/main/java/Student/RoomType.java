package Student;

public enum RoomType {

    // Single occupancy room with a rent of 20000
    SingleSharing(20000),

    // Double occupancy room with a rent of 15000
    DoubleSharing(15000),

    // Null value
    Null(0);

    private final int rent; //  final for constant values in enums

    private RoomType(int rent) {
        this.rent = rent;
    }

    public int getRent() {
        return rent;
    }

}
