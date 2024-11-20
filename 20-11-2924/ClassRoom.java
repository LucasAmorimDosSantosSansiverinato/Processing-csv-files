
public class ClassRoom {
public String roomType;
public int roomCapacity;
public String timeSpan;

public ClassRoom(String roomType, int roomCapacity, String timeSpan) {
    this.roomType = roomType;
    this.roomCapacity = roomCapacity;
    this.timeSpan = timeSpan;
}

public String getRoomType() {
    return roomType;
}

public int getRoomCapacity() {
    return roomCapacity;
}

public String getTimespan() {
    return timeSpan;
}

}


