package com.fo.up.action;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.stereotype.Controller;

import com.fo.up.entity.UpUser;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Controll层
 * 
 * @author Administrator 因为这里需要解决对Oracle数据中EMP表的CRUD所以我定义了一个实体类
 *         根据页面传入的值，这里需要使用模型驱动 curPage则是分页 表示当前页 这里整合了Ajax 而stuts2又不能直接返回值
 *         所以这里我使用了JSONArray将最后的结果转换为Json数组 OutputStream对象将结果返回给页面
 */
@Controller
public class SpringMvcAction extends ActionSupport implements ModelDriven<UpUser> {

    // 当前页
    private int curPage;

    /**
     * 查询方法
     * 
     * @return
     * @throws IOException
     */
    @Action(value = "/query")
    public String query() throws IOException {
        // 获取 输出流
        OutputStream os = ServletActionContext.getResponse().getOutputStream();
        // 将分页结果转换为json数组并且转换为字符串
//        String json = JSONArray.fromObject(page).toString();
        // 将结果返回给页面
        String json = "{'a':'哈哈'}";
        os.write(json.getBytes("UTF-8"));
        return NONE;

    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    @Override
    public UpUser getModel() {
        return null;
    }
}