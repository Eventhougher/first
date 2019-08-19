package com.servlet;


import com.dao.GoodsInfoDao;
import com.entity.GoodsInfo;
import com.until.StringUntil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;


public class OperateServlet extends HttpServlet {
    GoodsInfoDao goodsInfoDao = new GoodsInfoDao();

    //详情
    private void view(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得商品id
        String id = req.getParameter("id");

        //数据库获得对象

        GoodsInfo goods = new GoodsInfo(new Integer(id), null, null, 0, null, 0, 0, null, null);
        if (goods.getFlag() == 1) {

        }
        List<GoodsInfo> list = goodsInfoDao.findByGoods(goods);
        GoodsInfo goods3 = (list != null && list.size() > 0) ? list.get(0) : null;
        //设置作用域
        req.setAttribute("goods", goods3);
        //转发
        req.getRequestDispatcher("goods_view.jsp").forward(req, resp);
    }

    //删除
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得商品id
        String id = req.getParameter("id");

        //数据库获得对象

        int rows = goodsInfoDao.deleteGoodInfo(new Integer(id));

        req.getRequestDispatcher("good").forward(req, resp);

    }

    //修改
    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        //获得id
        Date date = new Date();
        GoodsInfo goods = new GoodsInfo();
        goods.setCreatedDate(date);


        List<GoodsInfo> list = goodsInfoDao.findByGoods(goods);
        //判断<form>中是否有enctype="multipart/form-data"
        String fileName = "";

        try {
            //判断enctype
            boolean isMultipart = ServletFileUpload.isMultipartContent(req);
            //判断是否为上传表单
            if (isMultipart) {
                //创建 ServletFileUpload对象
                if (getUpload(req, out, goods)) return;
                int rows = goodsInfoDao.updateGoodsInfo(goods);
                if (rows > 0) {
                    out.println("<script>alert('修改成功');location.href='good';</script>");
                }
                //否则失败
                else {
                    out.println("<script>alert('修改失败：没有此商品序号');history.back();</script>");
                }
                return;

            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        //z转发
        req.setAttribute("goods", list.get(0));
        req.getRequestDispatcher("goods_update.jsp").forward(req, resp);


    }

    private void update1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得商品id
        String id = req.getParameter("id");

        //数据库获得对象


        GoodsInfo goods = new GoodsInfo(new Integer(id), null, null, 0, null, 0, 0, null, null);
        List<GoodsInfo> list = goodsInfoDao.findByGoods(goods);
        GoodsInfo goods3 = (list != null && list.size() > 0) ? list.get(0) : null;

        //设置作用域
        req.setAttribute("goods", goods3);
        //转发
        req.getRequestDispatcher("goods_update.jsp").forward(req, resp);
    }


    //新增
    private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        //获得id
        Date date = new Date();
        GoodsInfo goods = new GoodsInfo();
        goods.setCreatedDate(date);
        List<GoodsInfo> list = goodsInfoDao.findByGoods(goods);
        //判断<form>中是否有enctype="multipart/form-data"
        String fileName = "";

        try {
            //判断enctype
            boolean isMultipart = ServletFileUpload.isMultipartContent(req);
            //判断是否为上传表单
            if (isMultipart) {
                //创建 ServletFileUpload对象
                if (getUpload(req, out, goods)) return;
                int rows = goodsInfoDao.insertGoodsInfo(goods);
                if (rows > 0) {
                    out.println("<script>alert('增加成功');location.href='good';</script>");
                }
                //否则失败
                else {
                    out.println("<script>alert('增加失败：没有此商品序号');history.back();</script>");
                }
                return;

            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        //z转发
        req.setAttribute("goods", list.get(0));
        req.getRequestDispatcher("goods_insert.jsp").forward(req, resp);

    }

    //上传
    private boolean getUpload(HttpServletRequest req, PrintWriter out, GoodsInfo goods) throws FileUploadException, IOException {
        String fileName;
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        //通过ServletFileUpload对象解析请求获得上传的控件的集合
        List<FileItem> fileItemList = upload.parseRequest(req);

        //遍历
        if (fileItemList != null && fileItemList.size() > 0) {
            for (FileItem item : fileItemList) {
                if (item.isFormField()) {
                    // 表示普通控件
                    if ("id".equals(item.getFieldName())) {
                        String id1 = item.getString("utf-8");
                        goods.setId(StringUntil.str2Int(id1, 0));
                    }
                    if ("goodsInfoName".equals(item.getFieldName())) {
                        String goodsInfoName = item.getString("utf-8");
                        goods.setGoodsInfoName(goodsInfoName);
                        if (!StringUntil.isNoNull(goods.getGoodsInfoName())) {
                            out.println("<script>alert('商品名字不能为空');history.back();</script>");
                            return true;
                        }
                    }
                    if ("goodsInfoPrice".equals(item.getFieldName())) {
                        String goodsInfoPrice = item.getString("utf-8");
                        goods.setGoodsInfoPrice(StringUntil.str2double(goodsInfoPrice, 0.0));
                        if (goods.getGoodsInfoPrice() < 0) {
                            out.println("<script>alert('价格不能为负');history.back();</script>");
                            return true;
                        }
                    }
                    if ("goodsInfoDescription".equals(item.getFieldName())) {
                        String goodsInfoDescription = item.getString("utf-8");
                        goods.setGoodsInfoDescription(goodsInfoDescription);
                        if (!StringUntil.isNoNull(goods.getGoodsInfoDescription())) {
                            out.println("<script>alert('商品描述不能为空');history.back();</script>");
                            return true;
                        }
                    }
                    if ("goodsStock".equals(item.getFieldName())) {
                        String goodsStock = item.getString("utf-8");
                        goods.setGoodsStock(StringUntil.str2Int(goodsStock, 0));
                    }
                    if ("flag".equals(item.getFieldName())) {
                        String flag = item.getString("utf-8");
                        if (flag.equals("激活")) {
                            goods.setFlag(1);
                        } else {
                            goods.setFlag(0);
                        }
//                        goods.setFlag(StringUntil.str2Int(flag, 0));
                    }
                    if ("created".equals(item.getFieldName())) {
                        String created = item.getString("utf-8");
                        goods.setCreated(created);
                        if (!StringUntil.isNoNull(goods.getCreated())) {
                            out.println("<script>alert('商品描述不能为空');history.back();</script>");
                            return true;
                        }
                    }
                }
                //表示上传控件
                else {
                    if (item.getName() != null && !"".equals(item.getName())) {
                        System.out.println(item.getName());
                        //获得upload目录在web服务中的绝对路径
                        String parentPath = req.getServletContext().getRealPath("/upload");
                        // 判断目录是否存在，如果不存在就创建出来
                        File parentFile = new File(parentPath);
                        // mkdirs()：创建目录
                        if (!parentFile.exists()) parentFile.mkdirs();
                        //写入服务器中的新的文件的文件对象
                        File newFile = new File(parentPath, item.getName());
                        // 获得上传文件的输入流
                        InputStream inputStream = item.getInputStream();
                        // 创建输出流
                        OutputStream outputStream = new FileOutputStream(newFile);
                        // 进入读写操作
                        IOUtils.copy(inputStream, outputStream);

                        fileName = item.getName();

                        if (fileName != null) {
                            goods.setGoodsInfoPic(fileName);
                        }
                    }
                }
            }
        }
        return false;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // 1、获得操作类型
        String opr = req.getParameter("opr");

        // 2、判断不同的操作类型调用不同的方法
        if ("insert".equals(opr)) {
            insert(req, resp);
        } else if ("view".equals(opr)) {
            view(req, resp);
        } else if ("update".equals(opr)) {
            update(req, resp);
        } else if ("delete".equals(opr)) {
            delete(req, resp);
        } else if ("update1".equals(opr)) {
            update1(req, resp);
        }


    }
}
