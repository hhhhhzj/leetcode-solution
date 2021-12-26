package solution;

import java.util.Arrays;
import java.util.List;

/**
 * @author Zhijian.H
 * @since 2021/9/19 上午11:41
 */
public class ContactClass {


    public static String string = "480998807\n" +
            "480998724\n" +
            "481001048\n" +
            "481001348\n" +
            "481001193\n" +
            "386386570\n" +
            "481000207\n" +
            "481010820\n" +
            "480998790\n" +
            "481011447\n" +
            "481010833\n" +
            "480993948\n" +
            "481008822\n" +
            "481008972\n" +
            "480984288\n" +
            "480998030\n" +
            "481000244\n" +
            "378351101\n" +
            "89725016\n" +
            "295353038\n" +
            "40716371\n" +
            "345641549\n" +
            "481011663\n" +
            "480998334\n" +
            "481012563\n" +
            "481013962\n" +
            "481011549\n" +
            "481011666\n" +
            "480999454\n" +
            "480997883\n" +
            "373923810\n" +
            "481005633\n" +
            "449968583\n" +
            "71664686\n" +
            "374663796\n" +
            "28316670\n" +
            "481001244\n" +
            "481003148\n" +
            "481013281";


    public static void main(String[] args) {
        List<String> userIdList = Arrays.asList(string.split("\n"));

        String stringBuilder = null;
        for (String userId : userIdList) {
            stringBuilder = stringBuilder + '"' + userId + '"';
            stringBuilder = stringBuilder + ", ";
        }
        System.out.println(stringBuilder);

    }
}
