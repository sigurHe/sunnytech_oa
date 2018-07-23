package cn.sunnytech.oa.work.entity;

import lombok.*;

/**
 * Created by HeBin on 2018\6\14 0014.
 * 办公:部门实体类
 */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private Integer id;
    private Integer subject;
    private String name;
    private String address;

}
