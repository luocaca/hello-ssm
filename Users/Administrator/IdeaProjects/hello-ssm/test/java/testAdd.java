import javax.activation.MimetypesFileTypeMap;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class testAdd {


    public static void main(String... args) {


        testUploadImage();


    }


    public static void testUploadImage() {

        String url = "http://192.168.0.13:80/hello/book/image";

        String fileName = "I:/礼金表.png";

        Map<String, String> textMap = new HashMap<>();

        // 可以设置多个 input 的 name ， value
        textMap.put("name", "testname");
        textMap.put("type", "2");
        //设置file 的name ， 路劲
        Map<String, String> fileMap = new HashMap<>();
        fileMap.put("file", fileName);
        String contentType = "";//image/png

        String ret = formUpload(url, textMap, fileMap, contentType);

        System.out.println(ret);


    }


    public static String formUpload(
            String urlStr, Map<String, String> textMap,
            Map<String, String> fileMap,
            String contentType
    ) {
        String res = "";
        HttpURLConnection conn = null;

        // boundary就是request头和上传文件内容的分隔符

        String BOUNDARY = "-------------------------------123821742118716";

        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5 * 1000);
            conn.setReadTimeout(3 * 1000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            conn.setRequestProperty("Content-Type",
                    "multipart/from-data; boundary=" + BOUNDARY);

            OutputStream out = new DataOutputStream(conn.getOutputStream());


            if (fileMap != null) {
                Iterator iterator = fileMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry) iterator.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }

                    File file = new File(inputValue);
                    String filename = file.getName();

                    // 没有传入 类型， 同时根据文件获取不到类型
                    //默认采用application / octet-stream
                    contentType = new MimetypesFileTypeMap().getContentType(file);

                    //contentType 非 空 采用 filename 匹配默认的图片类型
                    if (!"".equals(contentType)) {
                        if (filename.equals(".png")) {
                            contentType = "image/png";
                        } else if (filename.endsWith(".jpg")) {
                            contentType = "image/jpeg";
                        } else if (filename.endsWith(".gif")) {
                            contentType = "image/gif";
                        } else if (filename.endsWith("ico")) {
                            contentType = "image/image/x-icon";
                        }
                    }

                    if (contentType == null || "".equals(contentType)) {
                        contentType = "application/octet-stream";
                    }

                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("\r\n")
                            .append("--")
                            .append(BOUNDARY)
                            .append("\r\n");

//                    stringBuffer.append("Content-Disposition: form-data; name=\"" + inputName + "\"; filename=\"" + filename
//                            + "\"\r\n");

                    stringBuffer.append("Content-Disposition: form-data; name=\"" + inputName + "\" ; filename =\"" + filename + "\"\r\n");

                    stringBuffer.append("Content-Type:" + contentType + "\r\n\r\n");
                    out.write(stringBuffer.toString().getBytes());
                    DataInputStream in = new DataInputStream(new FileInputStream(file));

                    int bytes = 0;
                    byte[] bufferOut = new byte[1024];
                    while ((bytes = in.read(bufferOut)) != -1) {
                        out.write(bufferOut, 0, bytes);
                    }

                    in.close();
                }

                byte[] endData = ("\r\n--" + BOUNDARY).getBytes();
                out.write(endData);
                out.flush();
                out.close();

                // 读取返回数据
                StringBuffer strBuf = new StringBuffer();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String line = null;
                while ((line = reader.readLine()) != null) {
                    strBuf.append(line).append("\n");
                }

                res = strBuf.toString();
                reader = null;


            }


        } catch (Exception e) {
            System.out.println("发送POST请求出错。" + urlStr);
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }

        return res;

    }


}
