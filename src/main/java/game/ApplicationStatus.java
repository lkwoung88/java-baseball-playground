package game;

public enum ApplicationStatus {
    IN_PROGRESS, TERMINATED;

    public static boolean isInProgress(ApplicationStatus status) {
        return IN_PROGRESS.equals(status);
    }
}
