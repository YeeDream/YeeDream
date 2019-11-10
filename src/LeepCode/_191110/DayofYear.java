package LeepCode._191110;

/**
 * @Author DreamYee
 * @Create 2019/11/10  16:10
 */
/*给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。
通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。
每个月的天数与现行公元纪年法（格里高利历）一致。
*/
public class DayofYear {
    public int dayOfYear(String date){
        int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
        String[] dates=date.split("-");
        if(isLeapYear(dates[0])){
            days[1]=29;
        }
        int sum=0;
        int month=Integer.parseInt(dates[1]);
        for(int i=1;i<month;i++) {
            sum += days[i - 1];
        }
        return sum+Integer.parseInt(dates[2]);
    }

    public boolean isLeapYear(String year){
        int value=Integer.parseInt(year);
        return ((value%4==0&&value%100!=0)||value%400==0);
    }

    public static void main(String[] args) {
        DayofYear dd=new DayofYear();
        String date="2019-11-11";
        System.out.println(dd.dayOfYear(date));

    }
}
