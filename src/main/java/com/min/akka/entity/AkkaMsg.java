/* ***************************************************
 * 创建人  : @author min
 * 创建时间: 2022/11/2/14:59
 * 项目名称: akka-sample
 * 文件名称: AkkaMsg
 * 文件描述: @Description: todo(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 深圳市赢和信息技术有限公司
 * @Copyright:2016-2022
 *
 ********************************************************/
package com.min.akka.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述：todo <p/>
 * <p>
 * 包名称： com.min.akka.entity <p/>
 * 名称：AkkaMsg <p/>
 * 创建人：@author min <p/>
 * 创建时间：2022/11/2 14:59 <p/>
 */
@Data
@AllArgsConstructor
public class AkkaMsg {

    private final long msgNo;

    private final String message;

    @Override
    public String toString() {
        return "AkkaMsg{" +
                "msgNo=" + msgNo +
                ", message='" + message + '\'' +
                '}';
    }
}
