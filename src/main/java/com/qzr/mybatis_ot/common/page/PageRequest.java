package com.qzr.mybatis_ot.common.page;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PageRequest {
        private int pageNum=1;//当前页码
        private int pageSize=3;//每页数量

}

