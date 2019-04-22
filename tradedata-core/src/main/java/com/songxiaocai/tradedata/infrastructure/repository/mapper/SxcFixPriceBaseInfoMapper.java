package com.songxiaocai.tradedata.infrastructure.repository.mapper;

import com.songxiaocai.tradedata.infrastructure.repository.entity.SxcFixPriceBaseInfo;
import com.songxiaocai.tradedata.infrastructure.repository.entity.example.SxcFixPriceBaseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SxcFixPriceBaseInfoMapper {
    int insert(SxcFixPriceBaseInfo record);

    int insertSelective(SxcFixPriceBaseInfo record);

    List<SxcFixPriceBaseInfo> selectByExample(SxcFixPriceBaseInfoExample example);

    int updateByExampleSelective(@Param("record") SxcFixPriceBaseInfo record, @Param("example") SxcFixPriceBaseInfoExample example);

    int updateByExample(@Param("record") SxcFixPriceBaseInfo record, @Param("example") SxcFixPriceBaseInfoExample example);
}