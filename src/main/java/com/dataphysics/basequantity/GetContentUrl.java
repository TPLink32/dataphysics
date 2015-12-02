package com.dataphysics.basequantity;

/**
 * Created by Administrator on 2015/12/2.
 */

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetContentUrl {
    private static String curLine = "";
    private static String content = "";

    public static void getUrlContent() throws IOException {
        String curLine = "";
        String temp = "";
        URL server = new URL("http://baike.sogou.com/v95465.htm?fromTitle=%E4%BA%8C");
        HttpURLConnection connection = (HttpURLConnection) server
                .openConnection();
        connection.connect();
        InputStream is = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuffer stringBuffer = new StringBuffer();
        while ((curLine = reader.readLine()) != null) {
            temp = curLine + "\r\n";
            //String regEx="[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）：《》——+|{}\\[\\]【】_\\-\"‘；：”“’。，、？^(A-Za-z)^(0-9)]";
            String regEx = "[^\\u4e00-\\u9fa5]";
            Pattern p   =   Pattern.compile(regEx);
            Matcher m   =   p.matcher(temp);
            content += m.replaceAll("").trim();
        }
        //content = removerepeatedchar(content);
        System.out.println(content);
        content = analyzer(content);
        //content = removerepeatedword(content);
        stringBuffer.append(content);
        is.close();
//        return content;

        File file = new File("C:\\Users\\Administrator\\Desktop\\3.txt");
        createFile(file, stringBuffer);
    }
    public static String removerepeatedword(String str) {
        String[] words = str.split("|");
        str = "";
        Set<String> wordSet = new HashSet<String>();
        for (String word : words) {
            wordSet.add(word);
        }
        Iterator<String> it = wordSet.iterator();
        while(it.hasNext()){
            str += it.next()+"|";
        }
        return str;
    }

    public static String removerepeatedchar(String str) {
        List<String> data = new ArrayList<String>();

        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i + 1);
            if (!data.contains(s)) {
                data.add(s);
            }
        }

        String result = "";
        for (String s : data) {
            result += s;
        }
        return result;
    }
    private static String analyzer(String string) {
        String analyzerStr = "";
        Analyzer anal=new IKAnalyzer(true);
        StringReader reader=new StringReader(string);
        //分词
        TokenStream ts= null;
            ts = anal.tokenStream("", reader);
        CharTermAttribute term=ts.getAttribute(CharTermAttribute.class);
        //遍历分词数据
        try {
            while(ts.incrementToken()){
                analyzerStr += term.toString()+"|";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        reader.close();
        return analyzerStr;
    }
    private static void createFile(File file, StringBuffer buffer) {
        try {
            File newFile = new File(file.getAbsolutePath()+".txt");
            if (newFile.exists())// 存在，则删除
                if (!newFile.delete())// 删除成功则创建
                {
                    System.err.println("删除文件" + newFile + "失败");
                }
            if (newFile.createNewFile()) {// 创建成功，则写入文件内容
                PrintWriter p = new PrintWriter(new FileOutputStream(newFile
                        .getAbsolutePath()));
                p.write(buffer.toString());
                p.close();
            } else {
                System.err.println("创建文件：" + newFile + "失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException{
        getUrlContent();
    }
}