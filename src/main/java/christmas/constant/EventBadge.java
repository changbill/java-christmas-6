package christmas.constant;

import java.util.Arrays;
import java.util.List;

public enum EventBadge {
    NONE(0, "없음"),
    STAR(5_000, "별"),
    TREE(10_000, "트리"),
    SANTA(20_000, "산타"),
    ;

    private final int orMore;
    private final String badgeName;

    EventBadge(final int orMore, final String badgeName) {
        this.orMore = orMore;
        this.badgeName = badgeName;
    }

    public static String decideEventBadge(final int benefitAmount) {
        List<EventBadge> eventBadges = Arrays.stream(EventBadge.values())
                .takeWhile(eventBadge -> eventBadge.orMore <= benefitAmount).toList();

        return eventBadges.get(eventBadges.size() - 1).badgeName;
    }
}
