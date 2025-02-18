package com.yc.api;

import com.yc.common.core.base.constant.ApplicationConst;
import com.yc.common.core.base.dto.auth.UserIdReqDTO;
import com.yc.common.core.base.result.ResultBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @description:
 * @author: youcong
 * @time: 2022/1/3 21:21
 */
@FeignClient(contextId = "userApi", name = ApplicationConst.AUTH)
public interface UserApi {
    /**
     * 获取用户对应的角色菜单
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/auth/getPerm")
    ResultBody<List<String>> getPerm(@RequestBody UserIdReqDTO reqDTO);

    /**
     * 获取用户对应的角色
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/auth/getRole")
    ResultBody<List<String>> getRole(@RequestBody UserIdReqDTO reqDTO);
}
