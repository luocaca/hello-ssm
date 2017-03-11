package luocaca.photoview;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

@Table(name = "LocalData")
public class LocalData extends Model {

    @Column(name = "name")
    public String name = "";
    @Column(name = "age")
    public String age = "";
    @Column(name = "company")
    public String company = "";






}
