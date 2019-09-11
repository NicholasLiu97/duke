/**
 * Class for Duke to understand dates
 * Needed for Duke to understand the date string and convert the date
 * into a more readable and user friendly form
 * e.g from 22/9/2019 1800 to 22nd September 2019 6pm
 */
public class DateFormatter {
    protected String date;
    protected String day;
    protected String suffix;
    protected String month;
    protected String year;
    protected String hr;
    protected String min;
    protected String ampm;

    private String[] months = {"", "January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December"};

    /**
     * contructor for date
     * @param date used to store the date string obtained from the file
     */
    public DateFormatter(String date) {
        this.date = date;
    }

    /**
     * convert the date into a more readable and user friendly form
     * e.g from 22/9/2019 1800 to 22nd September 2019 6pm
     * @return A string that contains the date format understood by Duke
     * @throws DukeException if date to be converted is not in the dd/MM/yyyy HHmm format
     */
    public String toWords() throws DukeException {
        String[] split = this.date.split("\\/"); //get the day, month and year + time
        if (split.length != 3) { //if incorrect date format
            throw new DukeException(" ☹ OOPS!!! Please change date format to dd/MM/yyyy HHmm");
        }
        this.day = split[0];
        int dayInt = Integer.parseInt(this.day);
        if (dayInt == 11 || dayInt == 12 || dayInt == 13) {
            this.suffix = "th";
        } else if (dayInt%10 == 1) {
            this.suffix = "st";
        } else if (dayInt%10 == 2) {
            this.suffix = "nd";
        } else if (dayInt%10 == 3) {
            this.suffix = "rd";
        } else {
            this.suffix = "th";
        }

        int monthIndex = Integer.parseInt(split[1]);
        this.month = months[monthIndex];
        String[] splitYearTime = split[2].split(" "); //split up the year and time which are separated by " "
        this.year = splitYearTime[0];
        this.hr = new String(); this.min = new String();
        this.hr += splitYearTime[1].charAt(0);
        this.hr += splitYearTime[1].charAt(1);
        this.min += splitYearTime[1].charAt(2);
        this.min += splitYearTime[1].charAt(3);

        //changing hr to <= 12 and finding ampm
        int hour = Integer.parseInt(this.hr);

        if (hour >= 12) {
            this.ampm = "pm";
        } else {
            this.ampm = "am";
        }
        hour %= 12;
        this.hr = Integer.toString(hour);

        return this.day + this.suffix + " of " + this.month + " " + this.year + ", " + this.hr + this.min
                + this.ampm;
    }
}
