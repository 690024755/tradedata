package com.songxiaocai.tradedata.infrastructure.repository.mapper;

import com.songxiaocai.tradedata.infrastructure.repository.entity.SxcFixPriceRule;
import com.songxiaocai.tradedata.infrastructure.repository.entity.example.SxcFixPriceRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SxcFixPriceRuleMapper {
    int insert(SxcFixPriceRule record);

    int insertSelective(SxcFixPriceRule record);

    List<SxcFixPriceRule> selectByExample(SxcFixPriceRuleExample example);

    int updateByExampleSelective(@Param("record") SxcFixPriceRule record, @Param("example") SxcFixPriceRuleExample example);

    int updateByExample(@Param("record") SxcFixPriceRule record, @Param("example") SxcFixPriceRuleExample example);

}