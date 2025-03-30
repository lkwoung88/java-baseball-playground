package baseballgame.before.application;

public enum ApplicationStatus {

    APPLICATION_IN_PROGRESS("한번 더"),
    APPLICATION_TERMINATE("종료"),
    ;

    private final String description;

    ApplicationStatus(String description) {
        this.description = description;
    }
}
