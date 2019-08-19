package com.dao;



import com.entity.GoodsInfo;

import java.util.*;

public class GoodsInfoDao extends BaseDao {
    // 属性名和列名一致
    public List<GoodsInfo> findByGoods(GoodsInfo goods){
        List<Object> paramList = new ArrayList<>();
        // 1、sql语句
        StringBuffer sf = new StringBuffer();
        sf.append(" select * from goodsInfo where 1=1 ");

        // 2、条件判断生成动态sql
        if(goods!=null){
            if(goods.getId() >0){
                sf.append(" and id = ? ");
                paramList.add(goods.getId());
            }
        }

        return this.queryByConnection(GoodsInfo.class,sf.toString(),paramList.toArray());
    }

    // 属性名和列名不一致
    public List<GoodsInfo> findByGoods2(GoodsInfo goods){
        List<Object> paramList = new ArrayList<>();
        // 1、sql语句
        StringBuffer sf = new StringBuffer();
        sf.append(" select * from goodsInfo where 1=1 ");

        // 2、条件判断生成动态sql
        if(goods!=null){
            if(goods.getId()>0){
                sf.append(" and id = ? ");
                paramList.add(goods.getId());
            }
        }
        Map<String,String> propertyMap = new HashMap<>();
        // key：列名
        // value：属性名
        propertyMap.put("id","id");
        propertyMap.put("goodsInfoName","goodsInfoName");
        propertyMap.put("goodsInfoPic","goodsInfoPic");
        propertyMap.put("goodsInfoPrice","goodsInfoPrice");
        propertyMap.put("goodsInfoDescription","goodsInfoDescription");
        propertyMap.put("goodsStock","goodsStock");
        propertyMap.put("flag","flag");
        propertyMap.put("created","created");
        propertyMap.put("createdDate","createdDate");
        return this.query2ByConnection(GoodsInfo.class,sf.toString(),paramList.toArray(),propertyMap);
    }

    // 新增商品
    public int insertGoodsInfo(GoodsInfo goods){
        Date date = new Date();
        String sql = " insert into goodsInfo(goodsInfoName,goodsInfoPic,goodsInfoPrice,goodsInfoDescription,goodsStock,flag,created,createdDate) values(?,?,?,?,?,?,?,?) ";
        Object[] paramObjs = {
                goods.getGoodsInfoName(),
                goods.getGoodsInfoPic(),
                goods.getGoodsInfoPrice(),
                goods.getGoodsInfoDescription(),
                goods.getGoodsStock(),
                goods.getFlag(),
                goods.getCreated(),
                date,

        };
        return this.update(sql,paramObjs);
    }

    // 修改商品
    public int updateGoodsInfo(GoodsInfo goods){
        Date date = new Date();
        StringBuffer sf = new StringBuffer();
        sf.append(" update goodsInfo set ");
        sf.append("         goodsInfoName = ? ");
        sf.append("        ,goodsInfoPic = ? ");
        sf.append("        ,goodsInfoPrice = ? ");
        sf.append("        ,goodsInfoDescription = ? ");
        sf.append("        ,goodsStock = ? ");
        sf.append("        ,flag = ? ");
        sf.append("        ,created = ? ");
        sf.append("        ,createdDate = ? ");
        sf.append(" where id = ? ");
        Object[] paramObjs = {
                goods.getGoodsInfoName(),
                goods.getGoodsInfoPic(),
                goods.getGoodsInfoPrice(),
                goods.getGoodsInfoDescription(),
                goods.getGoodsStock(),
                goods.getFlag(),
                goods.getCreated(),
                goods.getCreatedDate(),
                goods.getId()
        };
        return this.update(sf.toString(),paramObjs);
    }

    // 删除学生
    public int deleteGoodInfo(int id){
        String sql = " delete from goodsInfo where id = ? ";
        Object[] paramObjs = {id};
        return this.update(sql,paramObjs);
    }

}
