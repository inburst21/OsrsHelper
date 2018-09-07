package inburst.com.osrshelper.Tools;

/**
 * lennyhicks
 * 9/7/18
 */
public class QueryTypes {
    public enum  Interval {
        FIFTEEN_MIN("15 Min", 15),
        THIRTY_MIN("30 Min", 30),
        ONE_HOUR("1 Hour", THIRTY_MIN.getInterval() * 2),
        TWO_HOUR("2 Hours", ONE_HOUR.getInterval() * 2),
        THREE_HOUR("3 Hours", ONE_HOUR.getInterval() * 3),
        SIX_HOUR("6 Hours", ONE_HOUR.getInterval() * 6),
        TWELVE_HOUR("12 Hours", ONE_HOUR.getInterval() * 12),
        ONE_DAY("24 Hours", ONE_HOUR.getInterval() * 24);


        private final String name;
        private final int interval;

        Interval(String name, int interval) {
            this.name = name;
            this.interval = interval;
        }

        public int getInterval() {
            return interval;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public enum PreDate {
        FIFTEEN_MIN("15 Min", 900000),
        THIRTY_MIN("30 Min",  FIFTEEN_MIN.getInterval() * 2),
        ONE_HOUR("1 Hour", THIRTY_MIN.getInterval() * 2),
        TWO_HOUR("2 Hours", ONE_HOUR.getInterval() * 2),
        THREE_HOUR("3 Hours", ONE_HOUR.getInterval() * 3),
        SIX_HOUR("6 Hours", ONE_HOUR.getInterval() * 6),
        TWELVE_HOUR("12 Hours", ONE_HOUR.getInterval() * 12),
        ONE_DAY("24 Hours", ONE_HOUR.getInterval() * 24),;


        private final String name;
        private final long interval;

        PreDate(String name, long interval) {
            this.name = name;
            this.interval = interval;
        }

        public long getInterval() {
            return interval;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
