package luocaca.photoview;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public class PersonBean extends BmobObject {

    private String count = "";
    private String pwd = "";
    private BmobFile file ;

    public PersonBean() {


    }


    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public BmobFile getFile() {
        return file;
    }

    public void setFile(BmobFile file) {
        this.file = file;
    }


   public   PersonBean (String count,String pwd, BmobFile file)
   {
       this.count= count;
       this.pwd= pwd;
       this.file= file;
   }

}
