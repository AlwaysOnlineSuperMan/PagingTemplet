package com.nings.dao;

import com.nings.entity.MCUtilitiesExpenseItem;

public interface MCUtilitiesExpenseItemMapper {
    int deleteByPrimaryKey(String utilitiesCode);

    int insert(MCUtilitiesExpenseItem record);

    int insertSelective(MCUtilitiesExpenseItem record);

    MCUtilitiesExpenseItem selectByPrimaryKey(String utilitiesCode);

    int updateByPrimaryKeySelective(MCUtilitiesExpenseItem record);

    int updateByPrimaryKey(MCUtilitiesExpenseItem record);
}