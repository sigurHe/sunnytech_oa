package cn.sunnytech.oa.global.beans;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by Administrator on 2018\6\11 0011.
 */

@Getter
@Setter
@ToString
@Builder
public class PageResult<T> {
    //和前端ajax做好配合的
    private List<T> data = Lists.newArrayList();

    private PageInfo<T> pageInfo;

}
