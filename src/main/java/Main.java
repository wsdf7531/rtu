

import java.io.*;
import java.net.URLDecoder;
import java.util.*;

/**
 * @Author: Xusj
 * @Date: 2018/8/17
 * @Description:
 */
public class Main {

    private static Map<String, List> testMap = new HashMap<String, List>();

    /**
     *       * 以行为单位读取文件，常用于读面向行的格式化文件
     * */
    public static void readFileByLines(String fileName) {

        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                String time=tempString.substring(6,19);
                String newTime="2018-08-15"+time;
                String info=org.apache.commons.lang3.StringUtils.substringAfter(tempString, "f");
                info=info.substring(9);
                String  newInfo= org.apache.commons.lang3.StringUtils.substringBefore(info,",[[");
                String  phone= org.apache.commons.lang3.StringUtils.substringAfter(info,"[[");
                String newPhone=org.apache.commons.lang3.StringUtils.substringBefore(phone,"]]");
                newPhone=newPhone.replaceAll(",","");
                newPhone=newPhone.replaceAll(" ","");
                newPhone=newPhone.replaceAll("0x","");
                newPhone=newPhone.substring(8);
                String p=until.convertHexToString(newPhone);
                Date newtime=until.parseDateTime(newTime);
                System.out.println("line " + line + ":" +time+","+ p);

//                if ("10.120.129.76:1205".equals(newInfo)){
//                    if (testMap.get(p)!=null){
//                        Date oldTime= testMap.get(p);
//                        long dvalue=until.secondsBetween(newtime,oldTime);
//                        if (dvalue>300){
//
//                            testMap.put(p,newtime);
//                        }
//                    }
//                    testMap.put(p,newtime);
//                }
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    public static void main(String[] args) {
        Main.readFileByLines("d:\\FFOutput\\1.log");
    }

}

