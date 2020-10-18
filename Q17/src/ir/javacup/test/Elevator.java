package ir.javacup.test;

public class Elevator {
    private boolean door;
    private int floorNumber;
    private State state;
    private boolean underMaintenance;

    public Elevator() {
        door = true;
        floorNumber = 0;
        state = State.SECURE;
        underMaintenance = false;
    }

    public boolean isOpen() {
        if (door) {
            return true;
        }
        return false;
    }

    public boolean isUnderMaintenance() {
        if (underMaintenance) {
            return true;
        }
        return false;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public State getState() {
        return state;
    }

    public void move(int pos) {
        if (underMaintenance) {
            throw new RuntimeException("Elevator is insecure");
        }else if (pos == floorNumber) {
            return;
        }else if (pos > -2 && pos < 10) {
            close();
            floorNumber = pos;
        } else {
            throw new IllegalArgumentException("Floor number should be between -2 and 10");
        }
    }

    public void open() {
        door = true;
    }

    public void close() {
        door = false;
    }

    public void startMaintenance() {
        underMaintenance = true;
        state = State.INSECURE;
    }

    public void finishMaintenance() {
        underMaintenance = false;
        state = State.SECURE;
    }
}
