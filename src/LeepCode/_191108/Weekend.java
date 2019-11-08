package LeepCode._191108;

import java.util.Date;

/**
 * @Author DreamYee
 * @Create 2019/11/08  18:11
 */
/*给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
输入为三个整数：day、month 和 year，分别表示日、月、年。
您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
*/
public class Weekend {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] m ={"Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday"};
        return m[new Date(year-month-day).getDay()];
    }

    public static void main(String[] args) {
        Weekend ww=new Weekend();
        int year=2019,month=11,day=8;
        System.out.println(ww.dayOfTheWeek(year,month,day));
    }
}
